package net.swofty.hypixelbedwarspractice.Events;

import net.swofty.hypixelbedwarspractice.Loader;
import net.swofty.hypixelbedwarspractice.Utils.API;
import net.swofty.hypixelbedwarspractice.Utils.Log;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class ServerStartup {

    public static void SetupPlugin(Plugin plugin) throws IOException {
        File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("HypixelBedwarsPractice").getDataFolder(), File.separator + "Sessions");
        File f = new File(userdata, File.separator + "bridge-test" + ".yml");
        FileConfiguration sessionData = YamlConfiguration.loadConfiguration(f);

        if (!f.exists()) {
            sessionData.createSection("token");
            sessionData.set("token", "bridge-test");
            sessionData.createSection("player");
            sessionData.set("player", "Notch");
            sessionData.createSection("created");
            sessionData.set("created", "1617544878");
            sessionData.createSection("time");
            sessionData.set("time", "60");
            sessionData.save(f);
        }
    }


}
