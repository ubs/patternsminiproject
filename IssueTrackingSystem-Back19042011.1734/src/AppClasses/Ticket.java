package AppClasses;

import java.util.Date;

/**
 *
 * @author iXeon
 */
public class Ticket {
    //Data Fields
    private String ticketID;
    private CategoryOld ticketCategory;
    private String ticketSubject;
    private String ticketDetails;
    private String ticketSolution;
    private int ticketStatus;
    private Date dateLogged;
    private Date dateResolved;

    //Constructor
    public Ticket() {
    }

    //Getters and Setters
    public Date getDateLogged() {
        return dateLogged;
    }

    public void setDateLogged(Date dateLogged) {
        this.dateLogged = dateLogged;
    }

    public Date getDateResolved() {
        return dateResolved;
    }

    public void setDateResolved(Date dateResolved) {
        this.dateResolved = dateResolved;
    }

    public CategoryOld getTicketCategory() {
        return ticketCategory;
    }

    public void setTicketCategory(CategoryOld ticketCategory) {
        this.ticketCategory = ticketCategory;
    }

    public String getTicketDetails() {
        return ticketDetails;
    }

    public void setTicketDetails(String ticketDetails) {
        this.ticketDetails = ticketDetails;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getTicketSolution() {
        return ticketSolution;
    }

    public void setTicketSolution(String ticketSolution) {
        this.ticketSolution = ticketSolution;
    }

    public int getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(int ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getTicketSubject() {
        return ticketSubject;
    }

    public void setTicketSubject(String ticketSubject) {
        this.ticketSubject = ticketSubject;
    }
}
