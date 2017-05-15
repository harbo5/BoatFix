package com.harbo.boatfix;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Boat extends JavaPlugin implements Listener{
    public void onEnable(){
        Bukkit.getPluginManager().registerEvents(this, this);
    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onExit(VehicleExitEvent e){
        if(e.getVehicle().getType() == EntityType.BOAT && e.getExited() instanceof Player){
            new BukkitRunnable() {
                @Override
                public void run() {
                    e.getExited().teleport(e.getExited().getLocation().add(0,1,0));
                }
            }.runTaskLater(this, 5L);
        }
    }
}
