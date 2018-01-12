package com.jdkd.automata;

import com.jdkd.automata.items.AutomataItems;
import com.jdkd.automata.proxy.CommonProxy;
import com.jdkd.automata.utils.AutomataRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = "automata", name = "Automata")
public class AutomataMain {

    @Mod.Instance("automata")
    public static AutomataMain instance;

    @SidedProxy(clientSide = "com.jdkd.automata.proxy.ClientOnlyProxy", serverSide = "com.jdkd.automata.proxy.DedicatedServerProxy")
    public static CommonProxy proxy;

    public static final CreativeTabs tab = new CreativeTabs("tabAutomata") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Items.APPLE);
        }
    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        System.out.println("Johnk was here!");
        proxy.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        proxy.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        proxy.postInit();
    }

}
