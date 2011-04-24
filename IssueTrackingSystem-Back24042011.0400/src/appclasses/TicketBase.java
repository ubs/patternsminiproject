package appclasses;

import java.util.Date;

/**
 * Tickets Base Class
 * @author iXeon
 */
public abstract class TicketBase {
    //Data Fields
    private String ticketID;
    private CategoryBase ticketCategory;
    private String ticketSubject;
    private String ticketDetails;
    private String ticketSolution;
    private int ticketStatus;
    private Date dateLogged;
    private Date dateResolved;

    //Abstract Methods
    abstract String toPersistenceString();

    //Constructor
    public TicketBase() {
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

    public CategoryBase getTicketCategory() {
        return ticketCategory;
    }

    public void setTicketCategory(CategoryBase ticketCategory) {
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
