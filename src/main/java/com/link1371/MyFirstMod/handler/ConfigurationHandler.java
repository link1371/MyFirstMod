package com.link1371.MyFirstMod.handler;

import com.link1371.MyFirstMod.reference.Reference;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;
public class ConfigurationHandler
{
    public static Configuration configuration;
    public static boolean testValue = false;

    public static void init(File configFile)
    {
        //Creates the configuration object from the given file
        if (configuration == null)
        {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
        {
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        testValue = configuration.getBoolean("configValue", Configuration.CATEGORY_GENERAL, false, "Example Text");
        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }
}
