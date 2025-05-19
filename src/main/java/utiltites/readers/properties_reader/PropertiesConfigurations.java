package utiltites.readers.properties_reader;

import lombok.Getter;

public class PropertiesConfigurations {
    @Getter
    private static String executionAddress;
    @Getter
    private static String executionAddressConfig;
    @Getter
    private static String platformName;



    public static void setConfigProperties() {
        setExecutionAddress(PropertiesDataManager.getProperty("executionAddress", PropertiesDataManager.Capability.EXECUTION));
        setExecutionAddressConfig(PropertiesDataManager.getProperty("executionAddressConfig", PropertiesDataManager.Capability.EXECUTION));
        setPlatformName(PropertiesDataManager.getProperty("platformName", PropertiesDataManager.Capability.EXECUTION));
    }

    public static String getCapability(String capability, String filePath) {
        return PropertiesDataManager.getProperty(capability, filePath);
    }

    public static void setExecutionAddress(String executionAddress) {
        PropertiesConfigurations.executionAddress = executionAddress;
    }

    public static void setExecutionAddressConfig(String executionAddressConfig) {
        PropertiesConfigurations.executionAddressConfig = executionAddressConfig;
    }

    public static void setPlatformName(String platformName) {
        PropertiesConfigurations.platformName = platformName;
    }
}