package usuario;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import eventos.CommandObtenerSugerenciaParaEvento;
import eventos.EnumEstadoSugerencia;
import eventos.Evento;
import eventos.Sugerencia;
import guardarropas.Guardarropa;

public class Usuario {
	
	private String nombreDeUsuario;
	private String mail;
	private List<Guardarropa> guardarropas = new ArrayList<>();
	private List<Evento> eventos = new ArrayList<Evento>();
	
	private Cuenta tipoDeCuenta = new CuentaGratuita();
	
	private PercepcionDeTemperatura percepcion = new PercepcionDeTemperatura(); 
	
	// Getters
	public List<Guardarropa> getGuardarropas() {
		return guardarropas;
	}
	
	public Cuenta getTipoDeCuenta() {
		return tipoDeCuenta;
	}
	public String getNombre() {
		return nombreDeUsuario;
	}
	
	public PercepcionDeTemperatura getPercepcion() {
		return percepcion;
	}
	
	public String getMail() {return mail;}
	
	// Setters
	public void setNombre(String nombre) {
		this.nombreDeUsuario =nombre;
	}
	
	public void setTipoDeCuenta(Cuenta tipoDeCuenta) {
		this.tipoDeCuenta = tipoDeCuenta;
	}
	public void setMail(String m) {this.mail = m;}
	
	
	// Métodos con guardarropas
	public void agregarGuardarropa(Guardarropa guardarropa) {
		guardarropas.add(requireNonNull(guardarropa));
		guardarropa.duenio(this);
	}
	
	public boolean tieneGuardarropaLleno(Guardarropa guardarropa) {
		return tipoDeCuenta.tieneGuardarropaLleno(guardarropa);
	}

	
	//Métodos con Eventos
	public void cargarEvento(LocalDate fecha, String descripcion, int ubicacion) throws Exception{
		Evento evento = new Evento(fecha, descripcion, this, ubicacion);
		this.eventos.add(evento);
		evento.procesarEvento();
	}
	
	public void procesarEvento(Evento evento) throws IOException {
		
		CommandObtenerSugerenciaParaEvento sugerenciaParaEvento = new CommandObtenerSugerenciaParaEvento();
		sugerenciaParaEvento.execute(evento);

	}
	
	
	//Métodos con Sugerencias
	
	// los usuarios tendrán la posibilidad de, una vez aceptada una sugerencia, calificarla.
	// esta calificación (del 1 al 3) servirá para, si le gusto,  
	// volver a sugerirla en próximos eventos  
	
	public void aceptarSugerencia(Sugerencia unaSugerencia) {
		unaSugerencia.setEstado(EnumEstadoSugerencia.ACEPTADA);
	}
	
	public void rechazarSugerencia(Sugerencia unaSugerencia) {
		unaSugerencia.setEstado(EnumEstadoSugerencia.RECHAZADA);
	}
	
	public void calificarSugerencia(Sugerencia unaSugerencia, int unaCalificacion) throws Exception {
		if( unaSugerencia.getEstado() == EnumEstadoSugerencia.ACEPTADA) {
			unaSugerencia.setCalificacion(unaCalificacion);
		}else {
			throw new Exception("Ingrese una sugerencia ACEPTADA");
		}
	}
	
	// La idea es que el usuario una vez aceptada una sugerencia, la evalua en su conjunto (del 1 al 3)
	// y luego califique parte por parte para saber que tan friolento o caluroso es en esa parte del cuerpo
	// este valor es del -2 al 2 (siendo -2 algo asi como que el usuario se está cagando de frio con eso y 
	// (+2) que se está cagando de calor
	
	public void calificarMiPercepcion(int percepcionCabeza,	int percepcionTorso,int percepcionPiernas) {
		percepcion.modificarPercepcionCabeza(percepcionCabeza); 
		percepcion.modificarPercepcionTorso(percepcionTorso); 
		percepcion.modificarPercepcionPiernas(percepcionPiernas); 
	}
	

	
//	public void calificarPrenda(Prenda unaPrenda, int calificacion) {
//		unaPrenda.setCalificacion(calificacion);
//	}
	
}