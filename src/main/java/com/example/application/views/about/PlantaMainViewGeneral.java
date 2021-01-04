package com.example.application.views.about;

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


	TextField numeroPisoAscensor1;
	TextField numeroPisoAscensor2;
	TextField numeroPisoAscensor3;
	Image ascensor1;
	Image ascensor2;
    Image ascensor3;

	private final int planta = getPlantaActual();
    public PlantaMainViewGeneral() {
    	
    	Edificio edificio = Edificio.getSingletonEdificio();
    	edificio.attachObserver(this, 0);
        setId("about-view");
        HorizontalLayout tituloHorizontalLayout = new HorizontalLayout();
        H1 planta  = getH1Planta();
        tituloHorizontalLayout.add(planta);
        tituloHorizontalLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        
        
        
        HorizontalLayout ascensores = new HorizontalLayout();
        
        VerticalLayout ascensorVerticalLayout =  new VerticalLayout();
        this.numeroPisoAscensor1 = new TextField();
        this.numeroPisoAscensor1.setValueChangeMode(ValueChangeMode.EAGER);
        this.numeroPisoAscensor1.setValue(String.valueOf(edificio.getAscensorPorIndex(0).getPiso()));
        this.numeroPisoAscensor1.setReadOnly(true);
        this.numeroPisoAscensor1.setWidth("30px");
        if (this.planta == edificio.getAscensorPorIndex(0).getPiso()) {
            this.ascensor1 = new Image("images/ascensorAbierto.jpg", "Ascensor Abierto");
        } else {
            this.ascensor1 = new Image("images/ascensorCerrado.jpg", "Ascensor Cerrado");

        }
        ascensor1.onEnabledStateChanged(false);
        
        this.ascensor1.setWidth("250px");
        this.ascensor1.setHeight("350px"); 
        Button callButton1 = new Button("Llamar",new Icon(VaadinIcon.PHONE));
        callButton1.addClickListener(e -> {
        	edificio.getPlantaPorIndex(this.planta).llamarAscensor(edificio.getAscensorPorIndex(0));
        });
        callButton1.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        ascensorVerticalLayout.add(numeroPisoAscensor1,ascensor1,callButton1);
        ascensorVerticalLayout.setHorizontalComponentAlignment(Alignment.CENTER, ascensor1);
        ascensorVerticalLayout.setHorizontalComponentAlignment(Alignment.CENTER, numeroPisoAscensor1);
        ascensorVerticalLayout.setHorizontalComponentAlignment(Alignment.CENTER, callButton1);
        
        
        VerticalLayout ascensorVerticalLayout2 = new VerticalLayout();
        numeroPisoAscensor2 = new TextField();
        this.numeroPisoAscensor2.setValueChangeMode(ValueChangeMode.EAGER);
        this.numeroPisoAscensor2.setValue(String.valueOf(edificio.getAscensorPorIndex(1).getPiso()));
        this.numeroPisoAscensor2.setReadOnly(true);
        this.numeroPisoAscensor2.setWidth("30px");
        if (this.planta == edificio.getAscensorPorIndex(1).getPiso()) {
            this.ascensor2 = new Image("images/ascensorAbierto.jpg", "Ascensor Abierto");
        } else {
            this.ascensor2 = new Image("images/ascensorCerrado.jpg", "Ascensor Cerrado");

        }       
        this.ascensor2.setWidth("250px");
        this.ascensor2.setHeight("350px");
        this.ascensor2.onEnabledStateChanged(false);

        Button callButton2 = new Button("Llamar",new Icon(VaadinIcon.PHONE));
        callButton2.addClickListener(e -> {
        	edificio.getPlantaPorIndex(this.planta).llamarAscensor(edificio.getAscensorPorIndex(1));
        });
        callButton2.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        ascensorVerticalLayout2.add(numeroPisoAscensor2,ascensor2,callButton2);
        ascensorVerticalLayout2.setHorizontalComponentAlignment(Alignment.CENTER, ascensor2);
        ascensorVerticalLayout2.setHorizontalComponentAlignment(Alignment.CENTER, numeroPisoAscensor2);
        ascensorVerticalLayout2.setHorizontalComponentAlignment(Alignment.CENTER, callButton2);


        
        VerticalLayout ascensorVerticalLayout3 = new VerticalLayout();
        this.numeroPisoAscensor3 = new TextField();
        this.numeroPisoAscensor3.setValueChangeMode(ValueChangeMode.EAGER);
        this.numeroPisoAscensor3.setValue(String.valueOf(edificio.getAscensorPorIndex(2).getPiso()));
        this.numeroPisoAscensor3.setReadOnly(true);
        this.numeroPisoAscensor3.setWidth("30px");
        Button callButton3 = new Button("Llamar",new Icon(VaadinIcon.PHONE));
        callButton3.addClickListener(e -> {
        	edificio.getPlantaPorIndex(this.planta).llamarAscensor(edificio.getAscensorPorIndex(2));
        });
        if (this.planta == edificio.getAscensorPorIndex(2).getPiso()) {
            this.ascensor3 = new Image("images/ascensorAbierto.jpg", "Ascensor Abierto");
        } else {
            this.ascensor3 = new Image("images/ascensorCerrado.jpg", "Ascensor Cerrado");

        }
        this.ascensor3.setWidth("250px");
        this.ascensor3.setHeight("350px");
        this.ascensor3.onEnabledStateChanged(false);

        callButton3.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        ascensorVerticalLayout3.add(numeroPisoAscensor3,ascensor3,callButton3);
        ascensorVerticalLayout3.setHorizontalComponentAlignment(Alignment.CENTER, ascensor3);
        ascensores.add(ascensorVerticalLayout,ascensorVerticalLayout2,ascensorVerticalLayout3);
        ascensorVerticalLayout3.setHorizontalComponentAlignment(Alignment.CENTER, numeroPisoAscensor3);
        ascensorVerticalLayout3.setHorizontalComponentAlignment(Alignment.CENTER, callButton3);
        
        
        

        
        
        
        add(tituloHorizontalLayout,ascensores); 
    }

	abstract int getPlantaActual();

	abstract H1 getH1Planta();

	@Override
	public void update(int piso) {
        this.numeroPisoAscensor1.setValue(String.valueOf(piso));
        if(piso == planta) {
        	this.ascensor1.setSrc("images/ascensorAbierto.jpg");
        }
	}
	
	
}
