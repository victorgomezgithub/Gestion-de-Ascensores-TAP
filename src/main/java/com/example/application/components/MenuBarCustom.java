package com.example.application.components;

import com.example.application.views.about.AboutView;
import com.example.application.views.helloworld.HelloWorldView;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.menubar.MenuBarVariant;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.router.RouterLink;

public class MenuBarCustom{


	
    private MenuBarCustom() {  	
	}
     
	public static MenuBar getMenuBarCustom() {
		MenuBar menuBar = new MenuBar();
		
    	menuBar.setOpenOnHover(true);
    	
    	menuBar.addItem(new Tab((new RouterLink("Panel de Control", HelloWorldView.class))));
        MenuItem plantas = menuBar.addItem(new Tab((new RouterLink("Plantas", HelloWorldView.class))));
        plantas.getSubMenu().addItem(new Tab(new RouterLink("Planta 1", AboutView.class)));
        menuBar.addThemeVariants(MenuBarVariant.LUMO_TERTIARY);
        
        return menuBar;
	}
	
}
