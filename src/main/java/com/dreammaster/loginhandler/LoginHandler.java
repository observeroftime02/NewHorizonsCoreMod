package com.dreammaster.loginhandler;

import com.dreammaster.config.CoreModConfig;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class LoginHandler
{
    @SuppressWarnings("unused")
    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event)
    {
        event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD +           "=================================================="    ));
        event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.BOLD +           "    Welcome to Gregtech:New Horizons Weebified"        ));
        event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED +            "   CAUTION! THIS IS NOT A PUBLIC RELEASE BUILD"        ));
        event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.BLUE +           "      THIS IS MAMITOMOES EXPERIMENTAL BUILD"           ));
        event.player.addChatMessage(new ChatComponentText( EnumChatFormatting.LIGHT_PURPLE+   "       Things will break. Please make backups!"        ));
        event.player.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD +           "=================================================="    ));
    }
}
