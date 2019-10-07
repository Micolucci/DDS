/*
	Se crean 7 prendas (con sus tipos, colores, materiales, etc)
	Se crea un usuario gratuito con 2 guardarropas
	Se le agregan distintas prendas a los guardarropas
	Se muestran por pantalla las distintas prendas del guardarropas
	se aceptan y rechazan sugerencias pero no intervienen ni prendas ni usuarios
*/

package main;

import java.util.HashSet;
import java.util.Set;

import componentes.Categoria;
import componentes.Color;
import componentes.Material;
import componentes.Prenda;
import componentes.PrendaNivel;
import componentes.TipoDePrenda;
import componentes.Trama;
import eventos.Sugerencia;
import guardarropas.Guardarropa;
import repositorio.Repositorio;
import usuario.Usuario;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class mainCreacionUsuariosGuardarropasPrendas {
	
	private static final String PERSISTENCE_UNIT_NAME = "DDS";
	private static EntityManagerFactory emFactory;
	private static Repositorio repositorio;
	
	public static void main(String[] args) throws Exception {
		
		emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		repositorio = new Repositorio(emFactory.createEntityManager());
		
		System.out.println("Arrancando");
		
		Set <Material> tiposDeMaterialRemera;
		Set <Material> tiposDeMaterialZapato;
		Set <Material> tiposDeMaterialZapatilla;
		Set <Material> tiposDeMaterialPantalon;
		Set <Material> tiposDeMaterialLentes;
		 
		Usuario ines = new Usuario("Ines");
		
		TipoDePrenda zapato;
		TipoDePrenda remera;
		TipoDePrenda pantalon;
		TipoDePrenda zapatilla;
		TipoDePrenda lentes;
		Color colorBlanco;
		Color colorRojo;
		Color colorNegro;
		Prenda unaRemeraBlancaLisa;
		Prenda unaRemeraRoja;
		Prenda unPantalonNegro;
		Prenda unZapatoNegro;
		Prenda unaZapatillaLonaBlanca;
		Prenda unLenteNegro;
		Guardarropa guardarropaInesUno;

		tiposDeMaterialRemera = new HashSet<Material>();
		tiposDeMaterialPantalon = new HashSet<Material>();
		tiposDeMaterialZapato= new HashSet<Material>();
		tiposDeMaterialZapatilla= new HashSet<Material>();
		tiposDeMaterialLentes = new HashSet<Material>();
		
		tiposDeMaterialRemera.add(Material.ALGODON);
		tiposDeMaterialRemera.add(Material.SEDA);
		tiposDeMaterialPantalon.add(Material.BENGALINA);
		tiposDeMaterialPantalon.add(Material.CORDEROY);
		tiposDeMaterialPantalon.add(Material.JEAN);
		tiposDeMaterialZapato.add(Material.CUERINA);
		tiposDeMaterialZapato.add(Material.CUERO);
		tiposDeMaterialZapatilla.add(Material.CUERINA);
		tiposDeMaterialZapatilla.add(Material.CUERO);
		tiposDeMaterialZapatilla.add(Material.LONA);
		tiposDeMaterialLentes.add(Material.PLASTICO);
		
		colorBlanco=new Color(255,255,0);
		colorNegro=new Color(10,10,10);
		colorRojo=new Color (255,0,0);
			
		remera = new  TipoDePrenda("Remera",Categoria.PARTE_SUPERIOR, tiposDeMaterialRemera,PrendaNivel.Nivel1);
		zapato= new TipoDePrenda("Zapato", Categoria.CALZADO, tiposDeMaterialZapato,PrendaNivel.Nivel2);
		zapatilla = new TipoDePrenda("Zapatilla", Categoria.CALZADO, tiposDeMaterialZapatilla,PrendaNivel.Nivel2);
		pantalon = new TipoDePrenda("Pantalon",Categoria.PARTE_INFERIOR, tiposDeMaterialPantalon,PrendaNivel.Nivel3);
		lentes = new TipoDePrenda("Lentes de sol", Categoria.ACCESORIO, tiposDeMaterialLentes,PrendaNivel.Nivel1);
		
		unaRemeraBlancaLisa = new Prenda("Remera Blanca lisa", remera, Material.ALGODON, colorBlanco, Trama.LISA );
		unaRemeraRoja= new Prenda("Remera Roja a lunares", remera, Material.SEDA, colorRojo, Trama.LUNARES);
		unPantalonNegro = new Prenda("Pantalon Negro", pantalon, Material.CORDEROY, colorNegro, Trama.LISA);
		unZapatoNegro= new Prenda("Zapatos Negros", zapato, Material.CUERO, colorNegro, Trama.LISA);
		unaZapatillaLonaBlanca= new Prenda("Zapatillas de lona blancas", zapatilla, Material.LONA, colorBlanco, Trama.LISA);
		unLenteNegro = new Prenda("Lentes de sol  negros", lentes, Material.PLASTICO, colorNegro, Trama.LISA);
		
		/*Persistiendo*/
		repositorio.prenda().persistir(unaRemeraBlancaLisa);
		repositorio.prenda().persistir(unaRemeraRoja);
		repositorio.prenda().persistir(unPantalonNegro);
		repositorio.prenda().persistir(unZapatoNegro);
		repositorio.prenda().persistir(unaZapatillaLonaBlanca);
		repositorio.prenda().persistir(unLenteNegro);
		
		repositorio.cerrar();
		emFactory.close();
		
		guardarropaInesUno = new Guardarropa();
	    guardarropaInesUno.duenio(ines);
	    
	    guardarropaInesUno.agregarAGuardarropas(unaRemeraBlancaLisa);
	    guardarropaInesUno.agregarAGuardarropas(unaRemeraRoja);
	    guardarropaInesUno.agregarAGuardarropas(unPantalonNegro);
	    guardarropaInesUno.agregarAGuardarropas(unZapatoNegro);
	    guardarropaInesUno.agregarAGuardarropas(unaZapatillaLonaBlanca);
	    guardarropaInesUno.agregarAGuardarropas(unLenteNegro); 	
	    
	    System.out.println("el guardarropas tiene: " + guardarropaInesUno.getPrendasSuperioresNivel1().size() + " prendas superiores");
	    System.out.println("el guardarropas tiene: " + guardarropaInesUno.getPrendasInferioresNivel3().size() + " prendas inferiores");
	    System.out.println("el guardarropas tiene: " + guardarropaInesUno.getCalzadosNivel2().size() + " calzados");
	    System.out.println("el guardarropas tiene: " + guardarropaInesUno.getAccesorios().size() + " accesorio");
		//guardarropaInesUno.sugerir();
		//QueMePongo.sugerirTodasLasCombinaciones(guardarropaInesUno);
	    
	    
	    //PROBANDO CALIFICAR SUGERENCIAS
	    
	      
	    Sugerencia sugerencia1 = new Sugerencia();
	    Sugerencia sugerencia2 = new Sugerencia();
	    Sugerencia sugerencia3 = new Sugerencia();
	    
	    sugerencia1.setDescripcion("sugerencia buena");
	    sugerencia2.setDescripcion("sugerencia meh");
	    sugerencia3.setDescripcion("sugerencia pedorra");
	    
	    ines.aceptarSugerencia(sugerencia1);
	    ines.aceptarSugerencia(sugerencia2);
	    ines.rechazarSugerencia(sugerencia3);
	    
	    
	    ines.calificarSugerencia(sugerencia1,3);
	    ines.calificarSugerencia(sugerencia2,2);
	    
	    System.out.println("Ahora Ines intenta calificar una sugerencia rechazada =>");
	    ines.calificarSugerencia(sugerencia3,1); 
	}
	
}
