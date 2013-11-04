package de.shop.util;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.math.BigDecimal;

import de.shop.bestellverwaltung.domain.Bestellung;
import de.shop.kundenverwaltung.domain.Adresse;
import de.shop.kundenverwaltung.domain.Kunde;
import de.shop.artikelverwaltung.domain.Artikel;


/**
 * Emulation des Anwendungskerns
 */
public final class Mock {
	private static final int MAX_ID = 99;
	private static final int MAX_KUNDEN = 8;
	private static final int MAX_BESTELLUNGEN = 4;
	private static final int MAX_ARTIKEL = 5;

	// TODO Methoden anpassen
	
	
	public static Kunde findKundeById(Long id) {
		if (id > MAX_ID) {
			return null;
		}
		final Kunde kunde = new Kunde();
		kunde.setId(id);
		kunde.setNachname("Nachname" + id);
		kunde.setVorname("Vorname" + id);
		kunde.setEmail("" + id + "@hska.de");
		//TODO Klasse Adresse
		
		final Adresse adresse = new Adresse();
		adresse.setId(id + 1);        
		adresse.setPlz("12345");
		adresse.setOrt("Testort");
		adresse.setKunde(kunde);
		kunde.setAdresse(adresse);
		
		return kunde;
	}

	public static List<Kunde> findAllKunden() {
		final int anzahl = MAX_KUNDEN;
		final List<Kunde> kunden = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final Kunde kunde = findKundeById(Long.valueOf(i));
			kunden.add(kunde);			
		}
		return kunden;
	}

	public static List<Kunde> findKundenByNachname(String nachname) {
		final int anzahl = nachname.length();
		final List<Kunde> kunden = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final Kunde kunde = findKundeById(Long.valueOf(i));
			kunde.setNachname(nachname);
			kunden.add(kunde);			
		}
		return kunden;
	}
	
	// Bestellung suchen mit ID
	public static Bestellung findBestellungById(Long id) {
		if (id > MAX_ID) {
			return null;
		}		
		
		//final Kunde kunde = findKundeById(id + 1);  // andere ID fuer den Kunden

		final Bestellung bestellung = new Bestellung();
		bestellung.setId(id);
		//bestellung.setAusgeliefert(false);
		//bestellung.setKunde(kunde);
		
		return bestellung;
	}
	
	public static List<Bestellung> findBestellungenByKunde(Kunde kunde) {
		// Beziehungsgeflecht zwischen Kunde und Bestellungen aufbauen
		final int anzahl = kunde.getId().intValue() % MAX_BESTELLUNGEN + 1;  // 1, 2, 3 oder 4 Bestellungen
		final List<Bestellung> bestellungen = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final Bestellung bestellung = findBestellungById(Long.valueOf(i));
			bestellung.setKunde(kunde);
			bestellungen.add(bestellung);			
		}
		kunde.setBestellungen(bestellungen);
		
		return bestellungen;
	}
	
	// TODO createBestellung siehe id

	public static Bestellung createBestellung(Bestellung bestellung) {
		final Long id = bestellung.getId();
		bestellung.setId(Long.valueOf(MAX_ID));
		
		final Boolean ausgeliefert = bestellung.getAusgeliefert();
		bestellung.setAusgeliefert(ausgeliefert);
		
		final URI KundeUri = bestellung.getKundeUri();
		bestellung.setKundeUri(KundeUri);
		
		return bestellung;	
	}
	
	public static Kunde createKunde(Kunde kunde) {
		// Neue IDs fuer Kunde und zugehoerige Adresse
		// Ein neuer Kunde hat auch keine Bestellungen
		final String nachname = kunde.getNachname();
		kunde.setId(Long.valueOf(nachname.length()));
		
		final Adresse adresse = kunde.getAdresse();
		adresse.setId((Long.valueOf(nachname.length())) + 1);
		adresse.setKunde(kunde);
		
		kunde.setBestellungen(null);
		
		System.out.println("Neuer Kunde: " + kunde);
		return kunde;
	}

	public static void updateKunde(Kunde kunde) {
		System.out.println("Aktualisierter Kunde: " + kunde);
	}

	public static void deleteKunde(Long kundeId) {
		System.out.println("Kunde mit ID=" + kundeId + " geloescht");
	}
	// Artikel
	
	public static Artikel findArtikelById(Long id) {
		if (id > MAX_ID) {
			return null;
		}
		
		final Artikel artikel = new Artikel();
		artikel.setId(id);
		artikel.setBezeichnung("Bezeichnung" + id);
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

	public static List<Artikel> findAllArtikel(){
		final int anzahl = MAX_ARTIKEL;
		final List<Artikel> artikelliste = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final Artikel artikel = findArtikelById(Long.valueOf(i));
			artikelliste.add(artikel);
		}
		return artikelliste;
	}

	public static Artikel createArtikel(Artikel artikel) {
		//Nur neue ID zugewiesen
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
	
	private Mock() { /**/ } 
}

