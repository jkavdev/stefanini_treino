package com.stefanini.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.stefanini.model.Agente;

@Path("/agente")
@RequestScoped
public class AgenteController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Agente> getInfracoes() {

		List<Agente> agentes = new ArrayList<>();
		Agente jhonatan = criaAgente("Jhonatan");
		Agente lucas = criaAgente("Lucas");
		Agente douglas = criaAgente("Douglas");

		agentes.add(douglas);
		agentes.add(jhonatan);
		agentes.add(lucas);

		return agentes;
	}

	public Agente criaAgente(String nome) {
		Agente agente = new Agente();
		agente.setDataContratacao(new Date());

		return agente;
	}

}
