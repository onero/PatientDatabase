/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientdatabase.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import patientdatabase.be.Patient;
import patientdatabase.bll.PatientManager;

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

    private final PatientManager patientModel = PatientManager.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        readDataIntoList();
    }

    /**
     * Reads Patient data into the list
     */
    private void readDataIntoList() {
        ObservableList<Patient> patientList
                = FXCollections.observableArrayList(
                        patientModel.getPatients());

        clmName.setCellValueFactory(new PropertyValueFactory<>("name"));
        clmEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tablePatients.setItems(patientList);

    }

    /**
     * Loads the Patient stage
     *
     * @param patient
     * @throws IOException
     */
    private void loadPatientDataView(Patient patient) throws IOException {
        //Gets primary stage, gets loader and loads FXML document
        Stage primStage = (Stage) tablePatients.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/patientdatabase/gui/view/PatientView.fxml"));
        Parent root = loader.load();

        //Fetches controller and assigns patient with data
        PatientViewController patientViewController = loader.getController();
        patientViewController.setPatient(patient);

        //Sets new stage as modal
        Stage stagePatientView = new Stage();
        stagePatientView.setScene(new Scene(root));
        stagePatientView.initModality(Modality.WINDOW_MODAL);
        stagePatientView.initOwner(primStage);

        stagePatientView.show();
    }

    @FXML
    private void mousePressedOnTableView(MouseEvent event) throws IOException {
        //Check double-click left mouse button
        if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
            Patient selectedPatient = tablePatients.getSelectionModel().getSelectedItem();
            loadPatientDataView(selectedPatient);
        }
    }

}
