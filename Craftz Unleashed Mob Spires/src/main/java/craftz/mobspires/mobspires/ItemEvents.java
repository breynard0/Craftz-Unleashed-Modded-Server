package craftz.mobspires.mobspires;

import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.*;

public class ItemEvents implements Listener {

    Inventory echest;

    @EventHandler
    public void Dmg(EntityDamageByEntityEvent e)
    {
        try
        {
            if(e.getDamager().getType().equals(EntityType.PLAYER))
            {
                Player p = (Player) e.getDamager();
                if(p.getInventory().getItemInMainHand() != null)
                    if(p.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData())
                        if(p.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 41)
                        {
                            if((p.getHealth() + (e.getDamage() / 2)) <= p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue()) {
                                p.setHealth(p.getHealth() + Math.round(e.getDamage() / 4));
                                p.sendHealthUpdate();
                            }
                            else
                            {
                                p.setHealth(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
                            }
                        }
            }
        }
        finally
        {

        }

    }

    @EventHandler
    public void Aggro(EntityTargetEvent e)
    {
        if(e.getTarget() instanceof Player)
        {
            if(((Player) e.getTarget()).getInventory().getHelmet() != null && e.getTarget().getWorld().getName().equals("world"))
                if(((Player) e.getTarget()).getInventory().getHelmet().getItemMeta().hasCustomModelData())
                {
                    if(((Player) e.getTarget()).getInventory().getHelmet().getItemMeta().getCustomModelData() == 42)
                    {
                        e.setCancelled(true);
                    }
                }
        }
    }

    @EventHandler
    public void UseItem(PlayerInteractEvent e)
    {
       // if(e.getPlayer().getItemInUse() != null)
        {
            if(e.getAction().isLeftClick() && e.getItem().getItemMeta().hasCustomModelData())
            {
                if(e.getItem().getItemMeta().getCustomModelData() == 43)
                {
                    if(e.getPlayer().getScoreboardTags().contains("shortbow"))
                    {
                        e.getPlayer().removeScoreboardTag("shortbow");
                        e.getPlayer().getWorld().spawnArrow(e.getPlayer().getLocation().add(0, 2, 0), e.getPlayer().getLocation().getDirection(), 2f, 0);
                    }
                }
            }

            if(e.getItem().getItemMeta().hasCustomModelData())
            {
                if(e.getItem().getItemMeta().getCustomModelData() == 45)
                {
                    Snowball proj = (Snowball) e.getPlayer().getWorld().spawnEntity(e.getPlayer().getLocation().add(0, 1, 0), EntityType.SNOWBALL);

                    proj.addScoreboardTag("web");
                    proj.setVelocity(e.getPlayer().getLocation().getDirection().multiply(2));
                }
            }

            if(e.getItem().getItemMeta().hasCustomModelData() && e.getAction().isRightClick())
            {
                if(e.getItem().getItemMeta().getCustomModelData() == 47)
                {
                    e.getPlayer().getWorld().spawnParticle(Particle.PORTAL, e.getPlayer().getLocation(), 400);
                    e.getPlayer().sendRawMessage(ChatColor.LIGHT_PURPLE + "Whoosh!" + ChatColor.BOLD);
                    e.getPlayer().teleport(e.getPlayer().getTargetBlock(120).getLocation());
                    e.getPlayer().getWorld().spawnParticle(Particle.REVERSE_PORTAL, e.getPlayer().getLocation(), 800);
                }
            }

            if(e.getItem().getItemMeta().hasCustomModelData() && e.getAction().isRightClick())
            {
                if(e.getItem().getItemMeta().getCustomModelData() == 431)
                {
                    Location checkLoc =  e.getPlayer().getLocation();

                    for(int i = 0; i < 20; i++)
                    {
                        Collection<Entity> entities = checkLoc.getNearbyEntities(2,2,2);
                        PotionEffect levitation = new PotionEffect(PotionEffectType.LEVITATION, 20, 8,false);

                        for(Entity a : entities)
                        {
                            if(a != e.getPlayer() && a instanceof LivingEntity)
                            {
                                levitation.apply((LivingEntity) a);
                            }
                        }

                        e.getPlayer().getWorld().spawnParticle(Particle.SQUID_INK, checkLoc, 4);
                        checkLoc = checkLoc.toVector().add(e.getPlayer().getLocation().getDirection().multiply(1)).toLocation(e.getPlayer().getWorld());
                    }
                }
            }
        }

    }

    @EventHandler
    public void ProjLaunch(ProjectileLaunchEvent e)
    {
        if(e.getEntity().getType() == EntityType.TRIDENT)
        {
            Player p = (Player) e.getEntity().getShooter();

            if(p.getInventory().getItemInMainHand().hasItemMeta())
            {
                if(p.getInventory().getItemInMainHand().getItemMeta().hasCustomModelData())
                {
                    if(p.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 481)
                    {
                        e.getEntity().addScoreboardTag("FireTrident");
                    }
                }
            }

            if(p.getInventory().getItemInOffHand().hasItemMeta())
            {
                if(p.getInventory().getItemInOffHand().getItemMeta().hasCustomModelData())
                {
                    if(p.getInventory().getItemInOffHand().getItemMeta().getCustomModelData() == 481)
                    {
                        e.getEntity().addScoreboardTag("FireTrident");
                    }
                }
            }


        }
    }

    @EventHandler
    public void ProjHit(ProjectileHitEvent e)
    {
        if(e.getEntity().getScoreboardTags().contains("web") && e.getHitEntity() != null)
        {
            PotionEffect slowness = new PotionEffect(PotionEffectType.SLOW, 20, 4, false, false);
            slowness.apply((LivingEntity) e.getHitEntity());
        }

        if(e.getEntity().getType().equals(EntityType.TRIDENT))
        {
            if(e.getEntity().getScoreboardTags().contains("FireTrident"))
            {
                if(e.getHitEntity() != null)
                {
                    e.getHitEntity().setFireTicks(200);
                }
            }
        }

        Player p = null;

        if(e.getHitEntity() instanceof Player)
        {
            p = (Player) e.getHitEntity();
        }

        if(e.getEntity().getType() == EntityType.ARROW && p != null)
        {
            if(p.getInventory().getBoots() != null)
            {
                if(p.getInventory().getBoots().getItemMeta().hasCustomModelData())
                {
                    if(p.getInventory().getBoots().getItemMeta().getCustomModelData() == 48)
                    {
                        e.setCancelled(true);
                    }
                }
            }
        }
    }

    @EventHandler
    public void InvClose(InventoryCloseEvent e)
    {
        if(e.getInventory().equals(echest))
        {
            e.getPlayer().getEnderChest().setContents(e.getInventory().getStorageContents());
        }
    }

    @EventHandler
    public void Crouch(PlayerToggleSneakEvent e)
    {
        Player p = e.getPlayer();
        if(!p.isSneaking() && p.getInventory().getLeggings() != null)
            if (p.getInventory().getLeggings().getItemMeta().hasCustomModelData())
                if(p.getInventory().getLeggings().getItemMeta().getCustomModelData() == 44)
                {
                    Location loc = p.getLocation().toVector().add(p.getLocation().getDirection().multiply(3)).toLocation(p.getWorld());
                    for(int i = 0; i < 50; i++)
                    {
                        p.getWorld().spawnEntity(loc, EntityType.EVOKER_FANGS);
                    }
                }
        if(p.getInventory().getChestplate() != null)
        {
            if(p.getInventory().getChestplate().getItemMeta().hasCustomModelData())
            {
                if(p.getInventory().getChestplate().getItemMeta().getCustomModelData() == 441)
                {
                    echest = Bukkit.createInventory(p, 27, "Your Ender Chest");

                    ItemStack[] contents = new ItemStack[27];

                    for(int b = 0; b < 27; b++)
                    {
                        ItemStack i = p.getEnderChest().getItem(b);

                        if(i != null)
                        {
                            contents[b] = i;
                        }
                        else
                        {
                            contents[b] = new ItemStack(Material.AIR);
                        }

                    }

                    echest.setContents(contents);

                    p.openInventory(echest);
                }
            }
        }
    }
}
