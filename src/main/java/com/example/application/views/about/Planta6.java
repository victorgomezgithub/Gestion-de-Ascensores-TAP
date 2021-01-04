package com.example.application.views.about;

import com.example.application.views.main.MainView;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "Planta6", layout = MainView.class)
@PageTitle("Planta 6")
public class Planta6 extends PlantaMainViewGeneral{
 
	@Override
	int getPlantaActual() {
		return 5;
	}

	@Override
	H1 getH1Planta() {
		return new H1("Planta 6");
	}
	
}
