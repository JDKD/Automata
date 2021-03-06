package com.jdkd.automata.utils;

import com.jdkd.automata.AutomataMain;
import com.jdkd.automata.entities.automaton.EntityAutomata;
import com.jdkd.automata.items.AutomataItems;
import com.jdkd.automata.items.parts.AutomatonPart;
import com.jdkd.automata.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;

import static net.minecraftforge.fml.common.registry.EntityRegistry.registerModEntity;

@Mod.EventBusSubscriber
public class AutomataRegistry {

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        AutomataItems.intialiseParts();

        for (Item item : AutomataItems.parts) {

            AutomatonPart part = (AutomatonPart) item;
            event.getRegistry().register(item);
        }

        event.getRegistry().register(AutomataItems.debugger);
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        for (Item item : AutomataItems.parts) {
            AutomatonPart part = (AutomatonPart) item;
            AutomataMain.proxy.registerItemRenderer(item, 0, item.getUnlocalizedName().substring(5));
        }

        AutomataMain.proxy.registerItemRenderer(AutomataItems.debugger, 0, AutomataItems.debugger.getUnlocalizedName().substring(5));
    }

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityEntry> event) {
        registerEntities(EntityAutomata.class, "base_automata", 21);
    }

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
    }

    @SuppressWarnings("SameParameterValue")
    private static void registerEntities(Class<? extends Entity> entityClass, String registryName, int id, int trackingRange, int updateFrequency, boolean sendVelocityUpdates, boolean hasEgg, int primaryColor, int secondaryColor) {
        ResourceLocation resourceLocation = Utils.setRL(registryName);
        if (hasEgg) {
            registerModEntity(resourceLocation, entityClass, registryName, id, AutomataMain.instance, trackingRange, updateFrequency, sendVelocityUpdates, primaryColor, secondaryColor);
        } else {
            registerModEntity(resourceLocation, entityClass, registryName, id, AutomataMain.instance, trackingRange, updateFrequency, sendVelocityUpdates);
        }
    }

    private static void registerEntities(Class<? extends Entity> entityClass, String registryName, int id, int primaryColor, int secondaryColor) {
        registerEntities(entityClass, registryName, id, 64, 1, true, true, primaryColor, secondaryColor);
    }

    private static void registerEntities(Class<? extends Entity> entityClass, String registryName, int id) {
        registerEntities(entityClass, registryName, id, 64, 1, true, false, 0, 0);
    }

}
