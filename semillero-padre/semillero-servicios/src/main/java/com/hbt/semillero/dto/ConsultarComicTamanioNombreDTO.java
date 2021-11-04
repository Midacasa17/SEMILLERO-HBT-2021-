package com.hbt.semillero.dto;


import java.util.ArrayList;
import java.util.List;

public class ConsultarComicTamanioNombreDTO extends ResultadoDTO{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private List<String> comicSuperatamaho;
	private List<String> comicNoSuperatamaho;
	
	public ConsultarComicTamanioNombreDTO() {
		//Constructor vacio
	}
	
	public ConsultarComicTamanioNombreDTO(Short lengthComic) {
		this.comicSuperatamaho = new ArrayList<>();
		this.comicSuperatamaho = new ArrayList<>();
	}

	public List<String> getComicSuperatamaho() {
		return comicSuperatamaho;
	}

	public void setComicSuperatamaho(List<String> comicSuperatamaho) {
		this.comicSuperatamaho = comicSuperatamaho;
	}

	public List<String> getComicNoSuperatamaho() {
		return comicNoSuperatamaho;
	}

	public void setComicNoSuperatamaho(List<String> comicNoSuperatamaho) {
		this.comicNoSuperatamaho = comicNoSuperatamaho;
	}

	public void setComicSuperatamaho(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setComicNoSuperatamaho(String string) {
		// TODO Auto-generated method stub
		
	}
	
	
}
