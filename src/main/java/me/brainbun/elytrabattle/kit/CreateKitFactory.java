package me.brainbun.elytrabattle.kit;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;

public class CreateKitFactory {

    public void giveEssentials(PlayerInventory inventory){
        inventory.setChestplate(new ItemStack(Material.ELYTRA));
        inventory.addItem(new ItemStack(Material.FIREWORK_ROCKET,64));
    }
    public void giveWeapon(MainWeaponInterface mainWeaponInterface, PlayerInventory inventory){
        ItemStack mainWeapon = new ItemStack(mainWeaponInterface.mainWeaponMaterial());
        if(mainWeaponInterface.enchantment()!= null){
            ItemMeta mainWeaponMeta = mainWeapon.getItemMeta();
            mainWeaponMeta.addEnchant(mainWeaponInterface.enchantment(),mainWeaponInterface.enchantmentLevel(),true);
            mainWeapon.setItemMeta(mainWeaponMeta);
        }
        inventory.addItem(mainWeapon);
    }
    public void giveTippedArrow(TippedArrowInterface arrow, PlayerInventory inventory){
        ItemStack tippedArrow = new ItemStack(Material.TIPPED_ARROW,64);
        PotionMeta potionMeta = (PotionMeta) tippedArrow.getItemMeta();
        for(PotionEffectInterface p :arrow.potionEffects()){
            potionMeta.addCustomEffect(new PotionEffect(p.potionEffect(),p.duration(),p.amplifier()),true);
        }
        potionMeta.setDisplayName(arrow.displayTippedArrowName());
        tippedArrow.setItemMeta(potionMeta);
        inventory.addItem(tippedArrow,tippedArrow);
    }

}
