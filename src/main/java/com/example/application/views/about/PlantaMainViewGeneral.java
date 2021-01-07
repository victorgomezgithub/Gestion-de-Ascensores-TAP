package com.example.application.views.about;

import java.util.ArrayList;


import org.jsoup.select.Evaluator.IsEmpty;

import com.example.application.views.main.MainView;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import backend.Edificio;
import backend.Observer;

public abstract class PlantaMainViewGeneral extends Div implements Observer {

	// LINEA UTIL PARA COMPRENDER LOS LAYOUT
	// botonera.getStyle().set("border", "1px solid #9E9E9E");

	private TextField[] numeroPisoAscensores = new TextField[3];
	private Image[] ascensoresImagenes = new Image[3];
	private ArrayList<Button> panelDeBotones;

	private final int planta = getPlantaActual();
	private Edificio edificio;

	private HorizontalLayout[] botonesExtraAscensorAbierto = new HorizontalLayout[3];

	public PlantaMainViewGeneral() {

		this.edificio = Edificio.getSingletonEdificio();

		attachObservers();

		HorizontalLayout tituloHorizontalLayout = generaTituloPlanta();

		HorizontalLayout ascensores = new HorizontalLayout();

		for (int i = 0; i < 3; i++) {
			VerticalLayout ascensorVerticalLayout = generalVistaAscensor(i);
			ascensores.add(ascensorVerticalLayout);
		}

		add(tituloHorizontalLayout, ascensores);
	}

	private VerticalLayout generalVistaAscensor(int numeroVista) {
		VerticalLayout ascensorVerticalLayout3 = new VerticalLayout();
		botonesExtraAscensorAbierto[numeroVista] = new HorizontalLayout();
		this.numeroPisoAscensores[numeroVista] = new TextField();
		this.numeroPisoAscensores[numeroVista].setValueChangeMode(ValueChangeMode.EAGER);
		this.numeroPisoAscensores[numeroVista]
				.setValue(String.valueOf(edificio.getAscensorPorIndex(numeroVista).getPiso() + 1));
		this.numeroPisoAscensores[numeroVista].setReadOnly(true);
		this.numeroPisoAscensores[numeroVista].setWidth("30px");
		Button callButton3 = new Button("Llamar", new Icon(VaadinIcon.PHONE));
		callButton3.addClickListener(e -> {
			edificio.getPlantaPorIndex(this.planta).llamarAscensor(edificio.getAscensorPorIndex(numeroVista));
		});
		if (this.planta == edificio.getAscensorPorIndex(numeroVista).getPiso()) {
			this.ascensoresImagenes[numeroVista] = new Image("images/ascensorAbierto.jpg", "Ascensor Abierto");
			panelDeBotones = new ArrayList<Button>();
			getPanelDeBotones(this.botonesExtraAscensorAbierto[numeroVista], numeroVista);
		} else {
			this.ascensoresImagenes[numeroVista] = new Image("images/ascensorCerrado.jpg", "Ascensor Cerrado");

		}
		this.ascensoresImagenes[numeroVista].setWidth("250px");
		this.ascensoresImagenes[numeroVista].setHeight("350px");
		this.ascensoresImagenes[numeroVista].onEnabledStateChanged(false);

		callButton3.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
		ascensorVerticalLayout3.add(this.numeroPisoAscensores[numeroVista], ascensoresImagenes[numeroVista],
				callButton3);
		ascensorVerticalLayout3.add(this.botonesExtraAscensorAbierto[numeroVista]);
		alignItemsInVerticalLayout(numeroVista, ascensorVerticalLayout3, callButton3);
		return ascensorVerticalLayout3;
	}

	private void alignItemsInVerticalLayout(int numeroVista, VerticalLayout ascensorVerticalLayout3,Button callButton3) {
		ascensorVerticalLayout3.setHorizontalComponentAlignment(Alignment.CENTER,this.botonesExtraAscensorAbierto[numeroVista]);
		ascensorVerticalLayout3.setHorizontalComponentAlignment(Alignment.CENTER, ascensoresImagenes[numeroVista]);
		ascensorVerticalLayout3.setHorizontalComponentAlignment(Alignment.CENTER,this.numeroPisoAscensores[numeroVista]);
		ascensorVerticalLayout3.setHorizontalComponentAlignment(Alignment.CENTER, callButton3);
	}

	private HorizontalLayout generaTituloPlanta() {
		setId("about-view");
		HorizontalLayout tituloHorizontalLayout = new HorizontalLayout();
		H1 planta = getH1Planta();
		tituloHorizontalLayout.add(planta);
		tituloHorizontalLayout.setJustifyContentMode(JustifyContentMode.CENTER);
		return tituloHorizontalLayout;
	}

	private void attachObservers() {
		this.edificio.attachObserver(this, 0);
		this.edificio.attachObserver(this, 1);
		this.edificio.attachObserver(this, 2);
	}

	private void getPanelDeBotones(HorizontalLayout botonesExtraAscensorAbierto, int ascensor) {
		VerticalLayout botonera = new VerticalLayout();
		HorizontalLayout panelPrimero = new HorizontalLayout();
		HorizontalLayout panelSegundo = new HorizontalLayout();
		HorizontalLayout panelTercero = new HorizontalLayout();
		HorizontalLayout panelCuarto = new HorizontalLayout();
		for (int i = 0; i <= 6; i++) {
			Button boton = new Button(String.valueOf(i + 1));
			boton.addClickListener(e -> {
				this.edificio.getPlantaPorIndex(Integer.parseInt(boton.getText()) - 1)
						.llamarAscensor(this.edificio.getAscensorPorIndex(ascensor));
			});

			panelDeBotones.add(boton);
			if (i == 0) {
				panelPrimero.add(panelDeBotones.get(i));
			} else if (i > 0 && i <= 3) {
				panelSegundo.add(panelDeBotones.get(i));
			} else {
				panelTercero.add(panelDeBotones.get(i));
			}
		}
		
		Button alarma = new Button(new Icon(VaadinIcon.BELL), e -> {
			Notification alarm = new Notification("¡Alarma en el Ascensor " + (this.edificio.getAscensorPorIndex(ascensor).getIdAscensor() + 1) + "!" , 2000);
			alarm.addThemeVariants(NotificationVariant.LUMO_ERROR);
			alarm.setPosition(Position.MIDDLE);
			alarm.open();
		});
		alarma.addThemeVariants(ButtonVariant.LUMO_ERROR);
		panelPrimero.add(alarma);
		
		Button abrirPuertas = new Button(new Icon(VaadinIcon.RESIZE_V), e -> {

		});
		Button cerrarPuertas = new Button(new Icon(VaadinIcon.HEADER), e -> {

		});
		
		panelCuarto.add(abrirPuertas,cerrarPuertas);
		
		botonera.add(panelPrimero, panelSegundo, panelTercero, panelCuarto);
		botonera.setHorizontalComponentAlignment(Alignment.CENTER, panelPrimero);
		botonera.setHorizontalComponentAlignment(Alignment.CENTER, panelCuarto);
		
		botonesExtraAscensorAbierto.add(botonera);
	}

	abstract int getPlantaActual();

	abstract H1 getH1Planta();

	@Override
	public void update(int piso, int idAscensor) {
		this.numeroPisoAscensores[idAscensor].setValue(String.valueOf(piso + 1));
		if (piso == planta) {
			this.ascensoresImagenes[idAscensor].setSrc("images/ascensorAbierto.jpg");
			this.botonesExtraAscensorAbierto[idAscensor].setVisible(true);
		} else {
			this.ascensoresImagenes[idAscensor].setSrc("images/ascensorCerrado.jpg");
			this.botonesExtraAscensorAbierto[idAscensor].setVisible(false);
		}

	}

}
