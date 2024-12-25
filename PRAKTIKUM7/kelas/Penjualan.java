package PRAKTIKUM7.kelas;

import java.util.Date;
import javafx.beans.property.*;

public class Penjualan {
	private SimpleIntegerProperty penjualanId;
	private SimpleIntegerProperty pelangganId;
	private SimpleIntegerProperty bukuId;
	private SimpleIntegerProperty jumlah;
	private SimpleDoubleProperty totalHarga;
	private Date tanggal;
	
	public Penjualan(Integer penjualanId, Integer pelangganId, Integer bukuId, Integer jumlah, Double totalHarga, Date tanggal) {
		this.penjualanId = new SimpleIntegerProperty(penjualanId == null ? 0 : penjualanId);
		this.pelangganId = new SimpleIntegerProperty(pelangganId == null ? 0 : pelangganId);
		this.bukuId = new SimpleIntegerProperty(bukuId == null ? 0 : bukuId);
		this.jumlah = new SimpleIntegerProperty(jumlah);
		this.totalHarga = new SimpleDoubleProperty(totalHarga);
		this.tanggal = tanggal;
	}
	
	public Integer getPenjualanId() {
		return penjualanId.get();
	}
	
	public void setPenjualanId(Integer penjualanId) {
		this.penjualanId.set(penjualanId);
	}
	
	public SimpleIntegerProperty penjualanIdProperty() {
		return penjualanId;
	}
	
	public Integer getPelangganId() {
		return pelangganId.get();
	}
	
	public void setPelangganId(Integer pelangganId) {
		this.pelangganId.set(pelangganId);
	}
	
	public SimpleIntegerProperty pelangganIdProperty() {
		return pelangganId;
	}
	
	public Integer getBukuId() {
		return bukuId.get();
	}
	
	public void setBukuId(Integer bukuId) {
		this.bukuId.set(bukuId);
	}
	
	public SimpleIntegerProperty bukuIdProperty() {
		return bukuId;
	}
	
	public Integer getJumlahBuku() {
		return jumlah.get();
	}
	
	public void setJumlahBuku(Integer jumlah) {
		this.jumlah.set(jumlah);
	}
	
	public SimpleIntegerProperty jumlahBukuProperty() {
		return jumlah;
	}
	
	public Double getTotalHarga() {
		return totalHarga.get();
	}
	
	public void setTotalHarga(Double totalHarga) {
		this.totalHarga.set(totalHarga);
	}
	
	public SimpleDoubleProperty totalHargaProperty() {
		return totalHarga;
	}
	
	public Date getTanggal() {
		return tanggal;
	}
	
	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}
}
