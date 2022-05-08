package dev.draylar.superpick.mixin;

import draylar.magna.api.MagnaTool;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PickaxeItem.class)
public abstract class PickaxeItemMixin extends Item implements MagnaTool {

    public PickaxeItemMixin(Settings settings) {
        super(settings);
    }

    @Override
    public int getRadius(ItemStack stack) {
        return 1;
    }

    @Override
    public boolean playBreakEffects() {
        return false;
    }

    @Override
    public boolean ignoreRadiusBreak(ItemStack stack, PlayerEntity player) {
        return !player.isSneaking();
    }

    @Override
    public boolean showExtendedOutline(ItemStack stack, PlayerEntity player) {
        return player.isSneaking();
    }
}
