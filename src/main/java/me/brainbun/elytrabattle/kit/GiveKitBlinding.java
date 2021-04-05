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

public class GiveKitBlinding implements TippedArrowInterface{
    public GiveKitBlinding(Player player){
        PlayerInventory inventory = player.getInventory();
        WeaponCreator mainWeapon = new WeaponCreator("Ink Shot",Material.BOW,Enchantment.ARROW_KNOCKBACK,2);
        mainWeapon.giveWeapon(inventory);
        CreateKitFactory.giveEssentials(inventory);
        CreateKitFactory.giveTippedArrow(this,inventory);

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
