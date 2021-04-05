package net.swofty.hypixelbedwarspractice.Managers.Interface;

import org.bukkit.entity.Player;

public interface IPracticePlayer {

    Player getBukkitPlayer();

    void setVersion(int version);

    int getVersion();

    void setScoreboardType(String scoreboard);

    String getScoreboardType();

    String getUUID();

}