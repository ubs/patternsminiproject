package AppClasses;

/**
 * Main Abstract Category class that contains its properties
 * @author iXeon
 */
public abstract class CategoryBase {
    //Data Fields
    private String catID;
    private String catName;
    private String catDescription;
    private String catParent;

    //Constructor
    public CategoryBase() {
        this.catID = null;
        this.catName = null;
        this.catDescription = null;
        this.catParent = null;
    }

    public CategoryBase(String catID, String catName, String catDescription) {
        this.catID = catID;
        this.catName = catName;
        this.catDescription = catDescription;
        this.catParent = null;
    }

    //@TODO: Remove this constructor definition and catParent Field, getter, setter
    public CategoryBase(String catID, String catName, String catDescription, String catParent) {
        this.catID = catID;
        this.catName = catName;
        this.catDescription = catDescription;
        this.catParent = catParent;
    }

    //Getters and Setters
    public String getCatDescription() {
        return catDescription;
    }

    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }

    public String getCatID() {
        return catID;
    }

    public void setCatID(String catID) {
        this.catID = catID;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatParent() {
        return catParent;
    }

    public void setCatParent(String catParent) {
        this.catParent = catParent;
    }
}