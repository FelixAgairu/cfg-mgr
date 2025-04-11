package dev.felixagairu.configmanager;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.fabricmc.loader.api.FabricLoader;

import java.io.*;

public class ConfigManager {
    private final Gson GSON = new Gson();
    private final File CONFIG_FILE;
    private final JsonObject DEFAULT_CONFIGS;

    public ConfigManager(String configFileName, String configDefault) {
        // Load file dir from given "configFileName"
        // 从"configFileName"获取配置文件路径
        CONFIG_FILE  = new File(FabricLoader.getInstance().getConfigDir().toFile(), configFileName);
        // Set the default config content
        // 设置默认配置文件内容
        DEFAULT_CONFIGS = JsonParser.parseString(configDefault).getAsJsonObject();
    }

    public JsonObject loadConfig() {
        // Read config file
        // 读取配置文件
        try (Reader reader = new FileReader(CONFIG_FILE)) {
            return GSON.fromJson(reader, JsonObject.class);
        } catch (IOException e) {
            System.err.println("Failed to load config: " + e.getMessage());
            return saveConfig(DEFAULT_CONFIGS).getAsJsonObject(); // Return default config
        }
    }

    public JsonObject saveConfig(JsonObject config) {
        // Save config file
        // 保存配置文件
        try (Writer writer = new FileWriter(CONFIG_FILE)) {
            GSON.toJson(config, writer);
            return config;
        } catch (IOException e) {
            System.err.println("Failed to save config: " + e.getMessage());
            return new JsonObject();
        }
    }
    /*
    public static void registerShutdownHandler() {
        ServerLifecycleEvents.SERVER_STOPPING.register(server -> {
            // Save your configuration file here
            saveConfig();
        });
    }
 */
}

