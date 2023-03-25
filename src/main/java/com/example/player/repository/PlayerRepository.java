
package com.example.player.repository;
import com.example.player.model.*;
import java.util.*;

public interface PlayerRepository{
    ArrayList<Player> getAllPlayers();
    Player getPlayer(int playerId);

    Player addPlayer(Player player);
    Player updatePlayer(int playerId ,Player player);

    ArrayList<Player> deletePlayer(int playerId);
}