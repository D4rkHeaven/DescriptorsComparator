package mediator;

import components.Component;

import javax.swing.*;
import java.io.File;

/**
 * Общий интерфейс посредников.
 */
public interface Mediator {
    void addNewImage(Image image);

    void deleteNote();

    void getInfoFromList(Image image);

    void saveChanges();

    void markNote();

    void clear();

    void setElementsList(ListModel<?> list);

    void registerComponent(Component component);

    void hideElements(boolean flag);

    void createGUI();
}