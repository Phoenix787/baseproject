package ru.bk.xenia;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.ElementFactory;

/**
 * в интерфейсе HasComponent  есть методы add(Component) и remove(Сomponent...) в дефолтной реализации
 */
@Tag("div")
public class MyComponentContainer extends Component implements HasComponents {

    public MyComponentContainer() {
        add();
    }

    /**
     * Если требуется другой тип API или имеется более сложная внутренняя иерархия элементов,
     * можно реализовать метод add самостоятельно
     */
    @Tag("div")
    public class MyComponentsContainer extends Component{
        public void add(Component child) {
            getElement().appendChild(child.getElement());
        }

        public void remove(Component child) {
            getElement().removeChild(child.getElement());
        }
    }

    /**
     * При добавлении компонента в качестве дочернего к другому компоненту единственное,
     * что должен сделать контейнер компонента - это присоединить элемент дочернего компонента к модели DOM.
     * В приведенном выше случае дочерний элемент присоединяется к корневому элементу,
     * как и HasComponents интерфейс
     * Вместо этого можно добавить элемент-оболочку вокруг каждого дочернего элемента
     * или при необходимости сделать более сложную иерархию элементов.
     *
     * Методы иерархии компонентов, такие как getChildren и getParent,
     * будут работать для компонента автоматически, поскольку они реализуются на основе иерархии элементов.
     * Они будут работать, даже если вы добавите элементы оболочки между ними.
     */

    @Tag("div")
    public class MyComponentsLContainer extends Component{

        public void add(Component child) {
            Element childWrapper = ElementFactory.createDiv();
            childWrapper.appendChild(child.getElement());
            getElement().appendChild(childWrapper);
        }

        public void remove(Component child) {
            Element wrapper = child.getElement().getParent();
            wrapper.removeFromParent();
        }
    }

}
