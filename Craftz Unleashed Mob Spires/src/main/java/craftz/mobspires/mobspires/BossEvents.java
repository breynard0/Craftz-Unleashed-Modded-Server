package craftz.mobspires.mobspires;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ShulkerBullet;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class BossEvents implements Listener {
    @EventHandler
    public void DeathLoot(EntityDeathEvent e)
    {
        Items CustomItems = new Items();
        Random rand = new Random();

        if(e.getEntity().getScoreboardTags().contains("MSZombieBoss"))
        {
            ItemStack[] dropsWeapon = { CustomItems.ZombieScimitar() };
            ItemStack[] dropsArmor = { CustomItems.ZombieHelm() };

            if(rand.nextInt(2) == 0)
            {
                for(ItemStack i : dropsArmor)
                {
                    e.getDrops().add(i);
                }
            }
            else
            {
                for(ItemStack i : dropsWeapon)
                {
                    e.getDrops().add(i);
                }
            }
        }

        if(e.getEntity().getScoreboardTags().contains("MSSkeletonBoss"))
        {
            ItemStack[] dropsWeapon = { CustomItems.Shortbow() };
            ItemStack[] dropsArmor = { CustomItems.BonyPants() };

            if(rand.nextInt(2) == 0)
            {
                for(ItemStack i : dropsArmor)
                {
                    e.getDrops().add(i);
                }
            }
            else
            {
                for(ItemStack i : dropsWeapon)
                {
                    e.getDrops().add(i);
                }
            }
        }

        if(e.getEntity().getScoreboardTags().contains("MSSpiderBoss"))
        {
            ItemStack[] dropsWeapon = { CustomItems.SpideySlingshot() };
            ItemStack[] dropsArmor = { CustomItems.TarantulaHat() };

            if(rand.nextInt(2) == 0)
            {
                for(ItemStack i : dropsArmor)
                {
                    e.getDrops().add(i);
                }
            }
            else
            {
                for(ItemStack i : dropsWeapon)
                {
                    e.getDrops().add(i);
                }
            }
        }

        if(e.getEntity().getScoreboardTags().contains("MSEnderBoss"))
        {
            ItemStack[] dropsWeapon = { CustomItems.EnderStaff() };
            ItemStack[] dropsArmor = { CustomItems.EmanBoots() };

            if(rand.nextInt(2) == 0)
            {
                for(ItemStack i : dropsArmor)
                {
                    e.getDrops().add(i);
                }
            }
            else
            {
                for(ItemStack i : dropsWeapon)
                {
                    e.getDrops().add(i);
                }
            }
        }

        if(e.getEntity().getScoreboardTags().contains("MSSlimeBoss"))
        {
            ItemStack[] dropsWeapon = { CustomItems.KBStick() };
            ItemStack[] dropsArmor = { CustomItems.FrogBoots() };

            if(rand.nextInt(2) == 0)
            {
                for(ItemStack i : dropsArmor)
                {
                    e.getDrops().add(i);
                }
            }
            else
            {
                for(ItemStack i : dropsWeapon)
                {
                    e.getDrops().add(i);
                }
            }
        }

        if(e.getEntity().getScoreboardTags().contains("MSShulkerBoss"))
        {
            ItemStack[] dropsWeapon = { CustomItems.WhooshWhip() };
            ItemStack[] dropsArmor = { CustomItems.ShulkerChestplate() };

            if(rand.nextInt(2) == 0)
            {
                for(ItemStack i : dropsArmor)
                {
                    e.getDrops().add(i);
                }
            }
            else
            {
                for(ItemStack i : dropsWeapon)
                {
                    e.getDrops().add(i);
                }
            }
        }

        if(e.getEntity().getScoreboardTags().contains("MSBlazeBoss"))
        {
            ItemStack[] dropsWeapon = { CustomItems.FireTrident() };
            ItemStack[] dropsArmor = { CustomItems.BlazeBlazer() };

            if(rand.nextInt(2) == 0)
            {
                for(ItemStack i : dropsArmor)
                {
                    e.getDrops().add(i);
                }
            }
            else
            {
                for(ItemStack i : dropsWeapon)
                {
                    e.getDrops().add(i);
                }
            }
        }
    }

    @EventHandler
    public void ProjHit(ProjectileHitEvent e)
    {
        if(e.getHitEntity() != null)
            if(e.getEntity().getScoreboardTags().contains("SkellyFallAttack") && e.getHitEntity().getType() == EntityType.SKELETON)
            {
                e.setCancelled(true);
            }
    }
}
