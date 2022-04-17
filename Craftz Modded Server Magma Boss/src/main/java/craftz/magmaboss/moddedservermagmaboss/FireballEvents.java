package craftz.magmaboss.moddedservermagmaboss;

import com.destroystokyo.paper.event.entity.ProjectileCollideEvent;
import net.kyori.adventure.text.Component;
import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class FireballEvents implements Listener {

    @EventHandler
    public void Collide(ProjectileCollideEvent e)
    {
        if(e.getEntity().getType() == EntityType.FIREBALL && e.getCollidedWith().getType() == EntityType.MAGMA_CUBE)
            e.setCancelled(true);
    }


    @EventHandler
    public void BossDrops(EntityDeathEvent e) {
        if (e.getEntity().getScoreboardTags().contains("magma_boss")) {
            ItemStack ns = new ItemStack(Material.NETHERITE_SCRAP, 2);
            Bukkit.getServer().getWorld("world_nether").dropItem(e.getEntity().getLocation(), ns);
        }
    }

}
