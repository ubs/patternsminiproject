package appclasses;

import java.io.PrintStream;

/**
 *
 * @author iXeon
 */
public class AppConfig {
    //Data Fields
    private String configKey;
    private String configName;
    private String configValue;

    //Constructors
    public AppConfig() {
        this.configKey = null;
        this.configName = null;
        this.configValue = null;
    }

    public AppConfig(String configKey, String configName, String configValue) {
        this.configKey = configKey;
        this.configName = configName;
        this.configValue = configValue;
    }

    public void print(PrintStream out) {
        out.println( "\nAppConfig Object: " );
        out.println( " configKey -> " + configKey );
        out.println( " configName -> " + configName );
        out.println( " configValue -> " + configValue + "\n");
    }

    //Getters and Setters
    public String getConfigKey() {
        return configKey;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    public String toPersistenceString(){
        return toXMLPersistenceString();
    }

    protected String toXMLPersistenceString(){
        StringBuilder XMLPersistenceString = new StringBuilder();
        String breakLine = "\n";

        XMLPersistenceString
                .append("<appconfig>").append(breakLine)
                    .append("<configkey>").append(getConfigKey()).append("</configkey>").append(breakLine)
                    .append("<configvalue>").append(getConfigValue()).append("</configvalue>").append(breakLine)
                .append("</appconfig>").append(breakLine);

        return XMLPersistenceString.toString();
    }
}