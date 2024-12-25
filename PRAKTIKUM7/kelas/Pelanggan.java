package PRAKTIKUM7.kelas;

import javafx.beans.property.*;

public class Pelanggan {
	private IntegerProperty pelangganId;
	private StringProperty nama;
    private StringProperty email;
    private StringProperty telepon;
    
    public Pelanggan(Integer id, String nama, String email, String telepon) {
        this.pelangganId = new SimpleIntegerProperty(id == null ? 0 : id);
        this.nama = new SimpleStringProperty(nama);
        this.email = new SimpleStringProperty(email);
        this.telepon = new SimpleStringProperty(telepon);
    }
    
    
    public Integer getPelangganId() {
        return pelangganId.get();
    }

    public void setPelangganId(Integer id) {
        this.pelangganId.set(id);
    }

    public IntegerProperty pelangganIdProperty() {
        return pelangganId;
    }

    public String getNama() {
        return nama.get();
    }

    public void setNama(String nama) {
        this.nama.set(nama);
    }

    public StringProperty namaProperty() {
        return nama;
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public StringProperty emailProperty() {
        return email;
    }
    
    public String getTelepon() {
        return telepon.get();
    }

    public void setTelepon(String telepon) {
        this.telepon.set(telepon);
    }

    public StringProperty teleponProperty() {
        return telepon;
    }
}