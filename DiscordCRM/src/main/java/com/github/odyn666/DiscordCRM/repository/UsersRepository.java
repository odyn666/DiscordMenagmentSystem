package com.github.odyn666.DiscordCRM.repository;

import com.github.odyn666.DiscordCRM.entity.User;
import net.dv8tion.jda.api.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User,Long> {

}
