package PRAKTIKUM6;

import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;

public class TabelMahasiswaController {
	@FXML
    private TableView<Mahasiswa> tblMahasiswa;

    @FXML
    private TableColumn<Mahasiswa, String> kolomNama;

    @FXML
    private TableColumn<Mahasiswa, String> kolomNim;
    
    private ObservableList<Mahasiswa> data;
    
    public void initialize() {
        kolomNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        kolomNim.setCellValueFactory(new PropertyValueFactory<>("nim"));
        
        
        
        data = FXCollections.observableArrayList(
            new Mahasiswa(1, "John", "123"),
            new Mahasiswa(2, "Jane", "123"),
            new Mahasiswa(3, "Jono", "124123"),
            new Mahasiswa(4, "Agus", "1241234"),
            new Mahasiswa(5, "Johan", "125124"),
            new Mahasiswa(6, "Lawliet", "1233443"),
            new Mahasiswa(7, "Galih", "121213"),
            new Mahasiswa(8, "Aji", "1231231"),
            new Mahasiswa(9, "Goku", "999999"),
            new Mahasiswa(10, "Standford", "1281233")
        );

       
        tblMahasiswa.setItems(data);
    }
}