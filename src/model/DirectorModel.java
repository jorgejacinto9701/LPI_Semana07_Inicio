package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Logger;

import entidad.Director;
import util.MySqlDBConexion;

public class DirectorModel {

	private static Logger log = Logger.getLogger(DirectorModel.class.getName());
	
	public int insertaDirector(Director obj) {
		int salida = -1;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			//1 Se crea la conexión
			conn = MySqlDBConexion.getConexion();
			
			//2 Se prepara el SQL
			String sql = "insert into director value(null,?,?,curtime(),?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setDate(2, obj.getFechaNacimiento());
			pstm.setInt(3, obj.getEstado());
			pstm.setInt(4, obj.getGrado().getIdGrado());
			log.info(">>> " + pstm);
			
			//3 Ejecutamos a la base de datos
			//Retorna la cantidad de registrados en salida
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
}
