package craftz.mobspires.mobspires;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.material.MaterialData;

import javax.print.attribute.Attribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Items {

    public ItemStack ZombieScimitar()
    {
        ItemStack scimitar = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = scimitar.getItemMeta();

        meta.setDisplayName(ChatColor.GOLD + "Zombo Scimitar");
        meta.setCustomModelData(41);
        String[] lore = {"Special Ability: LIFESTEAL", "Heal for 25% of the damage you deal", "with this weapon on hit"};
        meta.setLore(Arrays.stream(lore).toList());

        scimitar.setItemMeta(meta);
        return scimitar;
    }

    public ItemStack ZombieHelm()
    {
        ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta meta = helm.getItemMeta();

        meta.setDisplayName(ChatColor.AQUA + "Zombo Helm");
        meta.setCustomModelData(42);
        String[] lore = {"Special Ability: CAMOUFLAGE", "Makes you unnoticeable to most ", "overworld mobs"};
        meta.setLore(Arrays.stream(lore).toList());

        helm.setItemMeta(meta);
        return helm;
    }

    public ItemStack Shortbow()
    {
        ItemStack shortbow = new ItemStack(Material.BOW);
        ItemMeta meta = shortbow.getItemMeta();

        meta.setDisplayName(ChatColor.WHITE + "Skelly Shortbow");
        meta.setCustomModelData(43);
        String[] lore = {"Special Ability: SHORTBOW", "Shoots instantly on left click"};
        meta.setLore(Arrays.stream(lore).toList());
        
        shortbow.setItemMeta(meta);
        return shortbow;
    }

    public ItemStack BonyPants()
    {
        ItemStack pants = new ItemStack(Material.IRON_LEGGINGS);
        ItemMeta meta = pants.getItemMeta();

        meta.setDisplayName(ChatColor.WHITE + "Bony pants");
        meta.setCustomModelData(44);
        String[] lore = {"Special Ability: TRIBAL", "\"Bones\" pop up from the ground on crouch"};
        meta.setLore(Arrays.stream(lore).toList());

        pants.setItemMeta(meta);
        return pants;
    }

    public ItemStack SpideySlingshot()
    {
        ItemStack slingshot = new ItemStack(Material.STICK);
        ItemMeta meta = slingshot.getItemMeta();

        meta.setDisplayName(ChatColor.BLUE + "Spidey Slingshot");
        meta.setCustomModelData(45);
        String[] lore = {"Special Ability: Webbing", "Slows down entities on hit"};
        meta.setLore(Arrays.stream(lore).toList());

        slingshot.setItemMeta(meta);
        return slingshot;
    }

    public ItemStack TarantulaHat()
    {
        ItemStack hat = new ItemStack(Material.CHAINMAIL_HELMET);
        ItemMeta meta = hat.getItemMeta();

        meta.setDisplayName(ChatColor.RED + "Tarantula Hat");
        meta.setCustomModelData(46);
        String[] lore = {"Special Ability: Eye of the Spider", "Gives you night vision and ", "lets you climb up walls"};
        meta.setLore(Arrays.stream(lore).toList());

        hat.setItemMeta(meta);
        return hat;
    }

    public ItemStack EnderStaff()
    {
        ItemStack staff = new ItemStack(Material.BLAZE_ROD);
        ItemMeta meta = staff.getItemMeta();

        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Ender Staff");
        meta.setCustomModelData(47);
        String[] lore = {"Special Ability: Cosmos Dislocation", "Instantly teleports you where ", "you're looking on right click"};
        meta.setLore(Arrays.stream(lore).toList());

        staff.setItemMeta(meta);
        return staff;
    }

    public ItemStack EmanBoots()
    {
        ItemStack boots = new ItemStack(Material.IRON_BOOTS);
        ItemMeta meta = boots.getItemMeta();

        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "E-man's Boots");
        meta.setCustomModelData(48);
        String[] lore = {"Special Ability: Magnetosphere", "Negates damage from arrows"};
        meta.setLore(Arrays.stream(lore).toList());

        boots.setItemMeta(meta);
        return boots;
    }

    public ItemStack KBStick()
    {
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta meta = stick.getItemMeta();

        meta.setDisplayName(ChatColor.GREEN + "KB Stick");
        meta.setCustomModelData(411);
        meta.addEnchant(Enchantment.KNOCKBACK, 5, true);
        String[] lore = {"Special Ability: KB", "Whoosh!"};
        meta.setLore(Arrays.stream(lore).toList());

        stick.setItemMeta(meta);
        return stick;
    }

    public ItemStack FrogBoots()
    {
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta meta = boots.getItemMeta();

        LeatherArmorMeta lam = (LeatherArmorMeta) meta;

        lam.setDisplayName(ChatColor.GREEN + "Frog Boots");
        lam.setCustomModelData(421);
        String[] lore = {"Special Ability: Amphibian", "Jump boost and water breathing while wearing!"};
        lam.setLore(Arrays.stream(lore).toList());
        lam.setColor(Color.GREEN);

        boots.setItemMeta(lam);
        return boots;
    }

    public ItemStack WhooshWhip()
    {
        ItemStack boots = new ItemStack(Material.STICK);
        ItemMeta meta = boots.getItemMeta();

        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Whoosh Whip");
        meta.setCustomModelData(431);
        String[] lore = {"Special Ability: Whip", "Right click to cast!", " Gives anyone it hits levitation"};
        meta.setLore(Arrays.stream(lore).toList());

        boots.setItemMeta(meta);
        return boots;
    }

    public ItemStack ShulkerChestplate()
    {
        ItemStack boots = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = boots.getItemMeta();

        meta.setDisplayName(ChatColor.DARK_PURPLE + "Shulker Chestplate");
        meta.setCustomModelData(441);
        String[] lore = {"Special Ability: Mobile Linking", "Crouch to access your ender chest!"};
        meta.setLore(Arrays.stream(lore).toList());

        boots.setItemMeta(meta);
        return boots;
    }

    public ItemStack BlazeBlazer()
    {
        ItemStack boots = new ItemStack(Material.NETHERITE_CHESTPLATE);
        ItemMeta meta = boots.getItemMeta();

        meta.setDisplayName(ChatColor.RED + "Blaze Blazer");
        meta.setCustomModelData(471);
        String[] lore = {"Special Ability: Fondue", "Slowly heal in lava!", "Special Ability: Hot Hands", "Get fire resistance while wearing!"};
        meta.setLore(Arrays.stream(lore).toList());

        boots.setItemMeta(meta);
        return boots;
    }

    public ItemStack FireTrident()
    {
        ItemStack boots = new ItemStack(Material.TRIDENT);
        ItemMeta meta = boots.getItemMeta();

        meta.setDisplayName(ChatColor.RED + "Fire Trident");
        meta.setCustomModelData(481);
        String[] lore = {"Special Ability: Scorch", "Sets enemies on fire!"};
        meta.setLore(Arrays.stream(lore).toList());

        boots.setItemMeta(meta);
        return boots;
    }
}
