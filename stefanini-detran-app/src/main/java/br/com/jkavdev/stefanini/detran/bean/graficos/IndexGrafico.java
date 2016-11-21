package br.com.jkavdev.stefanini.detran.bean.graficos;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.PieChartModel;

import br.com.jkavdev.stefanini.detran.model.TipoInfracao;
import br.com.jkavdev.stefanini.detran.service.TipoInfracaoService;

@Named
@ViewScoped
public class IndexGrafico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TipoInfracaoService tipoService;
	private BarChartModel barModel;
	private PieChartModel pieModel1;
	private HorizontalBarChartModel horizontalBarModel;	

	@PostConstruct
	public void init() {
		createBarModels();
		createPieModel1();
	}

	public BarChartModel getBarModel() {
		return barModel;
	}

	public PieChartModel getPieModel1() {
		return pieModel1;
	}

	public void setPieModel1(PieChartModel pieModel1) {
		this.pieModel1 = pieModel1;
	}

	public HorizontalBarChartModel getHorizontalBarModel() {
		return horizontalBarModel;
	}

	private void createPieModel1() {
		pieModel1 = new PieChartModel();

		List<TipoInfracao> infracoes = tipoService.infracoesComValor();
		for (TipoInfracao tipoInfracao : infracoes) {
			pieModel1.set(tipoInfracao.getCodigo(), tipoInfracao.getPontos());
		}

		pieModel1.setTitle("Simple Pie");
		pieModel1.setLegendPosition("w");
	}

	private BarChartModel initBarModel() {
		BarChartModel model = new BarChartModel();

		ChartSeries boys = new ChartSeries();
		boys.setLabel("Infrações");

		List<TipoInfracao> infracoes = tipoService.infracoesComValor();
		for (TipoInfracao tipoInfracao : infracoes) {
			boys.set(tipoInfracao.getCodigo(), tipoInfracao.getPontos());
		}

		model.addSeries(boys);

		return model;
	}

	private void createBarModels() {
		createBarModel();
		createHorizontalBarModel();
	}

	private void createBarModel() {
		barModel = initBarModel();

		barModel.setTitle("Bar Chart");
		barModel.setLegendPosition("ne");

		Axis xAxis = barModel.getAxis(AxisType.X);
		xAxis.setLabel("Gender");

		Axis yAxis = barModel.getAxis(AxisType.Y);
		yAxis.setLabel("Births");
		yAxis.setMin(0);
		yAxis.setMax(200);
	}

	private void createHorizontalBarModel() {
		horizontalBarModel = new HorizontalBarChartModel();

		ChartSeries boys = new ChartSeries();
		boys.setLabel("Boys");
		boys.set("2004", 50);
		boys.set("2005", 96);
		boys.set("2006", 44);
		boys.set("2007", 55);
		boys.set("2008", 25);

		ChartSeries girls = new ChartSeries();
		girls.setLabel("Girls");
		girls.set("2004", 52);
		girls.set("2005", 60);
		girls.set("2006", 82);
		girls.set("2007", 35);
		girls.set("2008", 120);

		horizontalBarModel.addSeries(boys);
		horizontalBarModel.addSeries(girls);

		horizontalBarModel.setTitle("Horizontal and Stacked");
		horizontalBarModel.setLegendPosition("e");
		horizontalBarModel.setStacked(true);

		Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
		xAxis.setLabel("Births");
		xAxis.setMin(0);
		xAxis.setMax(200);

		Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
		yAxis.setLabel("Gender");
	}

}
