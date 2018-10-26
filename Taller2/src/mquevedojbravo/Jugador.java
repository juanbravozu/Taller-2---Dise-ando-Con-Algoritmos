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
		velmax = 7f;
		fmax = 0.3f;	
	}
	
	public void run() {
		while(vivo) {
			actualizar();
			PVector obj = new PVector(app.mouseX, app.mouseY);
			perseguir(obj);
			ang = vel.heading() + app.PI/2;
				try {
					sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	}
	
	public void pintar() {
		app.noStroke();
		synchronized(historia) {
			Iterator<PVector> it = historia.iterator();
			int i = 0;
			while(it.hasNext()) {
					PVector p = it.next();
					int tam = 5 + (int)(i/2);
					int opacidad = 30+(i*4);
					app.fill(0, 193, 208, opacidad);
					app.ellipse(p.x, p.y, tam, tam);
					i++;
			}
		}
		app.pushMatrix();
		app.translate(pos.x, pos.y);
		app.rotate(ang);
		app.image(nave, 0, 0);
		app.popMatrix();
	}
	
	public void actualizar() {
		vel.add(ac);
		vel.limit(velmax);
		pos.add(vel);
		ac.mult(0);
		PVector newP = new PVector(pos.x, pos.y);
		synchronized(historia) {
			historia.add(newP);
			if(historia.size() >  35) {
				historia.remove(0);
			}
		}
	}
	
	public void perseguir(PVector obj) {
		PVector deseado = PVector.sub(obj, pos);
		
		float dist = deseado.mag();
		deseado.normalize();
		if(dist < 100) {
			float mag = app.map(dist, 0, 100, 0, velmax);
			deseado.mult(mag);
		} else {
			deseado.mult(velmax);
		}
		PVector direccion = PVector.sub(deseado, vel);
		direccion.limit(fmax);
		aplicarFuerza(direccion);
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
