package com.example.arcade.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name of game should be not null")
    @Size(min = 4,max = 30,message = "name of game should be between 4 and 20")
    @Column(columnDefinition = "varchar(30) not null")
    private String name;
    @NotEmpty(message = "name of game should be not null")
    @Size(min = 4,max = 30,message = "name of company_name should be between 4 and 20")
    @Column(columnDefinition = "varchar(30) not null")
    private String companyName;
    @NotNull(message = "balance should not null")
    @Column(columnDefinition = "int not null")
    private Integer price;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "date not null")
    private Date subscriptionStartDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "date not null")
    private Date subscriptionEndtDate;
    @NotEmpty(message = "version should be not null")
    @Size(min = 2,max = 10,message = "version should be between 2 and 10")
    @Column(columnDefinition = "varchar(10)")
    private String version;
    @NotNull(message = "age_rating should not null")
    @Column(columnDefinition = "int not null")
    private Integer ageRating;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "game")
    private Set<Player> players;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "game")
    private Set<ConsoleGame> consoleGames;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @JsonIgnore
    private Employee employee;



}
