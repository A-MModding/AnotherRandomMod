package net.barrnone.anotherrandommod.item;

import net.barrnone.anotherrandommod.AnotherRandomMod;
import net.barrnone.anotherrandommod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AnotherRandomMod.MODID);

    public static final Supplier<CreativeModeTab> ANOTHER_RANDOM_MOD_TAB = CREATIVE_MODE_TAB.register("another_random_mod_tab",
            ()-> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.VITALUM_BLOCK.get()))
                    .title(Component.translatable("creativetab.armanotherrandommod.another_random_mod_tab"))
                    .displayItems((parameters, output)->{
                        output.accept(ModBlocks.VITALUM_ORE);
                        output.accept(ModItems.RAW_VITALUM);
                        output.accept(ModItems.VITALUM_INGOT);
                        output.accept(ModItems.VITALUM_NUGGET);
                        output.accept(ModBlocks.VITALUM_BLOCK);
                    }).build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
