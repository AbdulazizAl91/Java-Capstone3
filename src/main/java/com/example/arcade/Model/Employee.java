package com.example.arcade.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name of employee should be not null")
    @Size(min = 4,max = 20,message = "name of employee should be between 4 and 20")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @NotEmpty(message = "username of employee should be not null")
    @Size(min = 4,max = 20,message = "username of employee should be between 4 and 20")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String username;
    @NotEmpty(message = "password of employee should be not null")
    @Size(min = 8,max = 20,message = "password of employee should be between 8 and 20")
    @Pattern(regexp ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$",message ="password should Contains letters and numbers" )
    @Column(columnDefinition = "varchar(20) not null")
    private String Password;
    @Email
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;
    @NotNull(message = "salary should not null")
    @Column(columnDefinition = "int not null")
    private int salary;
    @NotNull(message = "balance should not null")
    @Column(columnDefinition = "int not null")
    private int balance;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employee")
    private Set<Player> player;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employee")
    private Set<ConsoleGame> consoleGames;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employee")
    private Set<Game> games;


}
