package com.jdkd.automata.proxy;

import com.jdkd.automata.items.util.TickSpeed;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientOnlyProxy extends CommonProxy {

    @Override
    public void preInit() {
        super.preInit();
        ModelResourceLocation modelResourceLocation = new ModelResourceLocation("automata:item_ticking_diamond", "inventory");
        for(TickSpeed tick : TickSpeed.values()){
            ModelLoader.setCustomModelResourceLocation(CommonProxy.tickingDiamond, tick.ordinal(), modelResourceLocation);
        }
    }

    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation("automata:" + id, "inventory"));
    }

    @Override
    public boolean isDedicatedServer() {
        return false;
    }
}
