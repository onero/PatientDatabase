/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientdatabase.dal;

public class PatientDAO {

    //Create singleton!
    private static PatientDAO instance = null;

    public static PatientDAO getInstance() {
        if (instance == null) {
            instance = new PatientDAO();
        }
        return instance;
    }

    private PatientDAO() {

    }

}
