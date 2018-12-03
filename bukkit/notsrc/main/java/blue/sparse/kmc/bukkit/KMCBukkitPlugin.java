package blue.sparse.kmc.bukkit;

import blue.sparse.kmc.api.KMC;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class KMCBukkitPlugin extends JavaPlugin {
	
	private static KMCBukkitPlugin plugin;
	
	public static File getDependenciesFolder() {
		return new File(getPlugin().getDataFolder(), "dependencies");
	}
	
	public static KMCBukkitPlugin getPlugin() {
		return plugin;
	}
	
	public void onLoad() {
		plugin = this;
	}
	
	public void onEnable() {
		try {
			KotlinLoader.downloadAndLoad(getDependenciesFolder());
		}catch(IOException | ReflectiveOperationException e) {
			getLogger().severe("Unable to load Kotlin for KMC, disabling.");
			e.printStackTrace();
			setEnabled(false);
			return;
		}
		
		
//		KMC.INSTANCE.initialize(getDataFolder().getAbsoluteFile().getParentFile(), null);
	}
	
}
