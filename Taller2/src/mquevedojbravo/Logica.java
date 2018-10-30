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
		menus = new PImage[4];
		for(int i = 0; i < menus.length; i++) {
			menus[i] = app.loadImage("menu" + i + ".png");
		}
	}

	public void pintar() {
		
		switch(pantalla) {
		case 0:
			pintarMenu();
			break;
		
		case 1:
			m.pintar();
			
			break;
		}
		app.stroke(255,100);
		app.noFill();
		app.ellipse(app.mouseX, app.mouseY, 10, 10);
	}
	
	public void pintarMenu() {
		float x = app.width/2;
		float y = app.height/2;
		interaccionMenu();
	}
	
	public void interaccionMenu() {
		int x = app.mouseX;
		int y = app.mouseY;
		float posX = app.width/2;
		float posY = app.height/2;
		if(x > posX - 72.82f && x < posX + 72.67f && y > posY + 86.75f && y < posY + 145.16f){
			app.image(menus[1], posX, posY);
		} else if(x > posX - 158.29f && x < posX + 161.94f && y > posY + 161.94f && y < posY + 207.66f){
			app.image(menus[2], posX, posY);
		} else if(x > posX - 56.32f && x < posX + 56.55f && y > posY + 236.77f && y < posY + 283.98f) {
			app.image(menus[3], posX, posY);
		}else {
			app.image(menus[0], posX, posY);
		}
	}
	
	public void click() {
		int x = app.mouseX;
		int y = app.mouseY;
		float posX = app.width/2;
		float posY = app.height/2;
		switch(pantalla) {
		case 0:
			if(x > posX - 72.82f && x < posX + 72.67f && y > posY + 86.75f && y < posY + 145.16f){
				pantalla = 1;
			} else if(x > posX - 158.29f && x < posX + 161.94f && y > posY + 161.94f && y < posY + 207.66f){
				pantalla = 2;
			} else if(x > posX - 56.32f && x < posX + 56.55f && y > posY + 236.77f && y < posY + 283.98f) {
				app.exit();
			}
		
		case 1:
			
		}
	}
}