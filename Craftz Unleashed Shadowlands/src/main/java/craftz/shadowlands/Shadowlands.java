package craftz.shadowlands;

import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public final class Shadowlands extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("overlord").setExecutor(new Command());

        Bukkit.getPluginManager().registerEvents(new Events(), this);

        //Every tick
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                for(Player e : Bukkit.getOnlinePlayers())
                {
                    if(e.isSneaking() && e.getPlayer().getInventory().getChestplate() != null)
                    {
                        if(e.getPlayer().getInventory().getChestplate().getItemMeta().hasCustomModelData())
                        {
                            if(e.getPlayer().getInventory().getChestplate().getItemMeta().getCustomModelData() == 23)
                            {
                                PotionEffect invis = new PotionEffect(PotionEffectType.INVISIBILITY, 20,1,true);
                                invis.apply(e);
                            }
                        }
                    }

                    for(Entity a : e.getWorld().getEntities())
                    {
                        if(a.getScoreboardTags().contains("ShadowOverlord"))
                        {
                            a.getWorld().spawnParticle(Particle.SQUID_INK, a.getLocation(), 10);
                        }

                        if(a.getType() == EntityType.DROPPED_ITEM)
                        {
                            Item i = (Item) a;

                            if(i.getItemStack().getType() == Material.WARPED_FUNGUS_ON_A_STICK && i.getItemStack().hasItemMeta())
                            {
                                if(i.getItemStack().getItemMeta().hasCustomModelData())
                                {
                                    if(i.getItemStack().getItemMeta().getCustomModelData() == 21)
                                    {
                                        for(Entity b : i.getLocation().getNearbyEntities(1,1,1))
                                        if(b.getType().equals(EntityType.DROPPED_ITEM) && b != i)
                                        {
                                            i.getWorld().spawnParticle(Particle.ELECTRIC_SPARK, i.getLocation().add(0,2,0), 10000);

                                            Zombie z = (Zombie) i.getWorld().spawnEntity(i.getLocation().add(0,2,0), EntityType.ZOMBIE);

                                            z.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(150);
                                            z.setHealth(150);
                                            z.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(8);
                                            z.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(1.1);

                                            ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);
                                            sword.getItemMeta().addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                                            z.getEquipment().setItemInMainHand(sword);

                                            z.addScoreboardTag("ShadowOverlord");

                                            z.getEquipment().setHelmet(new ItemStack(Material.OBSIDIAN));
                                            z.getEquipment().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
                                            z.getEquipment().setLeggings(new ItemStack(Material.NETHERITE_LEGGINGS));
                                            z.getEquipment().setBoots(new ItemStack(Material.NETHERITE_BOOTS));

                                            z.setCustomNameVisible(true);
                                            z.setCustomName(ChatColor.GRAY + "Shadow Overlord");

                                            i.remove();
                                        }

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }, 0, 1);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static void SpawnBoss(Location l, World w)
    {

    }
}
