package mquevedojbravo;

import java.util.Iterator;
import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Jugador extends Personaje{

	private LinkedList<PVector> historia;
	private int cometa;
	private int agujeros;
	private int contOvnis;
	
	public Jugador(PApplet app) {
		super(app);
		pos = new PVector(app.width/2, app.height/2);
		historia = new LinkedList<PVector>();
		historia.add(pos);
		img = app.loadImage("nave.png");
		velmax = 7f;
		fmax = 0.3f;
		contOvnis = 0;
		agujeros = 0;
		cometa = 0;
	}

	public void run() {
		while(vivo) {
			actualizar();
			PVector obj = new PVector(app.mouseX, app.mouseY);
			perseguir(obj);
			ang = vel.heading() + app.PI/2;
			try {					
				sleep(16);
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
		app.image(img, 0, 0);
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
	
	public boolean validarObj(Recogible o) {
		if(app.dist(pos.x, pos.y, o.getPos().x, o.getPos().y) < 28) {
			if(o instanceof Estrella) {
				estrellas++;
				return true;
			} else if(o instanceof Agujero){
				agujeros++;
				return true;
			} else {
				return false;
			}
		}else {
			return false;
		 }
	}
	
	public void usarCometa() {
		if(estrellas >= 5) {
			
			estrellas -= 5;
		}
	}
	
	public boolean usarAgujero() {
		if(estrellas >= 15) {
			
			estrellas -= 15;
			return true;
		}else {
			return false;
		}
	}
	
	public PVector getPos() {
		return pos;
	}
	
	public int getEstrellas() {
		return estrellas;
	}
	
	public void setEstrella(int e) {
		estrellas = e;
	}

	public int getContOvnis() {
		return contOvnis;
	}

	public void setContOvnis(int contOvnis) {
		this.contOvnis = contOvnis;
	}
	
	public int getAgujero() {
		return agujeros;
	}
	
	public void setAgujero(int agujeros) {
		this.agujeros = agujeros;
	}

	public int getCometa() {
		return cometa;
	}

	public void setCometa(int cometa) {
		this.cometa = cometa;
	}
	
	
	
}
