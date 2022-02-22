package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.conexion.ConexionBDD;
import modelo.entidades.Multa;

public class MultaDAO {
	//C
	private static final String SQL_INSERT="INSERT INTO  multa (idVehiculo,valor,anio,descripcion) VALUES(?,?,?,?)";
	//R
	private static final String SQL_SELECT_ID_VEHICULO="SELECT * FROM multa WHERE idVehiculo = ?";
	
	public MultaDAO() {}
	
	public static List<Multa> getMultas(int idVehiculo){
		List<Multa> multas = new ArrayList<Multa>();
		System.out.println("holaa");
		try {
			ResultSet rs = null;
			PreparedStatement prstm = null;
			prstm = ConexionBDD.getConexion().prepareStatement(SQL_SELECT_ID_VEHICULO);
			prstm.setInt(1, idVehiculo);
			rs = prstm.executeQuery();
			while(rs.next()) {
				Multa multa = new Multa(rs.getInt("idMulta"), rs.getInt("idVehiculo"), rs.getDouble("valor"), rs.getString("anio"), rs.getString("descripcion"));
				multas.add(multa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return multas;
	}
	
	public static void insertar(Multa multa) {
		try {
			PreparedStatement pstmt = ConexionBDD.getConexion().prepareStatement(SQL_INSERT);
			pstmt.setInt(1, multa.getIdVehiculo());
			pstmt.setDouble(2, multa.getValor());
			pstmt.setString(3, multa.getAnio());
			pstmt.setString(4, multa.getDescripcion());
			
			int filas = pstmt.executeUpdate();
			
			System.out.println("Numero de filas afectadas: " + filas);
		} catch (SQLException e) {
		}
	}
}
