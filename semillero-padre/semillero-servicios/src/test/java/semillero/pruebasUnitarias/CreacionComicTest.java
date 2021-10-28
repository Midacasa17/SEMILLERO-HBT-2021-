/**
 * CreacionDComicTest.java
 */
package semillero.pruebasUnitarias;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.*;

import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.enums.TematicaEnum;
import com.hbt.semillero.dto.ComicDTO;




/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author midac
 * @version 
 */
public class CreacionComicTest {
	private final static Logger log = Logger.getLogger(CreacionComicTest.class);
	/**
		 * 
		 * Metodo encargado de  incializar los Test
		 * <b>Caso de Uso</b>
		 * @author midac
		 *
		 */
   @BeforeTest
    public void init() {
	BasicConfigurator.configure();
	log.info(":::::::::::::::::::::::::::: INICIAN PRUEBAS UNITARIAS COMICS :::::::::::::::::::::::::::: ");
	}
   @Test
    public void ValidarComic(){
	   log.info("Inicializa la Validacion de la existencia de 10 Comic");
	   /** COMO SE LLENA UNA LISTA
	    *  List<String> testList = new ArrayList<String>();
        testList.add("1");
        testList.add("2");
        testList.add("3");
        testList.add("4");
        testList.add("5");
	    */
	   ArrayList<ComicDTO>NComis= new ArrayList<ComicDTO>();
	   NComis.add(new ComicDTO("01", "Chapulin 1", "R.Cegoviano", TematicaEnum.AVENTURAS, "1995", Integer.valueOf(100), BigDecimal.valueOf(80000), "Chespirito", true, EstadoEnum.INACTIVO, Long.valueOf(15L)));
	   NComis.add(new ComicDTO("02", "Chapulin 2", "R.Cegoviano", TematicaEnum.AVENTURAS, "1995", Integer.valueOf(100), BigDecimal.valueOf(70000), "Chespirito", true, EstadoEnum.ACTIVO, Long.valueOf(15L)));
	   NComis.add(new ComicDTO("03", "Un Cerdito Presidente", "R.Polombia", TematicaEnum.HORROR, "2019", Integer.valueOf(365), BigDecimal.valueOf(0), "Matarife Uribe", true, EstadoEnum.INACTIVO, Long.valueOf(100L)));
	   NComis.add(new ComicDTO("04", "Pandemia Primera Linea", "DerechosHumanosColombia", TematicaEnum.HISTORICO, "Nueva", Integer.valueOf(1000000), BigDecimal.valueOf(1000000), "Resistencia Civil", true, EstadoEnum.ACTIVO, Long.valueOf(15L)));
	   NComis.add(new ComicDTO("05", "SuperBotifarras", "CostaComec", TematicaEnum.CIENCIA_FICCION, "Nueva", Integer.valueOf(100), BigDecimal.valueOf(10000), "Anonimo", true, EstadoEnum.ACTIVO, Long.valueOf(20L)));
	   NComis.add(new ComicDTO("06", "SuperO", "MinisterioDesfalco", TematicaEnum.FANTASTICO, "Nueva", Integer.valueOf(200), BigDecimal.valueOf(500), "Un Profe de Español", true, EstadoEnum.ACTIVO, Long.valueOf(2L)));
	   NComis.add(new ComicDTO("07", "Malda en Latinoamerica", "Desconocido", TematicaEnum.BELICO, "Nueva", Integer.valueOf(5), BigDecimal.valueOf(30000), "Desconocido", true, EstadoEnum.INACTIVO, Long.valueOf(1L)));
	   NComis.add(new ComicDTO("08", "MinticOfPapper", "GremioTIc", TematicaEnum.FANTASTICO, "2021", Integer.valueOf(365), BigDecimal.valueOf(800000), "MoneyLosser", true, EstadoEnum.ACTIVO, Long.valueOf(2L)));
	   NComis.add(new ComicDTO("09", "OnlyFans", "Desesperadas", TematicaEnum.AVENTURAS, "Nueva", Integer.valueOf(300), BigDecimal.valueOf(9999999), "Mia Kaifha", true, EstadoEnum.ACTIVO, Long.valueOf(3L)));
	   NComis.add(new ComicDTO("00", "Lo Ocupada", "Soila", TematicaEnum.BELICO, "Nueva", Integer.valueOf(300), BigDecimal.valueOf(500), "Soylaq LavaCocina", true, EstadoEnum.ACTIVO, Long.valueOf(0L)));
	   /**
	    * AHORA CON EL TRY Y CATCH VERIFICAMOS SI LA LISTA NComic Estados Inactivos y Activos
	    * primero creamos los metodos de cada uno
	    */
	     try {
		 /**
		  *  Claro que tenemos que crear los metodos de cada uno para poder indagar crear los respectivos 
		  *  Creo que con uno era suficiente para que mostrase los dos
		  */
				VComicsActivos(NComis);
				VComicsInactivos(NComis);
			}
	     catch (Exception e) {
				System.out.println(e.getMessage());
			}
	        log.info("Finaliza la ejecucion del metodo validarCreacionComic()");
	        }
   @Test
                private ArrayList<ComicDTO> VComicsInactivos(ArrayList<ComicDTO> NComis) {
                	log.info("Finaliza la ejecucion del metodo VComicsInactivos()");
                	
                	ArrayList<ComicDTO> comicsInactivos = new ArrayList<ComicDTO>();
                	/**
                	 * Con un Metodo  de bucle forEach para recorrer las Listas de los comic con estado Inactivos
                	 * y despues implementamos una comparacion
                	 * con Assert.assetEqual() hacemos la prueba unitaria
                	 */
                	for(ComicDTO I:NComis) {
                		if(I.getEstadoEnum()!=(EstadoEnum.ACTIVO)) {
                			Assert.assertEquals(I.getEstadoEnum(), EstadoEnum.INACTIVO);
                			System.out.println(I.toString()); 
                			comicsInactivos.add(I);
                		}
                		
                		
                	}
                	log.info("Termina ejecucion del metodo verificarComicsInactivos()");
                	return comicsInactivos;
                	
                 }	 	
                	
	
   @Test                                        
                private ArrayList<ComicDTO> VComicsActivos(ArrayList<ComicDTO> NComis) {
                	
                	log.info("inicialuza la ejecucion del metodo VComicsActivos");
                                    	
                    	ArrayList<ComicDTO> comicsActivos = new ArrayList<ComicDTO>();
                    	/**
                    	 * Con un Metodo  de bucle forEach para recorrer las Listas de los comic con estado Inactivos
                    	 * y despues implementamos una comparacion
                    	 * con Assert.assetEqual() hacemos la prueba unitaria
                    	 */
                    	for(ComicDTO A:NComis) {
                    		if(A.getEstadoEnum()!=(EstadoEnum.INACTIVO)) {
                    			Assert.assertEquals(A.getEstadoEnum(), EstadoEnum.ACTIVO);
                    			System.out.println(A.toString()); 
                    			comicsActivos.add(A);
                    		}
                    		
                    		
                    	}
                    	log.info("Termina ejecucion del metodo VComicsActivos()");
                    	return comicsActivos;
                                             }
                
                
               
            	/**
            	 * 
            	 * Metodo encargado de retornar los comics que están inactivos 
            	 * <b>Caso de Uso</b>SEMILLERO 2021
            	 * @author midac
            	 * 
            	 * @param listaComics-> Lista de comics para revisar su estado
            	 * @return comicsActivos-> Lista de comics inactivos de listaComics
            	 * @throws Exception 
            	 */
                @Test
            	private ArrayList<ComicDTO> verificarComicsInactivos(ArrayList<ComicDTO> NComics) throws Exception{
                	 log.info("Inicia ejecucion del metodo verificarComicsInactivos()");
            		
            		ArrayList<ComicDTO> comicsInactivos = new ArrayList<ComicDTO>();
            		
            		ArrayList<String> nameComicsInactivos = new ArrayList<String>();
            		
            		
            		for (ComicDTO I: NComics) {
            			if(I.getEstadoEnum()==(EstadoEnum.INACTIVO)) { 				
            				Assert.assertEquals(I.getEstadoEnum(), EstadoEnum.INACTIVO); 
            				comicsInactivos.add(I); 
            				nameComicsInactivos.add(I.getNombre()); 
            			}
            		}
            		
            		
            			 
            		log.info("::::::::::::::::TAMAÑOS:::::::::::::::::::::::");
            		int SizeListaTotal =NComics.size();
            		int numeroTotalActivos = NComics.size() - comicsInactivos.size();
            		int numeroTotalInactivos = comicsInactivos.size();
            		String nombresComicsInactivos = nameComicsInactivos.toString();
            		
            		String message = "Se ha detectado que de " + SizeListaTotal + " comics se encontraron que " + numeroTotalActivos + "  se encuentran activos y " + numeroTotalInactivos + " inactivos. Los comics inactivos son: " + nombresComicsInactivos;
            		System.out.println(message); 
            		
            		for (ComicDTO comic: comicsInactivos) {
            			if(comic.getEstadoEnum()==(EstadoEnum.ACTIVO)) {			
            				throw new Exception(message);
            			}
            		}
            		
            		log.info("Termina ejecucion del metodo verificarComicsInactivos()");
            		
            		return comicsInactivos;
            	}
                
            	
            	@AfterTest
            	/**
            	 * 
            	 * Metodo para terminar las pruebas unitarias
            	 * <b>Caso de Uso</b>
            	 * @author Miguel
            	 *
            	 */
            	public void finalizaPruebasUnitarias() {
            		log.info(":::::::::::::::::::::::::::: FINALIZAN PRUEBAS UNITARIAS COMICS :::::::::::::::::::::::::::: ");
            	}
/**
 * NO SOY EL MEJOR EN ESTO ME TUVIERON QUE EXPLICAR MUCHOS TUTORIALES PERO ESPERO QUE ALGUNDIA ENTREMOS ANGULAR 
 */
    	
    	
    }


