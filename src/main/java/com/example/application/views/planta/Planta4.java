package com.example.application.views.planta;

import com.example.application.views.main.MainView;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "Planta4", layout = MainView.class)
@PageTitle("Planta 4")
public class Planta4 extends PlantaMainViewGeneral{
	@Override
	int getPlantaActual() {
		return 3;
	}

	@Override
	H1 getH1Planta() {
		return new H1("Planta 4");
	}
}
