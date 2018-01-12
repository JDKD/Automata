package com.jdkd.automata.proxy;

import net.minecraft.item.Item;

public abstract class CommonProxy {

    public void preInit(){

    }

    public void init(){

    }

    public void postInit() {

    }

    public void registerItemRenderer(Item item, int meta, String id) {

    }


    public abstract boolean isDedicatedServer();
}
