package pizzeria;

import java.util.Scanner;

public class eskaerak {
	Scanner teklatua = new Scanner(System.in);
	
	private int idpizza;
	private int iderabiltzaile;
	private int ideskaera;
	private int kopurua;
	
	public eskaerak() {
		this.idpizza=0;
		this.iderabiltzaile=0;
		this.ideskaera=0;
		this.kopurua=0;
	}
	
	public eskaerak(int ipizza,int ierabiltzailea,int ieskaera,int k) {
		this.idpizza=ipizza;
		this.iderabiltzaile=ierabiltzailea;
		this.ideskaera=ieskaera;
		this.kopurua=k;
	}

	public int getIdpizza() {
		return idpizza;
	}

	public void setIdpizza(int idpizza) {
		this.idpizza = idpizza;
	}

	public int getIderabiltzaile() {
		return iderabiltzaile;
	}

	public void setIderabiltzaile(int iderabiltzaile) {
		this.iderabiltzaile = iderabiltzaile;
	}

	public int getIdeskaera() {
		return ideskaera;
	}

	public void setIdeskaera(int ideskaera) {
		this.ideskaera = ideskaera;
	}

	public int getKopurua() {
		return kopurua;
	}

	public void setKopurua(int kopurua) {
		this.kopurua = kopurua;
	}

	@Override
	public String toString() {
		return "eskaerak [idpizza=" + idpizza + ", iderabiltzaile=" + iderabiltzaile + ", ideskaera=" + ideskaera
				+ ", kopurua=" + kopurua + "]";
	}
	
	public void irakurri(Scanner teklatua) {
		System.out.println("Zein da pizzaren id-a? ");
		this.idpizza = teklatua.nextInt();
		System.out.println("Zein da erabiltzailearen id-a? ");
		this.iderabiltzaile=teklatua.nextInt();
		System.out.println("Zein da eskaeraren id-a");
		this.ideskaera=teklatua.nextInt();
		System.out.println("Zein da eskaeraren kopurua? ");
		this.kopurua=teklatua.nextInt();
	}
	
	
}
