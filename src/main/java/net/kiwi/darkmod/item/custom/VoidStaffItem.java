package net.kiwi.darkmod.item.custom;

import net.kiwi.darkmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class VoidStaffItem extends Item {
    private static final Map<Block, Block> VOID_MAP =
            Map.of(
                    Blocks.DIRT, ModBlocks.TRUE_VOID_BLOCK,
                    Blocks.STONE, ModBlocks.TRUE_VOID_BLOCK,
                    Blocks.BIRCH_WOOD, Blocks.OAK_WOOD,
                    Blocks.DIAMOND_BLOCK, ModBlocks.VOID_DIAMOND_BLOCK,
                    Blocks.DIAMOND_ORE, ModBlocks.VOID_DIAMOND_ORE_BLOCK,
                    Blocks.DEEPSLATE_DIAMOND_ORE, ModBlocks.VOID_DIAMOND_ORE_DEEPSLATE_BLOCK
                    
                    
            );
    
    public VoidStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();
        
        if (VOID_MAP.containsKey(clickedBlock)) {
            if (!world.isClient()){
                world.setBlockState(context.getBlockPos(), VOID_MAP.get(clickedBlock).getDefaultState());
                
                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.ENTITY_WARDEN_HEARTBEAT, SoundCategory.BLOCKS);
            }
            
        }
        
        return ActionResult.SUCCESS;
    }
}
