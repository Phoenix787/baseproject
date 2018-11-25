package ru.bk.xenia;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.dom.Element;


/**
 *Создание компонента с использованием множества элементов
 * например, данный компонент может быть создан используя следующую DOM структуру
 * <div>
 *     <label></label>
 *     <input>
 * </div>
 *
 * Корневой элемент в DOM-структуре <div> помечается с помощью @Tag ("div"), а также создаются
 * и добавляются в корневой элемент label и input.
 * Синхронизация значений настраивается с помощью элемента input
 * Здесь используется альтернативный вариант:
 * inputElement.synchronizeProperty("value", "change");
 */
@Tag("div")
public class TextField extends Component {

    Element labelElement = new Element("label");
    Element inputElement = new Element("input");


    public TextField() {
        inputElement.synchronizeProperty("value", "change");
        getElement().appendChild(labelElement, inputElement);
    }

    /**
     * Добавляем API для установки значений в поле ввода и изменения текста у лэйбла
     * @return
     */
    public String getLabel(){
        return labelElement.getText();
    }

    public String getValue() {
        return inputElement.getProperty("value");
    }

    public void setLabel(String label) {
        labelElement.setText(label);
    }

    public void setValue(String value) {
        inputElement.setProperty("value", value);
    }

}
