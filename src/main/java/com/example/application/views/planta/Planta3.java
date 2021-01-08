package com.example.application.views.planta;

import com.example.application.views.main.MainView;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "Planta3", layout = MainView.class)
@PageTitle("Planta 3")
public class Planta3 extends PlantaMainViewGeneral{

	@Override
	int getPlantaActual() {
		return 2;
	}

	@Override
	H1 getH1Planta() {
		return new H1("Planta 3");
	}
	
}
