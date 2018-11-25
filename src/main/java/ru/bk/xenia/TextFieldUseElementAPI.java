package ru.bk.xenia;


import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasEnabled;
import com.vaadin.flow.component.Synchronize;
import com.vaadin.flow.component.Tag;

/**
 * Для создания компонента основанного на <input>. В данном классе используется Element API
 * и одиночный DOM элемент
 * расширяет класс {@link Component}
 * Component автоматически создает корневой элемент основанный на аннотации @Tag("имя DOM-элемента")
 * далее для доступа к этому корневому элементу используем метод getElement()
 */
@Tag("input")
public class TextFieldUseElementAPI extends Component implements HasEnabled {

    public TextFieldUseElementAPI(String value) {
        getElement().setProperty("value", value);
    }

    /**
     * для облегчения использования компонента добавляем в API геттеры и сеттеры
     * чтобы фреймворк посылал изменения свойств (пропертей) из браузера на сервер добавляем
     * аннотацию {@link @Synchronize}. Аннотация определяет имя DOM-элемента,
     * с которым триггеры синхронизируютсяю В этом примере событие "change" из input-элемента, которое
     * вызовет обновление свойства "value" (выводится из имени геттера), будет отправлено на сервер
     * из браузера.
     * Аннотация Synchronize сопоставляет события происходящие только от корня веб-компонента (или восходящие
     * к нему). Например, есть эелемент <div> как корень и элемент <input> внутри него.
     * единственные события, которые могут быть сопоставлены с помощью @Synchronized,
     * - это события из элемента <div>
     * @return
     */
    @Synchronize("change")
    public String getValue() {
        return getElement().getProperty("value");
    }

    public void setValue(String value) {
        getElement().setProperty("value", value);
    }

    /**
     * setEnabled  будет доступен после имплементации интерфейса HasEnabled
     * (который также идет с HasValue, HasComponents, Focusable)
     */
}
