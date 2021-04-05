package me.brainbun.elytrabattle;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class GetKitTab implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        List<String> list = new ArrayList<>();
        list.add("poison");
        list.add("blind");
        list.add("gravity");
        list.add("slowness");
        list.add("tnt");
        list.add("wildMagic");
        list.add("melee");

        return list;
    }
}
