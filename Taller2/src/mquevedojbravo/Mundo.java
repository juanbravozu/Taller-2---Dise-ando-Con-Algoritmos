package mquevedojbravo;

import java.util.Iterator;
import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import processing.sound.SoundFile;

public class Mundo extends Thread {

	private PApplet app;
	private Jugador j;
	private PImage fondo;
	private PImage interfaz;
	private LinkedList<Ovni> ovnis;
	private LinkedList<Recogible> objetos;
	private int contadorOvni;
	private int contadorObj;
	private int contadorTiempo;
	private PFont mali;
	private SoundFile mus;
	private boolean vivo;
	
	public Mundo(PApplet app) {
		this.app = app;
		j = new Jugador(app);
		j.start();
		vivo = true;
		ovnis = new LinkedList<Ovni>();
		Ovni o = new Ovni(app, this);
		o.start();
		ovnis.add(o);
		objetos = new LinkedList<Recogible>();
		fondo = app.loadImage("fondo1.png");
		interfaz = app.loadImage("Interfaz1.png");
		contadorOvni = 0;
		contadorObj = 100;
		mali = app.loadFont("maliB_28.vlw");
		mus = new SoundFile(app, "musicaJuego.wav");
		mus.play();
		contadorTiempo = app.millis()+59999;
	}
	
	public void pintar() {
		app.image(fondo, app.width/2, app.height/2);
		j.pintar();
		//Pintar Ovnis
		synchronized(ovnis) {
			Iterator<Ovni> it = ovnis.iterator();
			while(it.hasNext()) {
				Ovni o = it.next();
				o.pintar();
			}
		}
		synchronized(objetos) {
			Iterator<Recogible> ite = objetos.iterator();
			while(ite.hasNext()) {
				Recogible r = ite.next();
				r.pintar();
			}
		}
		app.image(interfaz, app.width/2, app.height/2);
		app.textAlign(app.CORNER, app.CENTER);
		app.textFont(mali);
		app.fill(255);
		app.text(j.getEstrellas(), 1111.64f, 620.7f);
		if((int)(contadorTiempo-app.millis())/1000 > 9) {
			app.text("0:"+(int)(contadorTiempo-app.millis())/1000, 1061.64f, 590);
		} else {
			app.text("0:0"+(int)(contadorTiempo-app.millis())/1000, 1061.64f, 590);
		}
		
		
	}
	
	public void run() {
		while(vivo) {
			synchronized(ovnis) {
				//Crear Ovnis
				if(contadorOvni % 180 == 0) {
					Ovni o = new Ovni(app, this);
					o.start();
					ovnis.add(o);
				}
			}

			synchronized(objetos) {
				if(contadorObj % 60 == 0) {
					objetos.add(new Estrella(app));
				}
				
				Iterator<Recogible> it = objetos.iterator();
				while(it.hasNext()) {
					Recogible o = it.next();
					if(j.validarObj(o)) {
						it.remove();
					}
				}
			}
					
			contadorOvni++;
			contadorObj++;
			
			try {
				sleep(16);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean terminarJuego() {
		if(contadorTiempo-app.millis() <= 0) {
			mus.stop();
			return true;
		} else {
			return false;
		}
	}
	
	public LinkedList<Recogible> getObjetos() {
		return objetos;
	}
	
	public LinkedList<Ovni> getOvnis() {
		return ovnis;
	}
	
	public Jugador getJ() {
		return j;
	}
}