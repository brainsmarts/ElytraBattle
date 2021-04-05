package me.brainbun.elytrabattle.kit;

import me.brainbun.elytrabattle.kitcreator.MainWeaponInterface;
import me.brainbun.elytrabattle.kitcreator.TippedArrowInterface;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

import static me.brainbun.elytrabattle.kitcreator.CreateKitFactory.*;

public class GiveKitGravity implements MainWeaponInterface, TippedArrowInterface {
    public GiveKitGravity(Player player){
        PlayerInventory inventory = player.getInventory();
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING,99999,1));
        giveWeapon(this,inventory);
        giveEssentials(inventory,Material.WHITE_STAINED_GLASS);
        giveTippedArrow(this,inventory);
    }

    @Override
    public String displayWeaponName() {
        return "Star Shot";
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

    @Override
    public String displayTippedArrowName() {
        return "Star Arrow";
    }

    @Override
    public Color color() {
        return Color.YELLOW;
    }

    @Override
    public List<PotionEffect> potionEffects() {
        List<PotionEffect> list = new ArrayList<>();
        list.add(new PotionEffect(PotionEffectType.LEVITATION,80,2));
        return list;
    }
}
