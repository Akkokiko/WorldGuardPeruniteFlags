package me.akkokiko.worldguardperuniteflags;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.util.Location;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldguard.protection.regions.RegionQuery;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;


public class BurningPreventer implements Listener {


    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {

        Entity ent = e.getEntity();
        if (ent instanceof Item) {
            Item a = (Item) ent;
            Location loc = BukkitAdapter.adapt(ent.getLocation());
            RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
            RegionQuery query = container.createQuery();
            ApplicableRegionSet set = query.getApplicableRegions(loc);
            if(set.testState(null,Main.ITEM_BURNING_Preventer)){
                if (e.getCause() == EntityDamageEvent.DamageCause.FIRE || e.getCause() == EntityDamageEvent.DamageCause.LAVA||
                        e.getCause()==  EntityDamageEvent.DamageCause.FIRE_TICK) {
                    e.setDamage(0);

                }
            }
        }
    }




}
