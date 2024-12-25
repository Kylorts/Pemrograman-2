package PRAKTIKUM7.database;

import java.sql.*;
import java.util.*;
import PRAKTIKUM7.kelas.Pelanggan;

public class PelangganDAO {
	 public boolean addPelanggan(Pelanggan pelanggan) {
		 String query = "INSERT INTO pelanggan (nama, email, telepon) VALUES (?, ?, ?)";
		 try (Connection conn = DatabaseConnection.getConnection();
				 PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
			 statement.setString(1, pelanggan.getNama());
			 statement.setString(2, pelanggan.getEmail());
	         statement.setString(3, pelanggan.getTelepon());
	         
	         Integer rowAffected = statement.executeUpdate();
	         if(rowAffected > 0) {
	        	 try(ResultSet generatedKeys = statement.getGeneratedKeys()){
	        		 if(generatedKeys.next()) {
	        			 Integer generateId = generatedKeys.getInt(1);
	        			 pelanggan.setPelangganId(generateId);
	        		 }
	        	 }
	        	 return true;
	         }
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return false;
	 }
	 
	 public List<Pelanggan> getAllPelanggan(){
		 List<Pelanggan> pelangganList = new ArrayList<>();
		 String query = "SELECT * FROM pelanggan";
		 try (Connection conn = DatabaseConnection.getConnection();
				 Statement statement = conn.createStatement();
				 ResultSet resultSet = statement.executeQuery(query)){
			 
			 while (resultSet.next()) {
				 Pelanggan pelanggan = new Pelanggan (
						 resultSet.getInt("pelanggan_id"),
						 resultSet.getString("nama"),
						 resultSet.getString("email"),
						 resultSet.getString("telepon")
						 );
				 pelangganList.add(pelanggan);
			 }
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return pelangganList;
	 }
	 
	 public static void updatePelanggan(Pelanggan pelanggan) throws Exception {
		    try (
		        Connection conn = DatabaseConnection.getConnection();
		        PreparedStatement stmt = conn.prepareStatement(
		        "UPDATE PELANGGAN SET NAMA = ?, EMAIL = ?, TELEPON = ? WHERE PELANGGAN_ID = ?"
		        )){

		        stmt.setString(1, pelanggan.getNama());
		        stmt.setString(2, pelanggan.getEmail());
		        stmt.setString(3, pelanggan.getTelepon());
		        stmt.setInt(4, pelanggan.getPelangganId());

		        stmt.executeUpdate();
		    } 
		    catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
	 
	 public static void deletePelanggan(Pelanggan pelanggan) {
	        try (
	            Connection conn = DatabaseConnection.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(
	            "DELETE FROM PELANGGAN WHERE PELANGGAN_ID = ?"
	            )){

	            stmt.setInt(1,pelanggan.getPelangganId());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    
	 }
}