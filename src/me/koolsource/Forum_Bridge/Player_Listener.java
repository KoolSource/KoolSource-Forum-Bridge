/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.koolsource.Forum_Bridge;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 *
 * @author john
 */
public class Player_Listener extends PlayerListener {

    public static Forum_Bridge plugin;

    public Player_Listener(Forum_Bridge instance) {
        plugin = instance;
    }

    @Override
    public void onPlayerChangedWorld(PlayerChangedWorldEvent event) {
        super.onPlayerChangedWorld(event);
    }
    
    @Override
    public void onPlayerQuit(PlayerQuitEvent event) {
        super.onPlayerQuit(event);
    }
    
    @Override
    public void onPlayerJoin(PlayerJoinEvent event) {
        //TODO: Finish?!? lol
        try {
            Object YAML_data = URL_Reader.requestYAML(null, null);
        } catch (IOException ex) {
            Logger.getLogger(Player_Listener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

}
