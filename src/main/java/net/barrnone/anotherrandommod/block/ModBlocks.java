package net.barrnone.anotherrandommod.block;

import net.barrnone.anotherrandommod.AnotherRandomMod;
import net.barrnone.anotherrandommod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(AnotherRandomMod.MODID);

    //Steps to make new block
    //1. Declare it Below
    //2. Grant it properties in its declaration
    //3. Add it to Creative Tab
    //4. Add Translation in Lang
    //5. give it block states
    //6. give it block model
    //7. give it an item model
    //8. give it texture
    //9. give it loot table

    public static final DeferredBlock<Block> VITALUM_BLOCK = registerBlock("vitalum_block",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .strength(5f,6f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)
            )
    );
    public static final DeferredBlock<Block> VITALUM_ORE = registerBlock("vitalum_ore",
            ()-> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GRAY)
                    .strength(3f,3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)
            )
    );
    public static final DeferredBlock<Block> DEEPSLATE_VITALUM_ORE = registerBlock("deepslate_vitalum_ore",
            ()-> new DropExperienceBlock(UniformInt.of(3,6),BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GRAY)
                    .strength(4.5f,3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)
            )
    );

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name , toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static  void  register (IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
