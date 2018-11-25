package ru.bk.xenia;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Synchronize;
import com.vaadin.flow.component.Tag;
import org.github.legioth.field.Field;

@Tag("input")
public class MyTextField extends Component implements Field<MyTextField, String> {

    private static final String DEFAULT_VALUE = "";
    private static final String PROPERTY_NAME = "value";

    public MyTextField() {
        Field.initSingleProperty(this, DEFAULT_VALUE, PROPERTY_NAME)
                .setSynchronizedEvent("change");
    }

    @Synchronize("change")
    public String getValue() {
        return getElement().getProperty(PROPERTY_NAME);
    }

    public void setValue(String value) {
        getElement().setProperty(PROPERTY_NAME, value);
    }
}
