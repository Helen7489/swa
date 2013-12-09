package de.shop.artikelverwaltung.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import de.shop.artikelverwaltung.domain.Artikel;
import de.shop.util.Mock;
import de.shop.util.interceptor.Log;

@Dependent
@Log
public class ArtikelServiceMock implements Serializable{

//	private static final int MAX_ARTIKEL = 5;

	/**
	 * 
	 */
	private static final long serialVersionUID = -4813113961399683792L;

	@NotNull(message = "{artikel.notFound.id}")
	public Artikel findArtikelById(Long id) {
		return Mock.findArtikelById(id);
	}

	@Size(min = 1, message = "{artikel.notFound.bezeichnung}")
	public List<Artikel> findArtikelByBezeichnung(String bezeichnung) {
		return Mock.findArtikelByBezeichnung(bezeichnung);
	}

	@Size(min = 1, message = "{artikel.notFound.all}")
	public List<Artikel> findAllArtikel() {
		return Mock.findAllArtikel();
	}

	public Artikel createArtikel(Artikel artikel) {
		return Mock.createArtikel(artikel);
	}

	public void updateArtikel(Artikel artikel) {
		Mock.updateArtikel(artikel);
	}

	public void deleteArtikel(Long id) {
		Mock.deleteArtikel(id);
	}
}
