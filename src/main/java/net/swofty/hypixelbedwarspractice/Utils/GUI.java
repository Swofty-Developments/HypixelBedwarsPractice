package net.swofty.hypixelbedwarspractice.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Wool;

import java.util.ArrayList;

public class GUI {

    public static void giveMainGUI(Player player) {
        Inventory gui = Bukkit.createInventory(player, 36, "Bed Wars Practice");

        Wool bridgingTemp = new Wool();
        bridgingTemp.setColor(DyeColor.CYAN);
        ItemStack bridging = bridgingTemp.toItemStack();
        bridging.setAmount(1);
        ItemMeta bridgingMeta = bridging.getItemMeta();
        bridgingMeta.setDisplayName(API.scolorize("&aBridging"));
        ArrayList<String> bridgingMetaLore = new ArrayList<String>();
        bridgingMetaLore.add(API.scolorize("&7Practice bridging across"));
        bridgingMetaLore.add(API.scolorize("&7the void with wool."));
        bridgingMetaLore.add(API.scolorize("&7 "));
        bridgingMetaLore.add(API.scolorize("&eClick to play!"));
        bridgingMeta.setLore(bridgingMetaLore);
        bridging.setItemMeta(bridgingMeta);


        ItemStack mlg = new ItemStack(Material.WATER_BUCKET);
        mlg.setAmount(1);
        ItemMeta mlgMeta = mlg.getItemMeta();
        mlgMeta.setDisplayName(API.scolorize("&aMLG"));
        ArrayList<String> mlgMetaLore = new ArrayList<String>();
        mlgMetaLore.add(API.scolorize("&7Practice preventing fall"));
        mlgMetaLore.add(API.scolorize("&7damage with water buckets"));
        mlgMetaLore.add(API.scolorize("&7and ladders."));
        mlgMetaLore.add(API.scolorize("&7 "));
        mlgMetaLore.add(API.scolorize("&eClick to play!"));
        mlgMeta.setLore(mlgMetaLore);
        mlg.setItemMeta(mlgMeta);

        ItemStack tnt = new ItemStack(Material.TNT);
        tnt.setAmount(1);
        ItemMeta tntMeta = tnt.getItemMeta();
        tntMeta.setDisplayName(API.scolorize("&aFireball/TNT Jumping"));
        ArrayList<String> tntMetaLore = new ArrayList<String>();
        tntMetaLore.add(API.scolorize("&7Practice jumping over the"));
        tntMetaLore.add(API.scolorize("&7void using Fireballs and"));
        tntMetaLore.add(API.scolorize("&7TNT."));
        tntMetaLore.add(API.scolorize("&7 "));
        tntMetaLore.add(API.scolorize("&eClick to play!"));
        tntMeta.setLore(tntMetaLore);
        tnt.setItemMeta(tntMeta);

        ItemStack close = new ItemStack(Material.BARRIER);
        close.setAmount(1);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(API.scolorize("&cClose"));
        ArrayList<String> closeMetaLore = new ArrayList<String>();
        closeMetaLore.add(API.scolorize("&7Close this GUI"));
        closeMeta.setLore(closeMetaLore);
        close.setItemMeta(closeMeta);

        gui.setItem(11, bridging);
        gui.setItem(13, mlg);
        gui.setItem(15, tnt);
    }
}
