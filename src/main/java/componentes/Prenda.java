package componentes;

import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Entity;

@Entity
@Table(name = "PRENDA")
public class Prenda extends Entidad {
	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "colorPrincipal", referencedColumnName = "id")
	@Transient
    private Color colorPrincipal;
	@Transient
    private Color colorSecundario;
	@Transient
    private Material material;
	@Transient
    private TipoDePrenda tipo;
	@Transient
    private Trama trama;
	@Transient
	private String urlImagen;
	private int calificacion=0;
	
	private String jpa_colorPpal;
	private String jpa_colorSec;	
	private String jpa_material;
	private String jpa_trama;
	private String jpa_categoria;
	private String jpa_nivel;
	
    public Prenda() {}

    //Constructor: Se puede construir una prenda con o sin color secundario.
    public Prenda(String nombre, TipoDePrenda tipo, Material material, Color colorPrincipal, Trama trama) {
    	Validaciones.validarCreacionPrenda(nombre, tipo, material, colorPrincipal, trama);
    	asignarValoresAPrenda(nombre, tipo, material, colorPrincipal, null, trama);    	
	}

    public Prenda(String nombre,TipoDePrenda tipo,  Material material, Color colorPrincipal, Color colorSecundario, Trama trama){
    	Validaciones.validarCreacionPrenda(nombre, tipo, material, colorPrincipal, colorSecundario, trama);
		asignarValoresAPrenda(nombre, tipo, material, colorPrincipal,colorSecundario,trama);
        
    }
    
    private void asignarValoresAPrenda(String nombre, TipoDePrenda tipo, Material material, Color cPpal, Color cSec, Trama trama) {
       	this.nombre = nombre;
		this.tipo = tipo;
        this.material = material;
        this.colorPrincipal = cPpal;
        this.trama = trama;
        this.colorSecundario = cSec;
        ///
        this.jpa_material = material.name();
    	this.jpa_colorPpal = cPpal.getternaColores();
    	this.jpa_categoria = tipo.getCategoria().name();
  		this.jpa_nivel = tipo.getNivel().name();
    	this.jpa_colorSec = cSec.getternaColores();
    	this.jpa_trama = trama.name();
	}
    
    /*    
    public boolean esDeInvierno() {
    	return true;
    }
    
    public boolean esDeVerano() {
    	return true;
    }
 	*/    


    //Lo unico que podriamos cambiar de una prenda es el nombre .
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//ESTE METODO LO USAMOS PARA QUE NOS DEVUELVA LA POSICION EN MEMORIA CUANDO QUEREMOS IMPRIMIR POR CONSOLA LA LISTA DE PRENDAS
	public String toString() {
		return this.getNombre();
	}
	
	//Getters
	public String getNombre() {
		return nombre;
	}
    public Color getColor() {
        return colorPrincipal;
    }
    public Color getColorSecundario() {
    	return colorSecundario;
    }
    public Material getMaterial() {
        return material;
    }
    public TipoDePrenda getTipo() {
        return tipo;
    }
    public Trama getTrama() {
        return trama;
    }
    public Categoria getCategoria() {
        return tipo.getCategoria();
    }
	public PrendaNivel getNivel() {
		return tipo.getNivel();
	}
	public String getUrlImagen() {
		return urlImagen;
	}
	public int getCalificacion() {
		return calificacion;
	}

    
    // Ver si vamos a usar los setter. 
	public void setColorPrincipal(Color colorPrincipal) {
		this.colorPrincipal = colorPrincipal;
	}
	public void setColorSecundario(Color colorSecundario) {
		this.colorSecundario = colorSecundario;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public void setTipo(TipoDePrenda tipo) {
		this.tipo = tipo;
	}
	public void setTrama(Trama trama) {
		this.trama = trama;
	}
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
	public void setCalificacion(int unaCalificacion) {
		this.calificacion=unaCalificacion;
	}
	/*
	public void setNivel(PrendaNivel nivel) {
		this.tipo.setNivel(nivel);
	}*/
	
}