package com.example.application.components;

import com.example.application.views.control.PanelDeControl;
import com.example.application.views.planta.Planta1;
import com.example.application.views.planta.Planta2;
import com.example.application.views.planta.Planta3;
import com.example.application.views.planta.Planta4;
import com.example.application.views.planta.Planta5;
import com.example.application.views.planta.Planta6;
import com.example.application.views.planta.Planta7;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.menubar.MenuBarVariant;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.router.RouterLink;


@CssImport("./styles/views/main/main-view.css")
public class MenuBarCustom{

    private MenuBarCustom() {  	
	}
     
	public static MenuBar getMenuBarCustom() {
		MenuBar menuBar = generaMenuBar();
        generaSubMenuPlantas(menuBar);
        return menuBar;
	}

	private static MenuBar generaMenuBar() {
		MenuBar menuBar = new MenuBar();
    	menuBar.setOpenOnHover(true);
        menuBar.addThemeVariants(MenuBarVariant.LUMO_TERTIARY);
        menuBar.getElement().getStyle().set("cursor", "pointer");
    	menuBar.addItem(new Tab((new RouterLink("Panel de Control", PanelDeControl.class))));
		return menuBar;
	}

	private static void generaSubMenuPlantas(MenuBar menuBar) {
		MenuItem plantas = menuBar.addItem(new Tab((new RouterLink("Plantas", PanelDeControl.class))));
        plantas.getSubMenu().addItem(new RouterLink("Planta 1", Planta1.class));
        plantas.getSubMenu().addItem(new RouterLink("Planta 2", Planta2.class));
        plantas.getSubMenu().addItem(new RouterLink("Planta 3", Planta3.class));
        plantas.getSubMenu().addItem(new RouterLink("Planta 4", Planta4.class));
        plantas.getSubMenu().addItem(new RouterLink("Planta 5", Planta5.class));
        plantas.getSubMenu().addItem(new RouterLink("Planta 6", Planta6.class));
        plantas.getSubMenu().addItem(new RouterLink("Planta 7", Planta7.class));
	}
	
}
