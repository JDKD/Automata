package com.jdkd.automata.proxy;

import com.jdkd.automata.items.util.ItemTickingDiamond;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public abstract class CommonProxy {

    public static Item tickingDiamond = new ItemTickingDiamond();

    public void preInit(){
        tickingDiamond = new ItemTickingDiamond();
        tickingDiamond.setUnlocalizedName("item_ticking_diamond");
        tickingDiamond.setRegistryName("item_ticking_diamond");
        ForgeRegistries.ITEMS.register(tickingDiamond);
    }

    public void init(){

    }

    public void postInit() {

    }

    public void registerItemRenderer(Item item, int meta, String id) {

    }


    public abstract boolean isDedicatedServer();
}
