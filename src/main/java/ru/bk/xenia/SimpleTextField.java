package ru.bk.xenia;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Input;
import com.vaadin.flow.component.html.Label;


/**
 * В данном примере создается компонент с использованием существующих HTML компонентов
 * Структура будет следующей
 * Div
 *   Label
 *   Input
 *
 *   Один из вариантов: можно было бы создать компонент, расширяя компонент Div,
 *   но это предоставило бы пользователю весь API компонента Div, например как метод add (Component).
 *   Чтобы избежать этого, компонент может быть основан на Composite.
 *
 *   Composite автоматически создаст корневой компонент, основанный на дженерике ( в нашем случае это будет Div)
 *   и он будет доступен с помощью getContent()
 *   в конструкторе нужно только создать другие компоненты и добавить их в корневой Div
 *   Значения устанавливаются с помощью setValue у Input компонента
 *
 */
public class SimpleTextField extends Composite<Div> {
    private Label label;
    private Input input;

    public SimpleTextField(String labelText, String value) {
        label = new Label();
        label.setText(labelText);
        input = new Input();
        input.setValue(value);

        getContent().add(label, input);
    }

    /**
     * открытый API текстового поля содержит только определенные методы в дополнение
     * к нескольким универсальным методам, определенным в интерфейсе Component
     *
     * использование Composite не создает накладных расходов в браузере
     *
     * использование компонентов вместо элементов не создает накладных расходов в браузере
     * @return
     */

    public String getLabel() {
        return label.getText();
    }

    public String getValue() {
        return input.getValue();
    }

    public void setLabel(String labelText) {
        label.setText(labelText);
    }

    public void setValue(String value) {
        input.setValue(value);
    }
}
