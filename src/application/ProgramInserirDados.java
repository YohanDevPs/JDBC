package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;



//Programa para INSERIR DADOS!!!
public class ProgramInserirDados {

	public static void main(String[] args) {
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
//			
//			st = conn.prepareStatement(
//					"INSERT INTO seller "
//					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
//					+ "VALUES "
//					+ "(?, ?, ?, ?, ?)",
//					Statement.RETURN_GENERATED_KEYS);
//			
//			st.setString(1,  "Carl Purple");
//			st.setString(2,  "carl@gmail.com");
//			st.setDate(3, new java.sql.Date(sdf.parse("22/04/1994").getTime()));
//			st.setDouble(4,  3000.0);
//			st.setInt(5, 4);
//			
				
			//Codigo para mudar inserir valores na tabela departamento
			st = conn.prepareStatement(
					"insert into department (Name) values ('D1'),('D2')",
					Statement.RETURN_GENERATED_KEYS);
			
			//O resultado � um numero inteiro que representa quantas linhas foram alteradas
			int rowsAffected = st.executeUpdate();
			
			
			//Para pegar o ID 
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();	
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! ID = "+ id);
				}
			}
			else {
				System.out.println("No rown affected! ");
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
			
		}
	}
}
