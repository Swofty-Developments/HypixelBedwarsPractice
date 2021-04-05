package net.swofty.hypixelbedwarspractice.Managers;

import net.swofty.hypixelbedwarspractice.Utils.API;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SessionManager {

    public static void makeNewSession(Player player) {
        String token = "bridge-" + API.getAlphaNumericString(15);
        player.sendMessage(API.scolorize("&aSending you to " + token + "!"));
    }

    public static void simulateEndSession(Player player) throws IOException {
        String token = "bridge-" + API.getAlphaNumericString(15);

        File userdata3 = new File(Bukkit.getServer().getPluginManager().getPlugin("HypixelBedwarsPractice").getDataFolder(), File.separator + "PlayerDatabase");
        File f3 = new File(userdata3, File.separator + player.getUniqueId() + ".yml");
        FileConfiguration playerData3 = YamlConfiguration.loadConfiguration(f3);
        ArrayList<String> list = (ArrayList<String>) playerData3.getStringList("recentgames");

        list.add(token);
        playerData3.set("recentgames", list);
        playerData3.save(f3);

        File sessionDataFile = new File(Bukkit.getServer().getPluginManager().getPlugin("HypixelBedwarsPractice").getDataFolder(), File.separator + "Sessions");
        File f = new File(sessionDataFile, File.separator + token + ".yml");
        FileConfiguration sessionData = YamlConfiguration.loadConfiguration(f);

        sessionData.createSection("token");
        sessionData.set("token", token);
        sessionData.createSection("player");
        sessionData.set("player", player.getUniqueId());
        sessionData.createSection("created");
        sessionData.set("created", System.currentTimeMillis());
        sessionData.createSection("time");
        sessionData.set("time", "60");
        sessionData.save(f);

        player.sendMessage(API.scolorize("&aSuccessfully spoofed game " + token));
    }
}
