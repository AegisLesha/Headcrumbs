package ganymedes01.headcrumbs.configs;

import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.libs.Reference;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ConfigHandler {

	public static ConfigHandler INSTANCE = new ConfigHandler();
	public Configuration configFile;
	public String[] usedCategories = { Configuration.CATEGORY_GENERAL, "heads" };

	public void init(File file) {
		configFile = new Configuration(file);

		syncConfigs();
	}

	private void syncConfigs() {
		Headcrumbs.enableRandomHeadDrop = configFile.get(Configuration.CATEGORY_GENERAL, "Heads drop randomly", Headcrumbs.enableRandomHeadDrop, "Heads will drop randomly when entities or players die").setRequiresMcRestart(false).getBoolean();
		Headcrumbs.enableVanillaHeadsDrop = configFile.get(Configuration.CATEGORY_GENERAL, "Vanilla heads drop randomly", Headcrumbs.enableVanillaHeadsDrop, "Vanilla Heads (creeper, skeleton, zombie) will drop randomly when entities die").setRequiresMcRestart(false).getBoolean();
		Headcrumbs.addPlayerHeadsAsDungeonLoot = configFile.get(Configuration.CATEGORY_GENERAL, "Add player heads as dungeon loot", Headcrumbs.addPlayerHeadsAsDungeonLoot).setRequiresMcRestart(false).getBoolean();
		Headcrumbs.enableMobsAndAnimalHeads = configFile.get(Configuration.CATEGORY_GENERAL, "Enable mobs and animals heads", Headcrumbs.enableMobsAndAnimalHeads, "Setting this to false will cause only player heads to show in the creative tab and drop updon death").setRequiresMcRestart(false).getBoolean();

		Headcrumbs.headDropChance = configFile.get(Configuration.CATEGORY_GENERAL, "Chance of random head drop", Headcrumbs.headDropChance, "Random.nextInt(X / fortune) == 0").setRequiresMcRestart(false).getInt();
		Headcrumbs.headsDungeonLootMaxWeight = configFile.get(Configuration.CATEGORY_GENERAL, "Player heads loot weight", Headcrumbs.headsDungeonLootMaxWeight, "The bigger this number the easier it will be to find heads in dungeons.\nSome heads will be rarer than others.\nExamples: Diamond is 1, Redstone is 10").setRequiresMcRestart(true).getInt();

		Headcrumbs.others = configFile.get("heads", "others", Headcrumbs.others).setRequiresMcRestart(true).getStringList();
		Headcrumbs.modders = configFile.get("heads", "modders", Headcrumbs.modders).setRequiresMcRestart(true).getStringList();
		Headcrumbs.youtubers = configFile.get("heads", "youtubers", Headcrumbs.youtubers).setRequiresMcRestart(true).getStringList();
		Headcrumbs.mojang = configFile.get("heads", "mojang", Headcrumbs.mojang).setRequiresMcRestart(true).getStringList();
		Headcrumbs.mindCrack = configFile.get("heads", "mindCrack", Headcrumbs.mindCrack).setRequiresMcRestart(true).getStringList();
		Headcrumbs.forgeCraft = configFile.get("heads", "forgeCraft", Headcrumbs.forgeCraft).setRequiresMcRestart(true).getStringList();
		Headcrumbs.ftb = configFile.get("heads", "ftb", Headcrumbs.ftb).setRequiresMcRestart(true).getStringList();

		if (configFile.hasChanged())
			configFile.save();
	}

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
		if (Reference.MOD_ID.equals(eventArgs.modID))
			syncConfigs();
	}
}