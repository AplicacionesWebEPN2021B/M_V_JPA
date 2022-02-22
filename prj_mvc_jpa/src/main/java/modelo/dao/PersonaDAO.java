package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.conexion.ConexionBDD;

public class PersonaDAO {
		//C
		private static final String SQL_SELECT_USUARIO_WHERE_PASSWORD="SELECT * FROM PERSONA WHERE usuario=? AND password=?";
		
		
		public static boolean autenticar(String usuario, String password) {
			
			ResultSet rs = null;
			PreparedStatement pstmt =null;
			try {
				pstmt = ConexionBDD.getConexion().prepareStatement(SQL_SELECT_USUARIO_WHERE_PASSWORD);
				pstmt.setString(1, usuario);
				pstmt.setString(2, password);
				rs = pstmt.executeQuery();
				if(rs.next()) return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return false;
		}
}
