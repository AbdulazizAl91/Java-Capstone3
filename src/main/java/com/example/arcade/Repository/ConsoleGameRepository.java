package com.example.arcade.Repository;

import com.example.arcade.Model.ConsoleGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsoleGameRepository extends JpaRepository<ConsoleGame,Integer> {
    ConsoleGame findConsoleGameById(Integer id);
    List<ConsoleGame> findConsoleGameByIsAvailable(Boolean isAvailable);

}
