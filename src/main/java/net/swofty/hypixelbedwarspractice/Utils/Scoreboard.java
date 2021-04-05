package net.swofty.hypixelbedwarspractice.Utils;

import net.swofty.hypixelbedwarspractice.Loader;
import net.swofty.hypixelbedwarspractice.Managers.Interface.IPracticePlayer;
import net.swofty.hypixelbedwarspractice.Managers.PracticePlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Scoreboard {

    public static void clearScoreboard(Player player) {
        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
    }

    public static void setBridgeScoreboard(Player player, String token) {
        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
    }



}
