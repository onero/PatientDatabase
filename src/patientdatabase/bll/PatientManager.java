/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientdatabase.bll;

import java.util.List;
import patientdatabase.be.Patient;
import patientdatabase.dal.PatientDAO;

public class PatientManager {

    private static PatientManager instance;

    public static PatientManager getInstance() {
        if (instance == null) {
            instance = new PatientManager();
        }
        return instance;
    }

    private PatientManager() {

    }

    /**
     * Gets the list of Patients
     *
     * @return
     */
    public List<Patient> getPatients() {
        return PatientDAO.getInstance().getAllPatientsFromFILE();
    }

}
