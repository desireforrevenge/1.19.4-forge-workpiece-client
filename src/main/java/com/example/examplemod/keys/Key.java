package com.example.examplemod.keys;

import com.example.examplemod.ExampleMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Key {
    @SubscribeEvent
    public void onKeyInput(InputEvent.Key e) {
        if (Minecraft.getInstance().player != null && !(Minecraft.getInstance().screen instanceof ChatScreen)) ExampleMod.keyPress(e.getKey(), e.getAction());
    }
}
