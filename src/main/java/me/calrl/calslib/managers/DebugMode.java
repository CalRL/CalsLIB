package me.calrl.calslib.managers;

import me.calrl.calslib.CalsLIB;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DebugMode {
    private final CalsLIB plugin;
    private final Logger logger;
    private final FileConfiguration config;

    public DebugMode(CalsLIB plugin, FileConfiguration config) {
        this.plugin = plugin;
        this.logger = plugin.getLogger();
        this.config = config;
    }

    public void info(String message) {
        if(config.getBoolean("debug")){
            logger.log(Level.INFO, "[DEBUG] " + message);
        }
    }
    public void warn(String message) {
        if(config.getBoolean("debug")){
            logger.log(Level.WARNING, message);
        }
    }

    public void severe(String message) {
        if(config.getBoolean("debug")){
            logger.log(Level.SEVERE, message);
        }
    }
}
