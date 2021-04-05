package me.brainbun.elytrabattle.kitcreator;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;

public class CreateKitFactory {

    public static void giveEssentials(PlayerInventory inventory){
        inventory.setChestplate(new ItemStack(Material.ELYTRA));
        inventory.addItem(new ItemStack(Material.FIREWORK_ROCKET,64));
    }
    public static void giveEssentials(PlayerInventory inventory, Material helmet){
        giveEssentials(inventory);
        inventory.setHelmet(new ItemStack(helmet));
    }
    public static void giveWeapon(MainWeaponInterface mainWeaponInterface, PlayerInventory inventory){
        ItemStack mainWeapon = new ItemStack(mainWeaponInterface.mainWeaponMaterial());

        ItemMeta mainWeaponMeta = mainWeapon.getItemMeta();
        if(mainWeaponInterface.enchantment() != null){
            mainWeaponMeta.addEnchant(mainWeaponInterface.enchantment(),mainWeaponInterface.enchantmentLevel(),true);
        }

        if (mainWeaponInterface != null){
            mainWeaponMeta.setDisplayName(mainWeaponInterface.displayWeaponName());
        }
        mainWeaponMeta.setUnbreakable(true);
        mainWeapon.setItemMeta(mainWeaponMeta);

        inventory.addItem(mainWeapon);
    }
    public static void giveTippedArrow(TippedArrowInterface arrow, PlayerInventory inventory){
        ItemStack tippedArrow = new ItemStack(Material.TIPPED_ARROW,64);
        PotionMeta potionMeta = (PotionMeta) tippedArrow.getItemMeta();

        for(PotionEffect p :arrow.potionEffects()){
            potionMeta.addCustomEffect(p,true);
        }

        potionMeta.setColor(arrow.color());
        potionMeta.setDisplayName(arrow.displayTippedArrowName());
        tippedArrow.setItemMeta(potionMeta);
        inventory.addItem(tippedArrow,tippedArrow);
    }
    public static void giveNormalArrows(PlayerInventory inventory){
        ItemStack arrow = new ItemStack(Material.ARROW,64);
        inventory.addItem(arrow,arrow);
    }

}
