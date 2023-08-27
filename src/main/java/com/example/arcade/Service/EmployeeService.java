package com.example.arcade.Service;

import com.example.arcade.Api.ApiException;
import com.example.arcade.Model.ConsoleGame;
import com.example.arcade.Model.Employee;
import com.example.arcade.Model.Game;
import com.example.arcade.Model.Player;
import com.example.arcade.Repository.ConsoleGameRepository;
import com.example.arcade.Repository.EmployeeRepository;
import com.example.arcade.Repository.GameRepository;
import com.example.arcade.Repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final GameRepository gameRepository;
    private final ConsoleGameRepository consoleGameRepository;
    private final PlayerRepository playerRepository;

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee){
        employeeRepository.save(employee);
    }
    public void updateEmployee(Integer id,Employee employee){
        Employee employee1 = employeeRepository.findEmployeeById(id);
        if (employee1==null){
            throw new ApiException("id not founded");
        }
        employee1.setName(employee.getName());
        employee1.setUsername(employee.getUsername());
        employee1.setPassword(employee.getPassword());
        employee1.setEmail(employee.getEmail());
        employee1.setSalary(employee.getSalary());
        employee1.setBalance(employee1.getBalance());

        employeeRepository.save(employee1);

    }
    public void deleteEmployee(Integer id){
        Employee employee = employeeRepository.findEmployeeById(id);
        if (employee==null){
            throw new ApiException("id not founded");
        }
        employeeRepository.delete(employee);
    }
    public void addNewGame(Integer employee_id, Game game){
        Employee employee = employeeRepository.findEmployeeById(employee_id);
        if(employee==null){
            throw new ApiException("id not founded");
        }
        if (game.getPrice()>employee.getBalance()){
            throw new ApiException("the balance of employee less than game price");
        }
        game.setEmployee(employee);
        employee.setBalance(employee.getBalance()-game.getPrice());
        gameRepository.save(game);
    }
    public void changeConsoleGameStatus(Integer employee_id,Integer consoleGame_id, ConsoleGame consoleGame){
        Employee employee = employeeRepository.findEmployeeById(employee_id);
        ConsoleGame consoleGame1=consoleGameRepository.findConsoleGameById(consoleGame_id);

        if(employee==null){
            throw new ApiException("id of employee not founded");
        }
        if(consoleGame1==null){
            throw new ApiException("id of console game not founded");
        }
        consoleGame1.setIsAvailable(consoleGame.getIsAvailable());

        consoleGameRepository.save(consoleGame1);
    }
    public void reNewSubscriptionForPlayer(Integer employee_id,Integer player_id,Player player ){
        int sub_price = 300;
        Employee employee = employeeRepository.findEmployeeById(employee_id);
        Player player1 = playerRepository.findPlayerById(player_id);
        if(employee==null){
            throw new ApiException("id of employee not founded");
        }
        if(player1==null){
            throw new ApiException("id of player not founded");
        }
        if (player1.getBalance()<sub_price) {
            throw new ApiException(" player dose not have balance for new Subscription");

        }
        player1.setBalance(sub_price-player1.getBalance());
        player1.setSubscriptionStartDate(player.getSubscriptionStartDate());
        player1.setSubscriptionEndtDate(player.getSubscriptionEndtDate());
        playerRepository.save(player1);

    }
    public Employee findEmployeeByName(String name){
        Employee employee=employeeRepository.findEmployeeByName(name);
        if (employee==null){
            throw new ApiException("the name if not founded");
        }
        return employee;
    }





}
