package net.swofty.hypixelbedwarspractice.Events;

import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerDamageEvent {

    public void playerDamageEvent(EntityDamageEvent event) {
        event.setCancelled(true);
    }
}
