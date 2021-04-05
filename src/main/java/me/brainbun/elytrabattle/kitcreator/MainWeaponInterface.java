package me.brainbun.elytrabattle.kitcreator;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

public interface MainWeaponInterface {
    String displayWeaponName();
    Material mainWeaponMaterial();
    Enchantment enchantment();
    int enchantmentLevel();
}
