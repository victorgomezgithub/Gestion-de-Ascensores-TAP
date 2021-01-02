package com.example.application.views.about;

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
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import backend.Edificio;
import backend.Observer;

import com.example.application.views.main.MainView;

@Route(value = "about", layout = MainView.class)
@PageTitle("About")
public class Planta1 extends Div implements Observer{

	TextField numeroPisoAscensor1;
	
    public Planta1() {
    	
    	Edificio edificio = Edificio.getSingletonEdificio();
    	edificio.attachObserver(this, 0);
        setId("about-view");
        HorizontalLayout tituloHorizontalLayout = new HorizontalLayout();
        H1 planta  = new H1("PLANTA 1");
        tituloHorizontalLayout.add(planta);
        tituloHorizontalLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        
        
        
        HorizontalLayout ascensores = new HorizontalLayout();
        
        VerticalLayout ascensorVerticalLayout =  new VerticalLayout();
        numeroPisoAscensor1 = new TextField();
        numeroPisoAscensor1.setValue(String.valueOf(edificio.getAscensorPorIndex(0).getPiso()));
        numeroPisoAscensor1.setReadOnly(true);
        numeroPisoAscensor1.setWidth("30px");
        Image ascensor1 = new Image("images/ascensorCerrado.jpg", "Ascensor Cerrado");
        ascensor1.setWidth("250px");
        ascensor1.setHeight("350px");
        Button callButton1 = new Button("Llamar",new Icon(VaadinIcon.PHONE));
        callButton1.addClickListener(e -> {
        	edificio.getPlantaPorIndex(0).llamarAscensor(edificio.getAscensorPorIndex(0));
        });
        callButton1.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        ascensorVerticalLayout.add(numeroPisoAscensor1,ascensor1,callButton1);
        ascensorVerticalLayout.getStyle().set("border", "1px solid #9E9E9E");
        ascensorVerticalLayout.setHorizontalComponentAlignment(Alignment.CENTER, ascensor1);
        ascensorVerticalLayout.setHorizontalComponentAlignment(Alignment.CENTER, numeroPisoAscensor1);
        ascensorVerticalLayout.setHorizontalComponentAlignment(Alignment.CENTER, callButton1);


        
        
        VerticalLayout ascensorVerticalLayout2 = new VerticalLayout();
        TextField numeroPisoAscensor2 = new TextField();
        numeroPisoAscensor2.setValue("0");
        numeroPisoAscensor2.setReadOnly(true);
        numeroPisoAscensor2.setWidth("30px");
        Image ascensor2 = new Image("images/ascensorCerrado.jpg", "Ascensor Cerrado");
        ascensor2.setWidth("250px");
        ascensor2.setHeight("350px");
        Button callButton2 = new Button("Llamar",new Icon(VaadinIcon.PHONE));
        callButton2.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        ascensorVerticalLayout2.add(numeroPisoAscensor2,ascensor2,callButton2);
        ascensorVerticalLayout2.getStyle().set("border", "1px solid #9E9E9E");
        ascensorVerticalLayout2.setHorizontalComponentAlignment(Alignment.CENTER, ascensor2);
        ascensorVerticalLayout2.setHorizontalComponentAlignment(Alignment.CENTER, numeroPisoAscensor2);
        ascensorVerticalLayout2.setHorizontalComponentAlignment(Alignment.CENTER, callButton2);


        
        VerticalLayout ascensorVerticalLayout3 = new VerticalLayout();
        TextField numeroPisoAscensor3 = new TextField();
        numeroPisoAscensor3.setValue("0");
        numeroPisoAscensor3.setReadOnly(true);
        numeroPisoAscensor3.setWidth("30px");
        Button callButton3 = new Button("Llamar",new Icon(VaadinIcon.PHONE));
        Image ascensor3;
        if (true) {
            ascensor3 = new Image("images/ascensorAbierto.jpg", "Ascensor Abierto");
        } else {
            ascensor3 = new Image("images/ascensorCerrado.jpg", "Ascensor Cerrado");

        }
        ascensor3.setWidth("250px");
        ascensor3.setHeight("350px");
        callButton3.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        ascensorVerticalLayout3.add(numeroPisoAscensor3,ascensor3,callButton3);
        ascensorVerticalLayout3.getStyle().set("border", "1px solid #9E9E9E");
        ascensorVerticalLayout3.setHorizontalComponentAlignment(Alignment.CENTER, ascensor3);
        ascensores.add(ascensorVerticalLayout,ascensorVerticalLayout2,ascensorVerticalLayout3);
        ascensorVerticalLayout3.setHorizontalComponentAlignment(Alignment.CENTER, numeroPisoAscensor3);
        ascensorVerticalLayout3.setHorizontalComponentAlignment(Alignment.CENTER, callButton3);
        
        
        
        ascensores.getStyle().set("border", "1px solid #9E9E9E");

        
        
        
        add(tituloHorizontalLayout,ascensores);
    }

	@Override
	public void update(int piso) {
        numeroPisoAscensor1.setValue(String.valueOf(piso));		
	}

}
