package mediator;

import components.Component;

import javax.swing.*;

/**
 * Общий интерфейс посредников.
 */
public interface Mediator {
    void addNewImage(Note note);

    void deleteNote();

    void getInfoFromList(Note note);

    void saveChanges();

    void markNote();

    void clear();

    void setElementsList(ListModel<?> list);

    void registerComponent(Component component);

    void hideElements(boolean flag);

    void createGUI();
}