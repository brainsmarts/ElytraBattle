package me.brainbun.elytrabattle.kitcreator;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class WeaponCreator {
    String weaponName;
    Material weaponMaterial;
    Enchantment enchantment;
    int enchantmentLevel;

    public WeaponCreator(String weaponName, Material weaponMaterial){
        this.weaponName = weaponName;
        this.weaponMaterial = weaponMaterial;
    }

    public WeaponCreator(String weaponName, Material weaponMaterial, Enchantment enchantment, int enchantmentLevel){
        this.weaponName = weaponName;
        this.weaponMaterial = weaponMaterial;
        this.enchantment = enchantment;
        this.enchantmentLevel = enchantmentLevel;
    }

    public void giveWeapon(PlayerInventory inventory){
        ItemStack mainWeapon = new ItemStack(weaponMaterial);

        ItemMeta mainWeaponMeta = mainWeapon.getItemMeta();
        if(enchantment != null){
            mainWeaponMeta.addEnchant(enchantment,enchantmentLevel,true);
        }

        if (weaponName != null){
            mainWeaponMeta.setDisplayName(weaponName);
        }
        mainWeaponMeta.setUnbreakable(true);
        mainWeapon.setItemMeta(mainWeaponMeta);

        inventory.addItem(mainWeapon);
    }
}
