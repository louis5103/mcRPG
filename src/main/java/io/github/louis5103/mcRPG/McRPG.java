package io.github.louis5103.mcRPG;

import io.github.louis5103.mcRPG.base.Events;
import io.github.louis5103.mcRPG.base.HelloCommand;
import io.github.louis5103.mcRPG.quest.BlockDestroyedCommand;
import io.github.louis5103.mcRPG.quest.QuestEvent;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class McRPG extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("플러그인이 활성화되었습니다.");
        getServer().getPluginManager().registerEvents(new Events(), this);
        getServer().getPluginManager().registerEvents(new QuestEvent(), this);
        getServer().getPluginCommand("hello").setExecutor(new HelloCommand());
        getServer().getPluginCommand("blockcrash").setExecutor(new BlockDestroyedCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("플러그인이 비활성화되었습니다.");
    }
}
