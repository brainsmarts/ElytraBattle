package me.brainbun.elytrabattle;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class RegenOnHit implements Listener {

    @EventHandler
    public void regenOnhit(EntityDamageByEntityEvent event){
        if(event.getDamager() instanceof Player){
            if(((Player) event.getDamager()).getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("Melee Weapon")){
                ((Player) event.getDamager()).addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,40,1));
                ((Player) event.getDamager()).addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,100,1));
            }
        }

    }
}
