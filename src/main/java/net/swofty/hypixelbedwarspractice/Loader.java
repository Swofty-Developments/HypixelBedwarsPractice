package net.swofty.hypixelbedwarspractice;

import net.swofty.hypixelbedwarspractice.Events.PlayerLoginEvent;
import net.swofty.hypixelbedwarspractice.Events.PlayerMoveEvent;
import net.swofty.hypixelbedwarspractice.Events.ServerStartup;
import net.swofty.hypixelbedwarspractice.Managers.PlayerManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class Loader extends JavaPlugin implements CommandExecutor {

    private PlayerManager playerManager;

    private static Loader instance;

    public static Loader getInstance()
    {
        return instance;
    }

    public PlayerManager getPlayerManager()
    {
        return playerManager;
    }

    @Override
    public void onEnable()
    {
        try {
            ServerStartup.SetupPlugin(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        registerEvents();
    }

    @Override
    public void onDisable()
    {
        // Plugin shutdown logic
    }

    public void registerEvents()
    {
        getServer().getPluginManager().registerEvents(new PlayerLoginEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerMoveEvent(), this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        try {
            net.swofty.hypixelbedwarspractice.Commands.Command.execute(sender, command, label, args);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
