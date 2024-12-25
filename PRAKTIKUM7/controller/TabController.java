package PRAKTIKUM7.controller;

import java.time.LocalDate;
import java.util.*;
import java.sql.Date;
import PRAKTIKUM7.database.BukuDAO;
import PRAKTIKUM7.database.PelangganDAO;
import PRAKTIKUM7.database.PenjualanDAO;
import PRAKTIKUM7.kelas.*;
import javafx.beans.property.*;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TabController {
	//bagian tab Pelanggan
	@FXML private TableView<Pelanggan> tblPelanggan;
    @FXML private TableColumn<Pelanggan, String> kolomNamaPelanggan, kolomEmailPelanggan, kolomTeleponPelanggan; 
    @FXML private TextField txtNamaPelanggan, txtEmailPelanggan, txtTeleponPelanggan;
    
    //bagian tab Buku
    @FXML private TableView<Buku> tblBuku;
    @FXML private TableColumn<Buku, String> kolomJudulBuku, kolomPenulisBuku; 
    @FXML private TableColumn<Buku, Double> kolomHargaBuku;
    @FXML private TableColumn<Buku, Integer> kolomStokBuku;
    @FXML private TextField txtJudulBuku, txtPenulisBuku, txtHargaBuku, txtStokBuku;
    
    //bagian tab Penjualaan
    @FXML private TableView<Penjualan> tblPenjualan;
    @FXML private TableColumn<Penjualan, String> kolomPelangganPenjualan, kolomBuku;
    @FXML private TableColumn<Penjualan, Date> kolomTanggalPenjualan;
    @FXML private TableColumn<Penjualan, Double> kolomTotalHarga;
    @FXML private TableColumn<Penjualan, Integer> kolomJumlah;
    @FXML private ComboBox<String> cmbBuku, cmbPelanggan;
    @FXML private TextField txtJumlahBuku;
    @FXML private DatePicker dtpPenjualan;
    
    
    private PelangganDAO pelangganDAO;
    private BukuDAO bukuDAO;
    private PenjualanDAO penjualanDAO;
    
    private ObservableList<Pelanggan> pelangganList;
    private ObservableList<Buku> bukuList;
    private ObservableList<Penjualan> penjualanList;
    
    private HashMap<Integer, String> pelangganIdToNameMap;
    private HashMap<Integer, String> bukuIdToTitleMap;
    
    public void initialize() {
    	pelangganIdToNameMap = new HashMap<>();
    	bukuIdToTitleMap = new HashMap<>();
    	
    	pelangganDAO = new PelangganDAO();
        pelangganList = FXCollections.observableArrayList();
        
        bukuDAO = new  BukuDAO();
        bukuList = FXCollections.observableArrayList();
        
        penjualanDAO = new PenjualanDAO();
        penjualanList = FXCollections.observableArrayList();
        
        // Setup kolom Tabel Pelanggan
        kolomNamaPelanggan.setCellValueFactory(cellData -> cellData.getValue().namaProperty());
        kolomEmailPelanggan.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        kolomTeleponPelanggan.setCellValueFactory(cellData -> cellData.getValue().teleponProperty());
        
        //setup kolom Tabel Buku
        kolomJudulBuku.setCellValueFactory(cellData -> cellData.getValue().judulProperty());
        kolomPenulisBuku.setCellValueFactory(cellData -> cellData.getValue().PenulisProperty());
        kolomHargaBuku.setCellValueFactory(cellData -> cellData.getValue().hargaProperty().asObject());
        kolomStokBuku.setCellValueFactory(cellData -> cellData.getValue().stokProperty().asObject());
        
        //setup kolom Tabel Penjualan
        kolomPelangganPenjualan.setCellValueFactory(cellData -> {
            Integer pelangganId = cellData.getValue().getPelangganId();
            String pelangganName = pelangganIdToNameMap.getOrDefault(pelangganId, "Tidak Diketahui");
            return new SimpleStringProperty(pelangganName);
        });

        kolomBuku.setCellValueFactory(cellData -> {
            Integer bukuId = cellData.getValue().getBukuId();
            String bukuTitle = bukuIdToTitleMap.getOrDefault(bukuId, "Tidak Diketahui");
            return new SimpleStringProperty(bukuTitle);
        });
        kolomTotalHarga.setCellValueFactory(cellData -> cellData.getValue().totalHargaProperty().asObject());
        kolomJumlah.setCellValueFactory(cellData -> cellData.getValue().jumlahBukuProperty().asObject());
        kolomTanggalPenjualan.setCellValueFactory(cellData -> {
            Date tanggal = (Date) cellData.getValue().getTanggal();
            return new SimpleObjectProperty<>(tanggal);
        });
        
        loadPelangganData();
        loadBukuData();
        loadPenjualanData();
        
        for (Pelanggan pelanggan : pelangganList) {
            pelangganIdToNameMap.put(pelanggan.getPelangganId(), pelanggan.getNama());
        }

        for (Buku buku : bukuList) {
            bukuIdToTitleMap.put(buku.getBukuId(), buku.getJudul());
        }

        cmbPelanggan.getItems().addAll(pelangganIdToNameMap.values());
        cmbBuku.getItems().addAll(bukuIdToTitleMap.values());
        
        tblPelanggan.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txtNamaPelanggan.setText(newValue.getNama());
                txtEmailPelanggan.setText(newValue.getEmail());
                txtTeleponPelanggan.setText(newValue.getTelepon());
            }
        });
        
        tblBuku.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txtJudulBuku.setText(newValue.getJudul());
                txtPenulisBuku.setText(newValue.getPenulis());
                txtHargaBuku.setText(String.valueOf(newValue.getHarga()));
                txtStokBuku.setText(String.valueOf(newValue.getStok()));
            }
        });
        
        tblPenjualan.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                Integer pelangganId = newValue.getPelangganId();
                Integer bukuId = newValue.getBukuId();
                Integer jumlah = newValue.getJumlahBuku();

                Pelanggan pelanggan = pelangganList.stream()
                        .filter(p -> p.getPelangganId().equals(pelangganId))
                        .findFirst()
                        .orElse(null);

                Buku buku = bukuList.stream()
                        .filter(b -> b.getBukuId().equals(bukuId))
                        .findFirst()
                        .orElse(null);

                if (pelanggan != null) {
                    cmbPelanggan.setValue(pelanggan.getNama());
                }

                if (buku != null) {
                    cmbBuku.setValue(buku.getJudul());
                }

                txtJumlahBuku.setText(String.valueOf(jumlah));

            }
        });
    }
    
    //bagian load data dari database
    private void loadPelangganData() {
        pelangganList.setAll(pelangganDAO.getAllPelanggan());
        tblPelanggan.setItems(pelangganList);
    }
    
    private void loadBukuData() {
    	bukuList.setAll(bukuDAO.getAllBuku());
    	tblBuku.setItems(bukuList);
    }
    
    private void loadPenjualanData() {
        penjualanList.setAll(penjualanDAO.getAllPenjualan());
        tblPenjualan.setItems(FXCollections.observableArrayList(penjualanList));
    }
    
    //bagian tab pelanggan
    @FXML
    public void addPelanggan() {
        String nama = txtNamaPelanggan.getText();
        String email = txtEmailPelanggan.getText();
        String telepon = txtTeleponPelanggan.getText();

        if (nama.isEmpty() || email.isEmpty() || telepon.isEmpty()) {
            showAlert("ERROR", "Input Error", "", "Semua field harus diisi!");
            return;
        }

        
        Pelanggan pelanggan = new Pelanggan(null, nama, email, telepon);
        boolean isAdded = pelangganDAO.addPelanggan(pelanggan);
        pelangganIdToNameMap.put(pelanggan.getPelangganId(), pelanggan.getNama());
        if (isAdded) {
            loadPelangganData();
            repopulateComboBoxPelanggan();
            showAlert("INFORMATION", "Success", "",  "Pelanggan berhasil ditambahkan!");
        } else {
            showAlert("ERROR", "Error", "", "Gagal menambahkan pelanggan!");
        }
    }
    
    @FXML
    public void editPelanggan() {
    	Pelanggan selectedPelanggan = tblPelanggan.getSelectionModel().getSelectedItem();
    	
		if (selectedPelanggan != null) {
			String nama = txtNamaPelanggan.getText();
			String email = txtEmailPelanggan.getText();
			String noTelepon = txtTeleponPelanggan.getText();
			
			if (nama.isEmpty() || email.isEmpty() || noTelepon.isEmpty()) {
				showAlert("ERROR", "Kesalahan Input", "", "Data yang dimasukkan belum lengkap!");
				return;
			}
			
			try {
				selectedPelanggan.setNama(nama);
				selectedPelanggan.setEmail(email);
				selectedPelanggan.setTelepon(noTelepon);

				PelangganDAO.updatePelanggan(selectedPelanggan);
				loadPelangganData();
				repopulateComboBoxPelanggan();
			} 
			catch (Exception e) {
				e.printStackTrace();
				showAlert("ERROR", "Database Eror", "", "Gagal mengubah data pelanggan.");
			}
		}
		
    }
    
    @FXML
    private void hapusPelanggan() {
		Pelanggan selectedPelanggan = tblPelanggan.getSelectionModel().getSelectedItem();
	
		if (selectedPelanggan != null) {
			Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
			confirmationAlert.setTitle("Konfirmasi Penghapusan Pelanggan");
			confirmationAlert.setHeaderText("Apakah Anda yakin untuk menghapus pelanggan ini?");
			confirmationAlert.setContentText("Tindakan ini tidak dapat dibatalkan.");

			Optional<ButtonType> result = confirmationAlert.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.OK) {
				try {
					pelangganIdToNameMap.remove(selectedPelanggan.getPelangganId(), selectedPelanggan.getNama());
					PelangganDAO.deletePelanggan(selectedPelanggan); 
					loadPelangganData();
					repopulateComboBoxPelanggan();
				} 
				catch (Exception e) {
					e.printStackTrace();
					showAlert("ERROR", "Database Eror", "", "Gagal menghapus pelanggan.");
				}
			}
		} else {
			showAlert("ERROR", "Tidak ada pelanggan terpilih", "", "Silahkan pilih pelanggan yang ingin dihapus!");
		}
	}
    
    //bagian tab Buku
    @FXML
    public void addBuku() {
        String judul = txtJudulBuku.getText();
        String penulis = txtPenulisBuku.getText();
        String harga = txtHargaBuku.getText();
        String stok = txtStokBuku.getText();

        if (judul.isEmpty() || penulis.isEmpty() || harga.isEmpty() || stok.isEmpty()) {
            showAlert("ERROR", "Input Error", "", "Semua field harus diisi!");
            return;
        }

        try {
            Double hargaBuku = Double.parseDouble(harga);
            Integer stokBuku = Integer.parseInt(stok);
            if (hargaBuku < 0 || stokBuku <= 0) {
                showAlert("ERROR", "Input Error", "", "Stok tidak boleh nol, stok dan harga buku tidak boleh negatif!");
                return;
            }

            Buku buku = new Buku(null, judul, penulis, hargaBuku, stokBuku);
            boolean isAdded = BukuDAO.addBuku(buku);
            if (isAdded) {
                loadBukuData();
                repopulateComboBoxBuku();
                showAlert("INFORMATION", "Success", "", "Buku berhasil ditambahkan!");
            } else {
                showAlert("ERROR", "Error", "", "Gagal menambahkan buku!");
            }
        } catch (NumberFormatException e) {
            showAlert("ERROR", "Input Error", "", "Harga harus berupa angka yang valid!");
        }
    }
    
    public void editBuku() {
    	Buku selectedBuku = tblBuku.getSelectionModel().getSelectedItem();
    	
		if (selectedBuku != null) {
			String judul = txtJudulBuku.getText();
			String penulis = txtPenulisBuku.getText();
			String harga = txtHargaBuku.getText();
			String stok = txtStokBuku.getText();
			
			if (judul.isEmpty() || penulis.isEmpty() || harga.isEmpty() || stok.isEmpty()) {
				showAlert("ERROR", "Kesalahan Input", "", "Data yang dimasukkan belum lengkap!");
				return;
			}
			
			try {
				Integer stokBuku = Integer.parseInt(stok);
				Double hargaBuku = Double.parseDouble(harga); 
				
				if (hargaBuku < 0 || stokBuku <= 0) {
	                showAlert("ERROR", "Input Error", "", "Stok tidak boleh nol, stok dan harga buku tidak boleh negatif!");
	                return;
	            }
				
				selectedBuku.setJudul(judul);
				selectedBuku.setPenulis(penulis);
				selectedBuku.setHarga(hargaBuku);
				selectedBuku.setStok(stokBuku);

				BukuDAO.updateBuku(selectedBuku);
				loadBukuData();
				repopulateComboBoxBuku();
			} 
			catch (Exception e) {
				e.printStackTrace();
				showAlert("ERROR", "Database Eror", "", "Gagal mengubah data buku.");
			}
		}
		
    }
    
    @FXML
    private void hapusBuku() {
		Buku selectedBuku = tblBuku.getSelectionModel().getSelectedItem();
	
		if (selectedBuku != null) {
			Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
			confirmationAlert.setTitle("Konfirmasi Penghapusan Pelanggan");
			confirmationAlert.setHeaderText("Apakah Anda yakin untuk menghapus buku ini?");
			confirmationAlert.setContentText("Tindakan ini tidak dapat dibatalkan.");

			Optional<ButtonType> result = confirmationAlert.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.OK) {
				try {
					bukuIdToTitleMap.remove(selectedBuku.getBukuId(), selectedBuku.getJudul());
					BukuDAO.deleteBuku(selectedBuku); 
					loadBukuData();
					repopulateComboBoxBuku();
				} 
				catch (Exception e) {
					e.printStackTrace();
					showAlert("ERROR", "Database Eror", "", "Gagal menghapus p.");
				}
			}
		} else {
			showAlert("ERROR", "Tidak ada buku terpilih", "", "Silahkan pilih buku yang ingin dihapus!");
		}
	}
    
    //bagian tab Penjualan
    private Integer getPelangganIdByName(String nama) {
        for (Pelanggan pelanggan : pelangganList) {
            if (pelanggan.getNama().equals(nama)) {
                return pelanggan.getPelangganId();
            }
        }
        return null; 
    }

    private Integer getBukuIdByTitle(String judul) {
        for (Buku buku : bukuList) {
            if (buku.getJudul().equals(judul)) {
                return buku.getBukuId();
            }
        }
        return null;
    }
    
    @FXML
    public void addPenjualan() {
        String pelangganName = cmbPelanggan.getSelectionModel().getSelectedItem();
        String bukuTitle = cmbBuku.getSelectionModel().getSelectedItem();
        String jumlahText = txtJumlahBuku.getText();
        LocalDate tanggalPick = dtpPenjualan.getValue();

        if (pelangganName == null || bukuTitle == null || jumlahText.isEmpty() || tanggalPick == null) {
            showAlert("ERROR", "Input Error", "", "Semua field harus diisi!");
            return;
        }

        try {
            Integer jumlah = Integer.parseInt(jumlahText);
            if (jumlah <= 0) {
                showAlert("ERROR", "Input Error", "", "Jumlah harus lebih dari nol!");
                return;
            }

            Integer pelangganId = getPelangganIdByName(pelangganName);
            Integer bukuId = getBukuIdByTitle(bukuTitle);
            Buku selectedBuku = bukuList.stream().filter(b -> b.getBukuId().equals(bukuId)).findFirst().orElse(null);

            if (pelangganId == null || bukuId == null || selectedBuku == null) {
                showAlert("ERROR", "Input Error", "", "Data pelanggan atau buku tidak valid!");
                return;
            }

            if (selectedBuku.getStok() < jumlah) {
                showAlert("ERROR", "Stok Tidak Cukup", "", "Stok buku tidak cukup untuk penjualan atau stok buku telah habis!");
                return;
            }

            selectedBuku.setStok(selectedBuku.getStok() - jumlah);
            BukuDAO.updateBuku(selectedBuku);  

            Double totalHarga = selectedBuku.getHarga() * jumlah;

            Penjualan penjualan = new Penjualan(null, pelangganId, bukuId, jumlah, totalHarga, java.sql.Date.valueOf(tanggalPick));
            boolean isAdded = PenjualanDAO.addPenjualan(penjualan);

            if (isAdded) {
                showAlert("INFORMATION", "Success", "", "Penjualan berhasil ditambahkan!");
                loadPenjualanData();
            } else {
                showAlert("ERROR", "Error", "", "Gagal menambahkan penjualan!");
            }
        } catch (NumberFormatException e) {
            showAlert("ERROR", "Input Error", "", "Jumlah harus berupa angka yang valid!");
        }
    }
    
    @FXML
    public void editPenjualan() {
        Penjualan selectedPenjualan = tblPenjualan.getSelectionModel().getSelectedItem();
        
        if (selectedPenjualan != null) {
            String pelangganName = cmbPelanggan.getSelectionModel().getSelectedItem();
            String bukuTitle = cmbBuku.getSelectionModel().getSelectedItem();
            String jumlahText = txtJumlahBuku.getText();
            LocalDate tanggalPick = dtpPenjualan.getValue();

            if (pelangganName == null || bukuTitle == null || jumlahText.isEmpty() || tanggalPick == null) {
                showAlert("ERROR", "Input Error", "", "Semua field harus diisi!");
                return;
            }

            try {
                Integer jumlah = Integer.parseInt(jumlahText);
                if (jumlah <= 0) {
                    showAlert("ERROR", "Input Error", "", "Jumlah harus lebih dari nol!");
                    return;
                }

                Integer pelangganId = getPelangganIdByName(pelangganName);
                Integer bukuId = getBukuIdByTitle(bukuTitle);
                Buku selectedBuku = bukuList.stream().filter(b -> b.getBukuId().equals(bukuId)).findFirst().orElse(null);

                if (pelangganId == null || bukuId == null || selectedBuku == null) {
                    showAlert("ERROR", "Input Error", "", "Data pelanggan atau buku tidak valid!");
                    return;
                }

                Double totalHarga = selectedBuku.getHarga() * jumlah;
                Integer previousJumlah = selectedPenjualan.getJumlahBuku();  
                Integer diffJumlah = jumlah - previousJumlah;
                Date sqlDate = Date.valueOf(tanggalPick);



                if (diffJumlah > 0) {
                    if (selectedBuku.getStok() < diffJumlah) {
                        showAlert("ERROR", "Stok Tidak Cukup", "", "Stok buku tidak mencukupi untuk transaksi ini.");
                        return;
                    }
                    selectedBuku.setStok(selectedBuku.getStok() - diffJumlah); 
                } else if (diffJumlah < 0) {
                    selectedBuku.setStok(selectedBuku.getStok() + (-diffJumlah)); 
                }


                BukuDAO.updateBuku(selectedBuku);

                selectedPenjualan.setJumlahBuku(jumlah);
                selectedPenjualan.setTotalHarga(totalHarga);
                selectedPenjualan.setBukuId(bukuId);  
                selectedPenjualan.setPelangganId(pelangganId);
                selectedPenjualan.setTanggal(sqlDate);  

                boolean isUpdated = PenjualanDAO.updatePenjualan(selectedPenjualan);

                if (isUpdated) {
                    showAlert("INFORMATION", "Success", "", "Penjualan berhasil diperbarui!");
                    loadPenjualanData();
                } else {
                    showAlert("ERROR", "Error", "", "Gagal memperbarui penjualan!");
                }
            } catch (NumberFormatException e) {
                showAlert("ERROR", "Input Error", "", "Jumlah harus berupa angka yang valid!");
            }
        }
    }
    
    @FXML
    private void hapusPenjualan() {
        Penjualan selectedPenjualan = tblPenjualan.getSelectionModel().getSelectedItem();

        if (selectedPenjualan != null) {
            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Konfirmasi Penghapusan Penjualan");
            confirmationAlert.setHeaderText("Apakah Anda yakin untuk menghapus penjualan ini?");
            confirmationAlert.setContentText("Tindakan ini tidak dapat dibatalkan.");

            Optional<ButtonType> result = confirmationAlert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                try {

                    Integer bukuId = selectedPenjualan.getBukuId();
                    Integer jumlah = selectedPenjualan.getJumlahBuku();
                    
                    Buku selectedBuku = bukuList.stream().filter(b -> b.getBukuId().equals(bukuId)).findFirst().orElse(null);

                    if (selectedBuku != null) {
                        selectedBuku.setStok(selectedBuku.getStok() + jumlah);
                        BukuDAO.updateBuku(selectedBuku);  
                    }


                    PenjualanDAO.deletePenjualan(selectedPenjualan);

                    loadPenjualanData();
                } catch (Exception e) {
                    e.printStackTrace();
                    showAlert("ERROR", "Database Error", "", "Gagal menghapus penjualan.");
                }
            }
        } else {
            showAlert("ERROR", "Tidak ada penjualan terpilih", "", "Silahkan pilih penjualan yang ingin dihapus!");
        }
    }
    
    private void repopulateComboBoxPelanggan() {
    	cmbPelanggan.getItems().clear();;
    	for (Pelanggan pelanggan : pelangganList) {
            pelangganIdToNameMap.put(pelanggan.getPelangganId(), pelanggan.getNama());
        }
    	cmbPelanggan.getItems().addAll(pelangganIdToNameMap.values());
    }
    
    private void repopulateComboBoxBuku() {
    	cmbBuku.getItems().clear();
    	for (Buku buku : bukuList) {
            bukuIdToTitleMap.put(buku.getBukuId(), buku.getJudul());
        }
    	cmbBuku.getItems().addAll(bukuIdToTitleMap.values());
    }
    
		
    private void showAlert(String type, String title, String header, String message){
    	Alert.AlertType alertType;

    	switch (type.toLowerCase()) {
    		case "information":
    			alertType = Alert.AlertType.INFORMATION;
    			break;
    		case "warning":
    			alertType = Alert.AlertType.WARNING;
    			break;
    		case "error":
    			alertType = Alert.AlertType.ERROR;
    			break;
    		case "confirmation":
    			alertType = Alert.AlertType.CONFIRMATION;
    			break;
    		default:
    			alertType = Alert.AlertType.NONE; 
    			break;
    	}

    	Alert alert = new Alert(alertType);
    	alert.setTitle(title);
    	alert.setHeaderText(header);
    	alert.setContentText(message);
    	alert.showAndWait();
    }
}