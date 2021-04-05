package net.swofty.hypixelbedwarspractice.Events;

import net.swofty.hypixelbedwarspractice.Loader;
import net.swofty.hypixelbedwarspractice.Managers.Interface.IPracticePlayer;
import net.swofty.hypixelbedwarspractice.Managers.PlayerManager;
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

public class PlayerLoginEvent implements Listener {

    @EventHandler
    public void playerLoginEvent(PlayerJoinEvent event) throws IOException {
        Player player = event.getPlayer();

        player.sendMessage(API.scolorize("&7Logged in as " + player.getPlayer().getUniqueId()));

        event.setJoinMessage("");

        File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("HypixelBedwarsPractice").getDataFolder(), File.separator + "PlayerDatabase");
        File f = new File(userdata, File.separator + player.getPlayer().getUniqueId() + ".yml");
        FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);

        if (!f.exists()) {
            try {
                playerData.createSection("lastlogin");
                playerData.createSection("bridging-statistics");
                playerData.createSection("lastgames");
                playerData.set("bridging-statistics.besttime", "0:00:00");
                playerData.set("lastlogin", System.currentTimeMillis());
                playerData.set("ingame", "lobby");
                player.sendMessage(API.scolorize("&aDo /start to open up the menu start practicing!"));

                playerData.save(f);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        } else {
            playerData.set("lastlogin", System.currentTimeMillis());

            if (!playerData.get("ingame").equals("lobby")) {
                if (playerData.get("ingame").equals("lobby-bypass")) {
                    player.sendMessage(API.scolorize("&7Disabled spawn protection bypass because you left"));
                    playerData.set("ingame", "lobby");
                } else {
                    player.sendMessage(API.scolorize("&7You left during a game, your time has been removed from your history"));
                    playerData.set("ingame", "lobby");
                }
            }
            playerData.save(f);

            player.sendMessage(API.scolorize("&aDo /start to open up the menu start practicing!"));
        }

        player.getInventory().clear();
        player.teleport(new Location(Bukkit.getWorld("spawn"), 0, 200, 0, 0, 0));

    }
}
