package mquevedojbravo;

import java.util.Iterator;
import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PImage;

public class Mundo {

	private PApplet app;
	private Jugador j;
	private PImage fondo;
	private PImage interfaz;
	private LinkedList<Ovni> ovnis;
	private LinkedList<Recogible> objetos;
	private int contadorOvni;
	
	public Mundo(PApplet app) {
		this.app = app;
		j = new Jugador(app);
		j.start();
		ovnis = new LinkedList<Ovni>();
		fondo = app.loadImage("fondo1.png");
		interfaz = app.loadImage("Interfaz1.png");
		contadorOvni = 0;
	}
	
	public void pintar() {
		app.image(fondo, app.width/2, app.height/2);
		j.pintar();
		Iterator<Ovni> it = ovnis.iterator();
		while(it.hasNext()) {
			Ovni o = it.next();
			o.pintar();
		}
		app.image(interfaz, app.width/2, app.height/2);
		if(contadorOvni % 60 == 0) {
			Ovni o = new Ovni(app, this);
			o.start();
			ovnis.add(o);
		}
		contadorOvni++;
	}
	
	public LinkedList<Recogible> getObjetos() {
		return objetos;
	}
	
	public Jugador getJ() {
		return j;
	}
}