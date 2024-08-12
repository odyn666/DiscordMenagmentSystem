package com.github.odyn666.DiscordCRM;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collection;

@SpringBootApplication
public class DiscordCrmApplication  {
	//TODO GET RID OF Hardcoded bot token. It's a security risk.'

    public static void main(String[] args) {
        SpringApplication.run(DiscordCrmApplication.class, args);
    }


}
