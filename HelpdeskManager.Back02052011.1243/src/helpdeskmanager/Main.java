/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package helpdeskmanager;

import persistence.HardwarePersistenceMapper;
import persistence.PersistenceFactory;

/**
 *
 * @author popoola
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main mainMan = new Main();
        mainMan.testHPM();
    }

    public void testHPM(){
        HardwarePersistenceMapper HPM = PersistenceFactory.getInstance().getHardwarePersistenceMapper();
        HPM.materializeTickets();
        HPM.dumpModelData();
    }

}
