package me.brainbun.elytrabattle.kit;

import me.brainbun.elytrabattle.kitcreator.CreateKitFactory;
import me.brainbun.elytrabattle.kitcreator.MainWeaponInterface;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

public class GiveKitWildMagic implements MainWeaponInterface {

    public GiveKitWildMagic(Player player){
        PlayerInventory inventory = player.getInventory();
        CreateKitFactory.giveWeapon(this,inventory);
        CreateKitFactory.giveEssentials(inventory);
        CreateKitFactory.giveNormalArrows(inventory);
    }

    @Override
    public String displayWeaponName() {
        return "Wild Magic";
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
