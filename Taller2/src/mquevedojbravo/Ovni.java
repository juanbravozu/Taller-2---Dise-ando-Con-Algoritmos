package mquevedojbravo;

import processing.core.PApplet;
import processing.core.PImage;

public class Ovni extends Personaje{

	private PApplet app;
	private Mundo m; 
	private Jugador j;
	private PImage ovni;
	
	public Ovni(PApplet app, Mundo m) {
		super(app);
		this.m = m;
		ovni = app.loadImage("ovni.png");
	}

	public void run() {
		while(vivo) {
			try {
				sleep(16);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
