package com.example.arcade.Service;

import com.example.arcade.Api.ApiException;
import com.example.arcade.Model.ConsoleGame;
import com.example.arcade.Model.Employee;
import com.example.arcade.Model.Game;
import com.example.arcade.Model.Player;
import com.example.arcade.Repository.ConsoleGameRepository;
import com.example.arcade.Repository.GameRepository;
import com.example.arcade.Repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;
    private final ConsoleGameRepository consoleGameRepository;
    private final PlayerRepository playerRepository;

    public List<Game> getAllGames(){
        return gameRepository.findAll();
    }

    public void addGame(Game game){
        gameRepository.save(game);
    }
    public void updateGame(Integer id,Game game){
        Game game1 = gameRepository.findGameById(id);
        if (game1==null){
            throw new ApiException("id not founded");
        }
        game1.setName(game.getName());
        game1.setCompanyName(game.getCompanyName());
        game1.setPrice(game.getPrice());
        game1.setSubscriptionStartDate(game.getSubscriptionStartDate());
        game1.setSubscriptionEndtDate(game.getSubscriptionEndtDate());
        game1.setVersion(game.getVersion());
        game1.setAgeRating(game.getAgeRating());

        gameRepository.save(game1);

    }
    public void deleteGame(Integer id){
        Game game = gameRepository.findGameById(id);
        if (game==null){
            throw new ApiException("id not founded");
        }
        gameRepository.delete(game);
    }

    public void AddPlayer(Integer game_id, Player player){
        Game game1 = gameRepository.findGameById(game_id);

        if (game1 == null){
            throw new ApiException("id of game not founded");
        }
        if (player.getAge()< game1.getAgeRating()){
            throw new ApiException("your age is less than game age rating");
        }
        player.setGame(game1);
        playerRepository.save(player);


    }
    public void connectToConsole(Integer game_id,Integer consoleGame_id){
        Game game1 = gameRepository.findGameById(game_id);
        ConsoleGame consoleGame =consoleGameRepository.findConsoleGameById(consoleGame_id);

        if (game1 == null){
            throw new ApiException("id of game not founded");
        }
        if (consoleGame == null){
            throw new ApiException("id of console Game not founded");
        }
        consoleGame.setGame(game1);
        consoleGameRepository.save(consoleGame);

    }
    public List<Game> findGameByAgeRating(Integer ageRating){
        List<Game> games=gameRepository.findGameByAgeRating(ageRating);
        if(games==null){
            throw new ApiException("there s no games with rating" + ageRating);
        }
        return games;
    }
    public List<Game> findGameByCompanyName(String companyName){
        List<Game> games=gameRepository.findGameByCompanyName(companyName);
        if(games==null){
            throw new ApiException("there s no games has company name"+companyName);
        }
        return games;
    }




}
