package com.github.odyn666.DiscordCRM.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
//@Table(name = "bot_props")
@Getter
@Setter
public class BotProp {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    private GuildChannels guildChannels;

}
