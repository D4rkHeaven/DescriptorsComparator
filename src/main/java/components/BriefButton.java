package components;

import descriptors.Brief;
import mediator.Mediator;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BriefButton extends JButton implements Component {

    public static final String IMAGE_PATH = "src/main/resources/home.png";

    private Mediator mediator;

    public BriefButton() {
        super("Brief");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        Brief brief = new Brief();
        Mat processedImage = brief.run(Imgcodecs.imread(IMAGE_PATH));
        ImageHelper imageHelper = new ImageHelper();
        imageHelper.addImage(processedImage);
    }

    @Override
    public String getName() {
        return "BriefButton";
    }
}