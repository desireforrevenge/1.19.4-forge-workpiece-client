package com.example.examplemod;

import com.example.examplemod.events.GetMessageEvent;
import com.example.examplemod.keys.Key;
import com.example.examplemod.module.Module;
import com.example.examplemod.module.chat.MathHelper;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

@Mod(ExampleMod.MODID)
public class ExampleMod {
    public static final String MODID = "examplemod";
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final List<Module> modules = new ArrayList<>();


    public ExampleMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new Key());
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    public static void keyPress(int key, int action) {
        if (action == 1) {
            for (Module m : modules) {
                if (m.getKey() == key) {
                    m.toggle();
                }
            }
        }
    }

}
