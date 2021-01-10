package com.example.application.views.control;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;

import com.example.application.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;

import backend.Ascensor;
import backend.Edificio;

@Route(value = "panel", layout = MainView.class)
@PageTitle("Hello World")
@RouteAlias(value = "", layout = MainView.class)
public class PanelDeControl extends Div {

	ArrayList<Ascensor> ascensores;
	Edificio edificio;

	public PanelDeControl() {
		this.edificio= Edificio.getSingletonEdificio();
		this.ascensores = edificio.getAscensores();		
		HorizontalLayout tituloPC = createsViewTitle();
		Grid<Ascensor> grid = createsGridWithData();
		grid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS, GridVariant.LUMO_ROW_STRIPES);
		HorizontalLayout botonesControlAscensores = generarControlAscensores();
		add(tituloPC, grid,botonesControlAscensores);
	}

	
	private HorizontalLayout generarControlAscensores() {
		HorizontalLayout botonesControlAscensores = new HorizontalLayout();
		Button addAscensor = new Button("Añadir Ascensor",VaadinIcon.PLUS.create(), event -> {
			edificio.addAscensor();
			UI.getCurrent().getPage().reload();
		});
		addAscensor.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
		addAscensor.setClassName("boton");

		Button deleteAscensor = new Button("Borrar Ascensor",VaadinIcon.PLUS.create(), event -> {
			edificio.removeAscensor();
			UI.getCurrent().getPage().reload();
		});
		deleteAscensor.addThemeVariants(ButtonVariant.LUMO_ERROR);
		
		botonesControlAscensores.add(addAscensor, deleteAscensor);
		botonesControlAscensores.setJustifyContentMode(JustifyContentMode.CENTER);
		
		return botonesControlAscensores;
	} 

	private HorizontalLayout createsViewTitle() {
		HorizontalLayout tituloPC = new HorizontalLayout();
		H1 panelcontrol = new H1("Panel de Control");
		tituloPC.add(panelcontrol);
		tituloPC.setJustifyContentMode(JustifyContentMode.CENTER);
		return tituloPC;
	}

	private Grid<Ascensor> createsGridWithData() {
		Grid<Ascensor> grid = new Grid<>();
		
		grid.setItems(ascensores);
		grid.addColumn(Ascensor::getIdAscensor).setHeader("Id Ascensor");
		grid.addColumn(Ascensor::getPisoPcontrol).setHeader("Piso actual");
		grid.addColumn(Ascensor::getEstadoPcontrol).setHeader("Estado actual");
		grid.addColumn(Ascensor::getPuertaPcontrol).setHeader("Estado puerta");
		grid.addColumn(Ascensor::getAlarmaPcontrol).setHeader("Alarma");
		return grid;
	}

}
