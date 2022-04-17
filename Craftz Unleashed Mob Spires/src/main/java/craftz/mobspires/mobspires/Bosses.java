package craftz.mobspires.mobspires;

import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.loot.Lootable;

import java.util.UUID;

public class Bosses {
    public static void Zombie(Location l, World w)
    {
        Zombie zombie = (Zombie) w.spawnEntity(l, EntityType.ZOMBIE);
        
        zombie.setCustomNameVisible(true);
        zombie.setCustomName(ChatColor.GREEN + "ZOMBOSS PRIME");

        zombie.getEquipment().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
        zombie.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
        zombie.getEquipment().setChestplate((new ItemStack(Material.GOLDEN_CHESTPLATE)));
        zombie.getEquipment().setHelmet(new ItemStack(Material.TURTLE_HELMET));

        ItemStack zombieSword = new ItemStack(Material.STONE_SWORD);
        ItemMeta swordMeta = zombieSword.getItemMeta();
        swordMeta.addEnchant(Enchantment.KNOCKBACK, 3, true);
        swordMeta.addEnchant(Enchantment.DAMAGE_ALL, 6, true);
        zombieSword.setItemMeta(swordMeta);
        zombie.getEquipment().setItemInMainHand(zombieSword);

        zombie.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(150);
        zombie.setHealth(150);

        zombie.addScoreboardTag("MSZombieBoss");
    }

    public static void Skeleton(Location l, World w)
    {
        Skeleton skelly = (Skeleton) w.spawnEntity(l, EntityType.SKELETON);

        skelly.setCustomNameVisible(true);
        skelly.setCustomName("SKELLY SOLDIER");

        skelly.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS));
        skelly.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
        skelly.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        skelly.getEquipment().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));

        ItemStack skellyBow = new ItemStack(Material.BOW);
        ItemMeta bowMeta = skellyBow.getItemMeta();
        bowMeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
        bowMeta.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
        skellyBow.setItemMeta(bowMeta);
        skelly.getEquipment().setItemInMainHand(skellyBow);

        skelly.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(80);
        skelly.setHealth(80);

        skelly.addScoreboardTag("MSSkeletonBoss");
    }

    public static void Spider(Location l, World w)
    {
        Spider spider = (Spider) w.spawnEntity(l, EntityType.SPIDER);

        spider.setCustomNameVisible(true);
        spider.setCustomName(ChatColor.AQUA + "SPIDEY");

        spider.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(180);
        spider.setHealth(180);

        spider.addScoreboardTag("MSSpiderBoss");
    }

    public static void Enderman(Location l, World w)
    {
        Enderman enderman = (Enderman) w.spawnEntity(l, EntityType.ENDERMAN);

        enderman.setCustomNameVisible(true);
        enderman.setCustomName(ChatColor.LIGHT_PURPLE + "BUFF ENDERMAN");

        enderman.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(130);
        enderman.setHealth(130);
        enderman.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(5);

        enderman.addScoreboardTag("MSEnderBoss");
    }

    public static void Slime(Location l, World w)
    {
        Slime slime = (Slime) w.spawnEntity(l, EntityType.SLIME);

        slime.setSize(12);

        slime.setCustomNameVisible(true);
        slime.setCustomName(ChatColor.GREEN + "CUBERT II");

        slime.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(100);
        slime.setHealth(100);

        slime.addScoreboardTag("MSSlimeBoss");
    }

    public static void Shulker(Location l, World w)
    {
        Shulker shulker = (Shulker) w.spawnEntity(l, EntityType.SHULKER);

        shulker.setCustomNameVisible(true);
        shulker.setCustomName(ChatColor.DARK_PURPLE + "OPEY-CLOSEY MAN");

        shulker.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(60);
        shulker.setHealth(60);

        shulker.addScoreboardTag("MSShulkerBoss");
    }

    public static void Blaze(Location l, World w)
    {
        Blaze blaze = (Blaze) w.spawnEntity(l, EntityType.BLAZE);

        blaze.setCustomNameVisible(true);
        blaze.setCustomName(ChatColor.YELLOW + "BLAZIN' BLITZ");

        blaze.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(70);
        blaze.setHealth(70);

        blaze.addScoreboardTag("MSBlazeBoss");
    }
}
