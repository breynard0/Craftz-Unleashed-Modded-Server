package craftz.mobspires.mobspires;

import org.bukkit.Location;
import org.bukkit.block.CommandBlock;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BossCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(args[0].equals("zombie"))
        {
            if(sender instanceof Player)
            {
                Player p = (Player) sender;

                Bosses.Zombie(p.getLocation(), p.getWorld());
            }
            else if(sender instanceof CommandBlock)
            {
                CommandBlock c = (CommandBlock) sender;
                Location l = c.getLocation();
                l.setY(l.getY() + 5);

                Bosses.Zombie(l, c.getWorld());
            }
        }
        else if(args[0].equals("skeleton"))
        {
            if(sender instanceof Player)
            {
                Player p = (Player) sender;

                Bosses.Skeleton(p.getLocation(), p.getWorld());
            }
            else if(sender instanceof CommandBlock)
            {
                CommandBlock c = (CommandBlock) sender;
                Location l = c.getLocation();
                l.setY(l.getY() + 5);

                Bosses.Skeleton(l, c.getWorld());
            }
        }
        else if(args[0].equals("spider"))
        {
            if(sender instanceof Player)
            {
                Player p = (Player) sender;

                Bosses.Spider(p.getLocation(), p.getWorld());
            }
            else if(sender instanceof CommandBlock)
            {
                CommandBlock c = (CommandBlock) sender;
                Location l = c.getLocation();
                l.setY(l.getY() + 5);

                Bosses.Spider(l, c.getWorld());
            }
        }
        else if(args[0].equals("enderman"))
        {
            if(sender instanceof Player)
            {
                Player p = (Player) sender;

                Bosses.Enderman(p.getLocation(), p.getWorld());
            }
            else if(sender instanceof CommandBlock)
            {
                CommandBlock c = (CommandBlock) sender;
                Location l = c.getLocation();
                l.setY(l.getY() + 5);

                Bosses.Enderman(l, c.getWorld());
            }
        }
        else if(args[0].equals("slime"))
        {
            if(sender instanceof Player)
            {
                Player p = (Player) sender;

                Bosses.Slime(p.getLocation(), p.getWorld());
            }
            else if(sender instanceof CommandBlock)
            {
                CommandBlock c = (CommandBlock) sender;
                Location l = c.getLocation();
                l.setY(l.getY() + 5);

                Bosses.Slime(l, c.getWorld());
            }
        }
        else if(args[0].equals("shulker"))
        {
            if(sender instanceof Player)
            {
                Player p = (Player) sender;

                Bosses.Shulker(p.getLocation(), p.getWorld());
            }
            else if(sender instanceof CommandBlock)
            {
                CommandBlock c = (CommandBlock) sender;
                Location l = c.getLocation();
                l.setY(l.getY() + 5);

                Bosses.Shulker(l, c.getWorld());
            }
        }
        else if(args[0].equals("blaze"))
        {
            if(sender instanceof Player)
            {
                Player p = (Player) sender;

                Bosses.Blaze(p.getLocation(), p.getWorld());
            }
            else if(sender instanceof CommandBlock)
            {
                CommandBlock c = (CommandBlock) sender;
                Location l = c.getLocation();
                l.setY(l.getY() + 5);

                Bosses.Blaze(l, c.getWorld());
            }
        }

        return true;
    }
}
