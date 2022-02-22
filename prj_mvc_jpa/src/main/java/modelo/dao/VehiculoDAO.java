package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.conexion.ConexionBDD;
import modelo.entidades.Vehiculo;

public class VehiculoDAO {
		//C
		private static final String SQL_INSERT="INSERT INTO  VEHICULO (placa,marca,anio,modelo,chasis,propietario) VALUES(?,?,?,?,?,?)";
		//R
		private static final String SQL_SELECT_ID="SELECT *FROM VEHICULO WHERE IDVEHICULO = ?";
		private static final String SQL_SELECT_PLACA="SELECT *FROM VEHICULO WHERE PLACA = ?";
		private static final String SQL_SELECT_CHASIS="SELECT *FROM VEHICULO WHERE CHASIS = ?";
		//U
		private static final String SQL_UPDATE="UPDATE VEHICULO SET placa = ?, marca=?, anio=?,modelo=?,chasis=?,propietario=? WHERE IDVEHICULO=?";
		//D
		private static final String SQL_DELETE="DELETE FROM VEHICULO WHERE IDVEHICULO = ?";
		
		public VehiculoDAO() {
			
		}
		
		public List<Vehiculo> getVehiculos() {
			List<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();	
			
			try {
			ResultSet rs = null;
			PreparedStatement pstmt =null;
			
				pstmt = ConexionBDD.getConexion().prepareStatement("SELECT *FROM VEHICULO");						
				rs =  pstmt.executeQuery();
							
				while(rs.next()) {
					Vehiculo v = new Vehiculo(rs.getInt("IDVEHICULO"),rs.getString("placa"),rs.getString("marca"),rs.getInt("anio"),rs.getString("modelo"),rs.getString("chasis"),rs.getString("propietario"));
					listaVehiculos.add(v);		
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			};
			return listaVehiculos;
		
		}
		
		
		public static Vehiculo getVehiculo(int idVehiculo) {
			Vehiculo v = null;
			
			ResultSet rs = null;
			PreparedStatement pstmt =null;
			try {
				pstmt = ConexionBDD.getConexion().prepareStatement(SQL_SELECT_ID);
				pstmt.setInt(1, idVehiculo);			
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					v = new Vehiculo(rs.getInt("IDVEHICULO"),rs.getString("placa"),rs.getString("marca"),rs.getInt("anio"),rs.getString("modelo"),rs.getString("chasis"),rs.getString("propietario"));}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			return v;
		}
		
		public static Vehiculo getVehiculoByPlaca(String placa) {
			Vehiculo v = null;
			
			ResultSet rs = null;
			PreparedStatement pstmt =null;
			try {
				pstmt = ConexionBDD.getConexion().prepareStatement(SQL_SELECT_PLACA);
				pstmt.setString(1, placa);			
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					v = new Vehiculo(rs.getInt("IDVEHICULO"),rs.getString("placa"),rs.getString("marca"),rs.getInt("anio"),rs.getString("modelo"),rs.getString("chasis"),rs.getString("propietario"));}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			return v;
		}
		
		public static Vehiculo getVehiculoByChasis(String chasis) {
			Vehiculo v = null;
			
			ResultSet rs = null;
			PreparedStatement pstmt =null;
			try {
				pstmt = ConexionBDD.getConexion().prepareStatement(SQL_SELECT_CHASIS);
				pstmt.setString(1, chasis);			
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					v = new Vehiculo(rs.getInt("IDVEHICULO"),rs.getString("placa"),rs.getString("marca"),rs.getInt("anio"),rs.getString("modelo"),rs.getString("chasis"),rs.getString("propietario"));}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			return v;
		}
		
		public void insertar(Vehiculo v) {
			try {
				PreparedStatement pstmt =null;
				pstmt = ConexionBDD.getConexion().prepareStatement(SQL_INSERT);
				pstmt.setString(1, v.getPlaca());	
				pstmt.setString(2, v.getMarca());
				pstmt.setInt(3, v.getAnio());
				pstmt.setString(4, v.getModelo());
				pstmt.setString(5, v.getChasis());
				pstmt.setString(6, v.getPropietario());
				
				int fila = pstmt.executeUpdate();
				System.out.println("Numero de filas afectadas: "+fila);			
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void actualizar(Vehiculo v) {
			try {
				PreparedStatement pstmt =null;
				pstmt = ConexionBDD.getConexion().prepareStatement(SQL_UPDATE);
				pstmt.setString(1, v.getPlaca());	
				pstmt.setString(2, v.getMarca());
				pstmt.setInt(3, v.getAnio());
				pstmt.setString(4, v.getModelo());
				pstmt.setString(5, v.getChasis());
				pstmt.setString(6, v.getPropietario());
				pstmt.setInt(7, v.getIdVehiculo());
				
				int fila = pstmt.executeUpdate();
				System.out.println("Numero de filas afectadas: "+fila);			
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public static void eliminar(int idVehiculo) { 
			try {
				PreparedStatement pstmt =null;
				pstmt = ConexionBDD.getConexion().prepareStatement(SQL_DELETE);
				pstmt.setInt(1, idVehiculo);
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
}
