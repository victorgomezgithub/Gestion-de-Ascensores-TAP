package com.example.application.views.about;

import com.example.application.views.main.MainView;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "Planta2", layout = MainView.class)
@PageTitle("Planta 2")
public class Planta2 extends PlantaMainViewGeneral{

	@Override
	int getPlantaActual() {
		return 1;
	}

	@Override
	H1 getH1Planta() {
		return new H1("Planta 2");
	}

}
