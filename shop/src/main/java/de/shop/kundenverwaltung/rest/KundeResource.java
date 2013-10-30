package de.shop.kundenverwaltung.rest;

import de.shop.kundenverwaltung.domain.Kunde;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path("/kunden")
//FIXME @Produces({APPLICATION_JSON, APPLICATION_XML + ";qs=0.75",
//	TEXT_XML + ";qs=0.75"})

@Consumes
public class KundeResource {

	@GET
	@Path("{id:[1-9][0-9]*}")
	public Response findKundeById(@PathParam("id") Long id) {
		//TODO Mock
		return null;
	}
}
