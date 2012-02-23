/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.koolsource.Forum_Bridge;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author john
 */
public class Forum_Bridge extends JavaPlugin {
    
    
    private final Player_Listener playerListener = new Player_Listener(this);
    private final Server_Listener serverListener = new Server_Listener(this);
    
    static final Logger log = Logger.getLogger("Forum_Bridge");
    
    static final String errorMsg = "[Forum Bridge] You do not have permission to execute this command.";

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {
        PluginManager pm = this.getServer().getPluginManager();
        
        pm.registerEvent(Event.Type.PLAYER_JOIN, playerListener, Event.Priority.Normal, this);
        pm.registerEvent(Event.Type.PLAYER_QUIT, playerListener, Event.Priority.Normal, this);
        pm.registerEvent(Event.Type.PLAYER_CHANGED_WORLD, playerListener, Event.Priority.Normal, this);
        
        getCommand("forumbridge").setExecutor(new Commands(this));
    }

    @Override
    public void onLoad() {
        super.onLoad();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return super.onCommand(sender, command, label, args);
    }
    
}
