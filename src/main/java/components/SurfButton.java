package components;

import descriptors.Orb;
import descriptors.Surf;
import mediator.Mediator;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SurfButton extends JButton implements Component {

    public static final String IMAGE_PATH = "src/main/resources/landscape-15.jpg";

    private Mediator mediator;

    public SurfButton() {
        super("Surf");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        Surf surf = new Surf();
        Mat processedImage = surf.run(Imgcodecs.imread(IMAGE_PATH));
        ImageHelper imageHelper = new ImageHelper();
        imageHelper.addImage(processedImage);
    }

    @Override
    public String getName() {
        return "SurfButton";
    }
}
