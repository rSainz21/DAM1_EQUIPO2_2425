/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.retoequipo2;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.TreeSet;
             /**
 *Clase que representa las Rutas que serán añadidas, modificadas y borradas en la base de datos junto con
 * sus atributos
 *
 *
 * @author Rubén
 */
public class Ruta {

    private int id_ruta;
    private String nombre;
    private LocalDate fecha;
    private double longitud_ini;
    private double latitud_ini;
    private double longitud_fin;
    private double latitud_fin;
    private int distancia_total;
    private int duracion;
    private double latitud_max;
    private double longitud_max;
    private CLASIFICACION clasificacion;
    private int nivel_riesgo;
    private int nivel_esfuerzo;
    private int desnivel_acumulado;
    private int tipo_terreno;
    private int indicaciones;
    private Actividad actividad;
    private Periodo periodo;
    private boolean accesible_inclusivo;
    private boolean familiar;
    private String url_gpx;
    private boolean validada;
    private String recomendaciones;
    private String zona_geografica;
    private double valoracion_media;
    private Usuario creador;
    private TreeSet<Puntos_ruta> puntos_ruta;
    private LinkedList<Resena> resenas;
    private LinkedList<Valoracion> valoraciones;
    private LinkedList<Periodo> periodos;
    private LinkedList<Actividad> actividades;

             /**
 *Crea una instancia de Ruta con todos sus atributos
 *
 *
 * @param id_ruta representa el id de la ruta en la base de datos
 * @param nombre nombre de la ruta
 * @param fecha fecha de creacion de la ruta
 * @param longitud_ini longitud en la que empieza la ruta
 * @param latitud_ini latitud en la que empieza la ruta
 * @param longitud_fin longitud en la que termina la ruta
 * @param latitud_fin latitud en la que termina la ruta
 * @param distancia_total kms de recorrido de la ruta
 * @param duracion minutos que dura la ruta aproximadamente
 * @param latitud_max latitud máxima de la ruta
 * @param longitud_max longitud máxima de la ruta
 * @param clasificacion enum que representa el tipo de ruta
 * @param indicaciones clasificacion del 1-5 para calcular cómo de bien señalizada está la ruta
 * @param desnivel_acumulado clasificacion del 1-5 para calcular el nivel de esfuerzo que requiere la ruta
 * @param tipo_terreno clasificacion del 1-5 para 
 * @param accesible_inclusivo indica si se trata de una ruta con accesibilidad
 * @param familiar indica si se trata de una ruta familiar
 * @param url_gpx dirección del gpx de la ruta
 * @param recomendaciones recomendaciones a la hora de hacer la ruta
 * @param zona_geografica Localizacion de la ruta
 * @param creador objeto de tipo {@link Usuario} que representa al usuario creador de la ruta
 */ 
    public Ruta(int id_ruta, String nombre, LocalDate fecha, double longitud_ini, double latitud_ini, double longitud_fin, double latitud_fin, int distancia_total, int duracion, double latitud_max, double longitud_max, CLASIFICACION clasificacion, int desnivel_acumulado, int tipo_terreno, int indicaciones, boolean accesible_inclusivo, boolean familiar, String url_gpx, String recomendaciones, String zona_geografica, Usuario creador) {
        puntos_ruta = new TreeSet<>();
        resenas = new LinkedList<>();
        valoraciones = new LinkedList<>();
        periodos = new LinkedList<>();
        actividades = new LinkedList<>();
        this.id_ruta = id_ruta;
        this.nombre = nombre;
        this.fecha = fecha;
        this.longitud_ini = longitud_ini;
        this.latitud_ini = latitud_ini;
        this.longitud_fin = longitud_fin;
        this.latitud_fin = latitud_fin;
        this.distancia_total = distancia_total;
        this.duracion = duracion;
        this.latitud_max = latitud_max;
        this.longitud_max = longitud_max;
        this.clasificacion = clasificacion;
        this.nivel_riesgo = calcularRiesgo();
        this.nivel_esfuerzo = calcularEsfuerzo();
        this.desnivel_acumulado = desnivel_acumulado;
        this.tipo_terreno = tipo_terreno;
        this.indicaciones = indicaciones;
        this.actividad = new Actividad();
        this.periodo = new Periodo();
        this.accesible_inclusivo = accesible_inclusivo;
        this.familiar = familiar;
        this.url_gpx = url_gpx;
        this.validada = false;
        this.recomendaciones = recomendaciones;
        this.zona_geografica = zona_geografica;
        this.valoracion_media=0;
        this.creador = creador;
    }
         /**
 *Crea una instancia de Ruta con todos sus atributos menos el id.
 *
 *
 * @param nombre nombre de la ruta
 * @param fecha fecha de creacion de la ruta
 * @param longitud_ini longitud en la que empieza la ruta
 * @param latitud_ini latitud en la que empieza la ruta
 * @param longitud_fin longitud en la que termina la ruta
 * @param latitud_fin latitud en la que termina la ruta
 * @param distancia_total kms de recorrido de la ruta
 * @param duracion minutos que dura la ruta aproximadamente
 * @param latitud_max latitud máxima de la ruta
 * @param longitud_max longitud máxima de la ruta
 * @param clasificacion enum que representa el tipo de ruta
 * @param indicaciones clasificacion del 1-5 para calcular cómo de bien señalizada está la ruta
 * @param desnivel_acumulado clasificacion del 1-5 para calcular el nivel de esfuerzo que requiere la ruta
 * @param tipo_terreno clasificacion del 1-5 para 
 * @param accesible_inclusivo indica si se trata de una ruta con accesibilidad
 * @param familiar indica si se trata de una ruta familiar
 * @param url_gpx dirección del gpx de la ruta
 * @param recomendaciones recomendaciones a la hora de hacer la ruta
 * @param zona_geografica Localizacion de la ruta
 * @param creador objeto de tipo {@link Usuario} que representa al usuario creador de la ruta
 */ 
    public Ruta(String nombre, LocalDate fecha, double longitud_ini, double latitud_ini, double longitud_fin, double latitud_fin, int distancia_total, int duracion, double latitud_max, double longitud_max, CLASIFICACION clasificacion, int desnivel_acumulado, int tipo_terreno, int indicaciones, boolean accesible_inclusivo, boolean familiar, String url_gpx, String recomendaciones, String zona_geografica, Usuario creador) {
        puntos_ruta = new TreeSet<>();
        resenas = new LinkedList<>();
        valoraciones = new LinkedList<>();
        periodos = new LinkedList<>();
        actividades = new LinkedList<>();
        this.nombre = nombre;
        this.fecha = fecha;
        this.longitud_ini = longitud_ini;
        this.latitud_ini = latitud_ini;
        this.longitud_fin = longitud_fin;
        this.latitud_fin = latitud_fin;
        this.distancia_total = distancia_total;
        this.duracion = duracion;
        this.latitud_max = latitud_max;
        this.longitud_max = longitud_max;
        this.clasificacion = clasificacion;
        this.nivel_riesgo = calcularRiesgo();
        this.nivel_esfuerzo = calcularEsfuerzo();
        this.desnivel_acumulado = desnivel_acumulado;
        this.tipo_terreno = tipo_terreno;
        this.indicaciones = indicaciones;
        this.actividad = new Actividad();
        this.periodo = new Periodo();
        this.accesible_inclusivo = accesible_inclusivo;
        this.familiar = familiar;
        this.url_gpx = url_gpx;
        this.validada = false;
        this.recomendaciones = recomendaciones;
        this.zona_geografica = zona_geografica;
        this.valoracion_media=0;
        this.creador = creador;

    }

    public int getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(int id_ruta) {
        this.id_ruta = id_ruta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getLongitud_ini() {
        return longitud_ini;
    }

    public void setLongitud_ini(double longitud_ini) {
        this.longitud_ini = longitud_ini;
    }

    public double getLatitud_ini() {
        return latitud_ini;
    }

    public void setLatitud_ini(double latitud_ini) {
        this.latitud_ini = latitud_ini;
    }

    public double getLongitud_fin() {
        return longitud_fin;
    }

    public void setLongitud_fin(double longitud_fin) {
        this.longitud_fin = longitud_fin;
    }

    public double getLatitud_fin() {
        return latitud_fin;
    }

    public void setLatitud_fin(double latitud_fin) {
        this.latitud_fin = latitud_fin;
    }

    public int getDistancia_total() {
        return distancia_total;
    }

    public void setDistancia_total(int distancia_total) {
        this.distancia_total = distancia_total;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public CLASIFICACION getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(CLASIFICACION clasificacion) {
        this.clasificacion = clasificacion;
    }

    public int getNivel_riesgo() {
        return nivel_riesgo;
    }

    public void setNivel_riesgo(int nivel_riesgo) {
        this.nivel_riesgo = nivel_riesgo;
    }

    public int getNivel_esfuerzo() {
        return nivel_esfuerzo;
    }

    public void setNivel_esfuerzo(int nivel_esfuerzo) {
        this.nivel_esfuerzo = nivel_esfuerzo;
    }

    public int getDesnivel_acumulado() {
        return desnivel_acumulado;
    }

    public void setDesnivel_acumulado(int desnivel_acumulado) {
        this.desnivel_acumulado = desnivel_acumulado;
    }

    public int getTipo_terreno() {
        return tipo_terreno;
    }

    public void setTipo_terreno(int tipo_terreno) {
        this.tipo_terreno = tipo_terreno;
    }

    public int getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(int indicaciones) {
        this.indicaciones = indicaciones;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public boolean isAccesible_inclusivo() {
        return accesible_inclusivo;
    }

    public void setAccesible_inclusivo(boolean accesible_inclusivo) {
        this.accesible_inclusivo = accesible_inclusivo;
    }

    public boolean isFamiliar() {
        return familiar;
    }

    public void setFamiliar(boolean familiar) {
        this.familiar = familiar;
    }

    public String getUrl_gpx() {
        return url_gpx;
    }

    public void setUrl_gpx(String url_gpx) {
        this.url_gpx = url_gpx;
    }

    public boolean isValidada() {
        return validada;
    }

    public void setValidada(boolean validada) {
        this.validada = validada;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public String getZona_geografica() {
        return zona_geografica;
    }

    public void setZona_geografica(String zona_geografica) {
        this.zona_geografica = zona_geografica;
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    public TreeSet<Puntos_ruta> getPuntos_ruta() {
        return puntos_ruta;
    }

    public void setPuntos_ruta(TreeSet<Puntos_ruta> puntos_ruta) {
        this.puntos_ruta = puntos_ruta;
    }

    public LinkedList<Resena> getResenas() {
        return resenas;
    }

    public void setResenas(LinkedList<Resena> resenas) {
        this.resenas = resenas;
    }

    public LinkedList<Valoracion> getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(LinkedList<Valoracion> valoraciones) {
        this.valoraciones = valoraciones;
    }

    public double getLatitud_max() {
        return latitud_max;
    }

    public void setLatitud_max(double latitud_max) {
        this.latitud_max = latitud_max;
    }

    public double getLongitud_max() {
        return longitud_max;
    }

    public void setLongitud_max(double longitud_max) {
        this.longitud_max = longitud_max;
    }

    public double getValoracion_media() {
        return valoracion_media;
    }

    public void setValoracion_media(double valoracion_media) {
        this.valoracion_media = valoracion_media;
    }
         /**
 *Metodo que calcula el nivel de riesgo de la ruta en funcion de los puntos de peligro registrados en la misma
 *
 *
 * @author Rubén
 */ 
    private int calcularRiesgo() {
        int riesgo = 0;
        int riesgoAcumulado = 0;
        int pps = 0;
        if (!puntos_ruta.isEmpty()) {
            for (Puntos_ruta p : puntos_ruta) {
                if (p instanceof Punto_peligro) {
                    riesgoAcumulado += ((Punto_peligro) p).getNivel_gravedad();
                    pps++;
                }
            }
            riesgo = Math.round((float) riesgoAcumulado / pps);
        }
        return riesgo;
    }
         /**
 *Metodo que calcula la valoracion media de la ruta en funcion de las valoraciones que tenga registradas
 *
 *
 * @author Rubén
 */ 
    private double calcularValoMedia() {
        double valo_media = 0;
        double valo_acumulada = 0;
        if (!this.valoraciones.isEmpty()) {
            for (Valoracion valo : valoraciones) {
                valo_acumulada += ((valo.getBelleza() + valo.getDificultad() + valo.getInteres_cultural()) / 3.0);
            }
            valo_media = valo_acumulada / valoraciones.size();
        }
        return valo_media;
    }
         /**
 *Metodo que calcula el nivel de esfuerzo de la ruta en base a los atributos de la misma
 *
 *
 * @author Rubén
 */ 
    private int calcularEsfuerzo() {
        int esfDuracion = 0;
        if (this.duracion < 31) {
            esfDuracion = 2;
        } else if (this.duracion > 30) {
            esfDuracion = 4;
        } else if (this.duracion > 60) {
            esfDuracion = 6;
        } else if (this.duracion > 120) {
            esfDuracion = 8;
        }
        int esfDistancia = 0;
        if (this.distancia_total < 5) {
            esfDistancia = 2;
        } else if (this.distancia_total > 5) {
            esfDistancia = 3;
        } else if (this.distancia_total > 10) {
            esfDistancia = 4;
        } else if (this.distancia_total > 15) {
            esfDistancia = 5;
        } else if (this.distancia_total > 20) {
            esfDistancia = 6;
        } else if (this.distancia_total > 25) {
            esfDistancia = 7;
        } else if (this.distancia_total > 30) {
            esfDistancia = 8;
        }

        int esfDesnivel = 0;
        if (this.desnivel_acumulado < 100) {
            esfDesnivel = 2;
        } else if (this.desnivel_acumulado > 100) {
            esfDesnivel = 3;
        } else if (this.desnivel_acumulado > 300) {
            esfDesnivel = 4;
        } else if (this.desnivel_acumulado > 500) {
            esfDesnivel = 5;
        } else if (this.desnivel_acumulado > 600) {
            esfDesnivel = 6;
        } else if (this.desnivel_acumulado > 800) {
            esfDesnivel = 7;
        } else if (this.desnivel_acumulado > 100) {
            esfDesnivel = 8;
        }
        return Math.round((float) (esfDuracion + esfDistancia + esfDesnivel) / 3);
    }
         /**
 *Inserta un punto de ruta en la lista de puntos de ruta de la ruta
 *
 * @param pr objeto de tipo {@link Puntos_ruta} que representa el punto de ruta a añadir
 * @author Rubén
 * @return {@code true} si el punto fue añadido a la lista; {@code false} en caso contrario
 */ 
    public boolean insertaPuntosRuta(Puntos_ruta pr) {
        boolean insertado = false;
        if (this.puntos_ruta.add(pr)) {
            insertado = true;
        }
        return insertado;
    }
         /**
 *Inserta una reseña en la lista de reseñas de la ruta
 *
 * @author Rubén
 * @param resena objeto de tipo {@link Resena} que representa la reseña a añadir
 * @return {@code true} si la reseña se añadió a la lista; {@code false} en caso contrario
 */
    public boolean insertaResena(Resena resena) {
        boolean insertada = false;
        if (this.resenas.add(resena)) {
            insertada = true;
        }
        return insertada;
    }
         /**
 *Inserta una Valoracion la lista de valoraciones de la ruta
 *
 * @author Rubén
 * @param valo objeto de tipo {@link Valoracion} que representa la valoracion a añadir
 * @return {@code true} si la Valoracion se insertó en la lista; {@code false} en caso contrario
 */
    public boolean insertaValoracion(Valoracion valo) {
        boolean insertada = false;
        if (this.valoraciones.add(valo)) {
            insertada = true;
        }
        return insertada;
    }
         /**
 *Borra un punto de ruta en la lista de puntos de ruta de la ruta
 *
 * @author Rubén
 * @param pr objeto de tipo {@link Puntos_ruta} que representa el punto de ruta a borrar
 * @return {@code true} si el punto de ruta fue borrado de la lista; {@code false} en caso contrario
 */ 
    public boolean borraPuntoRuta(Puntos_ruta pr) {
        boolean borrado = false;
        if (this.puntos_ruta.contains(pr)) {
            puntos_ruta.remove(pr);
            borrado = true;
        }
        return borrado;
    }
         /**
 *Borra una reseña en la lista de reseñas de la ruta
 *
 * @author Rubén
 * @param resena objeto de tipo {@link Resena} que representa la reseña a borrar
 * @return {@code true} si la reseña se borró de la lista; {@code false} en caso contrario
 */
    public boolean borraResena(Resena resena) {
        boolean borrada = false;
        if (this.resenas.contains(resena)) {
            resenas.remove(resena);
            borrada = true;
        }
        return borrada;
    }
         /**
 *Borra una Valoracion de la lista de valoraciones de la ruta
 *
 * @author Rubén
 * @param valo objeto de tipo {@link Valoracion} que representa la valoracion a borrar
 * @return {@code true} si la Valoración fue borrada de la lista; {@code false} en caso contrario
 */
    public boolean borraValoracion(Valoracion valo) {
        boolean borrada = false;
        if (this.valoraciones.contains(valo)) {
            valoraciones.remove(valo);
            borrada = true;
        }
        return borrada;
    }
}
