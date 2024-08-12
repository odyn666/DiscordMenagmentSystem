package com.github.odyn666.DiscordCRM.repository;

import com.github.odyn666.DiscordCRM.entity.GuildChannels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuildChannelRepository extends JpaRepository<GuildChannels, Long> {
    GuildChannels getGuildChannelById(Long guildId);

    GuildChannels getGuildChannelByName(String  name);

    List<GuildChannels> findAll();
}
