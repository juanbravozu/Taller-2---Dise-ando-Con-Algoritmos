package mquevedojbravo;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Ovni extends Personaje{

	private PApplet app;
	private Mundo m; 
	private Jugador j;
	private PImage ovni;
	private float ang;
	
	public Ovni(PApplet app, Mundo m) {
		super(app);
		this.m = m;
		this.app = app;
		
		int random = (int)app.random(4);
		float x, y;
		if(random == 0) {
			x = app.random(-200,-50);
			y = app.random(app.height);
		} else if(random == 1) {
			x = app.random(app.width+50, app.width+200);
			y = app.random(app.height);
		} else if(random == 2) {
			x = app.random(app.width);
			y = app.random(-200,-50);
		} else {
			x = app.random(app.width);
			y = app.random(app.height+50, app.height+200);
		}

		pos = new PVector(x, y);
		ovni = app.loadImage("ovni.png");
		
		velmax = 5;
		fmax = 0.2f;
		ang = 0;
		
		img = app.loadImage("ovni.png");
	}

	public void run() {
		while(vivo) {
			try {
				perseguir(m.getJ().getPos());
				actualizar();
				ang += app.PI/50;
				sleep(16);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void pintar() {
		app.pushMatrix();
		app.translate(pos.x, pos.y);
		app.fill(255);
		app.text(estrellas, 35, 15);
		app.rotate(ang);
		app.image(img, 0, 0);
		app.popMatrix();
	}
	
	public void buscarObj() {
		
	}
	
	public void huir() {
		
	}
}
