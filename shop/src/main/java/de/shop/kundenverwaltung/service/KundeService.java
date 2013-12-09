package de.shop.kundenverwaltung.service;

import java.io.Serializable;
//import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import de.shop.kundenverwaltung.domain.Kunde;
import de.shop.util.Mock;

public class KundeService implements Serializable{

	private static final long serialVersionUID = -7931952361984885554L;

	@NotNull(message = "{kunde.notFound.id}")
	public Kunde findKundeById(Long id) {
		
		if (id == null) {
			return null;
		}
		// TODO Datenbanzugriffsschicht statt Mock
		return Mock.findKundeById(id);
	}

	public List<Kunde> findAllKunden() {
		return Mock.findAllKunden();
	}
	
	@NotNull(message = "{kunde.notFound.email}")
	public Kunde findKundeByEmail(String email) {
		if (email == null) {
			return null;
		}
		// TODO Datenbanzugriffsschicht statt Mock
		return Mock.findKundeByEmail(email);
	}
	
	@Size(min = 1, message = "{kunde.notFound.nachname}")
	public List<Kunde> findKundenByNachname(String nachname) {
		// TODO Datenbanzugriffsschicht statt Mock
		return Mock.findKundenByNachname(nachname);
	}

	public Kunde createKunde(Kunde kunde) {

		if (kunde == null) {
			return kunde;
		}
		//TODO haut einem beim Post immer eine Exception raus
/*		final Kunde tmp = findKundeByEmail(kunde.getEmail());  // Kein Aufruf als Business-Methode
		if (tmp != null) {
			throw new EmailExistsException(kunde.getEmail());
		}*/
		// TODO Datenbanzugriffsschicht statt Mock
		kunde = Mock.createKunde(kunde);
		return kunde;
		
	}

	public <T extends Kunde> T updateKunde(T kunde) {
		if (kunde == null) {
			return null;
		}
		final Kunde vorhandenerKunde = findKundeByEmail(kunde.getEmail());  
		if (vorhandenerKunde != null) {
			if (vorhandenerKunde.getId().longValue() != kunde.getId().longValue()) {
				throw new EmailExistsException(kunde.getEmail());
			}
		}

		// TODO Datenbanzugriffsschicht statt Mock
		Mock.updateKunde(kunde);
		
		return kunde;
	}

	public void deleteKunde(Long kundeId) {
		/*Kunde kunde = findKundeById(kundeId); 
		if (kunde == null) {
			return;
		}
		if (!kunde.getBestellungen().isEmpty()) {
			throw new KundeDeleteBestellungException(kunde);
		}
		*/
		// TODO Datenbanzugriffsschicht statt Mock
		Mock.deleteKunde(kundeId);
	}

}
