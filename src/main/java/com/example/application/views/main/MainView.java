package com.example.application.views.main;

import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.charts.model.Navigator;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.menubar.MenuBarVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;
import com.example.application.components.MenuBarCustom;
import com.example.application.views.about.Planta1;
import com.example.application.views.helloworld.HelloWorldView;
import com.example.application.views.main.MainView;

/**
 * The main view is a top-level placeholder for other views.
 */
@CssImport(value = "./styles/views/main/main-view.css", themeFor = "vaadin-app-layout")
@CssImport("./styles/views/main/main-view.css")
@PWA(name = "My Project", shortName = "My Project", enableInstallPrompt = false)
@JsModule("./styles/shared-styles.js")
public class MainView extends AppLayout {

	private Navigator navigator = null;

	
    public MainView() {
        HorizontalLayout header = createHeader();
    	MenuBar barmenu = MenuBarCustom.getMenuBarCustom();
    	addToNavbar(header,barmenu);
    	
    }


	private HorizontalLayout createHeader() {
        HorizontalLayout header = new HorizontalLayout();
        header.setPadding(false);
        header.setSpacing(false);
        header.setWidthFull();
        header.setAlignItems(FlexComponent.Alignment.CENTER);
        header.setId("header");
        Image logo = new Image("images/logo.png", "My Project logo");
        logo.setId("logo");
        header.add(logo);
        header.add(new H1("Gestion de Ascensores"));
        return header;
    }
	
}
