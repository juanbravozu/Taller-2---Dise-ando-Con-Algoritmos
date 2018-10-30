package mquevedojbravo;

import processing.core.PApplet;
import processing.core.PImage;

public class Logica {

	private PApplet app;
	private Mundo m;
	private int pantalla;
	private PImage[] menus;
	private PImage[] botones;
	
	public Logica(PApplet app) {
		this.app = app;
		m = new Mundo(app);
		pantalla = 0;
		menus = new PImage[1];
		menus[0] = app.loadImage("menu.png");
		menus[0].resize(1200, 676);
		botones = new PImage[6];
		for(int i = 0; i < botones.length; i++) {
			if(i < 3) {
				botones[i] = app.loadImage("boton"+i+".png");
				botones[i].resize(botones[i].width/3, botones[i].height/3);
			} else {
				botones[i] = app.loadImage("boton"+(i-3)+".png");
				botones[i].resize((botones[i].width/2) + 30, (botones[i].height/2) + 30);
			}
		}
	}
	
	public void pintar() {
		pintarMenu();
		if(pantalla == 4) {
			m.pintar();
		}
		app.stroke(255,100);
		app.noFill();
		app.ellipse(app.mouseX, app.mouseY, 10, 10);
	}
	
	public void pintarMenu() {
		float x = app.width/2;
		float y = app.height/2;
		switch(pantalla) {
		case 0:
			app.image(menus[0], x, y);
			app.image(botones[0], x, y+70);
			app.image(botones[1], x, y+140);
			app.image(botones[2], x, y+210);
			
		}
	}
	
	public void interaccionMenu() {
		
	}
	
	public void click() {
		pantalla++;
	}
}