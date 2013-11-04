package de.shop.bestellverwaltung.service;

import java.util.List;
import java.util.Locale;

import de.shop.bestellverwaltung.domain.Bestellung;
import de.shop.kundenverwaltung.domain.Kunde;

public interface BestellungService {

		Bestellung findBestellungById(Long id);
		List<Bestellung> findBestellungenByKunde(Kunde kunde);
		Bestellung createBestellung(Bestellung bestellung, Kunde kunde, Locale locale);
}
