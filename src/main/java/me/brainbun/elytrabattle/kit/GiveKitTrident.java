package me.brainbun.elytrabattle.kit;

import me.brainbun.elytrabattle.kitcreator.CreateKitFactory;
import me.brainbun.elytrabattle.kitcreator.MainWeaponInterface;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

public class GiveKitTrident implements MainWeaponInterface {
    public GiveKitTrident(Player player){
        PlayerInventory inventory = player.getInventory();
        for(int i = 0; i < 5; i++){
            CreateKitFactory.giveWeapon(this,inventory);
        }
        CreateKitFactory.giveEssentials(inventory);
    }

    @Override
    public String displayWeaponName() {
        return "Jeffery";
    }

    @Override
    public Material mainWeaponMaterial() {
        return Material.TRIDENT;
    }

    @Override
    public Enchantment enchantment() {
        return Enchantment.LOYALTY;
    }

    @Override
    public int enchantmentLevel() {
        return 1;
    }
}
