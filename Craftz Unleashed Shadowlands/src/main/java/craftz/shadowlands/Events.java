package craftz.shadowlands;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class Events implements Listener
{
    @EventHandler
    public void UseItem(PlayerInteractEvent e)
    {
        if(e.getAction().isRightClick())
        {
            if(e.getPlayer().getInventory().getItemInMainHand() != null)
            {
                if(e.getPlayer().getInventory().getItemInMainHand().hasItemMeta())
                if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasCustomModelData())
                {
                    if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 22)
                    {
                        Player player = e.getPlayer();

                        player.playSound(player, Sound.ENTITY_ZOMBIE_VILLAGER_CURE, 1,1);

                        for(int i = 0; i < 10; i++)
                        {
                            player.teleport(player.getLocation().add(player.getLocation().getDirection().multiply(1)));


                            player.getWorld().spawnParticle(Particle.ELECTRIC_SPARK, player.getLocation(), 40);
                            for(Entity a : player.getNearbyEntities(2, 2, 2))
                            {
                                if(a instanceof LivingEntity)
                                {
                                    ((LivingEntity) a).damage(4);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void Drops(EntityDeathEvent e)
    {
        if(e.getEntity().getScoreboardTags().contains("ShadowOverlord"))
        {
            Items i = new Items();

            ItemStack[] drops1 = { i.DarkLordCloak() };
            ItemStack[] drops2 = { i.ShadowFalcion() };
            ItemStack[] drops3 = { i.DarkLordCloak() };
            ItemStack[] drops4 = { i.ShadowFalcion() };

            Random rand = new Random();

            switch (rand.nextInt(4))
            {
                case 1:
                    for(ItemStack f : drops1)
                    {
                        e.getDrops().add(f);
                    }
                    break;
                case 2:
                    for(ItemStack f : drops2)
                    {
                        e.getDrops().add(f);
                    }
                    break;
                case 3:
                    for(ItemStack f : drops3)
                    {
                        e.getDrops().add(f);
                    }
                    break;
                case 4:
                    for(ItemStack f : drops4)
                    {
                        e.getDrops().add(f);
                    }
                    break;
                default:
                    for(ItemStack f : drops1)
                    {
                        e.getDrops().add(f);
                    }
                    System.out.println("Default");
                    break;

            }
        }
    }
}
