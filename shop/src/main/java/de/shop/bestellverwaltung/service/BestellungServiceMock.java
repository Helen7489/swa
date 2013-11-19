package de.shop.bestellverwaltung.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.shop.artikelverwaltung.service.ArtikelServiceMock;
import de.shop.bestellverwaltung.domain.Bestellposition;
import de.shop.bestellverwaltung.domain.Bestellung;
import de.shop.kundenverwaltung.domain.Kunde;
import de.shop.kundenverwaltung.service.KundeServiceMock;

public class BestellungServiceMock {

	private static final int MAX_BESTELLUNGEN = 4;

	public static Bestellung findBestellungById(Long id) {

		Bestellposition bp1 = new Bestellposition(ArtikelServiceMock.findArtikelById((long) 10));
		Bestellposition bp2 = new Bestellposition(ArtikelServiceMock.findArtikelById((long) 20));
		final Kunde kunde = KundeServiceMock.findKundeById(id + 1);

		List<Bestellposition> liste = Arrays.asList(bp1, bp2);
		
// TODO ID für Bestellposition nicht gesetzt!
		
		final Bestellung bestellung = new Bestellung(kunde, liste);
		bestellung.setId(id);
		// bestellung.setAusgeliefert(false);
		bestellung.setKunde(kunde);

		return bestellung;
	}

	public static List<Bestellung> findBestellungenByKunde(Kunde kunde) {
		// Beziehungsgeflecht zwischen Kunde und Bestellungen aufbauen
		final int anzahl = kunde.getId().intValue() % MAX_BESTELLUNGEN + 1;
		final List<Bestellung> bestellungen = new ArrayList<>(anzahl);
		for (int i = 1; i <= anzahl; i++) {
			final Bestellung bestellung = findBestellungById(Long.valueOf(i));
			bestellung.setKunde(kunde);
			bestellungen.add(bestellung);
		}
		kunde.setBestellungen(bestellungen);

		return bestellungen;
	}

	
	public static Bestellung createBestellung(Bestellung bestellung) {
		
		final Long id = bestellung.getId();
		// System.out.print(id);
		bestellung.setId(Long.valueOf(id));

		
		final URI KundeUri = bestellung.getKundeUri();
		bestellung.setKundeUri(KundeUri);

		return bestellung;
	}

}
