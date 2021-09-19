package me.akkokiko.worldguardperuniteflags;

import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.flags.Flag;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.flags.registry.FlagConflictException;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;
import java.util.List;

public final class Main extends JavaPlugin {

    private static final List<String> INBUILT_FLAGS_LIST = new ArrayList<>();
    public static StateFlag  ITEM_BURNING_Preventer = register(new StateFlag("item-burning-preventer", false));

    @Override
    public void onEnable() {
        // Plugin startup logic
    getServer().getPluginManager().registerEvents(new BurningPreventer(),this);
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    private static <T extends Flag<?>> T register(T flag) throws FlagConflictException {
        WorldGuard.getInstance().getFlagRegistry().register((Flag)flag);
        INBUILT_FLAGS_LIST.add(flag.getName());
        return flag;
    }
}
