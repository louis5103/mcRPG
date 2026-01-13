package io.github.louis5103.mcRPG;

import io.github.louis5103.mcRPG.base.Events;
import io.github.louis5103.mcRPG.base.HelloCommand;
import io.github.louis5103.mcRPG.quest.BlockDestroyedCommand;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class McRPG extends JavaPlugin {
    public static McRPG instance;
    public long startTime = 0L;
    public List<Material> blockList = new ArrayList<>();
    public boolean onGame = false;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("플러그인이 활성화되었습니다.");
        getServer().getPluginManager().registerEvents(new Events(), this);
        instance = this;
        getServer().getPluginCommand("hello").setExecutor(new HelloCommand());
        getServer().getPluginCommand("blockcrash").setExecutor(new BlockDestroyedCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("플러그인이 비활성화되었습니다.");
    }
}
