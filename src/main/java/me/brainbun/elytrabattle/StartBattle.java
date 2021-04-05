package me.brainbun.elytrabattle;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class StartBattle implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (args.length > 0){
                switch(args[0]){
                    case "random":
                        randomLocation(player);
                        break;
                    case "above":
                        abovePlayer(player);
                        break;
                    default:
                        player.sendMessage("/startBattle [random or above]");
                }
            }else{
                player.sendMessage("/startBattle [random or above]");
            }

        } else{
            System.out.println("You need to be a player");
        }

        return false;
    }

    private void teleport(Location location){

        for(Player p : Bukkit.getOnlinePlayers()) {
            p.setSaturation(20);
            p.setHealth(20);
            p.setGlowing(true);
            p.teleport(location);
            p.setBedSpawnLocation(location);
        }
        location.setY(255);
        location.getBlock().setType(Material.STONE);
    }

    private void abovePlayer(Player player){
        World world = player.getWorld();
        WorldBorder border = world.getWorldBorder();

        Location location = player.getLocation();
        location.setY(256);
        border.setSize(300);
        border.setCenter(location);
       teleport(location);
    }

    private void randomLocation(Player player){
        Random random = new Random();

        int x = random.nextInt(10000);
        int y = 256;
        int z = random.nextInt(10000);
        World world = player.getWorld();
        WorldBorder border = world.getWorldBorder();

        Location location = new Location(world,x,y,z);
        border.setSize(300);
        border.setCenter(location);
        teleport(location);
    }
}
