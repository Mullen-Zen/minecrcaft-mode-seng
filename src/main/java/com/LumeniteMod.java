package com.example;

import net.fabricmc.api.ModInitializer;
import com.example.block.ModBlocks;
import com.example.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LumeniteMod implements ModInitializer {
	public static final String MOD_ID = "lumenite_mod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
        ModItems.registerModToolsAndArmor();
        
		LOGGER.info("Lumenite Mod initialized successfully!");
	}
}