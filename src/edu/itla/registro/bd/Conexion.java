package edu.itla.registro.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Conexion {
	private String nombreControlador;
	private String cadenaDeConexion;
	private Statement enunciado;
	private Connection conexion;
	
	public Conexion(String nombreControlador, String cadenaDeConexion) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException{
		this.nombreControlador = nombreControlador;
		this.cadenaDeConexion = cadenaDeConexion;
		//Cargar el controlador en memoria
		Class.forName(this.nombreControlador).newInstance();
		conexion = DriverManager.getConnection(this.cadenaDeConexion);
		enunciado = conexion.createStatement();
	}
	
	public ResultSet hacerConsulta(String consulta) throws SQLException{
		return enunciado.executeQuery(consulta);
	}
	
	public void ejecutar(String enunciado) throws SQLException{
		this.enunciado.execute(enunciado);
	}

}
