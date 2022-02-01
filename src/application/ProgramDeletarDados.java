package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntegrityException;

//Para esse programa, foi criado a 


public class ProgramDeletarDados {
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
				"DELETE FROM department "
				+ "WHERE "
				+ "iD = ?");
			
			st.setInt(1, 6);
					
					
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done! Rows affected " + rowsAffected);
		}
		catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}

	}

}
