package com.example.application.views.helloworld;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.example.application.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "hello", layout = MainView.class)
@PageTitle("Hello World")
@RouteAlias(value = "", layout = MainView.class)
public class HelloWorldView extends Div {

    public HelloWorldView() {
        setId("hello-world-view");
        add(new Text("Content placeholder"));
    }

}
