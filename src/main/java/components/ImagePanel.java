package components;

import mediator.Mediator;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel implements Component {

    private Mediator mediator;
    private BufferedImage image;

    public ImagePanel() {
        try {
            image = ImageIO.read(new File("src/main/resources/landscape-1.jpg"));
        } catch (IOException ex) {
            System.out.println("Error during reading image.");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public String getName() {
        return "ImagePanel";
    }

}
