package mquevedojbravo;

import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PImage;

public class Mundo {

	private PApplet app;
	private Jugador j;
	private PImage fondo;
	private LinkedList<Ovni> ovnis;
	private LinkedList<Recogible> objetos;
	
	public Mundo(PApplet app) {
		this.app = app;
		j = new Jugador(app);
		fondo = app.loadImage("fondo.png");
	}
	
	public void pintar() {
		app.image(fondo, app.width/2, app.height/2);
		j.pintar();
//		app.fill(255,100);
		app.stroke(255,100);
		app.noFill();
		app.ellipse(app.mouseX, app.mouseY, 10, 10);
	}
	
	public LinkedList<Recogible> getObjetos() {
		return objetos;
	}
}