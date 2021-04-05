package net.swofty.hypixelbedwarspractice.Commands;

import net.swofty.hypixelbedwarspractice.Managers.SessionManager;
import net.swofty.hypixelbedwarspractice.Utils.API;
import net.swofty.hypixelbedwarspractice.Utils.GUI;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.List;

public class Command {

    public static void execute(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) throws IOException {
        Player player = (Player) sender;
        switch (label) {

            case "start":
                GUI.giveMainGUI(player);
                break;

            case "history":



            case "commands":
                player.sendMessage(API.scolorize("&b- ADMIN COMMANDS -"));
                player.sendMessage(API.scolorize("&7/executetestflowbridge"));
                player.sendMessage(API.scolorize("&7/simulateendgame"));
                player.sendMessage(API.scolorize("&7/loadedmaps"));
                player.sendMessage(API.scolorize("&7/lastlogin"));
                player.sendMessage(API.scolorize("&7/bypassspawnprot"));
                player.sendMessage(API.scolorize("&b- USER COMMANDS -"));
                player.sendMessage(API.scolorize("&7/start"));
                player.sendMessage(API.scolorize("&7/history"));
                player.sendMessage(API.scolorize("&7/rejoin &c(SOON)"));
                break;

            case "lastlogin":
                if (!player.hasPermission("bedwarsprac.admin")) {
                    player.sendMessage(API.scolorize("&cYou need ADMIN or above to do this command"));
                    return;
                }

                if (args.length == 0) {
                    player.sendMessage(API.scolorize("&cUsage: /lastlogin <user>"));
                    return;
                }

                OfflinePlayer op = Bukkit.getOfflinePlayer(args[0]);

                File userdata = new File(Bukkit.getServer().getPluginManager().getPlugin("HypixelBedwarsPractice").getDataFolder(), File.separator + "PlayerDatabase");
                File f = new File(userdata, File.separator + op.getUniqueId() + ".yml");
                FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);

                if (!f.exists()) {
                    String lastloginunix = playerData.get("lastlogin").toString();
                    player.sendMessage(API.scolorize("&aLast login was " + lastloginunix + " in unix time"));
                } else {
                    player.sendMessage(API.scolorize("&cCould not find " + args[0]));
                }
                break;

            case "bypassspawnprot":
                if (!player.hasPermission("bedwarsprac.admin")) {
                    player.sendMessage(API.scolorize("&cYou need ADMIN or above to do this command"));
                    return;
                }


                File userdata2 = new File(Bukkit.getServer().getPluginManager().getPlugin("HypixelBedwarsPractice").getDataFolder(), File.separator + "PlayerDatabase");
                File f2 = new File(userdata2, File.separator + player.getUniqueId() + ".yml");
                FileConfiguration playerData2 = YamlConfiguration.loadConfiguration(f2);

                playerData2.set("ingame", "lobby-bypass");
                playerData2.save(f2);
                player.sendMessage(API.scolorize("&aYou have enabled lobby bypass"));
                break;

            case "simulateendgame":
                if (!player.hasPermission("bedwarsprac.admin")) {
                    player.sendMessage(API.scolorize("&cYou need ADMIN or above to do this command"));
                    return;
                }

                SessionManager.simulateEndSession(player);
                break;




        }
        return;
    }
}
