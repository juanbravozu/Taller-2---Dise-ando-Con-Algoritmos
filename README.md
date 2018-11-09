![Space Hunt](Taller2/data/Título.png)

## Taller 2 Diseñando Con Algoritmos
Taller 2 para curso Diseñando con Algoritmos de Diseño de Medios Interactivos - Universidad ICESI

Descripción general de clases y métodos utilizados en el código

- #### Main
  Clase principal, el programa se ejecuta aquí. Uso de la librería _processing.core.PApplet_.
  * **Métodos**
    * **settings(): void**
    * **setup(): void**
    * **draw: void**
    * **keyPressed(): void**
    * **mousePressed(): void**
- #### Logica
  Clase encargada de los menús principales y su interacción. Llama y ejecuta la clase _Mundo_ y otras variables en dichos menús.
  * **Métodos**
    * **pintar(): void** Pinta los menús según el valor de la variable _pantalla_.
    * **interaccionMenu(): void** Zonas sensibles de la pantalla principal del juego.
    * **iterInstru(): void** Zonas sensibles de las instrucciones del juego.
    * **perdiste(): void** Zonas sensibles y resultados de la pantalla _perdiste_.
    * **ganaste(): void** Zonas sensibles y resultados de la pantalla _ganaste_.
    * **clic(): void** Cambiar de pantalla según la zona donde se de clic.
    * **tecla(): void** Reaccionar al teclado según las condiciones del método.
- #### Mundo
  Clase/Hilo de java que ejecuta los procesos durante la pantalla de juego.
   * **Métodos**
      * **pintar(): void** Pinta la interfaz del juego, los puntajes obtenidos en tiempo real, el tiempo de juego restante, los personajes y los recogibles.
      * **run(): void** Método necesario del hilo. Se ejecutan todos los procesos de añadir enemigos y recogibles, así como su eliminación.
      * **terminarJuego(): boolean** Devuelve _true_ si el tiempo de juego se ha acabado o el jugador ha sido cazado, _false_ en caso contrario.
      * **pararMus(): void** Detiene la música del juego si se está ejecutando.
      * **tecla(): void** Ejecuta acciones y aplica efectos según la tecla presionada.
- #### Recogible
  Clase padre encargada de los parámetros base de las clases hijas. Abstracta.
  * **Métodos**
    * **pintar(): void** Clase abstracta que pinta las imágenes y procesos de las hijas.
    * **getPos(): PVector** Devuelve la variable pos (posición) de la clase.
- #### Estrella
  Clase hija. Extiende de Recogible. Los personajes pueden validar este elemento.
  * **Métodos**
    * **pintar(): void** Pinta la imagen de la estrella y su movimiento circular básico.
- #### Agujero
  Clase hija. Extiende de Recogible. Los personajes pueden validar este elemento.
  * **Métodos**
     * **pintar(): void** Pinta la imagen del agujero y su movimiento circular básico.
- #### Cometa
  Clase hija. Extiende de Recogible e implementa la interfaz Runnable. Los personajes pueden validar este elemento.
  * **Métodos**
    * **run(): void** Ejecuta el movimiento del cometa y sus variaciones.
    * **pintar(): void** Añade la imagen y la estela o historia del cometa.
    * **actualizar(): void** Le añade movimiento a la imagen y determina un tamaño para la estela.
    * **perseguir(PVector): void** Recibe un objetivo o punto de llegada del cometa. Añade fuerzas, velocidades y limita su movimiento.
    * **borrar(): boolean** Devuelve _true_ si el cometa se ha salido de la zona de juego y _false_ en caso contrario.
    * **getH(): Thread** Devuelve la variable hilo encargada de ejecutarse en la clase _Mundo_.
