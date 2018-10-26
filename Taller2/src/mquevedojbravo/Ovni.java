package mquevedojbravo;

import processing.core.PApplet;
import processing.core.PImage;

public class Ovni extends Personaje implements Runnable {

	private PApplet app;
	private Mundo m; 
	private Jugador j;
	private PImage ovni;
	
	public Ovni(PApplet app, Mundo m) {
		super(app);
		this.m = m;
		vivo = true;
	}

	public void run() {

	}
	
	public void pintar() {
		
	}
	
	public void buscarObj() {
		
	}
	
	public void huir() {
		
	}
	
	public void seguirJugador() {
		
	}
}
