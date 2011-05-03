/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

/**
 *
 * @author popoola
 */
public class SoftwareTicket extends Ticket{

    public SoftwareTicket() {
        super();
    }

    public boolean isIsApplicationRepair() {
        return isApplicationRepair;
    }

    public void setIsApplicationRepair(boolean isApplicationRepair) {
        this.isApplicationRepair = isApplicationRepair;
    }

    public boolean isIsOSRepair() {
        return isOSRepair;
    }

    public void setIsOSRepair(boolean isOSRepair) {
        this.isOSRepair = isOSRepair;
    }
    private boolean isOSRepair;
    private boolean isApplicationRepair;
}
