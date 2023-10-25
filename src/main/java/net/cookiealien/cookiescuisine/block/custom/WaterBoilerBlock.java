package net.cookiealien.cookiescuisine.block.custom;

import net.cookiealien.cookiescuisine.item.ModItems;
import net.cookiealien.cookiescuisine.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class WaterBoilerBlock extends HorizontalDirectionalBlock {
    public static final VoxelShape SHAPE = Block.box(2,0,2,14,14,14);
    public static final IntegerProperty WATER_LEVEL = IntegerProperty.create("water_level",0,3);
    public static final BooleanProperty HEATED = BooleanProperty.create("heated");
    public WaterBoilerBlock(Properties pProperties) {
        super(pProperties);
        registerDefaultState(defaultBlockState().setValue(FACING, Direction.NORTH).setValue(WATER_LEVEL,0).setValue(HEATED,false));
    }

    @Override
    @SuppressWarnings("deprecated")
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(!pLevel.isClientSide && pHand == InteractionHand.MAIN_HAND){
            if(pPlayer.getItemInHand(InteractionHand.MAIN_HAND).is(Items.WATER_BUCKET) && pState.getValue(WATER_LEVEL)!=3){
                pLevel.setBlock(pPos,pState.setValue(WATER_LEVEL,3),3);
                pLevel.playSound((Player) null,pPos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS);
                pPlayer.setItemInHand(InteractionHand.MAIN_HAND,new ItemStack(Items.BUCKET));
            }
            if(pPlayer.getItemInHand(InteractionHand.MAIN_HAND).is(Items.BUCKET)&&pState.getValue(WATER_LEVEL)==3){
                pLevel.setBlock(pPos,pState.setValue(WATER_LEVEL,0),3);
                pLevel.playSound((Player) null, pPos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS);
                pPlayer.setItemInHand(InteractionHand.MAIN_HAND, ItemUtils.createFilledResult(pPlayer.getItemInHand(InteractionHand.MAIN_HAND),pPlayer,new ItemStack(Items.WATER_BUCKET)));
            }
            if(pPlayer.getItemInHand(InteractionHand.MAIN_HAND).is(ModItems.PAPER_CUP.get())&&pState.getValue(WATER_LEVEL)>0){
                pLevel.setBlock(pPos,pState.setValue(WATER_LEVEL,pState.getValue(WATER_LEVEL)-1),3);
                pLevel.playSound((Player) null, pPos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS);
                pPlayer.setItemInHand(InteractionHand.MAIN_HAND, ItemUtils.createFilledResult(pPlayer.getItemInHand(InteractionHand.MAIN_HAND),pPlayer,new ItemStack(ModItems.WATER_CUP.get())));
            }
            if(pPlayer.getItemInHand(InteractionHand.MAIN_HAND).is(ModItems.NOODLES_CUP.get()) && pState.getValue(WATER_LEVEL)>0 && pState.getValue(HEATED)){
                pLevel.setBlock(pPos,pState.setValue(WATER_LEVEL,pState.getValue(WATER_LEVEL)-1),3);
                pLevel.playSound((Player) null, pPos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS);
                pPlayer.setItemInHand(InteractionHand.MAIN_HAND, ItemUtils.createFilledResult(pPlayer.getItemInHand(InteractionHand.MAIN_HAND),pPlayer,new ItemStack(ModItems.INSTANT_NOODLES.get())));
            }
        }

        return InteractionResult.sidedSuccess(!pLevel.isClientSide);
    }

    @Override
    @SuppressWarnings("deprecated")
    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pNeighborBlock, BlockPos pNeighborPos, boolean pMovedByPiston) {
        if(pPos.below().equals(pNeighborPos)){
            if(hasHeatSource(pLevel,pPos)){
                pLevel.setBlock(pPos,pState.setValue(HEATED,true),3);
                System.out.println("I'm heated!");
            }else{
                pLevel.setBlock(pPos,pState.setValue(HEATED,false),3);
                System.out.println("I'm not heated.");
            }
        }

    }



    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(FACING,WATER_LEVEL,HEATED);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        if (hasHeatSource(pContext.getLevel(),pContext.getClickedPos())){
            return defaultBlockState().setValue(FACING,pContext.getHorizontalDirection().getOpposite()).setValue(HEATED,true);
        }
        return defaultBlockState().setValue(FACING,pContext.getHorizontalDirection().getOpposite());
    }

    private boolean hasHeatSource(Level level, BlockPos pos){
        BlockState stateBelow = level.getBlockState(pos.below());
        if(stateBelow.is(ModTags.Blocks.HEAT_SOURCES)){
            if (stateBelow.hasProperty(BlockStateProperties.LIT)){
                return stateBelow.getValue(BlockStateProperties.LIT);
            }
            return true;
        }
        return false;
    }
}
