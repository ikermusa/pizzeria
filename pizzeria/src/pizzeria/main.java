package pizzeria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import  java.sql.Statement;

public class main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Scanner teklatua = new Scanner(System.in);
		
		ArrayList<erabiltzaileak> erabiltzaileak = new ArrayList<erabiltzaileak>();
		ArrayList<eskaerak> eskaerak = new ArrayList<eskaerak>();
		ArrayList<pizzak> pizzak = new ArrayList<pizzak>();
		
		boolean modificado = false;
		
		////////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////PRIMERA CONEXION///////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////////
		
		try{
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/pizzeria", "root", "");
			// si se ha conectado correctamente
			System.out.println("Conexión Correcta.");
			Statement st = conexion.createStatement();
			
			// cierro la conexion
			st.close();
			conexion.close();
		}catch (SQLException e){
			// si NO se ha conectado correctamente
			e.printStackTrace();
			System.out.println("Error de Conexión");
		}
		
		int aukera;
		
		do {

		System.out.println("Ze opzio nahi duzu?");
		System.out.println("0- Irten");
		System.out.println("1- Pizzak ikusi");
		System.out.println("2- Erabiltzaileak ikusi");
		System.out.println("3- Eskaerak ikusi");
		System.out.println("4- Pizza berri bat sartu");
		System.out.println("5- Erabiltzaile beri bat sortu");
		System.out.println("6- Eskaera berri bat sortu");
		aukera = teklatua.nextInt();
		
			switch (aukera) {
			case 1:
				/////////////////////////////
				//ENSEÑAR CONTENIDO DE PIZZAS
				for (pizzak erakutsiPizzak : pizzak) {
					System.out.println(erakutsiPizzak);
				}
				
				break;
			case 2:
				/////////////////////////////
				//ENSEÑAR CONTENIDO DE USUARIOS
				for (erabiltzaileak erakutsiErabiltzaileak : erabiltzaileak) {
					System.out.println(erakutsiErabiltzaileak);
				}
				
				break;
			case 3:
				/////////////////////////////
				//ENSEÑAR CONTENIDO DE PEDIDOS
				for (eskaerak erakutsiEskaerak : eskaerak) {
					System.out.println(erakutsiEskaerak);
				}
				
				break;
			case 4:
				/////////////////////////////
				//METER UNA NUEVA PIZZA
				pizzak pizzaSartu = new pizzak();
				pizzaSartu.irakurri(teklatua);
				pizzak.add(pizzaSartu);
				modificado = true;
				
				break;
			case 5:
				/////////////////////////////
				//METER UN NUEVO USUARIO
				erabiltzaileak erabiltzaileaSartu = new erabiltzaileak();
				erabiltzaileaSartu.irakurri(teklatua);
				erabiltzaileak.add(erabiltzaileaSartu);
				modificado = true;
				
				break;
			case 6:
				/////////////////////////////
				//METER UN NUEVO PEDIDO
				eskaerak eskaeraSartu = new eskaerak();
				eskaeraSartu.irakurri(teklatua);
				eskaerak.add(eskaeraSartu);
				modificado = true;
				
				break;
			case 0:
				System.exit(0);
				break;
				
			}
			
			
		} while (aukera != 0);
		
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////// COMPROBACION SI SE HA MODIFICADO Y CARGAR BASE DE DATOS ////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////
		
		if (modificado) {
			try {

			modificado = false;

			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/pizzeria", "root", "");
			Statement st = conexion.createStatement();
			
			//////////////////////////////////////////////////////////////////////
			//LIMPIAR LO QUE HAYA EN LAS TABLAS PARA METER LOS CAMBIOS HECHOS////
			////////////////////////////////////////////////////////////////////
			int registrosmodificados;
			registrosmodificados = st.executeUpdate ("DELETE FROM pizzeria.erabiltzaileak");
			if (registrosmodificados > 0) {
			// si se ha borrado algun registro
			System.out.println("El registro ha sido borrado");
			}
			else {
			// si NO se ha borrado algun registro
			System.out.println("NO se ha borrado ningún registro");
			}
			
			
			registrosmodificados = st.executeUpdate("DELETE FROM pizzeria.eskaerak;");
			if (registrosmodificados > 0) {
				// si se ha borrado algun registro
				System.out.println("El registro ha sido borrado");
			}else {
				// si NO se ha borrado algun registro
				System.out.println("NO se ha borrado ningún registro");
			}
			
			
			registrosmodificados = st.executeUpdate("DELETE FROM pizzeria.pizzak;");
			if (registrosmodificados > 0) {
				// si se ha borrado algun registro
				System.out.println("El registro ha sido borrado");
			}else {
				// si NO se ha borrado algun registro
				System.out.println("NO se ha borrado ningún registro");
			}
			
			////////////////////////////////
			//CARGAR USUARIOS A LA BASE DE DATOS
			for (int i=0; i < erabiltzaileak.size(); i++) {
				st.executeUpdate("INSERT INTO pizzeria.erailtzaileak VALUES (' "+erabiltzaileak.get(i).getId()+ " ', ' "+erabiltzaileak.get(i).getIzena()+" ', ' "+erabiltzaileak.get(i).getAbizena()+" ');");     
			}
			
			////////////////////////////////
			//CARGAR PEDIDOS A LA BASE DE DATOS
			for (int i=0; i < eskaerak.size(); i++) {
				st.executeUpdate("INSERT INTO pizzeria.eskaerak VALUES (' "+eskaerak.get(i).getIdpizza()+ " ', ' "+eskaerak.get(i).getIderabiltzaile()+" ', ' "+eskaerak.get(i).getIdeskaera()+" ', ' "+eskaerak.get(i).getKopurua()+" ');");
			}
			////////////////////////////////
			//CARGAR PIZZAS A LA BASE DE DATOS
			for (int i=0; i < pizzak.size(); i++) {
				st.executeUpdate("INSERT INTO pizzeria.pizzak VALUES (' "+pizzak.get(i).getId()+ " ', ' "+pizzak.get(i).getIzena()+" ', ' "+pizzak.get(i).getOsagaiak()+" ', ' "+pizzak.get(i).getPrezioak()+" ');");
			}

			st.close();
			conexion.close();

			}catch (SQLException e) {
				e.printStackTrace();
			}
		
		}

		
		teklatua.close();
		
	}

}
