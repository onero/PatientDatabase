/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientdatabase.dal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import patientdatabase.be.Patient;

public class PatientDAO {

    private static final String FILE = "src/patientdatabase/resource/Patients.csv";

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

    /**
     * Returns a List of allpatients from FILE
     *
     * @return
     */
    public List<Patient> getAllPatientsFromFILE() {
        List<Patient> patientList = new ArrayList();
        try (BufferedReader CSVFile = new BufferedReader(new FileReader(FILE))) {
            CSVFile.readLine(); //Skip first line header
            String line = CSVFile.readLine();
            while (line != null) {
                String[] dataArray = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
//                for (String string : dataArray) {
//                    System.out.println(string);
//                }
                patientList.add(new Patient(
                        Integer.parseInt(dataArray[0]),
                        dataArray[1],
                        dataArray[2],
                        dataArray[3]));
                line = CSVFile.readLine(); //Read next line
            }

        } catch (IOException ioe) {
            System.out.println("File not found" + ioe);
            return null;
        }
        return patientList;
    }

}
