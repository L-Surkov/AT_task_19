package config;

import org.aeonbits.owner.ConfigFactory;

public enum ConfigReader {
    INSTANCE;

    private final RemoteConfig config;

    ConfigReader() {
        try {
            this.config = ConfigFactory.create(RemoteConfig.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config: " + e.getMessage(), e);
        }
    }

    public RemoteConfig getConfig() {
        return config;
    }
}
