package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Jugador;
import util.MySqlDBConexion;

public class JugadorModel {

	public int insertaJugador(Jugador obj) {
		int salida = -1;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			//1 Se crea la conexión
			conn = MySqlDBConexion.getConexion();

			//2 Se prepara el SQL
			//String sql = "insert into jugador values(null,?,?,?)";
			//pstm = conn.prepareStatement(sql);
			
			String sql = "call sp_inserta_jugador(?,?,?)";
			pstm = conn.prepareCall(sql);
			
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getApellido());
			pstm.setDate(3, obj.getFechaNacimiento());
			System.out.println("SQL -> " + pstm);
			
			//2Se envía el SQL a la base de datos
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) pstm.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {}
		}
		return salida;
	}
	
	public int actualizaJugador(Jugador c) {
		int actualizados = -1;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySqlDBConexion.getConexion();
			String sql = "update jugador set nombre=?, apellido=?, fechaNacimiento=? where idjugador=?"; 
			pstm = con.prepareStatement(sql);
			pstm.setString(1, c.getNombre());
			pstm.setString(2, c.getApellido());
			pstm.setDate(3, c.getFechaNacimiento());
			pstm.setInt(4, c.getIdJugador());
			actualizados = pstm.executeUpdate();
			System.out.println("SQL -> " + pstm);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (con != null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return actualizados;
	}
	
	public int eliminaJugador(int idjugador) {
		int eliminados = -1;
		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = MySqlDBConexion.getConexion();
			String sql ="delete from jugador where idjugador=?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, idjugador);
			eliminados = pstm.executeUpdate();
			System.out.println("SQL -> " + pstm);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (con != null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return eliminados;
	}
	
	public List<Jugador> listaJugador() {
		ArrayList<Jugador> data = new ArrayList<Jugador>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; //Trae la data de la BD
		try {
			con = MySqlDBConexion.getConexion();
			String sql ="select * from jugador";
			pstm = con.prepareStatement(sql);
			System.out.println("SQL-->" + pstm);
			
			//En rs se trae los datos de la BD segun el SQL
			rs = pstm.executeQuery();
			
			//Se pasa la data del rs al ArrayList(data)
			Jugador c = null;
			while(rs.next()){
				c = new Jugador();
				// Se colocan los campos de la base de datos
				c.setIdJugador(rs.getInt("idjugador"));
				c.setNombre(rs.getString("nombre"));
				c.setApellido(rs.getString("apellido"));
				c.setFechaNacimiento(rs.getDate("fechaNacimiento"));
				data.add(c);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (con != null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	
}
