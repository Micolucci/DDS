/*
 * package tests;
 * 
 * import org.junit.Before; import org.junit.Test;
 * 
 * import static org.junit.Assert.assertEquals;
 * 
 * import java.util.HashSet; import java.util.Set;
 * 
 * import componentes.*; import guardarropas.*; import usuario.*;
 * 
 * 
 * public class TestPrenda {
 * 
 * private Set <Material> tiposDeMaterialRemera; private Set <Material>
 * tiposDeMaterialZapato; private Set <Material> tiposDeMaterialZapatilla;
 * private Set <Material> tiposDeMaterialPantalon; private Set <Material>
 * tiposDeMaterialLentes;
 * 
 * Usuario ines = new Usuario("Ines"); Usuario sandra = new Usuario("Sandra");
 * //la amiga con plata de ines
 * 
 * TipoDePrenda zapato; TipoDePrenda remera; TipoDePrenda pantalon; TipoDePrenda
 * zapatilla; TipoDePrenda lentes; Color colorBlanco; Color colorRojo; Color
 * colorVerde; Color colorNegro; Color colorAzulTrafico; Color colorFucsia;
 * Prenda unaRemeraBlancaLisa; Prenda unaRemeraRoja; Prenda unaRemeraNegra;
 * Prenda unPantalonNegro; Prenda unZapatoNegro; Prenda unaZapatillaLonaBlanca;
 * Prenda unLenteNegro; Guardarropa guardarropaInesUno; Guardarropa
 * guardarropaInesDos;
 * 
 * @Before public void init() throws Exception { tiposDeMaterialRemera = new
 * HashSet<Material>(); tiposDeMaterialPantalon = new HashSet<Material>();
 * tiposDeMaterialZapato= new HashSet<Material>(); tiposDeMaterialZapatilla= new
 * HashSet<Material>(); tiposDeMaterialLentes = new HashSet<Material>();
 * 
 * tiposDeMaterialRemera.add(Material.ALGODON);
 * tiposDeMaterialRemera.add(Material.SEDA);
 * tiposDeMaterialPantalon.add(Material.BENGALINA);
 * tiposDeMaterialPantalon.add(Material.CORDEROY);
 * tiposDeMaterialPantalon.add(Material.JEAN);
 * tiposDeMaterialZapato.add(Material.CUERINA);
 * tiposDeMaterialZapato.add(Material.CUERO);
 * tiposDeMaterialZapatilla.add(Material.CUERINA);
 * tiposDeMaterialZapatilla.add(Material.CUERO);
 * tiposDeMaterialZapatilla.add(Material.LONA);
 * tiposDeMaterialLentes.add(Material.PLASTICO);
 * 
 * 
 * colorBlanco=new Color(255,255,0); colorVerde=new Color(0,255,0);
 * colorNegro=new Color(10,10,10); colorRojo=new Color (255,0,0);
 * colorAzulTrafico=new Color(006,057,113);
 * 
 * 
 * remera = new TipoDePrenda("Remera",Categoria.PARTE_SUPERIOR,
 * tiposDeMaterialRemera,PrendaNivel.Nivel1); zapato= new TipoDePrenda("Zapato",
 * Categoria.CALZADO, tiposDeMaterialZapato,PrendaNivel.Nivel2); zapatilla = new
 * TipoDePrenda("Zapatilla", Categoria.CALZADO,
 * tiposDeMaterialZapatilla,PrendaNivel.Nivel2); pantalon = new
 * TipoDePrenda("Pantalon",Categoria.PARTE_INFERIOR,
 * tiposDeMaterialPantalon,PrendaNivel.Nivel2); lentes = new
 * TipoDePrenda("Lentes de sol", Categoria.ACCESORIO,
 * tiposDeMaterialLentes,PrendaNivel.Nivel1);
 * 
 * unaRemeraBlancaLisa = new Prenda("Remera Blanca lisa", remera,
 * Material.ALGODON, colorBlanco, Trama.LISA ); unaRemeraRoja= new
 * Prenda("Remera Roja a lunares", remera, Material.SEDA, colorRojo,
 * Trama.LUNARES); unaRemeraNegra= new Prenda("Remera Negra Basica", remera,
 * Material.ALGODON, colorNegro, Trama.LISA); unPantalonNegro = new
 * Prenda("Pantalon Negro", pantalon, Material.CORDEROY, colorNegro,
 * Trama.LISA); unZapatoNegro= new Prenda("Zapatos Negros", zapato,
 * Material.CUERO, colorNegro, Trama.LISA); unaZapatillaLonaBlanca= new
 * Prenda("Zapatillas de lona blancas", zapatilla, Material.LONA, colorBlanco,
 * Trama.LISA); unLenteNegro = new Prenda("Lentes de sol  negros", lentes,
 * Material.PLASTICO, colorNegro, Trama.LISA);
 * 
 * sandra.setTipoDeCuenta(new CuentaPremium());
 * 
 * guardarropaInesUno = new Guardarropa(); guardarropaInesDos = new
 * Guardarropa();
 * 
 * guardarropaInesUno.duenio(ines); guardarropaInesDos.duenio(ines);
 * 
 * guardarropaInesUno.agregarAGuardarropas(unaRemeraBlancaLisa);
 * guardarropaInesUno.agregarAGuardarropas(unaRemeraRoja);
 * guardarropaInesUno.agregarAGuardarropas(unPantalonNegro);
 * guardarropaInesUno.agregarAGuardarropas(unZapatoNegro);
 * guardarropaInesUno.agregarAGuardarropas(unaZapatillaLonaBlanca);
 * guardarropaInesUno.agregarAGuardarropas(unLenteNegro);
 * 
 * guardarropaInesDos.agregarAGuardarropas(unaRemeraNegra);
 * 
 * }
 * 
 * @Test public void testCategoria() { assertEquals(
 * unaRemeraBlancaLisa.getCategoria(),Categoria.PARTE_SUPERIOR); assertEquals(
 * unaRemeraRoja.getCategoria(),Categoria.PARTE_SUPERIOR); assertEquals(
 * unPantalonNegro.getCategoria(),Categoria.PARTE_INFERIOR); assertEquals(
 * unZapatoNegro.getCategoria(),Categoria.CALZADO); assertEquals(
 * unaZapatillaLonaBlanca.getCategoria(),Categoria.CALZADO); assertEquals(
 * unLenteNegro.getCategoria(),Categoria.ACCESORIO); }
 * 
 * @Test public void testMaterialOkey() { assertEquals(
 * unaRemeraBlancaLisa.getMaterial(),Material.ALGODON); assertEquals(
 * unaRemeraRoja.getMaterial(),Material.SEDA); assertEquals(
 * unPantalonNegro.getMaterial(),Material.CORDEROY); assertEquals(
 * unZapatoNegro.getMaterial(),Material.CUERO); assertEquals(
 * unaZapatillaLonaBlanca.getMaterial(),Material.LONA); assertEquals(
 * unLenteNegro.getMaterial(),Material.PLASTICO); }
 * 
 * //@Test(expected = Exception.class) public void testMaterialFalla() throws
 * Exception {
 * 
 * @SuppressWarnings("unused") Prenda zapatoDeCristal; zapatoDeCristal= new
 * Prenda("Zapatos Cenicienta", zapato, Material.CRISTAL, colorBlanco,
 * Trama.LISA); }
 * 
 * @Test public void testColor() {
 * 
 * assertEquals( unaRemeraBlancaLisa.getColor(), colorBlanco); assertEquals(
 * unaRemeraRoja.getColor(), colorRojo); assertEquals(
 * unPantalonNegro.getColor(), colorNegro); assertEquals(
 * unZapatoNegro.getColor(), colorNegro); assertEquals(
 * unaZapatillaLonaBlanca.getColor(), colorBlanco); assertEquals(
 * unLenteNegro.getColor(), colorNegro); }
 * 
 * 
 * Este test ya no se puede llevar a cabo xq "sugerir()" ahora no devuelve nada
 * 
 * @Test public void obtenerSugerenciasInesTest() { Set<List<Prenda>>
 * sugerencias = guardarropaInesUno.sugerir(); sugerencias.forEach(sugerencia ->
 * System.out.println(sugerencia)); assertEquals(4, sugerencias.size()); }
 * 
 * @Test public void listaDePrendasCorrectas() {
 * assertEquals(6,guardarropaInesUno.cantidadDePrendas()); }
 * 
 * @Test public void agregoUnaPrendaIgualAOtraYlaCantidadNoVaria() throws
 * Exception { // Agrego una prenda que ya se encuentra y da la misma cantidad
 * de prendas assertEquals(6, guardarropaInesUno.cantidadDePrendas());
 * guardarropaInesUno.agregarAGuardarropas(unaRemeraBlancaLisa); assertEquals(6,
 * guardarropaInesUno.cantidadDePrendas());
 * guardarropaInesUno.agregarAGuardarropas(unaRemeraNegra); assertEquals(7,
 * guardarropaInesUno.cantidadDePrendas()); assertEquals(1,
 * guardarropaInesDos.cantidadDePrendas());
 * guardarropaInesDos.agregarAGuardarropas(unaRemeraBlancaLisa); assertEquals(2,
 * guardarropaInesDos.cantidadDePrendas());
 * 
 * }
 * 
 * //@Test(expected = Exception.class) public void
 * AgregarMasPrendasDeLoPermitidoAUsuarioGratis() throws Exception { //
 * GuardarropaInesUno tiene 6 prendas, // al agregar 5 mas me deberia tirar una
 * excepcion
 * 
 * Prenda unaRemeraFucsia1 = new Prenda("Remera Fucsia", remera,
 * Material.ALGODON, colorFucsia, Trama.LISA ); Prenda unaRemeraFucsia2 = new
 * Prenda("Remera Fucsia", remera, Material.ALGODON, colorFucsia, Trama.LISA );
 * Prenda unaRemeraFucsia3 = new Prenda("Remera Fucsia", remera,
 * Material.ALGODON, colorFucsia, Trama.LISA ); Prenda unaRemeraFucsia4 = new
 * Prenda("Remera Fucsia", remera, Material.ALGODON, colorFucsia, Trama.LISA );
 * Prenda unaRemeraFucsia5 = new Prenda("Remera Fucsia", remera,
 * Material.ALGODON, colorFucsia, Trama.LISA ); Prenda unaRemeraFucsia6 = new
 * Prenda("Remera Fucsia", remera, Material.ALGODON, colorFucsia, Trama.LISA );
 * 
 * guardarropaInesUno.agregarAGuardarropas(unaRemeraFucsia1);
 * guardarropaInesUno.agregarAGuardarropas(unaRemeraFucsia2);
 * guardarropaInesUno.agregarAGuardarropas(unaRemeraFucsia3);
 * guardarropaInesUno.agregarAGuardarropas(unaRemeraFucsia4);
 * guardarropaInesUno.agregarAGuardarropas(unaRemeraFucsia5);
 * guardarropaInesUno.agregarAGuardarropas(unaRemeraFucsia6); }
 * 
 * 
 * }
 */