package me.brainbun.elytrabattle;

import me.brainbun.elytrabattle.kit.GiveKitPoison;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class GetKit implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            PlayerInventory inventory = ((Player) sender).getInventory();

            if (args.length > 0){
                getKit(args[0],inventory,((Player)sender));
            }else{
                sender.sendMessage("/getKit [kit]");
            }
        } else{
            System.out.println("You need to be a player");
        }
        return false;
    }

    private void getKit(String arg, PlayerInventory inventory, Player player){
        boolean isValidArgument = true;
        ItemStack mainWeapon = new ItemStack(Material.BOW);
        ItemMeta mainWeaponItemMeta = mainWeapon.getItemMeta();
        ItemStack ammo = new ItemStack(Material.TIPPED_ARROW,64);
        PotionMeta potionMeta = (PotionMeta) ammo.getItemMeta();

        switch (arg){
            case "poison":
                new GiveKitPoison(player);
                break;
            case "blind":
                potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.BLINDNESS,200,3),true);
                potionMeta.setDisplayName("Blinding Arrow");
                break;
            case "gravity":
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING,999999,0));
                potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.LEVITATION,120,3),true);
                potionMeta.setDisplayName("Levitating Arrow");
                break;
            case "slowness":
                potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.SLOW,300,100),true);
                potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.WITHER,100,1),true);
                potionMeta.setDisplayName("Slowness Arrow");
                break;
            case "tnt":
                mainWeaponItemMeta.setDisplayName("Explosion");
                break;
            case "wildMagic":
                mainWeaponItemMeta.setDisplayName("Wild Magic");
                break;
            case "melee":
                mainWeapon=new ItemStack(Material.NETHERITE_AXE);
                mainWeaponItemMeta.addEnchant(Enchantment.DAMAGE_ALL,500,true);
                ammo = new ItemStack(Material.AIR);
                break;
            case "shotgun":
                mainWeapon = new ItemStack(Material.CROSSBOW);
                mainWeaponItemMeta.addEnchant(Enchantment.MULTISHOT,2,true);


                ammo = new ItemStack(Material.FIREWORK_ROCKET,64);
                FireworkMeta meta = (FireworkMeta) ammo.getItemMeta();
                meta.setPower(10);
                for (int i = 0; i < 4; i++){
                    meta.addEffect(
                            FireworkEffect.builder().flicker(false).trail(true).with(FireworkEffect.Type.BALL_LARGE).withColor(Color.ORANGE).withFade(Color.RED).build());
                }
                ammo.setItemMeta(meta);
                break;
            default:
                isValidArgument = false;
        }

        if (isValidArgument){
            mainWeapon.setItemMeta(mainWeaponItemMeta);
            inventory.setChestplate(new ItemStack(Material.ELYTRA));
            inventory.addItem(mainWeapon);
            inventory.setChestplate(new ItemStack(Material.ELYTRA));
            ammo.setItemMeta(potionMeta);
            inventory.addItem(ammo,ammo);
        }else {
            player.sendMessage("Invalid Kit");
        }
    }
}
