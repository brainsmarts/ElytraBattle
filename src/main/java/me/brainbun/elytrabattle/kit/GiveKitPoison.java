package me.brainbun.elytrabattle.kit;

import me.brainbun.elytrabattle.kitcreator.MainWeaponInterface;
import me.brainbun.elytrabattle.kitcreator.TippedArrowInterface;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import java.util.ArrayList;
import java.util.List;

import static me.brainbun.elytrabattle.kitcreator.CreateKitFactory.*;

public class GiveKitPoison implements MainWeaponInterface, TippedArrowInterface {
    public GiveKitPoison(Player player){
        PlayerInventory inventory = player.getInventory();
        giveWeapon(this,inventory);
        giveEssentials(inventory);
        giveTippedArrow(this,inventory);
    }

    @Override
    public String displayTippedArrowName() {
        return "Poisoned Arrow";
    }

    @Override
    public Color color() {
        return Color.GREEN;
    }

    @Override
    public List<PotionEffect> potionEffects() {
        List<PotionEffect> list = new ArrayList<>();
        list.add(new PotionEffect(PotionEffectType.POISON,100,2));
        list.add(new PotionEffect(PotionEffectType.CONFUSION,300,5));
        return list;
    }

    @Override
    public String displayWeaponName() {
        return "Fanged Bow";
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
