package craftz.shadowlands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Items {
    public ItemStack ShadowFalcion()
    {
        ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);

        ItemMeta swordMeta = sword.getItemMeta();

        swordMeta.setCustomModelData(22);
        swordMeta.setDisplayName(ChatColor.GRAY + "Shadow Falcion");
        String[] lore = {"Right click: Implosion"};
        swordMeta.setLore(Arrays.stream(lore).toList());

        sword.setItemMeta(swordMeta);

        return sword;
    }

    public ItemStack ShadowHeart()
    {
        ItemStack sword = new ItemStack(Material.WARPED_FUNGUS_ON_A_STICK);

        ItemMeta swordMeta = sword.getItemMeta();

        swordMeta.setCustomModelData(21);
        swordMeta.setDisplayName(ChatColor.RED + "Shadow Heart");
        String[] lore = {"Throw on ground with another item in the same spot ", "and brace yourself"};
        swordMeta.setLore(Arrays.stream(lore).toList());

        sword.setItemMeta(swordMeta);

        return sword;
    }

    public ItemStack DarkLordCloak()
    {
        ItemStack sword = new ItemStack(Material.NETHERITE_CHESTPLATE);

        ItemMeta swordMeta = sword.getItemMeta();

        swordMeta.setCustomModelData(23);
        swordMeta.setDisplayName(ChatColor.GRAY + "Dark Lord Chestplate");
        String[] lore = {"Shadow Shroud: ", "Shift to conceal yourself with shadows"};
        swordMeta.setLore(Arrays.stream(lore).toList());

        sword.setItemMeta(swordMeta);

        return sword;
    }
}
