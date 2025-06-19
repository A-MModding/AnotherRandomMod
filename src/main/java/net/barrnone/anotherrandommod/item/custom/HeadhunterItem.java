package net.barrnone.anotherrandommod.item.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.client.event.sound.PlaySoundEvent;
import net.neoforged.neoforge.common.conditions.ICondition;

public class HeadhunterItem extends Item {
    public HeadhunterItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity interactionTarget, InteractionHand usedHand) {
        if(!player.level().isClientSide){
            if (interactionTarget.getHealth() < 5f){
                ItemStack headStack = null;

                if (interactionTarget.getType() == EntityType.ZOMBIE){
                    headStack = new ItemStack(Items.ZOMBIE_HEAD);
                } else if (interactionTarget.getType() == EntityType.SKELETON) {
                    headStack = new ItemStack(Items.SKELETON_SKULL);
                } else if (interactionTarget.getType() == EntityType.CREEPER){
                    headStack = new ItemStack(Items.CREEPER_HEAD);
                }

                player.level().playSound(null, interactionTarget.getOnPos(), SoundEvents.SHEEP_SHEAR, SoundSource.PLAYERS);

                ItemEntity drop = new ItemEntity(
                        player.level(),
                        interactionTarget.getX(), interactionTarget.getY() , interactionTarget.getZ(), headStack
                );
                player.level().addFreshEntity(drop);

                interactionTarget.hurt(player.damageSources().playerAttack(player) ,200f);

                stack.hurtAndBreak(1, player, usedHand == InteractionHand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND);

                player.getCooldowns().addCooldown(this,100);
            }
        }


        return InteractionResult.SUCCESS;
    }
}
