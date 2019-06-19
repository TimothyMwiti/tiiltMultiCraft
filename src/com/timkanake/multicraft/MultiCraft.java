package com.timkanake.multicraft;

import org.bukkit.plugin.java.JavaPlugin;

public class MultiCraft extends JavaPlugin{
	
	@Override
	public void onEnable() {
		getLogger().info("MultiCraft has been enabled!");
		// set up the executor for custom commands
		MultiCraftCommandExecutor mExec = new MultiCraftCommandExecutor(this);
		
		this.getCommand("mbuild").setExecutor(mExec);
		this.getCommand("pyramid").setExecutor(new PyramidBuilder(this));
		this.getCommand("mundo").setExecutor(mExec);
		this.getCommand("mredo").setExecutor(mExec);
		
		// start threads to handle client commands
		new SpeechToTextServer(this).start();
		new CommandsListener(this).start();
		new CommandExecution(this).start();
	}
	
	@Override
	public void onDisable() {
		getLogger().info("MultiCraft has been disabled");
	}
	
}
