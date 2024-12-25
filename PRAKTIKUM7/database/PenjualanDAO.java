package PRAKTIKUM7.database;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import PRAKTIKUM7.kelas.Penjualan;

public class PenjualanDAO {
	public List<Penjualan> getAllPenjualan(){
		 List<Penjualan> penjualanList = new ArrayList<>();
		 String query = "SELECT * FROM penjualan";
		 try (Connection conn = DatabaseConnection.getConnection();
				 Statement statement = conn.createStatement();
				 ResultSet resultSet = statement.executeQuery(query)){
			 
			 while (resultSet.next()) {
				 Penjualan penjualan = new Penjualan (
						 resultSet.getInt("penjualan_id"),
						 resultSet.getInt("pelanggan_id"),
						 resultSet.getInt("buku_id"),
						 resultSet.getInt("jumlah"),
						 resultSet.getDouble("total_harga"),
						 resultSet.getDate("tanggal")
						 );
				 penjualanList.add(penjualan);
			 }
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		 return penjualanList;
	}
	

	
	public static boolean addPenjualan(Penjualan penjualan) {
		 String query = "INSERT INTO penjualan (pelanggan_id, buku_id, jumlah, total_harga, tanggal) VALUES (?, ?, ?, ?, ?)";
		 try (Connection conn = DatabaseConnection.getConnection();
				 PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
			 statement.setInt(1, penjualan.getPelangganId());
			 statement.setInt(2, penjualan.getBukuId());
			 statement.setInt(3, penjualan.getJumlahBuku());			 
	         statement.setDouble(4, penjualan.getTotalHarga());
	         statement.setDate(5, (Date) penjualan.getTanggal());
	         
	         Integer rowAffected = statement.executeUpdate();
	         if(rowAffected > 0) {
	        	 try(ResultSet generatedKeys = statement.getGeneratedKeys()){
	        		 if(generatedKeys.next()) {
	        			 Integer generateId = generatedKeys.getInt(1);
	        			 penjualan.setPenjualanId(generateId);
	        		 }
	        	 }
	        	 return true;
	         }
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return false;
	}
	
	public static boolean updatePenjualan(Penjualan penjualan) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                "UPDATE penjualan SET pelanggan_id = ?, buku_id = ?, jumlah = ?, total_harga = ?, tanggal = ? WHERE penjualan_id = ?")) {

            stmt.setInt(1, penjualan.getPelangganId());
            stmt.setInt(2, penjualan.getBukuId());
            stmt.setInt(3, penjualan.getJumlahBuku());
            stmt.setDouble(4, penjualan.getTotalHarga());
            stmt.setDate(5, (Date) penjualan.getTanggal());  
            stmt.setInt(6, penjualan.getPenjualanId());


            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;  

        } catch (SQLException e) {
            e.printStackTrace();  
            return false;  
        }
    }

	
	public static void deletePenjualan(Penjualan penjualan) {
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(
            "DELETE FROM penjualan WHERE penjualan_id = ?"
            )){

            stmt.setInt(1, penjualan.getPenjualanId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }

}
