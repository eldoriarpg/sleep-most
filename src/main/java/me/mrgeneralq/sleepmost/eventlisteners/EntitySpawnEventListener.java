package me.mrgeneralq.sleepmost.eventlisteners;

import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

import me.mrgeneralq.sleepmost.interfaces.ISleepFlag;
import me.mrgeneralq.sleepmost.interfaces.ISleepFlagService;

public class EntitySpawnEventListener implements Listener {

	private final ISleepFlagService sleepFlagService;

	public EntitySpawnEventListener(ISleepFlagService sleepFlagService) {
		this.sleepFlagService = sleepFlagService;
	}

	@EventHandler
	public void onEntitySpawn(EntitySpawnEvent e){

		World world = e.getEntity().getWorld();
		
		if(!isPhantom(e.getEntityType())) {
			return;
		}
		ISleepFlag<Boolean> preventPhantomFlag = sleepFlagService.getSleepFlag("prevent-phantom");

		if(!preventPhantomFlag.getValue(world))
			return;

		e.setCancelled(true);
	}
	private boolean isPhantom(EntityType type) 
	{
		try {
			return type == EntityType.valueOf("PHANTOM");
		}
		catch(Exception ex) {
			return false;
		}
	}
}
