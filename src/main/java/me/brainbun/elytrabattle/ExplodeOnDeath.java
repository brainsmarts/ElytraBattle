package me.brainbun.elytrabattle;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class ExplodeOnDeath implements Listener {

    @EventHandler
    public void explodeOnDeath(PlayerDeathEvent event){
        Location location = event.getEntity().getLocation();
        World world = event.getEntity().getWorld();
        world.createExplosion(location,5);
    }
}
