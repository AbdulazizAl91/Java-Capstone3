package com.example.arcade.Controller;

import com.example.arcade.Model.ConsoleGame;
import com.example.arcade.Model.Employee;
import com.example.arcade.Service.ConsoleGameService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/console-game")
@RequiredArgsConstructor
public class ConsoleGameController {
    private final ConsoleGameService consoleGameService;

    @GetMapping("/get")
    public List<ConsoleGame> getAllConsoleGame() {
        return consoleGameService.getAllConsoleGame();
    }

    @PostMapping("/add")
    public ResponseEntity addConsoleGame(@RequestBody @Valid ConsoleGame consoleGame) {
        consoleGameService.addConsoleGame(consoleGame);
        return ResponseEntity.status(200).body("the console Game is added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateConsoleGame(@PathVariable Integer id ,@RequestBody ConsoleGame consoleGame) {
        consoleGameService.updateConsoleGame(id, consoleGame);
        return ResponseEntity.status(200).body("the console Game is updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteConsoleGame(@PathVariable Integer id) {

        consoleGameService.deleteConsoleGame(id);
        return ResponseEntity.status(200).body("the Employee is deleted");
    }
    @GetMapping("/get-by-status/{isAvailable}")
    public ResponseEntity findConsoleGameByIsAvailable(@PathVariable  Boolean isAvailable){

        return ResponseEntity.status(200).body( consoleGameService.findConsoleGameByIsAvailable(isAvailable));
    }
}
