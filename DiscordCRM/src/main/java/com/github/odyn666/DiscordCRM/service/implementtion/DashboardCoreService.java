package com.github.odyn666.DiscordCRM.service.implementtion;

import com.github.odyn666.DiscordCRM.entity.GuildChannels;
import com.github.odyn666.DiscordCRM.entity.User;
import com.github.odyn666.DiscordCRM.repository.GuildChannelRepository;
import com.github.odyn666.DiscordCRM.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class DashboardCoreService extends ListenerAdapter {
    private Set<User> dcUsers = new HashSet<>();

    private GuildChannels guildChannels;
    private final GuildChannelRepository guildChannelRepository;

    private final UsersRepository usersRepository;


    public List<User> getDcUsers() {
        return usersRepository.findAll();
    }


    public void saveDcUsersToDB(Set<User> dcUsers) {
        dcUsers.forEach(usersRepository::save);

    }

    public User mapDcMemberToUser(Member member) {
        User user = new User();

        user.setGuildId(member.getId());
        user.setName(member.getEffectiveName());
        user.setDiscriminator(member.getUser().getDiscriminator());
        user.setAvatarUrl(member.getUser().getAvatarUrl());
        user.setBannerUrl(member.getGuild().getBannerUrl());
        user.setFavChannelId("none");
        user.setRoleId(user.getRoleId());
        user.setTotalMessagesSent(0L);

        log.info(member.getUser().getDiscriminator());
        return user;
    }

    public User kickUser(Long userId) {
        return null;
    }
}
