package mquevedojbravo;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public abstract class Personaje {
	protected PApplet app;
	protected PVector pos;
	protected PVector vel;
	protected PVector ac;
	protected float fmax;
	protected float velmax;
	protected int estrellas;
	protected int tam;
	
	public Personaje(PApplet app) {
		this.app = app;
		ac = new PVector(0, 0);
		vel = new PVector(0, 0);
		pos = new PVector(app.width/2, app.height/2);
		velmax = 10f;
		fmax = 0.4f;	
		estrellas = 0;
	}
	
	public abstract void pintar();
	
	public void actualizar() {
		vel.add(ac);
		vel.limit(velmax);
		pos.add(vel);
		ac.mult(0);
	}
	
	public void aplicarFuerza(PVector f) {
		ac.add(f);
	}
	
	public void perseguir(PVector obj) {
		PVector deseado = PVector.sub(obj, pos);
		deseado.normalize();
		deseado.mult(velmax);
		PVector direccion = PVector.sub(deseado, vel);
		direccion.limit(fmax);
		aplicarFuerza(direccion);
	}
}
