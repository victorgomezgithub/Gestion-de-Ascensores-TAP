package com.example.application.views.helloworld;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.function.ValueProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;

import com.example.application.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;

import backend.Ascensor;
import backend.Edificio;

@Route(value = "hello", layout = MainView.class)
@PageTitle("Hello World")
@RouteAlias(value = "", layout = MainView.class)
public class HelloWorldView extends Div {
	
	private Edificio edificio;
	ArrayList<Ascensor> ascensores;
    public HelloWorldView() {
    	
    	this.edificio= Edificio.getSingletonEdificio();
    	ascensores= edificio.getAscensores();
    	HorizontalLayout tituloPC = new HorizontalLayout();
        H1 panelcontrol = new H1("Panel de Control");
        tituloPC.add(panelcontrol);
        tituloPC.setJustifyContentMode(JustifyContentMode.CENTER);
        Grid<Ascensor> grid = new Grid<>();
    	grid.setItems(ascensores);
    	grid.addColumn(Ascensor::getIdAscensor).setHeader("Id Ascensor");
    	grid.addColumn(Ascensor::getPisoPcontrol).setHeader("Piso actual");
    	grid.addColumn(Ascensor::getEstadoPcontrol).setHeader("Estado actual");
    	grid.addColumn(Ascensor::getPuertaPcontrol).setHeader("Estado puerta");
    	grid.addColumn(Ascensor::getAlarmaPcontrol).setHeader("Alarma");
    	grid.addThemeVariants(GridVariant.LUMO_NO_BORDER,GridVariant.LUMO_NO_ROW_BORDERS, GridVariant.LUMO_ROW_STRIPES);
    	add(tituloPC,grid);
            }
    

}
