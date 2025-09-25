package net.kiwi.darkmod.world;

import net.kiwi.darkmod.BetterDarkMod;
import net.kiwi.darkmod.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?,?>> VOID_DIAMOND_ORE_KEY = registerKey("void_diamond_ore");
    public static final RegistryKey<ConfiguredFeature<?,?>> VOID_GOO_ORE_KEY = registerKey("void_goo_ore");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldVoidDiamondOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.VOID_DIAMOND_ORE_BLOCK.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.VOID_DIAMOND_ORE_DEEPSLATE_BLOCK.getDefaultState()));
        List<OreFeatureConfig.Target> overworldVoidGooOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.VOID_GOO_BLOCK.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.VOID_GOO_DEEPSLATE_BLOCK.getDefaultState()));

        register(context, VOID_DIAMOND_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldVoidDiamondOres, 7));
        register(context, VOID_GOO_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldVoidGooOres, 14));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(BetterDarkMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
