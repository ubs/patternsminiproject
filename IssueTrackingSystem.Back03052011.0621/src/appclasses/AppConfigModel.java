package appclasses;

import java.util.*;

/**
 * AppConfig Model
 * @author iXeon
 */
public class AppConfigModel extends AppModel {
    //Data Fields
    private HashMap<String, AppConfig> appConfigs = new HashMap<String, AppConfig>();

    //Constructor
    private static AppConfigModel instance;

    private AppConfigModel() {
    }

    public static synchronized AppConfigModel getInstance() {
        if (instance == null) {
            instance = new AppConfigModel();
        }

        return instance;
    }

    //Prevent Cloning
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public void addAppConfig(AppConfig appConfig) {
        IDebug.print("AppConfigModel: Adding Config to Model");
        appConfigs.put(appConfig.getConfigKey(), appConfig);
    }

    public boolean addAppConfigs(Vector<AppConfig> appConfigObjects){
        boolean success = true;
        IDebug.print("Total Objects sent in: " + appConfigObjects.size());
        AppConfig appConfig;
        Enumeration e = appConfigObjects.elements();
        while( e.hasMoreElements() ){
            appConfig = (AppConfig) e.nextElement();
            addAppConfig(appConfig);
        }
        return success;
    }

    public AppConfig getAppConfig(String appConfigKey){
        if (appConfigs.containsKey(appConfigKey)){
            return appConfigs.get(appConfigKey);
        }
        return null;
    }

    public void removeAppConfig(String appConfigKey){
        if (appConfigs.containsKey(appConfigKey)){
            appConfigs.remove(appConfigKey);
        }
    }

    public void dumpAppConfigs(){
        AppConfig appConfig;
        IDebug.print("Dumping App Configs");

        for (Map.Entry<String, AppConfig> entry : appConfigs.entrySet()) {
            //String key = entry.getKey();
            appConfig = entry.getValue();
            appConfig.print(System.out);
        }
    }

    //Getters and Setters
    public Map<String, AppConfig> getAppConfigs() {
        return appConfigs;
    }

    public long getTotalCount(){
        return appConfigs.size();
    }

    //Persistence String Generator
    @Override
    public String toPersistenceString() {
        return toXMLPersistenceString();
    }

    protected String toXMLPersistenceString(){
        StringBuilder XMLPersistenceString = new StringBuilder();
        String breakLine = "\n";
        String modelRootBeginTag = "<appconfigmodel>";
        String modelRootEndTag = "</appconfigmodel>";
        AppConfig appConfig;

        XMLPersistenceString.append(getXMLHeaderString()).append(breakLine);

        XMLPersistenceString.append(modelRootBeginTag).append(breakLine);

        for (Map.Entry<String, AppConfig> entry : appConfigs.entrySet()) {
            //String key = entry.getKey();
            appConfig = entry.getValue();
            XMLPersistenceString.append( appConfig.toPersistenceString() ).append(breakLine);
        }

        XMLPersistenceString.append(modelRootEndTag).append(breakLine);

        return XMLPersistenceString.toString();
    }

    protected String getXMLHeaderString(){
        StringBuilder XMLHeaderString = new StringBuilder();
        String breakLine = "\n";

        XMLHeaderString
            .append("<?xml version='1.0' encoding='UTF-8'?>").append(breakLine)
            .append("<!DOCTYPE appconfigmodel [").append(breakLine)
            .append("<!ELEMENT appconfigmodel (appconfig)*>").append(breakLine)
            .append("<!ELEMENT appconfig (configkey, configvalue)>").append(breakLine)
            .append("<!ELEMENT configkey (#PCDATA)>").append(breakLine)
            .append("<!ELEMENT configvalue (#PCDATA)>").append(breakLine)
            .append("]>").append(breakLine);

        return XMLHeaderString.toString();
    }
}