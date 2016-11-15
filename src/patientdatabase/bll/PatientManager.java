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

    private final PatientDAO patientDAO = PatientDAO.getInstance();

    /**
     * Gets the list of Patients
     *
     * @return
     */
    public List<Patient> getPatients() {
        return patientDAO.getAllPatientsFromFILE();
    }

}
