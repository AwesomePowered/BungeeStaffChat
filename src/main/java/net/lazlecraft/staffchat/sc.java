package net.lazlecraft.staffchat;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class sc extends Command {
	
	public String c = ChatColor.RED + "] ";
	public String o = ChatColor.RED + "[";

	public sc(StaffChat plugin) {
		super("sc");
		this.plugin = plugin;
		// TODO Auto-generated constructor stub
	}
	StaffChat plugin;

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (sender.hasPermission("staff.chat")){
			ProxiedPlayer sndr = (ProxiedPlayer) sender;
			if (args.length == 0) {
				sender.sendMessage(plugin.Prefix + ChatColor.GOLD + "Usage: " + ChatColor.GREEN + "/sc \"message\"");
			} else if (args.length >= 1) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < args.length; i++)
			{
			    sb.append(' ').append(args[i]);
			}
			String chat = sb.toString().trim();
			ProxyServer.getInstance().getConsole().sendMessage(plugin.Prefix + o + ChatColor.GOLD + sndr.getServer().getInfo().getName()+ c + o + ChatColor.GREEN + sndr + c + ChatColor.translateAlternateColorCodes('&', chat));
			for (ProxiedPlayer p : plugin.getProxy().getPlayers()){
				if(p.hasPermission("staff.chat")) {
					p.sendMessage(o + ChatColor.GOLD + sndr.getServer().getInfo().getName()+ c + o + ChatColor.GREEN + sndr + c + ChatColor.RESET +  ChatColor.translateAlternateColorCodes('&', chat));
			}
			}
		}
		}
	}
}
