package ru.bk.xenia;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
public class MainView extends VerticalLayout {

    public MainView() {


        Label textByElementApi = new Label("Input created by Element API");
        TextFieldUseElementAPI fieldUseElementAPI = new TextFieldUseElementAPI("Simple text");
        fieldUseElementAPI.setEnabled(true);
        SimpleTextField textField = new SimpleTextField("Simple text field", "value");
        Button button = new Button("Click me",
                event -> Notification.show(fieldUseElementAPI.getValue()));
        add(textByElementApi, fieldUseElementAPI, button, textField);
    }


}
