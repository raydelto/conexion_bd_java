package edu.itla.registro;

import java.sql.ResultSet;
import java.sql.SQLException;

import edu.itla.registro.bd.Conexion;

public class Sistema {
	public static void main(String[] args) {
		Conexion conexion = null;
		try {
			conexion = new Conexion("com.mysql.jdbc.Driver","jdbc:mysql://localhost/registro?user=root");
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
			System.err.println("Hubo un error al cargar el driver de la base de datos: " + e.getMessage());
		}
		
		
		
		try {
			conexion.ejecutar("INSERT into estudiantes(nombre,apellido,matricula) values(\'Enmanuel\',\'Toribio\',\'20015421\')");
			ResultSet resultados = conexion.hacerConsulta("SELECT estudiante_id, nombre,apellido , matricula FROM estudiantes");
			while(resultados.next()){
//				System.out.println(resultados.getString("nombre") + "\t" + resultados.getString("apellido") );
				for(int i = 1 ; i<= resultados.getMetaData().getColumnCount(); i++){
					System.out.print(resultados.getString(i) + "\t");
				}
				System.out.println("\n");
			}
		} catch (SQLException e) {
			System.err.println("Hubo un error con la consulta: " + e.getMessage());
		}	
		
	}

}
