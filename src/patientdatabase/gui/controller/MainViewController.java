/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientdatabase.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import patientdatabase.be.Patient;
import patientdatabase.dal.PatientDAO;

/**
 *
 * @author gta1
 */
public class MainViewController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TableView<Patient> tablePatients;
    @FXML
    private TableColumn<Patient, String> clmName;
    @FXML
    private TableColumn<Patient, String> clmEmail;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        readDataIntoList();
    }

    private void readDataIntoList() {
        ObservableList<Patient> patientList
                = FXCollections.observableArrayList(
                        new Patient(0, "Adam Hansen", "alh@easv.dk", "Happiness"),
                        new Patient(1, "Jeppe Nielsen", "jlp@easv.dk", "Full retardo")
                );
        clmName.setCellValueFactory(new PropertyValueFactory<>("name"));
        clmEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tablePatients.setItems(patientList);
        PatientDAO patientDAO = PatientDAO.getInstance();
    }

}
