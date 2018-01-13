package com.jdkd.automata.utils;

import static net.minecraftforge.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler;

import com.jdkd.automata.entities.automaton.EntityAutomata;
import com.jdkd.automata.entities.automaton.RenderAutomata;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderEntityItem;
import net.minecraft.entity.item.EntityItem;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = "automata")
@SideOnly(Side.CLIENT)
public class ModelRegistry {

    @SubscribeEvent
    public static void registerEntityModels(ModelRegistryEvent event) {
        registerEntityRenderingHandler(EntityAutomata.class, RenderAutomata::new);
    }

}
