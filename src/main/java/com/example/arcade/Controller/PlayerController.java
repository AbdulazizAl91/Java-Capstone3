package com.example.arcade.Controller;

import com.example.arcade.Model.Game;
import com.example.arcade.Model.Player;
import com.example.arcade.Service.PlayerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/player")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;

    @GetMapping("/get")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PostMapping("/add")
    public ResponseEntity addPlayer(@RequestBody @Valid Player player) {
        playerService.addPlayer(player);
        return ResponseEntity.status(200).body("the player is added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updatePlayer(@PathVariable Integer id ,@RequestBody Player player) {
        playerService.updatePlayer(id, player);
        return ResponseEntity.status(200).body("the player is updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePlyer(@PathVariable Integer id) {

        playerService.deletePlayer(id);
        return ResponseEntity.status(200).body("the player is deleted");
    }

}
