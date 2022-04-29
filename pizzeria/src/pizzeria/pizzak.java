package pizzeria;

import java.util.Scanner;

public class pizzak {
	Scanner teklatua = new Scanner(System.in);
	
	private int id;
	private String izena;
	private String osagaiak;
	private int prezioak;
	
	
	public pizzak() {
		this.id=0;
		this.izena="";
		this.osagaiak="";
		this.prezioak=0;
	}
	
	public pizzak(int i, String iz, String o, int p) {
		this.id=i;
		this.izena=iz;
		this.osagaiak=o;
		this.prezioak=p;
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

	public String getOsagaiak() {
		return osagaiak;
	}

	public void setOsagaiak(String osagaiak) {
		this.osagaiak = osagaiak;
	}

	public int getPrezioak() {
		return prezioak;
	}

	public void setPrezioak(int prezioak) {
		this.prezioak = prezioak;
	}

	@Override
	public String toString() {
		return "pizzak [id=" + id + ", izena=" + izena + ", osagaiak=" + osagaiak + ", prezioak=" + prezioak + "]";
	}
	
	public void irakurri(Scanner teklatua) {
		System.out.println("Zein da pizzaren id-a? ");
		this.id=teklatua.nextInt();
		System.out.println("Zein da pizzaren izena?");
		this.izena=teklatua.next();
		System.out.println("Zein dira osagaiak?");
		this.osagaiak=teklatua.next();
		System.out.println("Sartu pizzaren prezioa: ");
		this.prezioak=teklatua.nextInt();
	}
	
}
