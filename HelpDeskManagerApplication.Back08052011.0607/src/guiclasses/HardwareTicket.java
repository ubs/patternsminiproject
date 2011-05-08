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
public class HardwareTicket extends Ticket{

    public HardwareTicket() {
        super();
    }

    protected String serialNumber;
    protected boolean isHardwareRepair;
    protected boolean isHardwareUpgrade;

    public boolean isIsHardwareRepair() {
        return isHardwareRepair;
    }

    public void setIsHardwareRepair(boolean isHardwareRepair) {
        this.isHardwareRepair = isHardwareRepair;
    }

    public boolean isIsHardwareUpgrade() {
        return isHardwareUpgrade;
    }

    public void setIsHardwareUpgrade(boolean isHardwareUpgrade) {
        this.isHardwareUpgrade = isHardwareUpgrade;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void printObject(){
        GenericHelper.printout("\n>>>Printin Data for Hardware Ticket: " + ticketID);
        GenericHelper.printout("ticketID: " + ticketID);
        GenericHelper.printout("problemDescription: " + problemDescription);
        GenericHelper.printout("customerName: " + customerName);
        GenericHelper.printout("customerAddress: " + customerAddress);
        GenericHelper.printout("contractID: " + contractID);
        GenericHelper.printout("resolution: " + resolution);
        GenericHelper.printout("resolutionDate: " + resolutionDate);
        GenericHelper.printout("dateCreated: " + dateCreated);
        GenericHelper.printout("serialNumber: " + serialNumber);
        GenericHelper.printout("isHardwareRepair: " + isHardwareRepair);
        GenericHelper.printout("isHardwareUpgrade: " + isHardwareUpgrade);
    }

    public String getReport(){
        StringBuilder str = new StringBuilder();

        str.append("\n>>>Reprot for Hardware Ticket: ").append(ticketID)
        .append("\nticketID: ").append(ticketID)
        .append("\nproblemDescription: ").append(problemDescription)
        .append("\ncustomerName: ").append(customerName)
        .append("\ncustomerAddress: ").append(customerAddress)
        .append("\ncontractID: ").append(contractID)
        .append("\nresolution: ").append(resolution)
        .append("\nresolutionDate: ").append(resolutionDate)
        .append("\ndateCreated: ").append(dateCreated)
        .append("\nserialNumber: ").append(serialNumber)
        .append("\nisHardwareRepair: ").append(isHardwareRepair)
        .append("\nisHardwareUpgrade:").append(isHardwareUpgrade);

        return str.toString();
    }
}