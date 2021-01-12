package com.example.application.views.planta;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import com.example.application.views.main.MainView;

@Route(value = "Planta1", layout = MainView.class)
@PageTitle("Planta 1")
public class Planta1 extends PlantaMainViewGeneral{

	@Override
	H1 getH1Planta() {
		return new H1("Planta 1");
	}

	@Override
	int getPlantaActual() {
		return 0;
	}

	
}
