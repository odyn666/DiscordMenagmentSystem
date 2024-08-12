package com.github.odyn666.DiscordCRM.service.slashCommands;

import com.github.odyn666.DiscordCRM.entity.GuildChannels;
import com.github.odyn666.DiscordCRM.repository.GuildChannelRepository;
import com.github.odyn666.DiscordCRM.repository.ICommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.managers.GuildManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class SetUp implements ICommand {

    private final GuildChannelRepository repository;

    @Override
    public String getName() {
        return "setup";
    }

    @Override
    public String getDescription() {
        return "run this to set up the bot ";
    }

    @Override
    public List<OptionData> getOptions() {
        return List.of(
                new OptionData(OptionType.CHANNEL, "admin_channel", "set admin channel", true),
                new OptionData(OptionType.CHANNEL, "info_channel", "set info channel", false),
                new OptionData(OptionType.CHANNEL, "welcome_channel", "set welcome channel", false),
                new OptionData(OptionType.CHANNEL, "music_bot_channel", "set info channel", false)

        );
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        GuildChannels guildChannels = new GuildChannels();
        guildChannels.setGuildId(Objects.requireNonNull(event.getGuild()).getId());
        event.getOptions().forEach(option -> {
            switch (option.getName()) {
                case "admin_channel" -> guildChannels.setAdminChannelId(option.getAsChannel().getId());
                case "info_channel" -> guildChannels.setInfoChannelId(option.getAsChannel().getId());
                case "welcome_channel" -> guildChannels.setWelcomeChannelId(option.getAsChannel().getId());
                case "music_bot_channel" -> guildChannels.setMusicBotCommandChannelId(option.getAsChannel().getId());
            }
        });
        guildChannels.setName(event.getGuild().getName().toString());
        event.getChannel().sendMessage("Bot settings updated successfully!").queue();
        guildChannels.setSet(true);
        guildChannels.setConfiguredBy(event.getUser().getId());
        event.getChannel().sendMessage(guildChannels.getChannelsToString()).queue();

        repository.save(guildChannels);
    }
}
