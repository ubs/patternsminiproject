/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helpdeskmanagerapplication;

import guiclasses.MyObserver;
import persistence.HardwarePersistenceMapper;
import persistence.SoftwarePersistenceMapper;

public class MainController {

    private MainController() {
    }

    // public static void createNewTicket() {
    // The controller passed the action to HardwarePersistenceMapper
    //   if (isHardwareRepair == true) {
    //   } else {
    //   }
    //}
    public static void implementHardwarePersistence(String problemDescription, String customerName,
            String customerAddress, String resolution, String serialNumber,
            boolean isHardwareRepair, boolean isHardwareUpgrade) {
        HardwarePersistenceMapper.getInstance().addNewTicketToModel(
                problemDescription, customerName, customerAddress,
                resolution, null, serialNumber,
                isHardwareRepair, isHardwareUpgrade);

        HardwarePersistenceMapper.getInstance().dumpModelData();
    }

    public static void implementSoftwarePersistence(String problemDescription, String customerName,
            String customerAddress, String resolution, String serialNumber,
            boolean isApplicationRepair, boolean isOSRepair) {
        SoftwarePersistenceMapper.getInstance().addNewTicketToModel(
                problemDescription, customerName, customerAddress,
                resolution, null, isApplicationRepair,
                isOSRepair);
        SoftwarePersistenceMapper.getInstance().dumpModelData();
    }

    public static String getReport() {
        String strReport = SoftwarePersistenceMapper.getInstance().getReport()
                + HardwarePersistenceMapper.getInstance().getReport();
        return strReport;
    }

    //Add Listeners to SPM and HOM Observables
    public static void addListenersToSPMHPM(MyObserver obs){
        HardwarePersistenceMapper.getInstance().attach(obs);
        SoftwarePersistenceMapper.getInstance().attach(obs);
    }

    //Get update of total tickets for display on listener's label
    public static long getTotalTicketsCount(){
        long ttc = HardwarePersistenceMapper.getInstance().getTicketCount() +
                SoftwarePersistenceMapper.getInstance().getTicketCount();
        return ttc;
    }
}
