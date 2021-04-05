package me.brainbun.elytrabattle;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;

public final class Elytrabattle extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("getKit").setExecutor(new GetKit());
        getCommand("startBattle").setExecutor(new StartBattle());
        getServer().getPluginManager().registerEvents(new CustomArrowEffects(),this);
        getServer().getPluginManager().registerEvents(new RegenOnHit(),this);
        getServer().getPluginManager().registerEvents(this,this);
        getServer().getPluginManager().registerEvents(new ExplodeOnDeath(),this);
        getCommand("getKit").setTabCompleter(new GetKitTab());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void setProjectileMeta(EntityShootBowEvent event){
        if (event.getEntity() instanceof Player){
            Player player = (Player)event.getEntity();
            if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("Explosion")){
                event.getProjectile().setMetadata("EffectArrow",new FixedMetadataValue(this,event.getProjectile()));
            } else if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("Wild Magic")){
                event.getProjectile().setMetadata("WildMagic",new FixedMetadataValue(this,event.getProjectile()));
            }
        }
    }


}
