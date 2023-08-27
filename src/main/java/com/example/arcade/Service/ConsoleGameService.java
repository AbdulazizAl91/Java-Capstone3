package com.example.arcade.Service;

import com.example.arcade.Api.ApiException;
import com.example.arcade.Model.ConsoleGame;
import com.example.arcade.Model.Employee;
import com.example.arcade.Repository.ConsoleGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsoleGameService {
    private final ConsoleGameRepository consoleGameRepository;

    public List<ConsoleGame> getAllConsoleGame(){
        return consoleGameRepository.findAll();
    }

    public void addConsoleGame(ConsoleGame consoleGame){
        consoleGameRepository.save(consoleGame);
    }
    public void updateConsoleGame(Integer id,ConsoleGame consoleGame){
        ConsoleGame consoleGame1 = consoleGameRepository.findConsoleGameById(id);
        if (consoleGame1==null){
            throw new ApiException("id not founded");
        }
        consoleGame1.setIsAvailable(consoleGame.getIsAvailable());


        consoleGameRepository.save(consoleGame1);

    }
    public void deleteConsoleGame(Integer id){
        ConsoleGame consoleGame = consoleGameRepository.findConsoleGameById(id);
        if (consoleGame==null){
            throw new ApiException("id not founded");
        }
        consoleGameRepository.delete(consoleGame);
    }
    public List<ConsoleGame> findConsoleGameByIsAvailable(Boolean isAvailable){
        List<ConsoleGame> consoleGames=consoleGameRepository.findConsoleGameByIsAvailable(isAvailable);
        if(consoleGames==null){
            throw new ApiException(" there is no console is " + isAvailable);
        }
        return consoleGames;
    }


}
