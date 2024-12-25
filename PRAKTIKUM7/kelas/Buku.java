package PRAKTIKUM7.kelas;

import javafx.beans.property.*;

public class Buku {
	private IntegerProperty bukuId;
	private StringProperty judul;
    private StringProperty penulis;
    private DoubleProperty harga;
    private IntegerProperty stok;
    
    public Buku(Integer id, String judul, String penulis, Double harga, Integer stok) {
    	this.bukuId = new SimpleIntegerProperty(id == null ? 0 : id);
    	this.judul = new SimpleStringProperty(judul);
    	this.penulis = new SimpleStringProperty(penulis);
    	this.harga = new SimpleDoubleProperty(harga);
    	this.stok = new SimpleIntegerProperty(stok);
    }
    
    public Integer getBukuId() {
        return bukuId.get();
    }

    public void setBukuId(Integer id) {
        this.bukuId.set(id);
    }

    public IntegerProperty bukuIdProperty() {
        return bukuId;
    }
    
    public String getJudul() {
        return judul.get();
    }

    public void setJudul(String judul) {
        this.judul.set(judul);
    }

    public StringProperty judulProperty() {
        return judul;
    }
    
    public String getPenulis() {
        return penulis.get();
    }

    public void setPenulis(String penulis) {
        this.penulis.set(penulis);
    }

    public StringProperty PenulisProperty() {
        return penulis;
    }
    
    public Double getHarga() {
        return harga.get();
    }

    public void setHarga(Double harga) {
        this.harga.set(harga);
    }

    public DoubleProperty hargaProperty() {
        return harga;
    }
    
    public Integer getStok() {
        return stok.get();
    }

    public void setStok(Integer stok) {
        this.stok.set(stok);
    }

    public IntegerProperty stokProperty() {
        return stok;
    }
}