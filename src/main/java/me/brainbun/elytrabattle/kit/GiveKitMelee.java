package me.brainbun.elytrabattle.kit;

import me.brainbun.elytrabattle.kitcreator.CreateKitFactory;
import me.brainbun.elytrabattle.kitcreator.WeaponCreator;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class GiveKitMelee {
    public GiveKitMelee(Player player){
        PlayerInventory inventory = player.getInventory();

        WeaponCreator mainWeapon = new WeaponCreator("Melee Weapon",Material.NETHERITE_AXE,Enchantment.DAMAGE_ALL,10);
        mainWeapon.giveWeapon(inventory);

        CreateKitFactory.giveEssentials(inventory);
        player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST,999999,4));
    }
}
