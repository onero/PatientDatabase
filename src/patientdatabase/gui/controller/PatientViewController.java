/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientdatabase.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import patientdatabase.be.Patient;

/**
 * FXML Controller class
 *
 * @author gta1
 */
public class PatientViewController implements Initializable {

    @FXML
    private Label lblID;
    @FXML
    private Label lblName;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblDiagnosis;

    private Patient currentPatient;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setPatient(Patient patient) {
        currentPatient = patient;
        fillLabels();
    }

    private void fillLabels() {
        lblID.setText(currentPatient.getId() + "");
        lblName.setText(currentPatient.getName());
        lblEmail.setText(currentPatient.getEmail());
        lblDiagnosis.setText(currentPatient.getDiagnosis());
    }

}
