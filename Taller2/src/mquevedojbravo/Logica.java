package mquevedojbravo;

import processing.core.PApplet;
import processing.core.PImage;

public class Logica {

	private PApplet app;
	private Mundo m;
	private int pantalla;
	private PImage[] menus;
	
	/**
	 * Pantalla 0 - Menu Inicio
	 * Pantalla 1 - Juego
	 * Pantalla 2 - Inst1
	 * Pantalla 3 - Inst2
	 * Pantalla 4 - Inst3
	 * Pantalla 5 - Inst4
	 */
	
	public Logica(PApplet app) {
		this.app = app;
		m = new Mundo(app);
		pantalla = 0;
		menus = new PImage[12];
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
		interInstru();
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
	
	public void interInstru() {
		int x = app.mouseX;
		int y = app.mouseY;
		float posX = app.width/2;
		float posY = app.height/2;
		switch(pantalla) {
		case 2:	
		if(x > posX - 105.41f && x < posX + 108.13f && y > posY + 219.98f && y < posY + 271.36f) {
			app.image(menus[5], posX, posY);
		}else {
			app.image(menus[4], posX, posY);
		}
			
			break;
		
		case 3:
			if(x > posX - 105.41f && x < posX + 108.13f && y > posY + 219.98f && y < posY + 271.36f) {
				app.image(menus[7], posX, posY);
			}else {
				app.image(menus[6], posX, posY);
			}
			break;
			
		case 4:
			if(x > posX - 105.41f && x < posX + 108.13f && y > posY + 219.98f && y < posY + 271.36f) {
				app.image(menus[9], posX, posY);
			}else {
				app.image(menus[8], posX, posY);
			}
			break;
			
		case 5:			
			if(x > posX - 69.16f && x < posX + 70.97f && y > posY + 218.9f && y < posY + 272.66f) {
				app.image(menus[11], posX, posY);
			}else {
				app.image(menus[10], posX, posY);
			}
			break;
			
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
			
			break;
		
		case 1:
			break;
			
		case 2:
			if(x > posX - 105.41f && x < posX + 108.13f && y > posY + 219.98f && y < posY + 271.36f) {
				pantalla = 3;
			}
				break;
			
		case 3:
			if(x > posX - 105.41f && x < posX + 108.13f && y > posY + 219.98f && y < posY + 271.36f) {
				pantalla = 4;
			}
			break;
			
		case 4:
			if(x > posX - 105.41f && x < posX + 108.13f && y > posY + 219.98f && y < posY + 271.36f) {
				pantalla = 5;
			}
			
			break;
			
		case 5:			
			if(x > posX - 69.16f && x < posX + 70.97f && y > posY + 218.9f && y < posY + 272.66f) {
				pantalla = 1;
			}
			break;
		}
	}
}