package com.example.arcade.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name of player should be not null")
    @Size(min = 4,max = 20,message = "name of employee should be between 4 and 20")
    @Column(columnDefinition = "varchar(20) not null")
    private String  name;
    @Positive
    @Column(columnDefinition = "int check (age>0)")
    private Integer age;
    @JsonFormat(pattern = "yyyy/MM/dd")
    @Column(columnDefinition = "date not null")
    private Date subscriptionStartDate;
    @JsonFormat(pattern = "yyyy/MM/dd")
    @Column(columnDefinition = "date not null")
    private Date subscriptionEndtDate;
    private Integer balance;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @JsonIgnore
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    @JsonIgnore
    private Game game;


}
