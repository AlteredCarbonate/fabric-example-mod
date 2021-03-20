package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.example.blocks.StrawberryCrop;
import net.fabricmc.example.items.Strawberry;
import net.fabricmc.example.items.StrawberrySeeds;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.*;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExampleMod implements ModInitializer {
	public static final String MODID = "examplemod";
	public static final Logger LOGGER = LogManager.getLogger(MODID);

	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier(MODID, "general"),
			() -> new ItemStack(Blocks.CARROTS));

	public static final FabricItemSettings ITEM_SETTING = new FabricItemSettings().group(ITEM_GROUP);

	public static final Block BLOCK_STRAWBERRYCROP = new StrawberryCrop(AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).nonOpaque());
	public static final Item ITEM_STRAWBERRY = new Strawberry(ITEM_SETTING);
	public static final AliasedBlockItem ITEM_STRAWBERRYSEEDS = new StrawberrySeeds(BLOCK_STRAWBERRYCROP, ITEM_SETTING);



		private static final Identifier STRAWBERRY_CROP_ID =  new Identifier(MODID, "strawberry_crop");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

//	WHEAT_SEEDS = register((String)"wheat_seeds", (Item)(new AliasedBlockItem(Blocks.WHEAT, (new Item.Settings()).group(ItemGroup.MATERIALS))));
//		Registry.register(Registry.ITEM, new Identifier(MODID, "strawberry"), ITEM_STRAWBERRY);

		Registry.register(Registry.ITEM, new Identifier(MODID, "strawberry"), ITEM_STRAWBERRY);
		Registry.register(Registry.ITEM, new Identifier(MODID, "strawberry_seeds"), ITEM_STRAWBERRYSEEDS);
		Registry.register(Registry.BLOCK, STRAWBERRY_CROP_ID, BLOCK_STRAWBERRYCROP);
		Registry.register(Registry.ITEM, new Identifier(MODID, "strawberry_crop"), new BlockItem(BLOCK_STRAWBERRYCROP, new FabricItemSettings().group(ItemGroup.MISC)));
		BlockRenderLayerMap.INSTANCE.putBlock(BLOCK_STRAWBERRYCROP, RenderLayer.getTranslucent());

//		LootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(Blocks.WHEAT).properties(StatePredicate.Builder.create().exactMatch(CropBlock.AGE, 7));
//		this.addDrop(Blocks.WHEAT, cropDrops(Blocks.WHEAT, Items.WHEAT, Items.WHEAT_SEEDS, builder2));

//		LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
//			LOGGER.info("STRAWBERRY_CROP_ID");
//			LOGGER.info(STRAWBERRY_CROP_ID.getNamespace());
//			LOGGER.info(STRAWBERRY_CROP_ID.getPath());
//
//
//			if (STRAWBERRY_CROP_ID.equals(id)) {
//				LOGGER.info("After Works u cunt");
//				FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
//						.rolls(ConstantLootTableRange.create(1))
//						.with(ItemEntry.builder(Items.ACACIA_DOOR));
//
//				supplier.pool(poolBuilder);
//			}
//		});

		LOGGER.info("[ExampleMod]: Initialize");
	}
}
