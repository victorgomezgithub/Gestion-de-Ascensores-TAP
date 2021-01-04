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


	TextField[] numeroPisoAscensores = new TextField[3];
	Image[] ascensoresImagenes = new Image[3];

	private final int planta = getPlantaActual();
    public PlantaMainViewGeneral() {
    	
    	Edificio edificio = Edificio.getSingletonEdificio();
    	
    	edificio.attachObserver(this, 0);
    	edificio.attachObserver(this, 1);
    	edificio.attachObserver(this, 2);
    	
        setId("about-view");
        HorizontalLayout tituloHorizontalLayout = new HorizontalLayout();
        H1 planta  = getH1Planta();
        tituloHorizontalLayout.add(planta);
        tituloHorizontalLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        
        
         
        HorizontalLayout ascensores = new HorizontalLayout();
        
        VerticalLayout ascensorVerticalLayout =  new VerticalLayout();
        this.numeroPisoAscensores[0] = new TextField();
        this.numeroPisoAscensores[0].setValueChangeMode(ValueChangeMode.EAGER);
        this.numeroPisoAscensores[0].setValue(String.valueOf(edificio.getAscensorPorIndex(0).getPiso()));
        this.numeroPisoAscensores[0].setReadOnly(true);
        this.numeroPisoAscensores[0].setWidth("30px");
        if (this.planta == edificio.getAscensorPorIndex(0).getPiso()) {
            this.ascensoresImagenes[0] = new Image("images/ascensorAbierto.jpg", "Ascensor Abierto");
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
        ascensorVerticalLayout.setHorizontalComponentAlignment(Alignment.CENTER, ascensoresImagenes[0]);
        ascensorVerticalLayout.setHorizontalComponentAlignment(Alignment.CENTER, this.numeroPisoAscensores[0]);
        ascensorVerticalLayout.setHorizontalComponentAlignment(Alignment.CENTER, callButton1);
        
        
        VerticalLayout ascensorVerticalLayout2 = new VerticalLayout();
        this.numeroPisoAscensores[1] = new TextField();
        this.numeroPisoAscensores[1].setValueChangeMode(ValueChangeMode.EAGER);
        this.numeroPisoAscensores[1].setValue(String.valueOf(edificio.getAscensorPorIndex(1).getPiso()));
        this.numeroPisoAscensores[1].setReadOnly(true);
        this.numeroPisoAscensores[1].setWidth("30px");
        if (this.planta == edificio.getAscensorPorIndex(1).getPiso()) {
            this.ascensoresImagenes[1] = new Image("images/ascensorAbierto.jpg", "Ascensor Abierto");
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
        ascensorVerticalLayout2.setHorizontalComponentAlignment(Alignment.CENTER, ascensoresImagenes[1]);
        ascensorVerticalLayout2.setHorizontalComponentAlignment(Alignment.CENTER, this.numeroPisoAscensores[1]);
        ascensorVerticalLayout2.setHorizontalComponentAlignment(Alignment.CENTER, callButton2);


        
        VerticalLayout ascensorVerticalLayout3 = new VerticalLayout();
        this.numeroPisoAscensores[2] = new TextField();
        this.numeroPisoAscensores[2].setValueChangeMode(ValueChangeMode.EAGER);
        this.numeroPisoAscensores[2].setValue(String.valueOf(edificio.getAscensorPorIndex(2).getPiso()));
        this.numeroPisoAscensores[2].setReadOnly(true);
        this.numeroPisoAscensores[2].setWidth("30px");
        Button callButton3 = new Button("Llamar",new Icon(VaadinIcon.PHONE));
        callButton3.addClickListener(e -> {
        	edificio.getPlantaPorIndex(this.planta).llamarAscensor(edificio.getAscensorPorIndex(2));
        });
        if (this.planta == edificio.getAscensorPorIndex(2).getPiso()) {
            this.ascensoresImagenes[2] = new Image("images/ascensorAbierto.jpg", "Ascensor Abierto");
        } else {
            this.ascensoresImagenes[2] = new Image("images/ascensorCerrado.jpg", "Ascensor Cerrado");

        }
        this.ascensoresImagenes[2].setWidth("250px");
        this.ascensoresImagenes[2].setHeight("350px");
        this.ascensoresImagenes[2].onEnabledStateChanged(false);

        callButton3.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        ascensorVerticalLayout3.add(this.numeroPisoAscensores[2],ascensoresImagenes[2],callButton3);
        ascensorVerticalLayout3.setHorizontalComponentAlignment(Alignment.CENTER, ascensoresImagenes[2]);
        ascensores.add(ascensorVerticalLayout,ascensorVerticalLayout2,ascensorVerticalLayout3);
        ascensorVerticalLayout3.setHorizontalComponentAlignment(Alignment.CENTER, this.numeroPisoAscensores[2]);
        ascensorVerticalLayout3.setHorizontalComponentAlignment(Alignment.CENTER, callButton3);
        
        
        

        
        
        
        add(tituloHorizontalLayout,ascensores); 
    }

	abstract int getPlantaActual();

	abstract H1 getH1Planta();

	@Override
	public void update(int piso,int idAscensor) {
		System.out.println(idAscensor);
        this.numeroPisoAscensores[idAscensor].setValue(String.valueOf(piso));
        if(piso == planta) {
        	this.ascensoresImagenes[idAscensor].setSrc("images/ascensorAbierto.jpg");
        }
	}
	
	
}
