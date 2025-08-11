package org.main.essential.essentialCommandCollectionByLuka;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class WarpManager {

    private final File file;
    private final FileConfiguration config;

    public WarpManager(File dataFolder) {
        // Ordner anlegen, falls er nicht existiert
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }

        this.file = new File(dataFolder, "warps.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.config = YamlConfiguration.loadConfiguration(file);
    }

    public void setWarp(String name, Location loc) {
        config.set(name + ".world", loc.getWorld().getName());
        config.set(name + ".x", loc.getX());
        config.set(name + ".y", loc.getY());
        config.set(name + ".z", loc.getZ());
        config.set(name + ".yaw", loc.getYaw());
        config.set(name + ".pitch", loc.getPitch());
        save();
    }

    public Location getWarp(String name) {
        if (!config.contains(name)) return null;
        World world = Bukkit.getWorld(config.getString(name + ".world"));
        double x = config.getDouble(name + ".x");
        double y = config.getDouble(name + ".y");
        double z = config.getDouble(name + ".z");
        float yaw = (float) config.getDouble(name + ".yaw");
        float pitch = (float) config.getDouble(name + ".pitch");
        return new Location(world, x, y, z, yaw, pitch);
    }

    public void deleteWarp(String name) {
        config.set(name, null);
        save();
    }

    private void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
