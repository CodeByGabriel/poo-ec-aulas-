package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.PatientRecord;
import model.PatientRecordDAO;

public class PatientRecordController {
    @FXML
    private TableView<PatientRecord> tableView;
    @FXML
    private TableColumn<PatientRecord, Integer> idColumn;
    @FXML
    private TableColumn<PatientRecord, String> matriculaColumn;
    @FXML
    private TableColumn<PatientRecord, String> nomeCompletoColumn;
    @FXML
    private TableColumn<PatientRecord, String> tipoSanguineoColumn;
    @FXML
    private TextField idField;
    @FXML
    private TextField matriculaField;
    @FXML
    private TextField nomeCompletoField;
    @FXML
    private TextField tipoSanguineoField;
    @FXML
    private Button addButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button saveButton;

    private ObservableList<PatientRecord> patientRecords;
    private PatientRecordDAO patientRecordDAO;

    public void initialize() {
        patientRecordDAO = new PatientRecordDAO();
        patientRecords = FXCollections.observableArrayList(patientRecordDAO.getAllRecords());

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        matriculaColumn.setCellValueFactory(new PropertyValueFactory<>("matricula"));
        nomeCompletoColumn.setCellValueFactory(new PropertyValueFactory<>("nomeCompleto"));
        tipoSanguineoColumn.setCellValueFactory(new PropertyValueFactory<>("tipoSanguineo"));

        tableView.setItems(patientRecords);

        addButton.setOnAction(event -> addRecord());
        updateButton.setOnAction(event -> updateRecord());
        deleteButton.setOnAction(event -> deleteRecord());
        cancelButton.setOnAction(event -> cancelEdit());
        saveButton.setOnAction(event -> saveRecord());
    }

    private void addRecord() {
        String matricula = matriculaField.getText();
        String nomeCompleto = nomeCompletoField.getText();
        String tipoSanguineo = tipoSanguineoField.getText();

        PatientRecord newRecord = new PatientRecord(0, matricula, nomeCompleto, tipoSanguineo);
        patientRecordDAO.addRecord(newRecord);
        patientRecords.add(newRecord);

        clearFields();
    }

    private void updateRecord() {
        // Implementar a lógica de atualização de registro
    }

    private void deleteRecord() {
        // Implementar a lógica de deleção de registro
    }

    private void cancelEdit() {
        clearFields();
    }

    private void saveRecord() {
        // Implementar a lógica de salvar registro
    }

    private void clearFields() {
        idField.clear();
        matriculaField.clear();
        nomeCompletoField.clear();
        tipoSanguineoField.clear();
    }
}
