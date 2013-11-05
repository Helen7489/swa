package de.shop.artikelverwaltung.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import de.shop.artikelverwaltung.domain.Artikel;
import de.shop.util.interceptor.Log;

@Log
public class ArtikelServiceMock {

	private static final int MAX_ARTIKEL = 5;

	public static Artikel findArtikelById(Long id) {
		final Artikel artikel = new Artikel();
		artikel.setId(id);
		artikel.setBezeichnung("Bezeichnung_" + id + "_Mock");
		artikel.setPreis(new BigDecimal(id + "0.0"));
		return artikel;
	}

	public static List<Artikel> findArtikelByBezeichnung(String bezeichnung) {
		final int anzahl = bezeichnung.length();
		final List<Artikel> artikelliste = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final Artikel artikel = findArtikelById(Long.valueOf(i));
			artikel.setBezeichnung(bezeichnung);
			artikelliste.add(artikel);
		}
		return artikelliste;
	}

	public static List<Artikel> findAllArtikel() {
		final int anzahl = MAX_ARTIKEL;
		final List<Artikel> artikelliste = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final Artikel artikel = findArtikelById(Long.valueOf(i));
			artikelliste.add(artikel);
		}
		return artikelliste;
	}

	public static Artikel createArtikel(Artikel artikel) {
		// Nur neue ID zugewiesen
		final String bezeichnung = artikel.getBezeichnung();
		artikel.setId(Long.valueOf(bezeichnung.length()));

		System.out.println("Neuer Artikel: " + artikel);
		return artikel;
	}

	public static void updateArtikel(Artikel artikel) {
		System.out.println("Aktualisierter Artikel: " + artikel);
	}

	public static void deleteArtikel(Long id) {
		System.out.println("Artikel mit ID=" + id + " geloescht");
	}
}
