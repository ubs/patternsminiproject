/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package guiclasses;

import classes.GenericHelper;

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


    public void printObject(){
        GenericHelper.printout("\n>>>Printin Data for Software Ticket: " + ticketID);
        GenericHelper.printout("ticketID: " + ticketID);
        GenericHelper.printout("problemDescription: " + problemDescription);
        GenericHelper.printout("customerName: " + customerName);
        GenericHelper.printout("customerAddress: " + customerAddress);
        GenericHelper.printout("contractID: " + contractID);
        GenericHelper.printout("resolution: " + resolution);
        GenericHelper.printout("resolutionDate: " + resolutionDate);
        GenericHelper.printout("dateCreated: " + dateCreated);
        GenericHelper.printout("isApplicationRepair: " + isApplicationRepair);
        GenericHelper.printout("isOSRepair:" + isOSRepair);
    }

    public String getReport(){
        StringBuilder str = new StringBuilder();

        str.append("\n>>>Reprot for Software Ticket: ").append(ticketID)
        .append("\nticketID: ").append(ticketID)
        .append("\nproblemDescription: ").append(problemDescription)
        .append("\ncustomerName: ").append(customerName)
        .append("\ncustomerAddress: ").append(customerAddress)
        .append("\ncontractID: ").append(contractID)
        .append("\nresolution: ").append(resolution)
        .append("\nresolutionDate: ").append(resolutionDate)
        .append("\ndateCreated: ").append(dateCreated)
        .append("\nisApplicationRepair: ").append(isApplicationRepair)
        .append("\nisOSRepair:").append(isOSRepair);

        return str.toString();
    }
}
