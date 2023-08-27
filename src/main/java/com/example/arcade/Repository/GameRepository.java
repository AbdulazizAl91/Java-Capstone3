package com.example.arcade.Repository;

import com.example.arcade.Model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game,Integer> {
    Game findGameById(Integer id);
    List <Game> findGameByAgeRating(Integer ageRating);
    List<Game> findGameByCompanyName(String companyName);
}
