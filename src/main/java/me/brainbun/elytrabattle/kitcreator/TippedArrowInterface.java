package me.brainbun.elytrabattle.kitcreator;
import org.bukkit.Color;
import org.bukkit.potion.PotionEffect;

import java.util.List;

public interface TippedArrowInterface {
    String displayTippedArrowName();
    Color color();
    List<PotionEffect> potionEffects();
}
