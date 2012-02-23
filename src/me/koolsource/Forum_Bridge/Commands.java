/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.koolsource.Forum_Bridge;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author john
 */
public class Commands implements CommandExecutor {

    private Forum_Bridge plugin;

    public Commands(Forum_Bridge plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmnd, String label, String[] args) {
        Player player = null;

        if (sender instanceof Player) {
            player = (Player) sender;
        }

        //This is cmnd because this is our "root command" everything else is a sub command of this one.
        if (cmnd.getName().equalsIgnoreCase("forumbridge")) {
            //Force a resync without relogging.
            if (args[0].equals("sync")) {
                if (args.length == 2) {
                    if (player.hasPermission("forumBridge.sync.others")) {
                        //TODO: Sync other player
                        
                        return true;
                    } else {
                        sender.sendMessage(ChatColor.RED + plugin.errorMsg);
                        return true;
                    }
                }
                if (args.length > 2) {
                    sender.sendMessage(ChatColor.RED + "Too many arguments!");
                    return true;
                }
                if(player.hasPermission("forumBridge.sync")){
                  //TODO: Sync Sender
                    
                  return true;
                }else{
                    sender.sendMessage(ChatColor.RED + plugin.errorMsg);
                }
                
                
                return true;
            }
            
            //Force a reload of Forum Bridge
            if(args[0].equals("reload")){
                if(player.hasPermission("forumBridge.reload")){
                    //TODO: Reload Plugin
                    
                    return true;
                }else{
                    sender.sendMessage(ChatColor.RED + plugin.errorMsg);
                    return true;
                }
            }
            
        }
        return false;
    }
}
