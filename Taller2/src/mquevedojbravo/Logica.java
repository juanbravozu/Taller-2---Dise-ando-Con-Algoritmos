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
				botones[i].resize((botones[i].width/3) + 30, (botones[i].height/3) + 15);
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
		app.image(menus[0], x, y);
		switch(pantalla) {		
		case 0:
			app.image(botones[0], x, y+90);
			app.image(botones[1], x, y+160);
			app.image(botones[2], x, y+230);
			break;
			
		case 1:
			app.image(botones[3], x, y+90);
			app.image(botones[1], x, y+160);
			app.image(botones[2], x, y+230);
			break;
			
		case 2:
			app.image(botones[0], x, y+90);
			app.image(botones[4], x, y+160);
			app.image(botones[2], x, y+230);
			break;
			
		case 3:
			app.image(botones[0], x, y+90);
			app.image(botones[1], x, y+160);
			app.image(botones[5], x, y+230);
		}
		interaccionMenu();
	}
	
	public void interaccionMenu() {
		int x = app.mouseX;
		int y = app.mouseY;
		float posX = app.width/2;
		float posY = app.height/2;
		if(y < posY+90+(botones[0].height/2) && y > posY+90-(botones[0].height/2) && x < posX+(botones[0].width/2) && x > posX-(botones[0].width/2)) {
			pantalla = 1;
		} else if(y < posY+160+(botones[1].height/2) && y > posY+160-(botones[1].height/2) && x < posX+(botones[1].width/2) && x > posX-(botones[1].width/2)) {
			pantalla = 2;
		} else if(y < posY+230+(botones[2].height/2) && y > posY+230-(botones[2].height/2) && x < posX+(botones[2].width/2) && x > posX-(botones[2].width/2)) {
			pantalla = 3; 
		} else {
			pantalla = 0;
		}
	}
	
	public void click() {
		pantalla= 4;
	}
}