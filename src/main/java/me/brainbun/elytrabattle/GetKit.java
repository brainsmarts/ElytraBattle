package me.brainbun.elytrabattle;

import me.brainbun.elytrabattle.kit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetKit implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            if (args.length > 0){
                getKit(args[0],((Player)sender));
            }else{
                sender.sendMessage("/getKit [kit]");
            }
        } else{
            System.out.println("You need to be a player");
        }
        return false;
    }

    private void getKit(String arg, Player player){
        switch (arg){
            case "poison":
                new GiveKitPoison(player);
                break;
            case "blind":
                new GiveKitBlinding(player);
                break;
            case "gravity":
                new GiveKitGravity(player);
                break;
            case "slowness":
                new GiveKitWither(player);
                break;
            case "tnt":
                new GiveKitTnt(player);
                break;
            case "wildMagic":
                new GiveKitWildMagic(player);
                break;
            case "melee":
                new GiveKitMelee(player);
                break;
            case "shotgun":
                new GiveKitShotgun(player);
                break;
            case "trident":
                new GiveKitTrident(player);
                break;
            default:
                player.sendMessage("Kit Not Found");
        }
    }
}
