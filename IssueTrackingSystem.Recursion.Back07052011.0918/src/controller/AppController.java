package controller;

/**
 * @PATTERN CONTROLLER
 * Pure Fabrication that Separates the View from the Model
 * Delegates duties to sub controllers
 * @author iXeon
 */
public class AppController {
    private ModelHandler modelHandler = new ModelHandler();

    public AppController() {}

    public void loadModels() {
        modelHandler.loadModels();
    }
}