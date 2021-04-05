package me.brainbun.elytrabattle.kit;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class GiveKitPoison extends CreateKitFactory implements MainWeaponInterface,TippedArrowInterface{
    public GiveKitPoison(Player player){
        PlayerInventory inventory = player.getInventory();
        giveWeapon(this,inventory);
        giveTippedArrow(this,inventory);
        giveEssentials(inventory);
    }

    @Override
    public String displayTippedArrowName() {
        return "Poisoned Arrow";
    }

    @Override
    public List<PotionEffectInterface> potionEffects() {
        List<PotionEffectInterface> list = new ArrayList<>();
        PotionEffectInterface effectOne = new PotionEffectInterface() {
            @Override
            public PotionEffectType potionEffect() {
                return PotionEffectType.CONFUSION;
            }

            @Override
            public int duration() {
                return 300;
            }

            @Override
            public int amplifier() {
                return 5;
            }
        };
        PotionEffectInterface effectTwo = new PotionEffectInterface() {
            @Override
            public PotionEffectType potionEffect() {
                return PotionEffectType.POISON;
            }

            @Override
            public int duration() {
                return 100;
            }

            @Override
            public int amplifier() {
                return 2;
            }
        };
        list.add(effectOne);
        list.add(effectTwo);
        return list;
    }

    @Override
    public String displayWeaponName() {
        return null;
    }

    @Override
    public Material mainWeaponMaterial() {
        return Material.BOW;
    }

    @Override
    public Enchantment enchantment() {
        return null;
    }

    @Override
    public int enchantmentLevel() {
        return 0;
    }
}
