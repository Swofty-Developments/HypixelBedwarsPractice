package net.swofty.hypixelbedwarspractice.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Log {

    public static void error(final String... message) {
        Bukkit.getLogger().info("[BWPRAC] [ERROR] " + message);
    }

    public static void info(final String message) {
        Bukkit.getLogger().info("[BWPRAC] [INFO] " + message);
    }

    public static void success(final String message) {
        Bukkit.getLogger().info("[BWPRAC] [SUCCESS] " + message);
    }

    public static void warn(final String message) {
        Bukkit.getLogger().info("[BWPRAC] [WARN] " + message);
    }
}