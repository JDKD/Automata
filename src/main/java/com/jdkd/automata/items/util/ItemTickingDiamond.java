package com.jdkd.automata.items.util;

import com.jdkd.automata.AutomataMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemTickingDiamond extends Item {

    public ItemTickingDiamond() {
        this.setMaxDamage(0);
        this.setMaxStackSize(1);
        this.setHasSubtypes(true);
        this.setCreativeTab(AutomataMain.tab);
    }

    @Override
    public int getMetadata(int damage) {
        return super.getMetadata(damage);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if(tab != null && tab.equals(AutomataMain.tab)) {
            for (TickSpeed tick : TickSpeed.values()) {
                ItemStack subStack = new ItemStack(this, 1, tick.ordinal());
                items.add(subStack);
            }
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + TickSpeed.values()[stack.getMetadata()].toString().toLowerCase();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }


}
