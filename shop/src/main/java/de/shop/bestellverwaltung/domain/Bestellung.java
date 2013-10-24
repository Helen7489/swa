package de.shop.bestellverwaltung.domain;

import java.net.URI;

public class Bestellung {
	
	private Long id;
	private Boolean ausgeliefert;
	private URI kundeUri;
	
//	Konstruktor
	
	public Bestellung(Long id, Boolean ausgeliefert, URI kundeUri) {
		super();
		this.id = id;
		this.ausgeliefert = ausgeliefert;
		this.kundeUri = kundeUri;	
		
	}

//	Getter & Setter
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getAusgeliefert() {
		return ausgeliefert;
	}

	public void setAusgeliefert(Boolean ausgeliefert) {
		this.ausgeliefert = ausgeliefert;
	}

	public URI getKundeUri() {
		return kundeUri;
	}

	public void setKundeUri(URI kundeUri) {
		this.kundeUri = kundeUri;
	}
	
//	hashcode ID
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
//   equals  ID
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bestellung other = (Bestellung) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

//	toString id,ausgeliefert,kundeURI
	
	@Override
	public String toString() {
		return "Bestellung [id=" + id + ", ausgeliefert=" + ausgeliefert
				+ ", kundeUri=" + kundeUri + "]";
	}
	
	

	}
