package br.com.jkavdev.stefanini.detran.bean.infracao.local;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;

import br.com.jkavdev.stefanini.detran.model.LocalInfracao;
import br.com.jkavdev.stefanini.detran.service.LocalInfracaoService;
import br.com.jkavdev.stefanini.detran.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroLocalMapa implements Serializable {

	private static final long serialVersionUID = 1L;

	private MapModel emptyModel;
	private Double lat;
	private Double lng;

	@Inject
	private LocalInfracaoService service;

	@Inject
	private LocalInfracao local;

	@PostConstruct
	public void init() {
		emptyModel = new DefaultMapModel();
	}

	public void cadastrar() {
		try {
			local.setLongitude(lat);
			local.setLongitude(lng);
			service.salvar(local);

			FacesUtil.addSuccessMessage("Local salvo com sucesso!");

			limpaFormulario();
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	private void limpaFormulario() {
		emptyModel = new DefaultMapModel();
		lat = null;
		lng = null;
		local = new LocalInfracao();
	}

	public LocalInfracao getLocal() {
		return local;
	}

	public void setLocal(LocalInfracao local) {
		this.local = local;
	}

	public MapModel getEmptyModel() {
		return emptyModel;
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
	}

}
