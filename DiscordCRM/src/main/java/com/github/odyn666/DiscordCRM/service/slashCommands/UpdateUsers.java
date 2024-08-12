package com.github.odyn666.DiscordCRM.service.slashCommands;

import com.github.odyn666.DiscordCRM.entity.GuildChannels;
import com.github.odyn666.DiscordCRM.entity.User;
import com.github.odyn666.DiscordCRM.repository.GuildChannelRepository;
import com.github.odyn666.DiscordCRM.repository.ICommand;
import com.github.odyn666.DiscordCRM.repository.UsersRepository;
import com.github.odyn666.DiscordCRM.service.implementtion.DashboardCoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Slf4j
@Component
public class UpdateUsers implements ICommand {
    private final GuildChannelRepository guildChannelRepository;
    private final UsersRepository usersRepository;
    private GuildChannels guildChannels;
    private final DashboardCoreService service;
    private Set<User> dcUsers = new HashSet<>();



    @Override
    public String getName() {
        return "update_users";
    }

    @Override
    public String getDescription() {
        return "update users in dashboard Data Base";
    }

    @Override
    public List<OptionData> getOptions() {
        return List.of();
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        if (event.getInteraction().getName().toLowerCase().equals("update_users")) {
            guildChannels = guildChannelRepository.getGuildChannelByName("poligon testujemy bota");
            Guild guildById = event.getJDA().getGuildById(guildChannels.getGuildId());
            List<Member> members = guildById.getMembers();
            members.forEach(member -> {
                dcUsers.add(service.mapDcMemberToUser(member));
            });

            service.saveDcUsersToDB(dcUsers);
            log.info(dcUsers.toString() + "AAAAAAAAAAAAAAAAA");
        }
    }
}
