/********************************************************************
 * Copyright (c) 1999 The Bean Factory, LLC.
 * All Rights Reserved.
 *
 * The Bean Factory, LLC. makes no representations or
 * warranties about the suitability of the software, either express
 * or implied, including but not limited to the implied warranties of
 * merchantableness, fitness for a particular purpose, or
 * non-infringement. The Bean Factory, LLC. shall not be
 * liable for any damages suffered by licensee as a result of using,
 * modifying or distributing this software or its derivatives.
 *
 *******************************************************************/
package guiclasses;

import java.util.Date;

/********************************************************************
 <B>Person</B> sets the last name, first name, company name, and
 email address of a person

 @version      : 1.1
 @author       : Nazamul Idris

********************************************************************/
public class Ticket {
//
// Data Members
//
    protected String ticketID;
    protected String problemDescription;
    protected String customerName;
    protected String customerAddress;
    protected String contractID;

    public String getContractID() {
        return contractID;
    }

    public void setContractID(String contractID) {
        this.contractID = contractID;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Date getResolutionDate() {
        return resolutionDate;
    }

    public void setResolutionDate(Date resolutionDate) {
        this.resolutionDate = resolutionDate;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }
    protected String resolution;
    protected Date resolutionDate;
    protected Date dateCreated;


//
// Methods
//
/**
 Default Constructor

 @param
 */
    public Ticket(){

    }

    
   
    
    /**
     Return an email address

     @return    email    an email address
     */
    


}//end of Person class

