package me.brainbun.elytrabattle;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
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
                getArrow(args[0],inventory,((Player)sender));
            }else{
                sender.sendMessage("/getKit [kit]");
            }
        } else{
            System.out.println("You need to be a player");
        }
        return false;
    }

    private void getArrow(String arg, PlayerInventory inventory,Player player){
        boolean isValidArgument = true;
        ItemStack mainWeapon = new ItemStack(Material.BOW);
        ItemMeta mainWeaponItemMeta = mainWeapon.getItemMeta();
        ItemStack arrow = new ItemStack(Material.TIPPED_ARROW,64);
        PotionMeta potionMeta = (PotionMeta) arrow.getItemMeta();

        switch (arg){
            case "poison":
                potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.POISON,100,3),true);
                potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.CONFUSION,300,3),true);
                potionMeta.setDisplayName("Poison Arrow");
                break;
            case "blind":
                potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.BLINDNESS,200,3),true);
                potionMeta.setDisplayName("Blinding Arrow");
                break;
            case "gravity":
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING,999999,2));
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
                mainWeapon.setItemMeta(mainWeaponItemMeta);
                break;
            case "wildMagic":
                mainWeaponItemMeta.setDisplayName("Wild Magic");
                mainWeapon.setItemMeta(mainWeaponItemMeta);
                break;
                case "melee":
                mainWeapon=new ItemStack(Material.NETHERITE_AXE);
                mainWeaponItemMeta.addEnchant(Enchantment.DAMAGE_ALL,500,true);
                mainWeapon.setItemMeta(mainWeaponItemMeta);
                arrow = new ItemStack(Material.AIR);
                break;
            default:
                isValidArgument = false;

        }

        if (isValidArgument){
            inventory.setChestplate(new ItemStack(Material.ELYTRA));
            inventory.addItem(mainWeapon);
            inventory.addItem(new ItemStack(Material.FIREWORK_ROCKET,64));
            arrow.setItemMeta(potionMeta);
            inventory.addItem(arrow,arrow);
        }else {
            player.sendMessage("Invalid Kit");
        }
    }
}
