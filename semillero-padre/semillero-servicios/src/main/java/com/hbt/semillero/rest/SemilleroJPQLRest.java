package com.hbt.semillero.rest;



//import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;


import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.enums.EstadoEnum;


@Path("/SemilleroJPQLRest")
public class SemilleroJPQLRest {
	private final static Logger log = Logger.getLogger(SemilleroJPQLRest.class);

	
	@PersistenceContext
	private EntityManager em;
	
	
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public String ObtenerComic() {
		Comic comic = null;
		try {
			comic= em.find(Comic.class,4L );
			
			String consultarUnComic= "SELECT c FROM c WHERE c.id=4L";
			Query queryUnComic = em.createQuery(consultarUnComic);
			comic =(Comic)queryUnComic.getSingleResult();
			
			String consultarUnComicConParametro = "SELECT c FROM Comic c WHERE c.id= :idComic"
					+"AND c.estadoEnum = :estadoComic"+"ORDER BY c.nombre DESC";
			Query queryUnComicConParametro = em.createQuery(consultarUnComicConParametro);
			queryUnComicConParametro.setParameter("idCoic", 4L);
			queryUnComicConParametro.setParameter("estadoComic", EstadoEnum.ACTIVO);
			comic =(Comic)queryUnComicConParametro.getSingleResult();
			
			
			//String finAllComic = "SELECT c FROM c WHERE c.id=4L";
			//Query queryFindAllComic = em.createQuery(finAllComic);
			//List<Comic>ListaComics = queryFindAllComic.getResultList();
			
		}catch(NonUniqueResultException nur){
			log.info("EXISTE MAS DE UN RESGISTRO" +nur.getMessage());
				
		}
	     catch(NoResultException nur){
		log.info("EXISTE MAS DE UN RESGISTRO" +nur.getMessage());
		
		
	    }
		return comic.toString();
	
	}
}