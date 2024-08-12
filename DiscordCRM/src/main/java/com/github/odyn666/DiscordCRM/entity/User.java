package com.github.odyn666.DiscordCRM.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.regex.Pattern;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "users")
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Setter(AccessLevel.NONE)
    private Long id;
    private transient final Pattern pattern = Pattern.compile("(.{2,32})#(\\d{4})");
    @Column(name = "guild_id")
    private String guildId;
    @Column(name = "discord_name")
    private String name;
    @Column(name = "discriminator")
    private String discriminator;
    @Column(name = "avatar_url")
    private String avatarUrl;
    @Column(name = "banner_url")
    private String bannerUrl;
    @Column(name = "total_msg_count")
    private Long totalMessagesSent;
    @Column(name = "fav_channel_id")
    private String  favChannelId;
    @Column(name = "role_id")
    private String  roleId;
    @Column(name = "can_use_music_bot")
    private boolean canUseMusicBot;
}

