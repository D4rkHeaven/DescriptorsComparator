import components.*;
import mediator.*;
import org.opencv.core.Core;

import javax.swing.*;

public class Main {
    public static final String IMAGE_PATH = "src/main/resources/image.png";

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mediator mediator = new Editor();
        mediator.registerComponent(new Title());
        mediator.registerComponent(new TextBox());
        mediator.registerComponent(new AddButton());
        mediator.registerComponent(new OrbButton());
        mediator.registerComponent(new DeleteButton());
        mediator.registerComponent(new SaveButton());
        mediator.registerComponent(new List(new DefaultListModel<>()));
        mediator.registerComponent(new ImagePanel());
        mediator.registerComponent(new Filter());

        mediator.createGUI();

       /* Orb orb = new Orb();
        Mat processedImage = orb.run(Imgcodecs.imread(IMAGE_PATH));
        components.ImageHelper imageHelper = new components.ImageHelper();
        imageHelper.addImage(processedImage);*/
    }
}
