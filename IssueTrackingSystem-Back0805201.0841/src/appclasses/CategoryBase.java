package appclasses;

import java.io.PrintStream;

/**
 * Main Abstract Category class that contains its properties
 * @author iXeon
 */
public abstract class CategoryBase {
    //Data Fields
    private String catID;
    private String catName;
    private String catDescription;
    private String catParentID;

    //Abstract Methods
    abstract String toPersistenceString();

    //Constructor
    public CategoryBase() {
        this.catID = null;
        this.catName = null;
        this.catDescription = null;
        this.catParentID = null;
    }

    public CategoryBase(String catID, String catName, String catDescription) {
        this.catID = catID;
        this.catName = catName;
        this.catDescription = catDescription;
        this.catParentID = null;
    }
    
    public CategoryBase(String catID, String catName, String catDescription, String catParent) {
        this.catID = catID;
        this.catName = catName;
        this.catDescription = catDescription;
        this.catParentID = catParent;
    }

    @Override
    public String toString() {
        return "CategoryBase{" + "catID=" + catID + "catName=" + catName + "catParentID=" + catParentID + '}';
    }

    public void print(PrintStream out) {
        out.println( "\nCategory Object: " );
        out.println( " catID -> " + catID );
        out.println( " catName -> " + catName );
        out.println( " catDescription -> " + catDescription );
        out.println( " catParent -> " + catParentID + "\n");
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

    public String getCatParentID() {
        return catParentID;
    }

    public void setCatParentID(String catParent) {
        this.catParentID = catParent;
    }
}