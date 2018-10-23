package mquevedojbravo;

import java.util.Iterator;
import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Jugador extends Personaje{

	private PImage nave;
	private LinkedList<PVector> historia;
	private Cometa cometa;
	private Agujero agujero;
	
	public Jugador(PApplet app) {
		super(app);
		historia = new LinkedList<PVector>();
		historia.add(pos);
		nave = app.loadImage("nave.png");
	}
	
	public void pintar() {
		float ang = vel.heading() + app.PI/2;
		Iterator<PVector> it = historia.iterator();
		int i = 0;
		while(it.hasNext()) {
			PVector p = it.next();
			int tam = 5 + (int)(i/2);
			int opacidad = 30+(i*4);
			app.fill(0, 193, 208, opacidad);
			app.pushMatrix();
			app.translate(p.x, p.y);
			app.ellipse(0, 0, tam, tam);
			app.popMatrix();
			i++;
		}
		app.pushMatrix();
		app.translate(pos.x, pos.y);
		app.rotate(ang);
		app.image(nave, 0, 0);
		app.popMatrix();
		actualizar();
		PVector obj = new PVector(app.mouseX, app.mouseY);
		perseguir(obj);
	}
	
	public void actualizar() {
		vel.add(ac);
		vel.limit(velmax);
		pos.add(vel);
		ac.mult(0);
		PVector newP = new PVector(pos.x, pos.y);
		historia.add(newP);
		if(historia.size() > 35) {
			historia.remove(0);
		}
	}
	
	public void aplicarFuerza(PVector f) {
		ac.add(f);
	}
	
	public void validarObj() {
		
	}
	
	public void usarCometa() {
		
	}
	
	public void usarAgujero() {
		
	}
	
	public PVector getPos() {
		return pos;
	}
}
