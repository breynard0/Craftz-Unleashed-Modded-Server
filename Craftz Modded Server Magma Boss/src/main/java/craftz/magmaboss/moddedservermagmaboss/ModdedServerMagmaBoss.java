package craftz.magmaboss.moddedservermagmaboss;

import jdk.javadoc.internal.doclint.HtmlTag;
import net.kyori.adventure.text.Component;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.block.data.BlockData;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.function.Predicate;

public final class ModdedServerMagmaBoss extends JavaPlugin {

    public MagmaCube boss = null;

    @Override
    public void onEnable() {
        // Plugin startup logic

        getServer().getPluginManager().registerEvents(new FireballEvents(), this);

        int id = getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
                for (Entity e : getServer().getWorld("world_nether").getEntities()) {



                    if (e.getType() == EntityType.MAGMA_CUBE && getServer().getWorld("world_nether").getBlockAt(e.getLocation().getBlockX() - 1, e.getLocation().getBlockY() - 1, e.getLocation().getBlockZ() -1).getType() == Material.ANCIENT_DEBRIS) {
                        boss = (MagmaCube) getServer().getWorld("world_nether").spawnEntity(e.getLocation(), EntityType.MAGMA_CUBE);
                        boss.addScoreboardTag("magma_boss");
                        boss.setCustomName(ChatColor.RED + "Cubert" + ChatColor.BOLD);
                        boss.setPersistent(true);
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "attribute @e[type=minecraft:magma_cube, limit=1, sort=nearest, tag=] minecraft:generic.follow_range base set 200");
                        MetadataValue size = null;
                        boss.setSize(20);
                        e.remove();
                    }
                }
            }
        }, 0, 40);
        int tick = getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
                for (Entity e : getServer().getWorld("world_nether").getEntities()) {
                    if(e.getScoreboardTags().contains("magma_boss"))
                    {
                        for (Player p : Bukkit.getOnlinePlayers())
                        {
                            if (p.getLocation().distance(p.getLocation()) <= 40)
                            {
                                Location spawnLoc = e.getLocation();
                                Fireball fb = (Fireball) getServer().getWorld("world_nether").spawnEntity(spawnLoc, EntityType.FIREBALL);
                                fb.setDirection(p.getLocation().toVector().subtract(boss.getLocation().toVector()));
                            }
                        }
                    }
                }
            }
        }, 0, 16);
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public Server GetServer()
    {
        return getServer();
    }

}
