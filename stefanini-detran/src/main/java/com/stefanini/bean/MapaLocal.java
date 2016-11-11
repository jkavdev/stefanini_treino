package com.stefanini.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;

import com.stefanini.model.LocalInfracao;
import com.stefanini.service.LocalInfracaoService;
import com.stefanini.util.jsf.FacesUtil;

@Named
@SessionScoped
public class MapaLocal implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private MapModel emptyModel;
	private String title;
	private Double lat;
	private Double lng;
	@Inject
	private LocalInfracaoService service;
	@Inject
	private LocalInfracao local;

	public void cadastrar() {
			local.setLatitude(lat);
			local.setLongitude(lng);
			service.incluir(local);
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			FacesUtil.adicionarMensagemInfo("Local cadastrado com Sucesso");
	}

	public LocalInfracao getLocal() {
		return local;
	}

	public void setLocal(LocalInfracao local) {
		this.local = local;
	}

	@PostConstruct
	public void init() {
		emptyModel = new DefaultMapModel();
	}

	public MapModel getEmptyModel() {
		return emptyModel;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public void addMarker() {
		new LatLng(lat, lng);
		System.out.println(lat);
		System.out.println(lng);
	}
}