package PRAKTIKUM7.database;

import java.sql.*;
import java.util.*;
import PRAKTIKUM7.kelas.Buku;

public class BukuDAO {
	public List<Buku> getAllBuku(){
		 List<Buku> bukuList = new ArrayList<>();
		 String query = "SELECT * FROM buku";
		 try (Connection conn = DatabaseConnection.getConnection();
				 Statement statement = conn.createStatement();
				 ResultSet resultSet = statement.executeQuery(query)){
			 
			 while (resultSet.next()) {
				 Buku buku = new Buku (
						 resultSet.getInt("buku_id"),
						 resultSet.getString("judul"),
						 resultSet.getString("penulis"),
						 resultSet.getDouble("harga"),
						 resultSet.getInt("stok")
						 );
				 bukuList.add(buku);
			 }
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		 return bukuList;
	}
	
	
	public static boolean addBuku(Buku buku) {
		 String query = "INSERT INTO buku (judul, penulis, harga, stok) VALUES (?, ?, ?, ?)";
		 try (Connection conn = DatabaseConnection.getConnection();
				 PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
			 statement.setString(1, buku.getJudul());
			 statement.setString(2, buku.getPenulis());
	         statement.setDouble(3, buku.getHarga());
	         statement.setInt(4, buku.getStok());
	         
	         Integer rowAffected = statement.executeUpdate();
	         if(rowAffected > 0) {
	        	 try(ResultSet generatedKeys = statement.getGeneratedKeys()){
	        		 if(generatedKeys.next()) {
	        			 Integer generateId = generatedKeys.getInt(1);
	        			 buku.setBukuId(generateId);;
	        		 }
	        	 }
	        	 return true;
	         }
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return false;
	}
	
	public static void updateBuku(Buku buku)  {
	    try (
	        Connection conn = DatabaseConnection.getConnection();
	        PreparedStatement stmt = conn.prepareStatement(
	        "UPDATE buku SET judul = ?, penulis = ?, harga = ?, stok = ? WHERE buku_id = ?"
	        )){

	        stmt.setString(1, buku.getJudul());
	        stmt.setString(2, buku.getPenulis());
	        stmt.setDouble(3, buku.getHarga());
	        stmt.setInt(4, buku.getStok());
	        stmt.setInt(5, buku.getBukuId());

	        stmt.executeUpdate();
	    } 
	    catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void deleteBuku(Buku buku) {
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(
            "DELETE FROM buku WHERE buku_id = ?"
            )){

            stmt.setInt(1, buku.getBukuId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }
}
