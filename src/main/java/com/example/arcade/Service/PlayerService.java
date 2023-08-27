package com.example.arcade.Service;

import com.example.arcade.Api.ApiException;
import com.example.arcade.Model.Game;
import com.example.arcade.Model.Player;
import com.example.arcade.Model.ConsoleGame;
import com.example.arcade.Repository.ConsoleGameRepository;
import com.example.arcade.Repository.GameRepository;
import com.example.arcade.Repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository;
    private final ConsoleGameRepository consoleGameRepository;


    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    public void addPlayer(Player player){
        playerRepository.save(player);
    }
    public void updatePlayer(Integer id,Player player){
        Player player1 = playerRepository.findPlayerById(id);
        if (player1==null){
            throw new ApiException("id not founded");
        }
        player1.setName(player.getName());
        player1.setAge(player.getAge());
        player1.setSubscriptionStartDate(player.getSubscriptionStartDate());
        player1.setSubscriptionEndtDate(player.getSubscriptionEndtDate());
        player1.setBalance(player.getBalance());

        playerRepository.save(player1);

    }
    public void deletePlayer(Integer id){
        Player player = playerRepository.findPlayerById(id);
        if (player==null){
            throw new ApiException("id not founded");
        }
        playerRepository.delete(player);
    }
    public List<Player>findPlayerByAge(Integer age){
        List<Player>players=playerRepository.findPlayerByAge(age);
        if (players==null){
            throw new ApiException("there is no player with "+ age);
        }
        return players;
    }



}
