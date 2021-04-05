package me.brainbun.elytrabattle.kit;

import me.brainbun.elytrabattle.kitcreator.CreateKitFactory;
import me.brainbun.elytrabattle.kitcreator.WeaponCreator;
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

public class GiveKitWither implements TippedArrowInterface {
    public GiveKitWither(Player player){
        PlayerInventory inventory = player.getInventory();
        WeaponCreator mainWeapon = new WeaponCreator("Withering Bow",Material.BOW);
        mainWeapon.giveWeapon(inventory);
        CreateKitFactory.giveEssentials(inventory,Material.WITHER_SKELETON_SKULL);
        CreateKitFactory.giveTippedArrow(this,inventory);
    }

    @Override
    public String displayTippedArrowName() {
        return "Arrow of Decay";
    }

    @Override
    public Color color() {
        return Color.GRAY;
    }

    @Override
    public List<PotionEffect> potionEffects() {
        List<PotionEffect> list = new ArrayList<>();
        list.add(new PotionEffect(PotionEffectType.SLOW,300,100));
        list.add(new PotionEffect(PotionEffectType.WITHER,300,0));
        return list;
    }
}
