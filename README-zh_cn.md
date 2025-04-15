[English](/README.md) **[简体中文](README-zh_cn.md)**
# 设置管理器
基于GSON的配置文件序列化器。

## Use
- 在`Gradle`中使用`modImplementation`
- 在`IDE`同步变更
```java
import dev.felixagairu.configmanager.ConfigManager

public class Test() {
	private static final String defaultConfigs ="{'key':'value'}";
    private static final ConfigManager configManager = new ConfigManager("modid.json", defaultConfigs);
    private static final JsonObject configs = configManager.loadConfig();
}
```


