package com.jdkd.automata;

import com.jdkd.automata.utils.AutomataRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = "automata", name = "Automata")
public class AutomataMain {

    @Mod.Instance("automata")
    public static AutomataMain instance;

    public static final CreativeTabs tab = new CreativeTabs("tabAutomata") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Items.APPLE);
        }
    };

    @SubscribeEvent
    public void preInit(FMLPreInitializationEvent event){
    }

}
