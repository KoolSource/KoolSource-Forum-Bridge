/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.koolsource.Forum_Bridge;

import org.bukkit.event.server.ServerListener;

/**
 *
 * @author john
 */
public class Server_Listener extends ServerListener {
    
    public static Forum_Bridge plugin;

    public Server_Listener(Forum_Bridge instance) {
        plugin = instance;
    }
}
