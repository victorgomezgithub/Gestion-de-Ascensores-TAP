package com.example.application.views.planta;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import backend.Edificio;
import backend.Observer;

import java.util.concurrent.TimeUnit;

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
