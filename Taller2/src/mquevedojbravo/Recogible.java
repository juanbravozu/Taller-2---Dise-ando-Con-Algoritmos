package mquevedojbravo;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public abstract class Recogible extends Thread {

	protected PApplet app;
	protected PImage img;
	protected PVector pos;
	protected int tam;
	protected boolean vivo;
	
	public Recogible(PApplet app) {
		this.app = app;
		vivo = true;
	}
	
	public abstract void run();
	
	public abstract void pintar();
	
	public PVector getPos() {
		return pos;
	}
}
