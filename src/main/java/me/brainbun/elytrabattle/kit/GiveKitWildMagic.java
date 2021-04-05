package me.brainbun.elytrabattle.kit;

import me.brainbun.elytrabattle.kitcreator.CreateKitFactory;
import me.brainbun.elytrabattle.kitcreator.WeaponCreator;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

public class GiveKitWildMagic{

    public GiveKitWildMagic(Player player){
        PlayerInventory inventory = player.getInventory();
        WeaponCreator mainWeapon = new WeaponCreator("Wild Magic",Material.BOW);
        mainWeapon.giveWeapon(inventory);
        CreateKitFactory.giveEssentials(inventory);
        CreateKitFactory.giveNormalArrows(inventory);
    }
}
