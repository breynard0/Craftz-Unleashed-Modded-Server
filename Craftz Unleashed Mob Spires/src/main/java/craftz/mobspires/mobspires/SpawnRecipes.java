package craftz.mobspires.mobspires;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

public class SpawnRecipes implements Listener {

    @EventHandler
    public void RingUse(PlayerInteractEvent e) throws InterruptedException {
        if(e.getItem() != null)
        if(e.getItem().getItemMeta().hasCustomModelData())
        {
            if(e.getAction().isRightClick())
            {
                Location l = e.getPlayer().getLocation();

                if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == e.getItem().getItemMeta().getCustomModelData())
                switch (e.getItem().getItemMeta().getCustomModelData())
                {
                    case 101:
                        e.getPlayer().getWorld().spawnParticle(Particle.TOTEM, l, 150);

                        Bukkit.getScheduler().runTaskLater(MobSpires.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                Bosses.Zombie(l, e.getPlayer().getWorld());
                            }
                        }, 60);

                        if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == e.getItem().getItemMeta().getCustomModelData())
                        {
                            e.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                        }
                        else
                        {
                            e.getPlayer().getInventory().setItemInOffHand(new ItemStack(Material.AIR));
                        }

                        break;
                    case 102:
                        e.getPlayer().getWorld().spawnParticle(Particle.TOTEM, l, 150);

                        Bukkit.getScheduler().runTaskLater(MobSpires.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                Bosses.Skeleton(l, e.getPlayer().getWorld());
                            }
                        }, 60);

                        if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == e.getItem().getItemMeta().getCustomModelData())
                        {
                            e.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                        }
                        else
                        {
                            e.getPlayer().getInventory().setItemInOffHand(new ItemStack(Material.AIR));
                        }

                        break;
                    case 103:
                        e.getPlayer().getWorld().spawnParticle(Particle.TOTEM, l, 150);

                        Bukkit.getScheduler().runTaskLater(MobSpires.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                Bosses.Spider(l, e.getPlayer().getWorld());
                            }
                        }, 60);

                        if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == e.getItem().getItemMeta().getCustomModelData())
                        {
                            e.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                        }
                        else
                        {
                            e.getPlayer().getInventory().setItemInOffHand(new ItemStack(Material.AIR));
                        }

                        break;
                    case 104:
                        e.getPlayer().getWorld().spawnParticle(Particle.TOTEM, l, 150);

                        Bukkit.getScheduler().runTaskLater(MobSpires.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                Bosses.Enderman(l, e.getPlayer().getWorld());
                            }
                        }, 60);

                        if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == e.getItem().getItemMeta().getCustomModelData())
                        {
                            e.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                        }
                        else
                        {
                            e.getPlayer().getInventory().setItemInOffHand(new ItemStack(Material.AIR));
                        }

                        break;
                    case 105:
                        e.getPlayer().getWorld().spawnParticle(Particle.TOTEM, l, 150);

                        Bukkit.getScheduler().runTaskLater(MobSpires.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                Bosses.Slime(l, e.getPlayer().getWorld());
                            }
                        }, 60);

                        if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == e.getItem().getItemMeta().getCustomModelData())
                        {
                            e.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                        }
                        else
                        {
                            e.getPlayer().getInventory().setItemInOffHand(new ItemStack(Material.AIR));
                        }

                        break;
                    case 106:
                        e.getPlayer().getWorld().spawnParticle(Particle.TOTEM, l, 150);

                        Bukkit.getScheduler().runTaskLater(MobSpires.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                Bosses.Shulker(l, e.getPlayer().getWorld());
                            }
                        }, 60);

                        if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == e.getItem().getItemMeta().getCustomModelData())
                        {
                            e.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                        }
                        else
                        {
                            e.getPlayer().getInventory().setItemInOffHand(new ItemStack(Material.AIR));
                        }

                        break;
                    case 107:
                        e.getPlayer().getWorld().spawnParticle(Particle.TOTEM, l, 150);

                        Bukkit.getScheduler().runTaskLater(MobSpires.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                Bosses.Blaze(l, e.getPlayer().getWorld());
                            }
                        }, 60);

                        if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == e.getItem().getItemMeta().getCustomModelData())
                        {
                            e.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                        }
                        else
                        {
                            e.getPlayer().getInventory().setItemInOffHand(new ItemStack(Material.AIR));
                        }

                        break;
                    default:
                        break;
                }
            }
        }
    }

}
