package craftz.shadowlands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.CommandBlock;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;

public class Command implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {

        Items items = new Items();


        if(sender instanceof Player)
        {
            ItemStack[] items2 = {items.ShadowFalcion(), items.DarkLordCloak(), items.ShadowHeart()};
            ((Player) sender).getInventory().addItem(items2);
        }
        else
        {
            CommandBlock c = (CommandBlock) sender;

            for(Entity e : c.getLocation().getNearbyEntities(10,10,10))
            {

                if(e.getType() == EntityType.DROPPED_ITEM)
                {

                    Item i = (Item) e;

                    if(i.getItemStack().getType() == Material.WARPED_FUNGUS_ON_A_STICK)
                    {

                    }
                }
            }

        }

        return true;
    }
}
