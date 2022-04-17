package craftz.mobspires.mobspires;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.Arrays;
import java.util.logging.Level;

public final class MobSpires extends JavaPlugin {

    public JavaPlugin plugin = this;

    private static MobSpires INSTANCE;

    @Override
    public void onEnable() {
        // Plugin startup logic
        INSTANCE = this;

        this.getCommand("mobspireitems").setExecutor(new ItemCommands());
        this.getCommand("spawnboss").setExecutor(new BossCommands());

        Bukkit.getPluginManager().registerEvents(new ItemEvents(), this);
        Bukkit.getPluginManager().registerEvents(new BossEvents(), this);
        Bukkit.getPluginManager().registerEvents(new SpawnRecipes(), this);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable()
        {
            int ZombieSpawningTicks = 0;
            int SkellyFallTicks = 0;
            boolean SkellyHasShot = false;
            int SlimeTicks = 0;
            int ShulkerTicks = 0;
            int ShulkerInvisTicks = 0;
            int ShulkerTPTicks = 0;
            int BlazeFireTicks = 0;
            int BlazeSummonTicks = 0;

            public void run() {
                //Boss Ticks
                for(World w : Bukkit.getServer().getWorlds())
                {
                    for (Entity e : w.getEntities())
                    {
                        if(e.getType() == EntityType.ZOMBIE && e.getScoreboardTags().contains("MSZombieBoss"))
                        {
                            Zombie zomboss = (Zombie) e;

                            //Zombie Spawning
                            if(ZombieSpawningTicks >= 12)
                            {
                                for(Entity e2 : zomboss.getNearbyEntities(50, 50, 50)) {
                                    if (e2 instanceof Player)
                                    {
                                        //Spawn Zombie
                                        zomboss.getWorld().spawnParticle(Particle.REVERSE_PORTAL, zomboss.getLocation(), 800);
                                        zomboss.getWorld().spawnEntity(e.getLocation(), EntityType.ZOMBIE);
                                        zomboss.getWorld().spawnEntity(e.getLocation(), EntityType.ZOMBIE);
                                        zomboss.getWorld().spawnEntity(e.getLocation(), EntityType.ZOMBIE);
                                        zomboss.getWorld().spawnEntity(e.getLocation(), EntityType.ZOMBIE);

                                        ZombieSpawningTicks = 0;
                                    }
                                }
                            }
                            else
                            {
                                ZombieSpawningTicks++;
                            }

                            //Speed
                            PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, 15, 1, true, false);
                            zomboss.addPotionEffect(speed);
                        }

                        if(e.getType() == EntityType.SKELETON && e.getScoreboardTags().contains("MSSkeletonBoss"))
                        {
                            Skeleton skelly = (Skeleton) e;

                            for (Player p : Bukkit.getOnlinePlayers())
                            {
                                if (p.getLocation().distance(p.getLocation()) <= 40)
                                {
                                    if(!SkellyHasShot)
                                    {
                                        Location spawnLoc = e.getLocation();
                                        Arrow ar = (Arrow) skelly.getWorld().spawnEntity(spawnLoc, EntityType.ARROW);
                                        ar.setDamage(0.2);
                                        ar.setCustomName("Skelly Soldier");
                                        ar.setPersistent(false);
                                        ar.addScoreboardTag("SkellyArrow");
                                        ar.setVelocity(p.getLocation().toVector().subtract(skelly.getLocation().toVector()));
                                        ar.setKnockbackStrength(0);
                                        SkellyHasShot = true;
                                        for(Entity a : ar.getNearbyEntities(4, 4, 4))
                                        {
                                            if(a.getType() == EntityType.ARROW && a != ar && a.getScoreboardTags().contains("SkellyArrow"))
                                            {
                                                a.remove();
                                            }
                                        }
                                    }
                                    else
                                    {
                                        SkellyHasShot = false;
                                    }




                                    if(SkellyFallTicks >= 20)
                                    {
                                        double x, y, z;

                                        {
                                            for(double i=0; i<3*Math.PI; i = i+(Math.PI/4)){
                                                x = Math.sin(i)*5;
                                                z = Math.cos(i)*5;

                                                Location l = e.getLocation();
                                                l = l.add(x,0,z);
                                                l.setY(l.getY() + 8);
                                                Arrow arrow = (Arrow) l.getWorld().spawnEntity(l,EntityType.ARROW);
                                                arrow.addScoreboardTag("SkellyFallAttack");
                                                arrow.setDamage(3);
                                            }
                                        }

                                        SkellyFallTicks = 0;

                                    }
                                    else
                                    {
                                        SkellyFallTicks++;
                                    }
                                }
                            }
                        }

                        if(e.getType() == EntityType.SPIDER && e.getScoreboardTags().contains("MSSpiderBoss"))
                        {
                            Snowball proj = (Snowball) e.getWorld().spawnEntity(e.getLocation().add(0, 1, 0), EntityType.SNOWBALL);

                            proj.addScoreboardTag("web");

                            for (Player p : Bukkit.getOnlinePlayers())
                            {
                                if (p.getLocation().distance(p.getLocation()) <= 40)
                                {
                                    proj.setVelocity(p.getLocation().toVector().subtract(e.getLocation().toVector()));
                                }
                            }
                        }

                        if(e.getType() == EntityType.SLIME && e.getScoreboardTags().contains("MSSlimeBoss"))
                        {
                            Snowball proj = (Snowball) e.getWorld().spawnEntity(e.getLocation().add(0, 1, 0), EntityType.SNOWBALL);
                            proj.setBounce(true);

                            proj.addScoreboardTag("slime");


                            if(SlimeTicks < 12)
                            {
                                for (Player p : Bukkit.getOnlinePlayers())
                                {
                                    if (p.getLocation().distance(p.getLocation()) <= 40)
                                    {
                                        proj.setVelocity(p.getLocation().toVector().subtract(e.getLocation().toVector()));
                                    }
                                }
                                SlimeTicks = 0;
                            }
                            else
                            {
                                SlimeTicks++;
                            }
                        }

                        if(e.getType() == EntityType.SHULKER && e.getScoreboardTags().contains("MSShulkerBoss"))
                        {
                            if(ShulkerTicks < 8)
                            {
                                for (Player p : Bukkit.getOnlinePlayers())
                                {
                                    if (p.getLocation().distance(p.getLocation()) <= 40)
                                    {
                                        ShulkerBullet sb = (ShulkerBullet) e.getWorld().spawnEntity(new Location(e.getWorld(), e.getLocation().getX(), e.getLocation().getY() + 3, e.getLocation().getZ()), EntityType.SHULKER_BULLET);

                                        sb.setTarget(p);
                                    }
                                }

                                ShulkerTicks = 0;
                            }
                            else
                            {
                                ShulkerTicks++;
                            }

                            if(ShulkerInvisTicks < 200)
                            {
                                PotionEffect invis = new PotionEffect(PotionEffectType.INVISIBILITY, 100, 1, false);
                                invis.apply((LivingEntity) e);

                                ShulkerInvisTicks = 0;
                            }
                            else
                            {
                                ShulkerInvisTicks++;
                            }
                        }

                        if(e.getType() == EntityType.BLAZE && e.getScoreboardTags().contains("MSBlazeBoss")) {
                            if (BlazeFireTicks < 20) {

                                for (Player p : Bukkit.getOnlinePlayers()) {
                                    if (p.getLocation().distance(p.getLocation()) <= 40) {
                                        SmallFireball sb = (SmallFireball) e.getWorld().spawnEntity(new Location(e.getWorld(), e.getLocation().getX(), e.getLocation().getY(), e.getLocation().getZ()), EntityType.SMALL_FIREBALL);
                                        for (Player p2 : Bukkit.getOnlinePlayers()) {
                                            if (p2.getLocation().distance(p2.getLocation()) <= 4) {
                                                sb.setDirection(p2.getLocation().toVector().subtract(e.getLocation().toVector()));
                                            }
                                        }
                                    }
                                }

                                BlazeFireTicks = 0;
                            } else {
                                BlazeFireTicks++;
                            }

                            if(BlazeSummonTicks >= 30)
                            {
                                for(Entity e2 : e.getNearbyEntities(50, 50, 50)) {
                                    if (e2 instanceof Player)
                                    {

                                        e.getWorld().spawnParticle(Particle.REVERSE_PORTAL, e.getLocation(), 800);
                                        e.getWorld().spawnEntity(e.getLocation(), EntityType.BLAZE);
                                        e.getWorld().spawnEntity(e.getLocation(), EntityType.BLAZE);

                                        BlazeSummonTicks = 0;
                                    }
                                }
                            }
                            else
                            {
                                BlazeSummonTicks++;
                            }
                        }
                    }


                }


                for(Player p : Bukkit.getOnlinePlayers())
                {
                    p.addScoreboardTag("shortbow");

                    if(p.getInventory().getHelmet() != null)
                    {
                        //Spider helm
                        if(p.getInventory().getHelmet().getItemMeta().hasCustomModelData())
                        {
                            Material[] blacklist = {Material.TALL_GRASS, Material.AIR, Material.GRASS, Material.WATER, Material.OXEYE_DAISY, Material.DANDELION, Material.POPPY, Material.BLUE_ORCHID, Material.ALLIUM, Material.AZURE_BLUET,Material.ORANGE_TULIP, Material.PINK_TULIP, Material.RED_TULIP, Material.WHITE_TULIP, Material.CORNFLOWER, Material.LILY_OF_THE_VALLEY, Material.WITHER_ROSE, Material.SUNFLOWER, Material.LILAC, Material.ROSE_BUSH, Material.PEONY};

                            Location head = p.getLocation().add(0,1,0);
                            if(p.getInventory().getHelmet().getItemMeta().getCustomModelData() == 46)
                            {
                                PotionEffect nightVision = new PotionEffect(PotionEffectType.NIGHT_VISION, 260, 1, true, false);
                                nightVision.apply(p);

                                if(!Arrays.stream(blacklist).toList().contains(Bukkit.getWorld(p.getWorld().getUID()).getBlockAt(head.toVector().add(p.getLocation().getDirection().multiply(1)).toLocation(p.getWorld())).getType()))
                                {
                                    PotionEffect lev = new PotionEffect(PotionEffectType.LEVITATION, 12, 2, false, false);
                                    lev.apply(p);
                                }
                            }

                        }
                    }

                    //Frog boots
                    if(p.getInventory().getBoots() != null)
                    {
                        if(p.getInventory().getBoots().getItemMeta().hasCustomModelData())
                        {
                            if(p.getInventory().getBoots().getItemMeta().getCustomModelData() == 421)
                            {
                                PotionEffect jump = new PotionEffect(PotionEffectType.JUMP, 20, 3, true, false);
                                jump.apply(p);
                                PotionEffect swim = new PotionEffect(PotionEffectType.WATER_BREATHING, 20, 1, true, false);
                                swim.apply(p);
                            }

                        }
                    }

                    //Blaze Blazer
                    if(p.getInventory().getChestplate() != null)
                    {
                        if(p.getInventory().getChestplate().getItemMeta().hasCustomModelData())
                        {
                            if(p.getInventory().getChestplate().getItemMeta().getCustomModelData() == 471)
                            {
                                PotionEffect fireRes = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 10, 1, true, false);
                                p.addPotionEffect(fireRes);

                                if(p.getWorld().getBlockAt(p.getLocation()).getType() == Material.LAVA)
                                {
                                    PotionEffect saturation = new PotionEffect(PotionEffectType.SATURATION, 10, 1, true, false);
                                    p.addPotionEffect(saturation);
                                }
                            }
                        }
                    }

                }
            }
        }, 0, 10);

        //Mob Essence
        ItemStack mobEssence = new ItemStack(Material.WARPED_FUNGUS_ON_A_STICK);

        ItemMeta mobEssenceMeta = mobEssence.getItemMeta();

        mobEssenceMeta.setCustomModelData(100);
        mobEssenceMeta.setDisplayName(ChatColor.GOLD + "Mob Essence");
        String[] lore = {ChatColor.AQUA + "Used to create summoning rings for powerful bosses"};
        mobEssenceMeta.setLore(Arrays.stream(lore).toList());

        mobEssence.setItemMeta(mobEssenceMeta);

        Bukkit.removeRecipe(NamespacedKey.minecraft("netherite_scrap"));

        NamespacedKey MEKey = new NamespacedKey(this, "mob_essence");

        FurnaceRecipe recipe = new FurnaceRecipe(mobEssence, Material.ANCIENT_DEBRIS);

        Bukkit.addRecipe(recipe);

        //Zombie Ring
        ItemStack zombieRing = new ItemStack(Material.WARPED_FUNGUS_ON_A_STICK);

        ItemMeta zombieRingMeta = zombieRing.getItemMeta();

        zombieRingMeta.setCustomModelData(101);
        zombieRingMeta.setDisplayName(ChatColor.GREEN + "Zombie Ring");
        String[] zrlore = {ChatColor.DARK_GREEN + "Summons Zomboss Prime", "Right click to use"};
        zombieRingMeta.setLore(Arrays.stream(zrlore).toList());

        zombieRing.setItemMeta(zombieRingMeta);

        NamespacedKey zrkey = new NamespacedKey(this, "zombie_ring");
        ShapedRecipe zombieRingRecipe = new ShapedRecipe(zrkey, zombieRing);

        zombieRingRecipe.shape(" M ", " R ");
        zombieRingRecipe.setIngredient('M', mobEssence);
        zombieRingRecipe.setIngredient('R', Material.ROTTEN_FLESH);

        Bukkit.addRecipe(zombieRingRecipe);

        //Skeleton Ring
        ItemStack skeletonRing = new ItemStack(Material.WARPED_FUNGUS_ON_A_STICK);

        ItemMeta skeletonRingMeta = skeletonRing.getItemMeta();

        skeletonRingMeta.setCustomModelData(102);
        skeletonRingMeta.setDisplayName("Skeleton Ring");
        String[] srlore = {ChatColor.GRAY + "Summons Skelly Soldier", "Right click to use"};
        skeletonRingMeta.setLore(Arrays.stream(srlore).toList());

        skeletonRing.setItemMeta(skeletonRingMeta);

        NamespacedKey srkey = new NamespacedKey(this, "skeleton_ring");
        ShapedRecipe skeletonRingRecipe = new ShapedRecipe(srkey, skeletonRing);

        skeletonRingRecipe.shape(" M ", " R ");
        skeletonRingRecipe.setIngredient('M', mobEssence);
        skeletonRingRecipe.setIngredient('R', Material.BONE);

        Bukkit.addRecipe(skeletonRingRecipe);

        //Spider Ring
        ItemStack spiderRing = new ItemStack(Material.WARPED_FUNGUS_ON_A_STICK);

        ItemMeta spiderRingMeta = spiderRing.getItemMeta();

        spiderRingMeta.setCustomModelData(103);
        spiderRingMeta.setDisplayName(ChatColor.RED + "Spider Ring");
        String[] srlore2 = {"Summons Spidey", "Right click to use"};
        spiderRingMeta.setLore(Arrays.stream(srlore2).toList());

        spiderRing.setItemMeta(spiderRingMeta);

        NamespacedKey srkey2 = new NamespacedKey(this, "spidey_ring");
        ShapedRecipe spiderRingRecipe = new ShapedRecipe(srkey2, spiderRing);

        spiderRingRecipe.shape(" M ", " R ");
        spiderRingRecipe.setIngredient('M', mobEssence);
        spiderRingRecipe.setIngredient('R', Material.SPIDER_EYE);

        Bukkit.addRecipe(spiderRingRecipe);

        //Enderman Ring
        ItemStack enderRing = new ItemStack(Material.WARPED_FUNGUS_ON_A_STICK);

        ItemMeta enderRingMeta = enderRing.getItemMeta();

        enderRingMeta.setCustomModelData(104);
        enderRingMeta.setDisplayName(ChatColor.DARK_PURPLE + "Ender Ring");
        String[] erlore2 = {"Summons Buff Enderman", "Right click to use"};
        enderRingMeta.setLore(Arrays.stream(erlore2).toList());

        enderRing.setItemMeta(enderRingMeta);

        NamespacedKey erkey2 = new NamespacedKey(this, "ender_ring");
        ShapedRecipe enderRingRecipe = new ShapedRecipe(erkey2, enderRing);

        enderRingRecipe.shape(" M ", " R ");
        enderRingRecipe.setIngredient('M', mobEssence);
        enderRingRecipe.setIngredient('R', Material.ENDER_PEARL);

        Bukkit.addRecipe(enderRingRecipe);

        //Slime Ring
        ItemStack slimeRing = new ItemStack(Material.WARPED_FUNGUS_ON_A_STICK);

        ItemMeta slimeRingMeta = slimeRing.getItemMeta();

        slimeRingMeta.setCustomModelData(105);
        slimeRingMeta.setDisplayName(ChatColor.GREEN + "Slime Ring");
        String[] srlore3 = {"Summons Cubert II", "Right click to use"};
        slimeRingMeta.setLore(Arrays.stream(srlore3).toList());

        slimeRing.setItemMeta(slimeRingMeta);

        NamespacedKey srkey3 = new NamespacedKey(this, "slime_ring");
        ShapedRecipe slimeRingRecipe = new ShapedRecipe(srkey3, slimeRing);

        slimeRingRecipe.shape(" M ", " R ");
        slimeRingRecipe.setIngredient('M', mobEssence);
        slimeRingRecipe.setIngredient('R', Material.SLIME_BALL);

        Bukkit.addRecipe(slimeRingRecipe);

        //Shulker Ring
        ItemStack shulkerRing = new ItemStack(Material.WARPED_FUNGUS_ON_A_STICK);

        ItemMeta shulkerRingMeta = shulkerRing.getItemMeta();

        shulkerRingMeta.setCustomModelData(106);
        shulkerRingMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Shulker Ring");
        String[] srlore4 = {"Summons Opey-Closey Man", "Right click to use"};
        shulkerRingMeta.setLore(Arrays.stream(srlore4).toList());

        shulkerRing.setItemMeta(shulkerRingMeta);

        NamespacedKey srkey4 = new NamespacedKey(this, "shulker_ring");
        ShapedRecipe shulkerRingRecipe = new ShapedRecipe(srkey4, shulkerRing);

        shulkerRingRecipe.shape(" M ", " R ");
        shulkerRingRecipe.setIngredient('M', mobEssence);
        shulkerRingRecipe.setIngredient('R', Material.SHULKER_SHELL);

        Bukkit.addRecipe(shulkerRingRecipe);

        //Blaze Ring
        ItemStack blazeRing = new ItemStack(Material.WARPED_FUNGUS_ON_A_STICK);

        ItemMeta blazeRingMeta = blazeRing.getItemMeta();

        blazeRingMeta.setCustomModelData(107);
        blazeRingMeta.setDisplayName(ChatColor.YELLOW + "Blaze Ring");
        String[] brlore2 = {"Summons Blazin' Blitz", "Right click to use"};
        blazeRingMeta.setLore(Arrays.stream(brlore2).toList());

        blazeRing.setItemMeta(blazeRingMeta);

        NamespacedKey brkey2 = new NamespacedKey(this, "blaze_ring");
        ShapedRecipe blazeRingRecipe = new ShapedRecipe(brkey2, blazeRing);

        blazeRingRecipe.shape(" M ", " R ");
        blazeRingRecipe.setIngredient('M', mobEssence);
        blazeRingRecipe.setIngredient('R', Material.BLAZE_ROD);

        Bukkit.addRecipe(blazeRingRecipe);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static MobSpires getInstance()
    {
        return INSTANCE;
    }
}
