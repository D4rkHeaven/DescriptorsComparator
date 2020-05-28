package components;

import descriptors.Orb;
import descriptors.Sift;
import mediator.Mediator;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SiftButton extends JButton implements Component {

    public static final String IMAGE_PATH = "src/main/resources/home.png";

    private Mediator mediator;

    public SiftButton() {
        super("Sift");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        Sift sift = new Sift();
        Mat processedImage = sift.run(Imgcodecs.imread(IMAGE_PATH));
        ImageHelper imageHelper = new ImageHelper();
        imageHelper.addImage(processedImage);
    }

    @Override
    public String getName() {
        return "SiftButton";
    }
}
