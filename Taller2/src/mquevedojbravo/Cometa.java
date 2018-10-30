package mquevedojbravo;

import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PVector;

public class Cometa extends Recogible implements Runnable {

	private LinkedList<PVector> historia;
	private boolean vivo;
	
	public Cometa(PApplet app) {
		super(app);
		vivo = true;
	}
	public void run() {
		while(vivo) {
			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void pintar() {

	}

}
