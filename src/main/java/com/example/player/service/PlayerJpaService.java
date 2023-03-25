
package com.example.player.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import com.example.player.model.*;
import com.example.player.repository.PlayerRepository;
import com.example.player.repository.PlayerJpaRepository;

@Service
public class PlayerJpaService implements PlayerRepository{
    
    @Autowired
    public PlayerJpaRepository playerRepository;

    public ArrayList<Player> getAllPlayers(){
        List<Player> arrPlayer = playerRepository.findAll();
        ArrayList<Player> players = new ArrayList<>(arrPlayer);
        return players;
    }

    public Player getPlayer(int playerId){
        try{
            Player player  = playerRepository.findById(playerId).get();
            return player;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        
    }

    public Player addPlayer(Player player){
        Player players = playerRepository.save(player);
        return players;
    }

    public Player updatePlayer(int playerId, Player player){
        try{
            Player play = playerRepository.findById(playerId).get();
        
        if(player.getPlayerName() != null){
            play.setPlayerName(player.getPlayerName());
        }
        if((Integer)player.getJerseyNumber() != 0){
            play.setJerseyNumber(player.getJerseyNumber());
        }
        if(player.getRole() != null){
            play.setRole(player.getRole());
        }

        playerRepository.save(play);
        return play;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        
    }

    public ArrayList<Player> deletePlayer(int playerId){
        try{
           // Player player  = playerRepository.findById(playerId).get();
            playerRepository.deleteById(playerId);
            List<Player> arrPlayer = playerRepository.findAll();
            ArrayList<Player> players = new ArrayList<>(arrPlayer);
            return players;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        
    }
}
