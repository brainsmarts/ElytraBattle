package me.brainbun.elytrabattle.kit;

import me.brainbun.elytrabattle.kitcreator.CreateKitFactory;
import me.brainbun.elytrabattle.kitcreator.WeaponCreator;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.FireworkMeta;

public class GiveKitShotgun {

    public GiveKitShotgun(Player player){
        PlayerInventory inventory = player.getInventory();
        WeaponCreator mainWeapon = new WeaponCreator("Shotgun",Material.CROSSBOW, Enchantment.MULTISHOT,1);
        mainWeapon.giveWeapon(inventory);
        mainWeapon.giveWeapon(inventory);
        CreateKitFactory.giveEssentials(inventory);
        giveFireworks(inventory);
    }

    private void giveFireworks(PlayerInventory inventory){
        ItemStack fireworks = new ItemStack(Material.FIREWORK_ROCKET,64);
        FireworkMeta meta = (FireworkMeta) fireworks.getItemMeta();
        meta.setPower(10);
        for (int i = 0; i < 4; i++){
            meta.addEffect(
                    FireworkEffect.builder().flicker(false).trail(true).with(FireworkEffect.Type.BALL_LARGE).withColor(Color.ORANGE).withFade(Color.RED).build());
        }
        meta.setDisplayName("AMMO");
        fireworks.setItemMeta(meta);

        inventory.addItem(fireworks,fireworks);
    }
}
