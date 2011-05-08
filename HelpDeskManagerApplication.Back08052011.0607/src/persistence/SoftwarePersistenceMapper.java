package persistence;

import classes.GenericHelper;
import guiclasses.SoftwareTicket;
import guiclasses.MyObservable;
import guiclasses.MyObserver;
import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

/**
 *
 * @author popoola
 */
public class SoftwarePersistenceMapper implements MyObservable {

    private static SoftwarePersistenceMapper instance;
    //Model to Hold Objects Read in from XML File
    private HashMap<String, SoftwareTicket> ticketModel = new HashMap<String, SoftwareTicket>();
    private SoftwareTicket softwareTicket;
    private String xmlFilePath = "src/persistence/SoftwareTicket.xml";
    private final String XML_ROOT_ELEMENT_TAG = "SoftwareTicketItem";

    private SoftwarePersistenceMapper() {
    }

    public static synchronized SoftwarePersistenceMapper getInstance() {
        if (instance == null) {
            instance = new SoftwarePersistenceMapper();
        }
        return instance;
    }

    public void addTicketToModel(SoftwareTicket swt) {
        ticketModel.put(swt.getTicketID(), swt);
        updateListener();
    }

    public void removeTicketFromModel(String ticketID) {
        if (ticketModel.containsKey(ticketID)) {
            ticketModel.remove(ticketID);
        }
    }

    public void updateTicketInModel(String ticketID, String problemDescription, String customerName,
            String customerAddress, String contractID, String resolution, 
            boolean isApplicationRepair, boolean isOSRepair) {

        SoftwareTicket swt;
        if (ticketModel.containsKey(ticketID)) {
            swt = ticketModel.get(ticketID);
            swt.setProblemDescription(problemDescription);
            swt.setCustomerName(customerName);
            swt.setCustomerAddress(customerAddress);
            swt.setContractID(contractID);
            swt.setResolution(resolution);
            swt.setIsApplicationRepair(isApplicationRepair);
            swt.setIsOSRepair(isOSRepair);
        }
    }

    public void addNewTicketToModel(String problemDescription, String customerName,
            String customerAddress, String contractID, String resolution,
            boolean isApplicationRepair, boolean isOSRepair) {

        SoftwareTicket swt = new SoftwareTicket();
        String ticketID = GenericHelper.getRandomTicketID();

        swt.setTicketID(ticketID);
        swt.setProblemDescription(problemDescription);
        swt.setCustomerName(customerName);
        swt.setCustomerAddress(customerAddress);
        swt.setContractID("");
        swt.setResolution(resolution);
        swt.setIsApplicationRepair(isApplicationRepair);
        swt.setIsOSRepair(isOSRepair);

        addTicketToModel(swt);
    }

    public void dumpModelData(){
        SoftwareTicket swt;
        GenericHelper.printout("\n[Dumping Data for " + getClass() + "]");
        for (Map.Entry<String, SoftwareTicket> mapEntry : ticketModel.entrySet()){
            swt = mapEntry.getValue();
            swt.printObject();
            }
    }

    public String getReport(){
        SoftwareTicket swt;
        StringBuilder str = new StringBuilder();
        GenericHelper.printout("\n[Generating Report for " + getClass() + "]");
        
        for (Map.Entry<String, SoftwareTicket> mapEntry : ticketModel.entrySet()){
            swt = mapEntry.getValue();
            str.append(swt.getReport()).append("\n");
        }

        return str.toString();
    }

    public long getTicketCount(){
        return ticketModel.size();
    }

    //Materialize Objects from XML File
    public void materializeTickets() {
        try {
            //Get a file input stream
            InputStream iStream = new FileInputStream(xmlFilePath);

            //Create an XML Document Object
            Document xmlDoc; //Init XML doc

            GenericHelper.printout("Info >> About to read XML File: " + xmlFilePath);
            DocumentBuilderFactory xmlFactoryBuilder = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = xmlFactoryBuilder.newDocumentBuilder();
            xmlDoc = docBuilder.parse(iStream);

            //Get the number of tickets on file
            int size = XMLUtility.getSize(xmlDoc, XML_ROOT_ELEMENT_TAG);

            for (int i = 0; i < size; i++) {
                //instantiate a Ticket object
                softwareTicket = new SoftwareTicket();

                //Read a ticket data from xml file and set fields for hardwareTicket
                Element row = XMLUtility.getElement(xmlDoc, XML_ROOT_ELEMENT_TAG, i);
                softwareTicket.setTicketID(XMLUtility.getValue(row, "ticketID"));
                softwareTicket.setProblemDescription(XMLUtility.getValue(row, "problemDescription"));
                softwareTicket.setCustomerName(XMLUtility.getValue(row, "customerName"));
                softwareTicket.setCustomerAddress(XMLUtility.getValue(row, "customerAddress"));
                softwareTicket.setContractID(XMLUtility.getValue(row, "contractID"));
                softwareTicket.setResolution(XMLUtility.getValue(row, "resolution"));
                softwareTicket.setResolutionDate(
                        GenericHelper.convertString2Date(XMLUtility.getValue(row, "resolutionDate")));
                softwareTicket.setDateCreated(
                        GenericHelper.convertString2Date(XMLUtility.getValue(row, "dateCreated")));

                //Add the ticket to the model
                addTicketToModel(softwareTicket);
            }//end for
        } catch (Exception e) {
            GenericHelper.printout(e.getMessage());
        }
    }

    //OBSERVER PATTERN implementation
    private ArrayList<MyObserver> observers = new ArrayList<MyObserver>();

    public void attach(MyObserver obs) {
        observers.add(obs);
    }

    public void detach(MyObserver obs) {
        observers.remove(obs);
    }

    public void updateListener() {
        Iterator<MyObserver> obsIterator = observers.iterator();
        while (obsIterator.hasNext()){
            obsIterator.next().update(this);
        }
    }
}
