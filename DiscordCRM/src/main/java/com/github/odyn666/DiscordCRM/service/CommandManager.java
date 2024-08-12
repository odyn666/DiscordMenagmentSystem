package com.github.odyn666.DiscordCRM.service;

import com.github.odyn666.DiscordCRM.repository.ICommand;
import com.github.odyn666.DiscordCRM.service.implementtion.DashboardCoreService;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public class CommandManager extends ListenerAdapter {
    private List<ICommand> commands = new ArrayList<>();
    private final DashboardCoreService service;

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        for (Guild guild : event.getJDA().getGuilds()) {
            for (ICommand command : commands) {
                if (command.getOptions() == null) {
                    guild.upsertCommand(command.getName().toLowerCase(Locale.ROOT), command.getDescription().toLowerCase(Locale.ROOT)).queue();
                } else {
                    guild.upsertCommand(command.getName().toLowerCase(Locale.ROOT), command.getDescription().toLowerCase(Locale.ROOT)).addOptions(command.getOptions()).queue();
                }
            }
        }

    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        for (ICommand command : commands) {
            if (command.getName().equals(event.getName())) {
                command.execute(event);
                return;
            }
        }
    }

    public void add(ICommand command) {
        commands.add(command);
    }
}
