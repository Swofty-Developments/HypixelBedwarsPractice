package net.swofty.hypixelbedwarspractice.Events;

import net.swofty.hypixelbedwarspractice.Utils.API;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;

public class PlayerMoveEvent implements Listener {

    @EventHandler
    public void playerMoveEvent(org.bukkit.event.player.PlayerMoveEvent event) throws IOException {
        Player player = event.getPlayer();

        File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("HypixelBedwarsPractice").getDataFolder(), File.separator + "PlayerDatabase");
        File f = new File(userdata, File.separator + player.getPlayer().getUniqueId() + ".yml");
        FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);

        if (playerData.get("ingame").equals("lobby")) {
            player.teleport(new Location(Bukkit.getWorld("spawn"), 0, 200, 0, 0, 0));
        }
    }
}
