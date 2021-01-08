package com.example.application.views.planta;

import com.example.application.views.main.MainView;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "Planta5", layout = MainView.class)
@PageTitle("Planta 5")
public class Planta5 extends PlantaMainViewGeneral{
	@Override
	int getPlantaActual() {
		return 4;
	}

	@Override
	H1 getH1Planta() {
		return new H1("Planta 5");
	}
}
