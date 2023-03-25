/*
 * 
 * You can use the following import statemets
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * import org.springframework.beans.factory.annotation.Autowired;
 * 
 */

// Write your code here
package com.example.player.controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.player.model.Player;
import com.example.player.service.PlayerJpaService;

@RestController
public class PlayerController{
    @Autowired
    public PlayerJpaService playerservice;

    @GetMapping("/players")
    public ArrayList<Player> getAllPlayers(){
        return playerservice.getAllPlayers();
    }

    @GetMapping("/players/{playerId}")
    public Player getPlayer(@PathVariable int playerId){
        return playerservice.getPlayer(playerId);
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player){
        return playerservice.addPlayer(player);
    }

    @PutMapping("/players/{playerId}")
    public Player updatePlayer(@PathVariable int playerId, @RequestBody Player player){
        return playerservice.updatePlayer(playerId,player);
    }

    @DeleteMapping("/players/{playerId}")
    public ArrayList<Player> deletePlayer(@PathVariable int playerId){
        return playerservice.deletePlayer(playerId);
    }
}