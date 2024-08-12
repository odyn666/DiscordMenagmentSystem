package com.github.odyn666.DiscordCRM.entity;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Entity
@Table(name = "guild_channels")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class GuildChannels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String guildId;
    @Column(name = "guild_name")
    private String name;
    private String infoChannelId;
    private String welcomeChannelId;
    private String adminChannelId;
    private String musicBotCommandChannelId;
    private boolean isSet;
    private String configuredBy;


    public String getChannelsToString() {
        return
                " InfoChannel=<#" + infoChannelId + ">" + '\n' +
                        " WelcomeChannel=<#" + welcomeChannelId + ">" + '\n' +
                        " AdminChannelId=<#" + adminChannelId + ">" + '\n' +
                        " MusicBotCommandChannel=<#" + musicBotCommandChannelId + ">" + '\n' +
                        " ConfiguredBy=<@" + configuredBy + ">" + '\n' +
                        " for serber =  " + name + '\n';
    }
}
