package com.example.application.views.about;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.FlexLayout.ContentAlignment;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.example.application.views.main.MainView;

@Route(value = "about", layout = MainView.class)
@PageTitle("About")
public class Planta1 extends Div {

    public Planta1() {
        setId("about-view");
        HorizontalLayout tituloHorizontalLayout = new HorizontalLayout();
        H1 planta  = new H1("PLANTA 1");
        tituloHorizontalLayout.add(planta);
        tituloHorizontalLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        
        
        
        HorizontalLayout ascensores = new HorizontalLayout();
        
        VerticalLayout ascensorVerticalLayout =  new VerticalLayout();
        TextField numeroPisoAscensor1 = new TextField();
        numeroPisoAscensor1.setValue("0");
        numeroPisoAscensor1.setReadOnly(true);
        numeroPisoAscensor1.setWidth("30px");
        Image ascensor1 = new Image("images/ascensorCerrado.jpg", "Ascensor Cerrado");
        ascensorVerticalLayout.add(numeroPisoAscensor1,ascensor1);
        ascensorVerticalLayout.getStyle().set("border", "1px solid #9E9E9E");
        ascensorVerticalLayout.setHorizontalComponentAlignment(Alignment.CENTER, ascensor1);
        ascensorVerticalLayout.setHorizontalComponentAlignment(Alignment.CENTER, numeroPisoAscensor1);


        
        
        VerticalLayout ascensorVerticalLayout2 = new VerticalLayout();
        TextField numeroPisoAscensor2 = new TextField();
        numeroPisoAscensor2.setValue("0");
        numeroPisoAscensor2.setReadOnly(true);
        numeroPisoAscensor2.setWidth("30px");
        Image ascensor2 = new Image("images/ascensorCerrado.jpg", "Ascensor Cerrado");
        ascensorVerticalLayout2.add(numeroPisoAscensor2,ascensor2);
        ascensorVerticalLayout2.getStyle().set("border", "1px solid #9E9E9E");
        ascensorVerticalLayout2.setHorizontalComponentAlignment(Alignment.CENTER, ascensor2);
        ascensorVerticalLayout.setHorizontalComponentAlignment(Alignment.CENTER, numeroPisoAscensor2);


        
        
        VerticalLayout ascensorVerticalLayout3 = new VerticalLayout();
        TextField numeroPisoAscensor3 = new TextField();
        numeroPisoAscensor3.setValue("0");
        numeroPisoAscensor3.setReadOnly(true);
        numeroPisoAscensor3.setWidth("30px");
        Image ascensor3 = new Image("images/ascensorCerrado.jpg", "Ascensor Cerrado");
        ascensorVerticalLayout3.add(numeroPisoAscensor3,ascensor3);
        ascensorVerticalLayout3.getStyle().set("border", "1px solid #9E9E9E");
        ascensorVerticalLayout3.setHorizontalComponentAlignment(Alignment.CENTER, ascensor3);
        ascensores.add(ascensorVerticalLayout,ascensorVerticalLayout2,ascensorVerticalLayout3);
        ascensorVerticalLayout.setHorizontalComponentAlignment(Alignment.CENTER, numeroPisoAscensor3);
        
        
        ascensores.getStyle().set("border", "1px solid #9E9E9E");

        
        
        
        add(tituloHorizontalLayout,ascensores);
    }

}
