package craftz.mobspires.mobspires;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ItemCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Items items = new Items();

            if(args[0].equals("zombie_scimitar"))
            {
                player.getInventory().addItem(items.ZombieScimitar());
            }
            else if(args[0].equals("zombie_helm"))
            {
                player.getInventory().addItem(items.ZombieHelm());
            }
            else if(args[0].equals("skelly_shortbow"))
            {
                player.getInventory().addItem(items.Shortbow());
            }
            else if(args[0].equals("bony_pants"))
            {
                player.getInventory().addItem(items.BonyPants());
            }
            else if(args[0].equals("spidey_slingshot"))
            {
                player.getInventory().addItem(items.SpideySlingshot());
            }
            else if(args[0].equals("tarantula_hat"))
            {
                player.getInventory().addItem(items.TarantulaHat());
            }
            else if(args[0].equals("ender_staff"))
            {
                player.getInventory().addItem(items.EnderStaff());
            }
            else if(args[0].equals("eman_boots"))
            {
                player.getInventory().addItem(items.EmanBoots());
            }
            else if(args[0].equals("kb_stick"))
            {
                player.getInventory().addItem(items.KBStick());
            }
            else if(args[0].equals("frog_boots"))
            {
                player.getInventory().addItem(items.FrogBoots());
            }
            else if(args[0].equals("whoosh_whip"))
            {
                player.getInventory().addItem(items.WhooshWhip());
            }
            else if(args[0].equals("shulker_chestplate"))
            {
                player.getInventory().addItem(items.ShulkerChestplate());
            }
            else if(args[0].equals("blaze_blazer"))
            {
                player.getInventory().addItem(items.BlazeBlazer());
            }
            else if(args[0].equals("fire_trident"))
            {
                player.getInventory().addItem(items.FireTrident());
            }

        }

        return true;
    }
}
