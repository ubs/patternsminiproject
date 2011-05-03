package persistence;

import classes.GenericHelper;
import classes.HardwareTicket;
import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

/**
 *
 * @author popoola
 */
public class HardwarePersistenceMapper {

    private static HardwarePersistenceMapper instance;
    //Model to Hold Objects Read in from XML File
    private HashMap<String, HardwareTicket> ticketModel = new HashMap<String, HardwareTicket>();
    
    private HardwareTicket hardwareTicket;
    private String xmlFilePath = "src/persistence/HardwareTicket.xml";
    private final String XML_ROOT_ELEMENT_TAG = "hardwareTicketItem";

    private HardwarePersistenceMapper() {
    }

    public static synchronized HardwarePersistenceMapper getInstance() {
        if (instance == null) {
            instance = new HardwarePersistenceMapper();
        }
        return instance;
    }

    public void addTicketToModel(HardwareTicket hwt){
        ticketModel.put(hwt.getTicketID(), hwt);
    }

    public void removeTicketFromModel(String ticketID){
        if (ticketModel.containsKey(ticketID)){
            ticketModel.remove(ticketID);
        }
    }

    public void updateTicketInModel(String ticketID, String problemDescription, String customerName,
            String customerAddress, String contractID, String resolution, Date resolutionDate,
            String serialNumber, boolean isHardwareRepair, boolean isHardwareUpgrade) {
        
        HardwareTicket hwt;
        if (ticketModel.containsKey(ticketID)){
            hwt = ticketModel.get(ticketID);
            hwt.setProblemDescription(problemDescription);
            hwt.setCustomerName(customerName);
            hwt.setCustomerAddress(customerAddress);
            hwt.setContractID(contractID);
            hwt.setResolution(resolution);
            hwt.setResolutionDate(resolutionDate);
            //hwt.setSerialNumber(serialNumber);
            hwt.setIsHardwareRepair(isHardwareRepair);
            hwt.setIsHardwareUpgrade(isHardwareUpgrade);
        }
    }

    public void addNewTicketToModel(String ticketID, String problemDescription, String customerName,
            String customerAddress, String contractID, String resolution, Date resolutionDate,
            String serialNumber, boolean isHardwareRepair, boolean isHardwareUpgrade) {

        HardwareTicket hwt = new HardwareTicket();
        hwt.setTicketID(ticketID);
        hwt.setProblemDescription(problemDescription);
        hwt.setCustomerName(customerName);
        hwt.setCustomerAddress(customerAddress);
        hwt.setContractID(contractID);
        hwt.setResolution(resolution);
        hwt.setResolutionDate(resolutionDate);
        hwt.setSerialNumber(serialNumber);
        hwt.setIsHardwareRepair(isHardwareRepair);
        hwt.setIsHardwareUpgrade(isHardwareUpgrade);
        hwt.setDateCreated(new Date());

        addTicketToModel(hwt);
    }

    public void dumpModelData(){
        HardwareTicket hwt;
        GenericHelper.printout("\n[Dumping Data for " + getClass() + "]");
        for (Map.Entry<String, HardwareTicket> mapEntry : ticketModel.entrySet()){
            hwt = mapEntry.getValue();
            hwt.printObject();
        }
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
                hardwareTicket = new HardwareTicket();

                //Read a ticket data from xml file and set fields for hardwareTicket
                Element row = XMLUtility.getElement(xmlDoc, XML_ROOT_ELEMENT_TAG, i);
                hardwareTicket.setTicketID(XMLUtility.getValue(row, "ticketID"));
                hardwareTicket.setProblemDescription(XMLUtility.getValue(row, "problemDescription"));
                hardwareTicket.setCustomerName(XMLUtility.getValue(row, "customerName"));
                hardwareTicket.setCustomerAddress(XMLUtility.getValue(row, "customerAddress"));
                hardwareTicket.setContractID(XMLUtility.getValue(row, "contractID"));
                hardwareTicket.setResolution(XMLUtility.getValue(row, "resolution"));
                hardwareTicket.setResolutionDate(
                        GenericHelper.convertString2Date( XMLUtility.getValue(row, "resolutionDate")) );
                hardwareTicket.setDateCreated(
                        GenericHelper.convertString2Date( XMLUtility.getValue(row, "dateCreated")) );

                //Add the ticket to the model
                addTicketToModel(hardwareTicket);
            }//end for
        } catch (Exception e) {
            GenericHelper.printout(e.getMessage());
        }
    }
}