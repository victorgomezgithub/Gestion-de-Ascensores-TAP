package com.example.application.views.planta;

import java.util.ArrayList;

import javax.swing.text.html.HTML;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import backend.Edificio;
import backend.Observer;

public abstract class PlantaMainViewGeneral extends Div implements Observer {

	// LINEA UTIL PARA COMPRENDER LOS LAYOUT
	// botonera.getStyle().set("border", "1px solid #9E9E9E");

	private TextField[] numeroPisoAscensores;
	private Image[] ascensoresImagenes;
	private ArrayList<Button> panelDeBotones;

	private final int planta = getPlantaActual();
	private Edificio edificio;

	private HorizontalLayout[] botonesExtraAscensorAbierto;

	
	
	// Constructor, inicializa el edificio, numero de ascensores, las huecos para las imágenes. 
	
	
	public PlantaMainViewGeneral() {

		this.edificio = Edificio.getSingletonEdificio();
		this.numeroPisoAscensores = new TextField[edificio.getAscensoresLength()];
		this.ascensoresImagenes = new Image[edificio.getAscensoresLength()];
		botonesExtraAscensorAbierto = new HorizontalLayout[edificio.getAscensoresLength()];

		attachObservers();

		HorizontalLayout tituloHorizontalLayout = generaTituloPlanta();

		HorizontalLayout ascensores = new HorizontalLayout();

		for (int i = 0; i < edificio.getAscensoresLength(); i++) {
			VerticalLayout ascensorVerticalLayout = generalVistaAscensor(i);
			ascensores.add(ascensorVerticalLayout);
		}
		
		HorizontalLayout panelDeReinicio = generaBotonDeReinicio();

		add(tituloHorizontalLayout, ascensores, panelDeReinicio);
	}

	
	// Crea el botón de reinicio
	
	private HorizontalLayout generaBotonDeReinicio() {
		HorizontalLayout panelDeReinicio = new HorizontalLayout();
		
		Button botonReinicio = new Button("Reiniciar el sistema", new Icon(VaadinIcon.STOP));
		Dialog dialogoReinicio = generaDialogoDeReinicio();
		botonReinicio.addThemeVariants(ButtonVariant.LUMO_ERROR);
		botonReinicio.addClickListener(e -> { dialogoReinicio.open(); });
		panelDeReinicio.add(botonReinicio);
		panelDeReinicio.setJustifyContentMode(JustifyContentMode.CENTER);
		panelDeReinicio.setMargin(true);
		return panelDeReinicio;
	}
	
	
	
	// Díalogo que aparece en caso de pulsar el botón de reinicio
	// Puedes cancelar el reinicio
	
	private Dialog generaDialogoDeReinicio() {
		Dialog dialog = new Dialog();

		dialog.setCloseOnEsc(false);
		dialog.setCloseOnOutsideClick(false);
		dialog.add(new Html("<p>¿Seguro que quiere <b>reiniciar</b> el sistema?</p>\n"));
		Button confirmButton = new Button("Confirmar", VaadinIcon.CHECK.create(), event -> {

			edificio.reiniciarSistema();
		    dialog.close();
			UI.getCurrent().getPage().reload();
			creaNotificacionLumoContrast("Reiniciando...");		    
		});
		Button cancelButton = new Button("Cancel",VaadinIcon.CLOSE.create(), event -> {
			dialog.close();
			creaNotificacionLumoContrast("Cancelado...");		    
		});
		
		confirmButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
		confirmButton.setClassName("boton");
		cancelButton.addThemeVariants(ButtonVariant.LUMO_ERROR);

		dialog.add(confirmButton, cancelButton);
		
		return dialog;
	}
	
	
	// Muestra un cuadro de diálogo con el texto que se le pase
	private void creaNotificacionLumoContrast(String mensaje) {
		Notification notificacionCancelado = new Notification(mensaje, 4000);
		notificacionCancelado.addThemeVariants(NotificationVariant.LUMO_CONTRAST);
		notificacionCancelado.setPosition(Position.MIDDLE);
		notificacionCancelado.open();
	}
	
	// Crea un espacio para cada uno de los ascensores, son tres de forma predeterminada, pero se pueden agregar o eliminar ascensores 
	private VerticalLayout generalVistaAscensor(int numeroVista) {
		VerticalLayout ascensorVerticalLayout3 = new VerticalLayout();
		botonesExtraAscensorAbierto[numeroVista] = new HorizontalLayout();
		this.numeroPisoAscensores[numeroVista] = new TextField();
		this.numeroPisoAscensores[numeroVista].setValueChangeMode(ValueChangeMode.EAGER);
		this.numeroPisoAscensores[numeroVista].setValue(String.valueOf(edificio.getAscensorPorIndex(numeroVista).getPiso() + 1));
		this.numeroPisoAscensores[numeroVista].setReadOnly(true);
		this.numeroPisoAscensores[numeroVista].setWidth("30px");
		Button callButton3 = new Button("Llamar", new Icon(VaadinIcon.PHONE));
		callButton3.addClickListener(e -> {
			edificio.getPlantaPorIndex(this.planta).llamarAscensor(edificio.getAscensorPorIndex(numeroVista));
			Notification alarm = new Notification("¡Llegada del Ascensor " + (this.edificio.getAscensorPorIndex(numeroVista).getIdAscensor() + 1) + "!" , 4000);
			alarm.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
			alarm.setPosition(Position.MIDDLE);
			alarm.open();
		});
		
		panelDeBotones = new ArrayList<Button>();
		getPanelDeBotones(this.botonesExtraAscensorAbierto[numeroVista], numeroVista);
		
		if (checkPuertasAbiertas(numeroVista)) {
			this.ascensoresImagenes[numeroVista] = new Image("images/ascensorAbierto.jpg", "Ascensor Abierto");
			botonesExtraAscensorAbierto[numeroVista].setVisible(true);
		} else {
			this.ascensoresImagenes[numeroVista] = new Image("images/ascensorCerrado.jpg", "Ascensor Cerrado");
			botonesExtraAscensorAbierto[numeroVista].setVisible(false);
		}
		this.ascensoresImagenes[numeroVista].setWidth("250px");
		this.ascensoresImagenes[numeroVista].setHeight("350px");
		this.ascensoresImagenes[numeroVista].onEnabledStateChanged(false);

		HorizontalLayout panelCuarto = new HorizontalLayout();
		
		Button abrirPuertas = new Button(new Icon(VaadinIcon.EXPAND_SQUARE), e -> {
			this.edificio.getAscensorPorIndex(numeroVista).abrirPuertas();
		});
		Button cerrarPuertas = new Button(new Icon(VaadinIcon.COMPRESS_SQUARE), e -> {
			this.edificio.getAscensorPorIndex(numeroVista).cerrarPuertas();
		});
		
		panelCuarto.add(abrirPuertas,cerrarPuertas);
		
		callButton3.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
		ascensorVerticalLayout3.add(this.numeroPisoAscensores[numeroVista], ascensoresImagenes[numeroVista], callButton3, panelCuarto);
		ascensorVerticalLayout3.add(this.botonesExtraAscensorAbierto[numeroVista]);
		alignItemsInVerticalLayout(numeroVista, ascensorVerticalLayout3, callButton3, panelCuarto);
		return ascensorVerticalLayout3;
	}

	private void alignItemsInVerticalLayout(int numeroVista, VerticalLayout ascensorVerticalLayout3,Button callButton3, HorizontalLayout panelCuarto) {
		ascensorVerticalLayout3.setHorizontalComponentAlignment(Alignment.CENTER,this.botonesExtraAscensorAbierto[numeroVista]);
		ascensorVerticalLayout3.setHorizontalComponentAlignment(Alignment.CENTER, ascensoresImagenes[numeroVista]);
		ascensorVerticalLayout3.setHorizontalComponentAlignment(Alignment.CENTER,this.numeroPisoAscensores[numeroVista]);
		ascensorVerticalLayout3.setHorizontalComponentAlignment(Alignment.CENTER, callButton3);
		ascensorVerticalLayout3.setHorizontalComponentAlignment(Alignment.CENTER, panelCuarto);
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
		for(int i = 0; i < edificio.getAscensoresLength(); i++) {
			this.edificio.attachObserver(this, i);
		}
	}

	private void getPanelDeBotones(HorizontalLayout botonesExtraAscensorAbierto, int ascensor) {
		VerticalLayout botonera = new VerticalLayout();
		HorizontalLayout panelPrimero = new HorizontalLayout();
		HorizontalLayout panelSegundo = new HorizontalLayout();
		HorizontalLayout panelTercero = new HorizontalLayout();
		for (int i = 0; i <= 6; i++) {
			Button boton = new Button(String.valueOf(i + 1));
			boton.addClickListener(e -> {
				this.edificio.getPlantaPorIndex(Integer.parseInt(boton.getText()) - 1).llamarAscensor(this.edificio.getAscensorPorIndex(ascensor));
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
			Notification alarm = new Notification("¡Alarma en el Ascensor " + (this.edificio.getAscensorPorIndex(ascensor).getIdAscensor() + 1) + "!" , 4000);
			alarm.addThemeVariants(NotificationVariant.LUMO_ERROR);
			alarm.setPosition(Position.MIDDLE);
			alarm.open();
		});
		alarma.addThemeVariants(ButtonVariant.LUMO_ERROR);
		panelPrimero.add(alarma);
		
		
		botonera.add(panelPrimero, panelSegundo, panelTercero);
		botonera.setHorizontalComponentAlignment(Alignment.CENTER, panelPrimero);
		
		botonesExtraAscensorAbierto.add(botonera);
	}

	abstract int getPlantaActual();

	abstract H1 getH1Planta();

	@Override 
	public void update(int piso, int idAscensor) {
		this.numeroPisoAscensores[idAscensor].setValue(String.valueOf(piso + 1));
		if (checkPuertasAbiertas(idAscensor)) {
			this.ascensoresImagenes[idAscensor].setSrc("images/ascensorAbierto.jpg");
			this.botonesExtraAscensorAbierto[idAscensor].setVisible(true);
		} else {
			this.ascensoresImagenes[idAscensor].setSrc("images/ascensorCerrado.jpg");
			this.botonesExtraAscensorAbierto[idAscensor].setVisible(false);
		}

	}
	
	
	public boolean checkPuertasAbiertas(int idAscensor) {		
		if(this.planta == edificio.getAscensorPorIndex(idAscensor).getPiso() && edificio.getAscensorPorIndex(idAscensor).getPuerta() == true) {
			return true;
		} else {
			return false;
		}		
	}

}
