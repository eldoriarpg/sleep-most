package me.mrgeneralq.sleepmost.events;

import me.mrgeneralq.sleepmost.enums.SleepSkipCause;
import org.bukkit.World;
import org.bukkit.event.HandlerList;
import org.bukkit.event.world.WorldEvent;

public class SleepSkipEvent extends WorldEvent {

	private static final HandlerList HANDLERS = new HandlerList();
	private final SleepSkipCause cause;
	private final String lastSleeperName;
	
	public SleepSkipEvent(World world, SleepSkipCause cause){
		this(world, cause, null);
	}
	public SleepSkipEvent(World world, SleepSkipCause cause, String lastSleeperName){
		super(world);
		this.cause = cause;
		this.lastSleeperName = lastSleeperName;
	}
	public SleepSkipCause getCause() {
		return cause;
	}
	public String getLastSleeperName() {
		return this.lastSleeperName;
	}

	@Override
	public HandlerList getHandlers() {
		return HANDLERS;
	}

	public static HandlerList getHandlerList() {
		return HANDLERS;
	}
}
