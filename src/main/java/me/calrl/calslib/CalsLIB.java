package me.calrl.calslib;

import me.calrl.calslib.utils.ChatUtils;
import org.bukkit.plugin.java.JavaPlugin;

public final class CalsLIB extends JavaPlugin {
    private ChatUtils chatUtils;

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public ChatUtils getChatUtils() {
        return chatUtils;
    }
}
