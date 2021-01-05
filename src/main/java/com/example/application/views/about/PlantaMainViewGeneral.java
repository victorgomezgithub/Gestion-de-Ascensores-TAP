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
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import backend.Edificio;
import backend.Observer;


public abstract class PlantaMainViewGeneral extends Div implements Observer{

	//LINEA UTIL PARA COMPRENDER LOS LAYOUT
	//botonera.getStyle().set("border", "1px solid #9E9E9E");

	
	private TextField[] numeroPisoAscensores = new TextField[3];
	private Image[] ascensoresImagenes = new Image[3];
	private ArrayList<Button> panelDeBotones;


	private final int planta = getPlantaActual();
	private Edificio edificio;
	
	private HorizontalLayout[] botonesExtraAscensorAbierto = new HorizontalLayout[3];
	
	
    public PlantaMainViewGeneral() {
    	
    	this.edificio = Edificio.getSingletonEdificio();
    	
    	this.edificio.attachObserver(this, 0);
    	this.edificio.attachObserver(this, 1);
    	this.edificio.attachObserver(this, 2);
    	
    	
    	setId("about-view");
        HorizontalLayout tituloHorizontalLayout = new HorizontalLayout();
        H1 planta  = getH1Planta();
        tituloHorizontalLayout.add(planta);
        tituloHorizontalLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        
        
         
        HorizontalLayout ascensores = new HorizontalLayout();       
        VerticalLayout ascensorVerticalLayout =  new VerticalLayout();
        this.botonesExtraAscensorAbierto[0] = new HorizontalLayout();
        
        this.numeroPisoAscensores[0] = new TextField();
        this.numeroPisoAscensores[0].setValueChangeMode(ValueChangeMode.EAGER);
        this.numeroPisoAscensores[0].setValue(String.valueOf(edificio.getAscensorPorIndex(0).getPiso() + 1));
        this.numeroPisoAscensores[0].setReadOnly(true);
        this.numeroPisoAscensores[0].setWidth("30px");
        if (this.planta == edificio.getAscensorPorIndex(0).getPiso()) {
            this.ascensoresImagenes[0] = new Image("images/ascensorAbierto.jpg", "Ascensor Abierto");
            panelDeBotones = new ArrayList<Button>();
            getPanelDeBotones(this.botonesExtraAscensorAbierto[0],0);
        } else {
            this.ascensoresImagenes[0] = new Image("images/ascensorCerrado.jpg", "Ascensor Cerrado");
        }
        this.ascensoresImagenes[0].onEnabledStateChanged(false); 
        
        this.ascensoresImagenes[0].setWidth("250px");
        this.ascensoresImagenes[0].setHeight("350px"); 
        Button callButton1 = new Button("Llamar",new Icon(VaadinIcon.PHONE));
        callButton1.addClickListener(e -> {
        	edificio.getPlantaPorIndex(this.planta).llamarAscensor(edificio.getAscensorPorIndex(0));
        });
        callButton1.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        ascensorVerticalLayout.add(this.numeroPisoAscensores[0],ascensoresImagenes[0],callButton1);
        ascensorVerticalLayout.add(this.botonesExtraAscensorAbierto[0]);
        ascensorVerticalLayout.setHorizontalComponentAlignment(Alignment.CENTER, this.botonesExtraAscensorAbierto[0]);
        ascensorVerticalLayout.setHorizontalComponentAlignment(Alignment.CENTER, ascensoresImagenes[0]);
        ascensorVerticalLayout.setHorizontalComponentAlignment(Alignment.CENTER, this.numeroPisoAscensores[0]);
        ascensorVerticalLayout.setHorizontalComponentAlignment(Alignment.CENTER, callButton1);
       
        
        VerticalLayout ascensorVerticalLayout2 = new VerticalLayout();
        this.botonesExtraAscensorAbierto[1] = new HorizontalLayout();
        this.numeroPisoAscensores[1] = new TextField();
        this.numeroPisoAscensores[1].setValueChangeMode(ValueChangeMode.EAGER);
        this.numeroPisoAscensores[1].setValue(String.valueOf(edificio.getAscensorPorIndex(1).getPiso() + 1));
        this.numeroPisoAscensores[1].setReadOnly(true);
        this.numeroPisoAscensores[1].setWidth("30px");
        if (this.planta == edificio.getAscensorPorIndex(1).getPiso()) {
            this.ascensoresImagenes[1] = new Image("images/ascensorAbierto.jpg", "Ascensor Abierto"); 
            panelDeBotones = new ArrayList<Button>();
            getPanelDeBotones(this.botonesExtraAscensorAbierto[1],1);
        } else {
            this.ascensoresImagenes[1] = new Image("images/ascensorCerrado.jpg", "Ascensor Cerrado");
        }       
        this.ascensoresImagenes[1].setWidth("250px");
        this.ascensoresImagenes[1].setHeight("350px");
        this.ascensoresImagenes[1].onEnabledStateChanged(false);

        Button callButton2 = new Button("Llamar",new Icon(VaadinIcon.PHONE));
        callButton2.addClickListener(e -> {
        	edificio.getPlantaPorIndex(this.planta).llamarAscensor(edificio.getAscensorPorIndex(1));
        });
        callButton2.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        ascensorVerticalLayout2.add(this.numeroPisoAscensores[1],ascensoresImagenes[1],callButton2);
        ascensorVerticalLayout2.add(this.botonesExtraAscensorAbierto[1]);
        ascensorVerticalLayout2.setHorizontalComponentAlignment(Alignment.CENTER, this.botonesExtraAscensorAbierto[1]);
        ascensorVerticalLayout2.setHorizontalComponentAlignment(Alignment.CENTER, ascensoresImagenes[1]);
        ascensorVerticalLayout2.setHorizontalComponentAlignment(Alignment.CENTER, this.numeroPisoAscensores[1]);
        ascensorVerticalLayout2.setHorizontalComponentAlignment(Alignment.CENTER, callButton2);


        
        VerticalLayout ascensorVerticalLayout3 = new VerticalLayout();
        botonesExtraAscensorAbierto[2] = new HorizontalLayout();
        this.numeroPisoAscensores[2] = new TextField();
        this.numeroPisoAscensores[2].setValueChangeMode(ValueChangeMode.EAGER);
        this.numeroPisoAscensores[2].setValue(String.valueOf(edificio.getAscensorPorIndex(2).getPiso() + 1));
        this.numeroPisoAscensores[2].setReadOnly(true);
        this.numeroPisoAscensores[2].setWidth("30px");
        Button callButton3 = new Button("Llamar",new Icon(VaadinIcon.PHONE));
        callButton3.addClickListener(e -> {
        	edificio.getPlantaPorIndex(this.planta).llamarAscensor(edificio.getAscensorPorIndex(2));
        });
        if (this.planta == edificio.getAscensorPorIndex(2).getPiso()) {
            this.ascensoresImagenes[2] = new Image("images/ascensorAbierto.jpg", "Ascensor Abierto");
            panelDeBotones = new ArrayList<Button>();
            getPanelDeBotones(this.botonesExtraAscensorAbierto[2],2);
        } else {
            this.ascensoresImagenes[2] = new Image("images/ascensorCerrado.jpg", "Ascensor Cerrado");

        }
        this.ascensoresImagenes[2].setWidth("250px");
        this.ascensoresImagenes[2].setHeight("350px");
        this.ascensoresImagenes[2].onEnabledStateChanged(false);

        callButton3.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        ascensorVerticalLayout3.add(this.numeroPisoAscensores[2],ascensoresImagenes[2],callButton3);
        ascensorVerticalLayout3.add(this.botonesExtraAscensorAbierto[2]);
        ascensorVerticalLayout3.setHorizontalComponentAlignment(Alignment.CENTER, this.botonesExtraAscensorAbierto[2]);
        ascensorVerticalLayout3.setHorizontalComponentAlignment(Alignment.CENTER, ascensoresImagenes[2]);
        ascensorVerticalLayout3.setHorizontalComponentAlignment(Alignment.CENTER, this.numeroPisoAscensores[2]);
        ascensorVerticalLayout3.setHorizontalComponentAlignment(Alignment.CENTER, callButton3);
        
        ascensores.add(ascensorVerticalLayout,ascensorVerticalLayout2,ascensorVerticalLayout3);
        
        add(tituloHorizontalLayout,ascensores); 
    }

	private void getPanelDeBotones(HorizontalLayout botonesExtraAscensorAbierto, int ascensor) {
		VerticalLayout botonera = new VerticalLayout();
		HorizontalLayout panelPrimero = new HorizontalLayout();
		HorizontalLayout panelSegundo = new HorizontalLayout();
		HorizontalLayout panelTercero = new HorizontalLayout();
		for(int i = 0; i <= 6 ;i++) {
			Button boton = new Button(String.valueOf(i + 1));
			boton.addClickListener(e-> {
				this.edificio.getPlantaPorIndex(Integer.parseInt(boton.getText()) - 1).llamarAscensor(this.edificio.getAscensorPorIndex(ascensor));
			});
			
			panelDeBotones.add(boton);
			if(i == 0) {
				panelPrimero.add(panelDeBotones.get(i));
			} else if (i > 0 && i <= 3) {
				panelSegundo.add(panelDeBotones.get(i));
			} else {
				panelTercero.add(panelDeBotones.get(i));
			}
		}
		botonera.add(panelPrimero,panelSegundo,panelTercero);
		botonera.setHorizontalComponentAlignment(Alignment.CENTER, panelPrimero);
		
		botonesExtraAscensorAbierto.add(botonera);
	}

	abstract int getPlantaActual();

	abstract H1 getH1Planta();

	@Override
	public void update(int piso,int idAscensor) {
        this.numeroPisoAscensores[idAscensor].setValue(String.valueOf(piso));
        if(piso == planta) {
        	this.ascensoresImagenes[idAscensor].setSrc("images/ascensorAbierto.jpg");	
        } else {
        	this.ascensoresImagenes[idAscensor].setSrc("images/ascensorCerrado.jpg");
            this.botonesExtraAscensorAbierto[idAscensor].setVisible(false);
        }
        
	}
	
	
}
