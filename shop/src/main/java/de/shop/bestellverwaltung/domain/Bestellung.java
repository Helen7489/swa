package de.shop.bestellverwaltung.domain;

import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import de.shop.kundenverwaltung.domain.Kunde;

@XmlRootElement
public class Bestellung implements Serializable {

	private static final long serialVersionUID = -4802402419256415365L;

	private Long id;

	private List<Bestellposition> bestellpositionen;

	@XmlTransient
	private Kunde kunde;

	@Transient
	private URI kundeUri;

	public Bestellung() {
		super();
	}
	
	public Bestellung(Kunde kunde, List<Bestellposition> bestellpositionen) {
		super();
		this.kunde = kunde;
		this.bestellpositionen = bestellpositionen;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Bestellposition> getBestellpositionen() {
		if (bestellpositionen == null) {
			return null;
		}
		return Collections.unmodifiableList(bestellpositionen);
	}

	public void setBestellpositionen(List<Bestellposition> bestellpositionen) {
		if (this.bestellpositionen == null) {
			this.bestellpositionen = bestellpositionen;
			return;
		}
		// Wiederverwendung der vorhandenen Collection
		this.bestellpositionen.clear();
		if (bestellpositionen != null) {
			this.bestellpositionen.addAll(bestellpositionen);
		}
	}

	public Bestellung addBestellposition(Bestellposition bestellposition) {
		if (bestellpositionen == null) {
			bestellpositionen = new ArrayList<>();
		}
		bestellpositionen.add(bestellposition);
		return this;
	}

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	public URI getKundeUri() {
		return kundeUri;
	}

	public void setKundeUri(URI kundeUri) {
		this.kundeUri = kundeUri;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + ((bestellpositionen == null) ? 0 : bestellpositionen.hashCode());

		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((kunde == null) ? 0 : kunde.hashCode());
		result = prime * result + ((kundeUri == null) ? 0 : kundeUri.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Bestellung other = (Bestellung) obj;

		if (bestellpositionen == null) {
			if (other.bestellpositionen != null)
				return false;
		}
		else if (!bestellpositionen.equals(other.bestellpositionen))
			return false;

		if (id == null) {
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		if (kunde == null) {
			if (other.kunde != null)
				return false;
		}
		else if (!kunde.equals(other.kunde))
			return false;
		if (kundeUri == null) {
			if (other.kundeUri != null)
				return false;
		}
		else if (!kundeUri.equals(other.kundeUri))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return "Bestellung [id=" + id + ", bestellpositionen=" + bestellpositionen + ", kunde=" + kunde + ", kundeUri="
				+ kundeUri + "]";
	}

}
