package org.main.essential;

import org.bukkit.plugin.java.JavaPlugin;
import org.main.essential.essentialCommandCollectionByLuka.*;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("EssentialsCommands geladen!");
        getServer().getPluginManager().registerEvents(new MuteListener(), this);
        getLogger().info("HealCommand Plugin aktiviert.");
        WarpManager warpManager = new WarpManager(getDataFolder());

        registerCommand("setspawn", new SetSpawnCommand(this));
        registerCommand("spawn", new SpawnCommand(this));
        registerCommand("home", new HomeCommand(this));
        registerCommand("sethome", new SetHomeCommand(this));
        registerCommand("tp", new TeleportCommand(this));
        registerCommand("msg", new MsgCommand());
        registerCommand("gm", new GamemodeCommand());
        registerCommand("fly", new FlyCommand());
        registerCommand("kick", new KickCommand());
        registerCommand("ban", new BanCommand());
        registerCommand("ec", new EnderChestCommand());
        registerCommand("god", new GodCommand());
        registerCommand("kill", new KillCommand());
        registerCommand("mute", new MuteCommand());
        registerCommand("nick", new NickCommand());
        registerCommand("tpa", new TpaCommands());
        registerCommand("tphere", new TphereCommand());
        registerCommand("unban", new UnbanCommand());
        registerCommand("unmute", new UnmuteCommand());
        registerCommand("vanish", new VanishCommand());
        registerCommand("heal", new HealCommand());
        registerCommand("day", new DayCommand());
        registerCommand("night", new NightCommand());
        registerCommand("setwarp", new SetWarpCommand(warpManager));
        registerCommand("warp", new WarpCommand(warpManager));
        registerCommand("delwarp", new DelWarpCommand(warpManager));
    }

    private void registerCommand(String name, org.bukkit.command.CommandExecutor executor) {
        if (getCommand(name) != null) {
            getCommand(name).setExecutor(executor);
        } else {
            getLogger().warning("Befehl '" + name + "' ist nicht in plugin.yml registriert!");
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("EssentialsCommands deaktiviert!");
    }
}
