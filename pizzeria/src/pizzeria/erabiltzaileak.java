package pizzeria;

import java.util.Scanner;

public class erabiltzaileak {
	Scanner teklatua = new Scanner(System.in);
	private int id;
	private String izena;
	private String abizena;
	
	public erabiltzaileak() {
		this.id=0;
		this.izena="";
		this.abizena="";
	}
	
	public erabiltzaileak(int i,String iz, String a){
		this.id=i;
		this.izena=iz;
		this.abizena=a;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getAbizena() {
		return abizena;
	}

	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}

	@Override
	public String toString() {
		return "erabiltzaileak [id=" + id + ", izena=" + izena + ", abizena=" + abizena + "]";
	}
	
	public void irakurri(Scanner teklatua) {
		System.out.println("Zein da id-a? ");
		this.id=teklatua.nextInt();
		System.out.println("Zein da zure izena? ");
		this.izena=teklatua.next();
		System.out.println("Zein da zure abizena?");
		this.abizena=teklatua.next();
	}
	
	
}
