package ru.bk.xenia;

import com.vaadin.flow.templatemodel.TemplateModel;

public interface HelloWorldModel extends TemplateModel {
    void setGreeting(String emptyNameGreeting);

    String getUserInput();
}
