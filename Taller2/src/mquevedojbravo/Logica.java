package mquevedojbravo;

import processing.core.PApplet;
import processing.core.PImage;

public class Logica {

	private PApplet app;
	private Mundo m;
	private int pantalla;
	private PImage[] menus;
	
	public Logica(PApplet app) {
		this.app = app;
		m = new Mundo(app);
		pantalla = 0;
		menus = new PImage[1];
		menus[0] = app.loadImage("pantalla0.png");
	}
	
	public void pintar() {
		m.pintar();
		app.stroke(255,100);
		app.noFill();
		app.ellipse(app.mouseX, app.mouseY, 10, 10);
	}
	
	public void interaccionMenu() {
		
	}
	
	public void click() {
		pantalla++;
	}
}