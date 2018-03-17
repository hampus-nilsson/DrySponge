package com.artlinedev.DrySponge;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World.Environment;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "DrySponge has been enabled.");
	}
	
	public void onDisable()
	{
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "DrySponge has been disabled.");
	}
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlace(BlockPlaceEvent event)
	{
		Player player = event.getPlayer();
		Block block = event.getBlock();
		
		if (player.getWorld().getEnvironment() == Environment.NETHER)
		{
			if (block.getType() == Material.SPONGE)
			{
				if (block.getData() == (byte) 1)
				{
					block.setData((byte) 0);
				}
			}
		}
	}
}