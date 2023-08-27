package com.example.arcade.Controller;

import com.example.arcade.Model.ConsoleGame;
import com.example.arcade.Model.Game;
import com.example.arcade.Model.Player;
import com.example.arcade.Service.GameService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/game")
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;

    @GetMapping("/get")
    public List<Game> getAllGame() {
        return gameService.getAllGames();
    }

    @PostMapping("/add")
    public ResponseEntity addgame(@RequestBody @Valid Game game) {
        gameService.addGame(game);
        return ResponseEntity.status(200).body("the player is added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateGame(@PathVariable Integer id ,@RequestBody Game game) {
        gameService.updateGame(id, game);
        return ResponseEntity.status(200).body("the Game is updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteGame(@PathVariable Integer id) {

        gameService.deleteGame(id);
        return ResponseEntity.status(200).body("the game is deleted");
    }
    @PostMapping("/Add-player/{game_id}")
    public ResponseEntity AddPlayer(@PathVariable Integer game_id,@RequestBody  Player player){
        gameService.AddPlayer(game_id,player);
        return ResponseEntity.status(200).body("the player is add game");
    }
        @PutMapping("/connect-to-console/{game_id}-{consoleGame_id}")
    public ResponseEntity connectToConsole(@PathVariable Integer game_id,@PathVariable Integer consoleGame_id){
        gameService.connectToConsole(game_id,consoleGame_id);
        return ResponseEntity.status(200).body("the console game is add game");
    }
    @GetMapping("/search-by-age-rating/{ageRating}")
    public ResponseEntity findGameByAgeRating(@PathVariable Integer ageRating){
        return ResponseEntity.status(200).body(gameService.findGameByAgeRating(ageRating));
    }
    @GetMapping("/search-by-company-name/{companyName}")
    public ResponseEntity findGameByCompanyName(@PathVariable String companyName){
        return ResponseEntity.status(200).body(gameService.findGameByCompanyName(companyName));
    }


}
