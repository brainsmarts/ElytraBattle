package me.brainbun.elytrabattle.kit;

import me.brainbun.elytrabattle.kitcreator.CreateKitFactory;
import me.brainbun.elytrabattle.kitcreator.MainWeaponInterface;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class GiveKitMelee implements MainWeaponInterface {
    public GiveKitMelee(Player player){
        PlayerInventory inventory = player.getInventory();
        CreateKitFactory.giveWeapon(this,inventory);
        CreateKitFactory.giveEssentials(inventory);
        player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST,999999,4));
    }

    @Override
    public String displayWeaponName() {
        return "Melee Weapon";
    }

    @Override
    public Material mainWeaponMaterial() {
        return Material.NETHERITE_AXE;
    }

    @Override
    public Enchantment enchantment() {
        return Enchantment.DAMAGE_ALL;
    }

    @Override
    public int enchantmentLevel() {
        return 10;
    }
}
