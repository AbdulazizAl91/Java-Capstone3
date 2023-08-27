package com.example.arcade.Repository;

import com.example.arcade.Model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer> {
        Player findPlayerById(Integer id);
        List<Player> findPlayerByAge(Integer age);
}
