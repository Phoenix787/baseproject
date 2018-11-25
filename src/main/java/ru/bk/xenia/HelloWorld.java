package ru.bk.xenia;

import com.vaadin.flow.component.Synchronize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.EventHandler;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;

import java.util.Optional;

@Tag("hello-world")
@HtmlImport("src/hello-world.html")
@Route("hello")
public class HelloWorld extends PolymerTemplate<HelloWorldModel> {

    private static final String EMPTY_NAME_GREETING = "Please enter your name";


    public HelloWorld() {
        setId("template");
        getModel().setGreeting(EMPTY_NAME_GREETING);
    }

    @EventHandler
    public void sayHello() {
        getModel().setGreeting(Optional.ofNullable(getModel().getUserInput())
        .filter(userInput-> !userInput.isEmpty())
        .map(greeting->String.format("Hello. %s", greeting))
        .orElse(EMPTY_NAME_GREETING));

    }
}
