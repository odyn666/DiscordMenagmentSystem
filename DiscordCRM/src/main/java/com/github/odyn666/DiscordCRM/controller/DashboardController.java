package com.github.odyn666.DiscordCRM.controller;

import com.github.odyn666.DiscordCRM.entity.GuildChannels;
import com.github.odyn666.DiscordCRM.entity.User;
import com.github.odyn666.DiscordCRM.repository.GuildChannelRepository;
import com.github.odyn666.DiscordCRM.service.implementtion.DashboardCoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class DashboardController {
    private final GuildChannelRepository guildChannelRepository;
    private final DashboardCoreService serviceCore;

    @GetMapping("/guilds")
    public ResponseEntity<List<GuildChannels>> fetchAllGuildChannels() {
        return ResponseEntity.ok(guildChannelRepository.findAll());

    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(serviceCore.getDcUsers());
    }
    @GetMapping("/users/kick")
    public ResponseEntity<User> kickUser(Long userId) {
        return ResponseEntity.ok(serviceCore.kickUser(userId));
    }

}
