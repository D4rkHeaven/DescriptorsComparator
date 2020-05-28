import components.*;
import mediator.*;
import org.opencv.core.Core;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mediator mediator = new Editor();
        mediator.registerComponent(new Title());
        mediator.registerComponent(new TextBox());
        mediator.registerComponent(new AddButton());
        mediator.registerComponent(new OrbButton());
        mediator.registerComponent(new SurfButton());
        mediator.registerComponent(new BriefButton());
        mediator.registerComponent(new SiftButton());
        mediator.registerComponent(new DeleteButton());
        mediator.registerComponent(new List(new DefaultListModel<>()));
        mediator.registerComponent(new ImagePanel());

        mediator.createGUI();
    }
}
