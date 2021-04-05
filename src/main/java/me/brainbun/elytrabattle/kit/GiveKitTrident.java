package me.brainbun.elytrabattle.kit;

import me.brainbun.elytrabattle.kitcreator.CreateKitFactory;
import me.brainbun.elytrabattle.kitcreator.WeaponCreator;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

public class GiveKitTrident  {
    public GiveKitTrident(Player player){
        PlayerInventory inventory = player.getInventory();
        WeaponCreator mainWeapon = new WeaponCreator("Jeffery",Material.TRIDENT, Enchantment.LOYALTY,3);
        for(int i = 0; i < 5; i++){
            mainWeapon.giveWeapon(inventory);
        }
        CreateKitFactory.giveEssentials(inventory);
    }
}
