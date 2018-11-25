package ru.bk.xenia;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;

@PageTitle("Hello World with components")
@Route(value = "component"/*, layout = MainLayout.class*/)
public class HelloWorldComponent extends Composite<Div> {

    public HelloWorldComponent() {


        PaperInput input = new PaperInput();
       // input.getElement().setAttribute("style", "width:200px");
        input.setStyle("width:200px");

        MyTextField myTextField = new MyTextField();

        Binder<Person> binder = new Binder<>(Person.class);
        binder.bind(myTextField, "name");


        Div greeting = new Div();

        updateGreeting(input, greeting);

        //listen for value change events
        input.addValueChangeListener(event -> updateGreeting(input, greeting));

        input.setId("inputId");
        greeting.setId("greetingId");

        PaperNumberInput numberInput = new PaperNumberInput();
        numberInput.getElement().setAttribute("min", "1");
        numberInput.getElement().setAttribute("max", "12");
        numberInput.getElement().setAttribute("value", "1");
        numberInput.getElement().setAttribute("style", "width:200px");
        numberInput.getElement().setAttribute("step", "0.1");
        numberInput.getElement().setAttribute("label", "Количество");
        numberInput.getElement().setAttribute("fallback-value", "0");
        numberInput.getElement().setProperty("stepUpIcon", "integer-input:step-up");
        numberInput.getElement().setProperty("stepDownIcon", "integer-input:step-down");

        Div numbering = new Div();
        updateNumbering(numberInput, numbering);

        numberInput.addValueChangeListener(e -> updateNumbering(numberInput, numbering));

        getContent().add(input, greeting, numberInput, numbering, myTextField);

    }

    private void updateNumbering(PaperNumberInput numberInput, Div numbering) {
        String num = numberInput.getValue();
        numbering.setText(num);
    }

    private void updateGreeting(PaperInput input, Div greeting) {
        String name = input.getValue();
        if (name == null || name.isEmpty()) {
            greeting.setText("Please enter your name");
        } else {
            greeting.setText(String.format("Hello, %s", name));
        }
    }

    /**
     * Custom component implementation for interacting with the paper-input web component
     */
    @Tag("paper-input")
    @HtmlImport("bower_components/paper-input/paper-input.html")
    public static class PaperInput extends Component{

        /**
         * Automatically send the current value  of the "value" property to the server
         * whenever a value-changed event is fired by the paper-input element
         */

        @Synchronize("value-changed")
        public String getValue() {
            return getElement().getProperty("value");
        }

        public void setStyle(String value) {
            getElement().setAttribute("style", value);
        }

        /**
         * Добавляем слушателя, который автоматически подключается
         * к элементу DOM на основе аннотации класса событий определяемого ниже
         * @param listener
         *
         * @return registration
         */
        public Registration addValueChangeListener(ComponentEventListener<ValueChangeEvent> listener){
            return addListener(ValueChangeEvent.class, listener);
        }
    }

    @DomEvent("value-changed")
    public static class ValueChangeEvent extends ComponentEvent<PaperInput>{

        /**
         * Creates a new event using the given source and indicator whether the
         * event originated from the client side or the server side.
         *
         * @param source     the source component
         * @param fromClient <code>true</code> if the event originated from the client
         */
        public ValueChangeEvent(PaperInput source, boolean fromClient) {
            super(source, fromClient);
        }
    }

    @Tag("paper-number-input")
    @HtmlImport("bower_components/paper-number-input/paper-number-input-icons.html")
    @HtmlImport("bower_components/paper-number-input/paper-number-input.html")
    public static class PaperNumberInput extends Component{

        @Synchronize("value-changed")
        public String getValue() {
            return getElement().getProperty("value");
        }

        public Registration addValueChangeListener(ComponentEventListener<ValueChangeEventNumber> listener) {
            return addListener(ValueChangeEventNumber.class, listener);
        }

    }
    @DomEvent("value-changed")
    public static class ValueChangeEventNumber extends ComponentEvent<PaperNumberInput> {
        /**
         * Creates a new event using the given source and indicator whether the
         * event originated from the client side or the server side.
         *
         * @param source     the source component
         * @param fromClient <code>true</code> if the event originated from the client
         */
        public ValueChangeEventNumber(PaperNumberInput source, boolean fromClient) {
            super(source, fromClient);
        }
    }

}
