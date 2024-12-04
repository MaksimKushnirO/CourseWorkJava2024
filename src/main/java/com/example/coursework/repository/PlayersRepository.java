package com.example.coursework.repository;

import com.example.coursework.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayersRepository extends JpaRepository<Player,Long> {
}
