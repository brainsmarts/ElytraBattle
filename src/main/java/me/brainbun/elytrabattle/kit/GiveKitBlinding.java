package me.brainbun.elytrabattle.kit;

import me.brainbun.elytrabattle.kitcreator.CreateKitFactory;
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

public class GiveKitBlinding implements TippedArrowInterface, MainWeaponInterface {
    public GiveKitBlinding(Player player){
        PlayerInventory inventory = player.getInventory();
        CreateKitFactory.giveWeapon(this,inventory);
        CreateKitFactory.giveEssentials(inventory);
        CreateKitFactory.giveTippedArrow(this,inventory);

    }
    @Override
    public String displayWeaponName() {
        return "Ink Shot";
    }

    @Override
    public Material mainWeaponMaterial() {
        return Material.BOW;
    }

    @Override
    public Enchantment enchantment() {
        return Enchantment.ARROW_KNOCKBACK;
    }

    @Override
    public int enchantmentLevel() {
        return 2;
    }

    @Override
    public String displayTippedArrowName() {
        return "Blinding Arrow";
    }

    @Override
    public Color color() {
        return Color.BLACK;
    }

    @Override
    public List<PotionEffect> potionEffects() {
        List<PotionEffect> list = new ArrayList<>();
        list.add(new PotionEffect(PotionEffectType.BLINDNESS,260,10));
        return list;
    }
}
