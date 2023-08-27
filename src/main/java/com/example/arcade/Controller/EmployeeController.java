package com.example.arcade.Controller;

import com.example.arcade.Model.ConsoleGame;
import com.example.arcade.Model.Employee;
import com.example.arcade.Model.Game;
import com.example.arcade.Model.Player;
import com.example.arcade.Service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/get")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @PostMapping("/add")
    public ResponseEntity addEmployee(@RequestBody @Valid Employee employee) {
        employeeService.addEmployee(employee);
        return ResponseEntity.status(200).body("the Employee is added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateEmployee(@PathVariable Integer id ,@RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee);
        return ResponseEntity.status(200).body("the Employee is updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteEmployee(@PathVariable Integer id) {

        employeeService.deleteEmployee(id);
        return ResponseEntity.status(200).body("the Employee is deleted");
    }
    @PutMapping("/change-console-status/{employee_id}-{consoleGame_id}")
    public ResponseEntity changeConsoleGameStatus(@PathVariable Integer employee_id,@PathVariable Integer consoleGame_id,@RequestBody ConsoleGame consoleGame){
        employeeService.changeConsoleGameStatus(employee_id,consoleGame_id,consoleGame);
        return ResponseEntity.status(200).body("the console Game is changed");
    }
    @PutMapping("/re-new-subscription-for-player/{employee_id}-{player_id}")
    public ResponseEntity<String> reNewSubscriptionForPlayer(@PathVariable Integer employee_id, @PathVariable Integer player_id, @RequestBody Player player){
        employeeService.reNewSubscriptionForPlayer(employee_id,player_id,player);
        return ResponseEntity.status(200).body("the player  is re new Subscription");
    }
    @PostMapping("/add-new-game/{employee_id}")
    public ResponseEntity addNewGame(@PathVariable Integer employee_id,@RequestBody Game game){
        employeeService.addNewGame(employee_id,game);
        return ResponseEntity.status(200).body("new game is add");
    }
    @GetMapping("get-employee-by-name/{name}")
    public ResponseEntity findByName(@PathVariable String name){
        return ResponseEntity.status(200).body(employeeService.findEmployeeByName(name));
    }



}
