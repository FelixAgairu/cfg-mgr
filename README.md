# Config Manager
A serializer using GSON and load/save config files.

## Use
- `Gradle` use `modImplementation`
- `IDE` sync changes
```java
import dev.felixagairu.configmanager.ConfigManager

public class Test() {
	private static final String defaultConfigs ="{'key':'value'}";
    private static final ConfigManager configManager = new ConfigManager("modid.json", defaultConfigs);
    private static final JsonObject configs = configManager.loadConfig();
}
```


