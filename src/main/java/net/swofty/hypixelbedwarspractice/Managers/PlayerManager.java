package net.swofty.hypixelbedwarspractice.Managers;

import net.swofty.hypixelbedwarspractice.Managers.Interface.IPracticePlayer;
import net.swofty.hypixelbedwarspractice.Utils.Log;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerManager {

    private final Map<Player, PracticePlayer> players = new HashMap<Player, PracticePlayer>();

    public void registerPlayer(Player player)
    {
        PracticePlayer practicePlayer = new PracticePlayer(player);
        players.put(player, practicePlayer);
    }

    public void unregisterPlayer(Player player)
    {
        if(players.containsKey(player))
        {
            players.remove(player);

            Log.info("Unregistered " + player.getName() + " from the database.");
        }
    }

    public IPracticePlayer getPlayer(Player player)
    {
        return players.getOrDefault(player, null);
    }


}
