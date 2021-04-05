package me.brainbun.elytrabattle;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class CustomArrowEffects implements Listener {

    @EventHandler
    public void CustomArrowEffects(ProjectileHitEvent event){
        if (event.getEntity().getShooter() instanceof  Player
                && event.getHitEntity() instanceof  Player){
            Location location = event.getHitEntity().getLocation();
            World world = event.getEntity().getWorld();
            Player victim = (Player)event.getHitEntity();
            Projectile arrow = event.getEntity();
            if (arrow.hasMetadata("EffectArrow")){
                event.getHitEntity().getLocation();
                world.createExplosion(location,2,true);
            } else if (arrow.hasMetadata("WildMagic")){
                wildMagic(victim);
            }
        }
    }

    private void wildMagic(Player victim){
        Random random = new Random();
        int x = random.nextInt(10)+1;
        World world = victim.getWorld();


        switch (x){
            case 6:
                world.createExplosion(victim.getLocation(),20,true);
                for(int i = 0; i < 10; i++){
                    world.strikeLightning(victim.getLocation());
                }
                break;
            case 7:
                Location location = victim.getLocation();
                location.setY(location.getY()+(Math.random()-20)+40);
                location.setX(location.getX()-(Math.random()-20)+40);
                location.setZ(location.getZ()-(Math.random()-20)+40);
                victim.teleport(location);
                break;
            case 8:
                randomPotionEffect(victim);
                break;
            case 9:

                for(int i = 0; i < 10; i++){
                    world.spawnEntity(victim.getLocation(), EntityType.BLAZE);
                }
                break;
            case 10:
                victim.getInventory().clear();
        }
    }

    private void randomPotionEffect(Player victim){
        Random random = new Random();
        if (1 == random.nextInt(2)){
            victim.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,200,10));
        }
        if (1 == random.nextInt(2)){
            victim.addPotionEffect(new PotionEffect(PotionEffectType.POISON,100,3));
        }
        if (1 == random.nextInt(2)){
            victim.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,200,10));
        }
        if (1 == random.nextInt(2)){
            victim.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,300,10));
        }
        if (1 == random.nextInt(2)){
            victim.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION,240,10));
        }
        if (1 == random.nextInt(2)){
            victim.addPotionEffect(new PotionEffect(PotionEffectType.HEAL,200,10));
        }
    }
}
