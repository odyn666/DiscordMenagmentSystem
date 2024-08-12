package com.github.odyn666.DiscordCRM.service;

import com.github.odyn666.DiscordCRM.service.slashCommands.SetUp;
import com.github.odyn666.DiscordCRM.service.slashCommands.UpdateUsers;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.hibernate.sql.Update;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JDAInitializer implements
        CommandLineRunner {
    private static final String BOT_TOKEN = "TEMPORARY SPOT FOR TOKEN";
    private final CommandManager commandManager;
    private final SetUp setUp;
private final UpdateUsers updateUsers;

    @Override
    public void run(String... args) throws Exception {
        commandManager.add(setUp);
        commandManager.add(updateUsers);


        JDA jda = JDABuilder.create(BOT_TOKEN, GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS,
                        GatewayIntent.GUILD_VOICE_STATES, GatewayIntent.GUILD_EMOJIS_AND_STICKERS,
                        GatewayIntent.SCHEDULED_EVENTS, GatewayIntent.GUILD_PRESENCES)
                .addEventListeners(commandManager)
                .build().awaitReady();
    }

}
