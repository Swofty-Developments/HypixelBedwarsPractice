package net.swofty.hypixelbedwarspractice.Managers;

import net.swofty.hypixelbedwarspractice.Managers.Interface.IPracticePlayer;
import org.bukkit.entity.Player;

public class PracticePlayer implements IPracticePlayer {

    protected Player player;

    protected Integer version = -1;

    protected String scoreboard = "";

    protected String uuid = player.getUniqueId().toString();

    /*
     * Constants
     */

    public static final Integer JAVA = 0;
    public static final Integer BEDROCK = 1;

    public static final String LOBBY_SCOREBOARD = "scoreboard.lobby";

    public PracticePlayer(Player thisPlayer)
    {
        player = thisPlayer;
    }

    public Player getBukkitPlayer()
    {
        return player;
    }

    @Override
    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public int getVersion()
    {
        return version;
    }

    @Override
    public String getScoreboardType()
    {
        return scoreboard;
    }

    @Override
    public String getUUID()
    {
        return uuid;
    }

    @Override
    public void setScoreboardType(String scoreboard)
    {
        this.scoreboard = scoreboard;
    }
}