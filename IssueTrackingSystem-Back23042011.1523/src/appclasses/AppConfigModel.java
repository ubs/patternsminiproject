package appclasses;

import java.util.*;

/**
 * AppConfig Model
 * @author iXeon
 */
public class AppConfigModel {
    //Data Fields
    private HashMap<String, AppConfig> appConfigs = new HashMap();

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
}