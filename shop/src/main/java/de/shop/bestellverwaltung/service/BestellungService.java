package de.shop.bestellverwaltung.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


import de.shop.bestellverwaltung.domain.Bestellposition;
import de.shop.bestellverwaltung.domain.Bestellung;
import de.shop.kundenverwaltung.domain.Kunde;
import de.shop.util.Mock;

// Logger eintragen

public class BestellungService {

	private   final int MAX_BESTELLUNGEN = 4;
	private   final Long ARTIKEL_ID_1 = Long.valueOf(20);
	private   final Long ARTIKEL_ID_2 = Long.valueOf(30);

public Bestellung findBestellungById(Long id) {

		// IDs setzen
		final Bestellposition bp1 = new Bestellposition(Mock.findArtikelById(ARTIKEL_ID_1));
		bp1.setId(id+1);
		
		final Bestellposition bp2 = new Bestellposition(Mock.findArtikelById(ARTIKEL_ID_2));
		bp2.setId(id+2);
	
		final Kunde kunde = Mock.findKundeById(id + 1);
		
		final Bestellung bestellung = new Bestellung();
		bestellung.addBestellposition(bp1);
		bestellung.addBestellposition(bp2);
		
		// ArrayList wird übernommen von addBestellposition
		
		bestellung.setKunde(kunde);
		
		bestellung.setId(id);
		
		// bestellung.setAusgeliefert(false); --> keine Lieferungsklasse vorhanden
		
		return bestellung;
	}

	public List<Bestellung> findBestellungenByKunde(Kunde kunde) {
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

	
	public Bestellung createBestellung(Bestellung bestellung) {
		
		final Long id = bestellung.getId();
		// System.out.print(id);
		bestellung.setId(Long.valueOf(id));

		
		final URI KundeUri = bestellung.getKundeUri();
		bestellung.setKundeUri(KundeUri);

		return bestellung;
	}

}
