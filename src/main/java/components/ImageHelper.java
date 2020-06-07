package components;

import mediator.Mediator;
import org.opencv.core.Mat;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

/**
 * Вспомогательный класс, отвечающий за вывод изображения с особыми точками
 */
public class ImageHelper extends JFrame implements Component {

    private Mediator mediator;
    private final JFrame frame = new JFrame();
    private final JPanel panel = new JPanel();
    private final JScrollPane scrollPane = new JScrollPane(panel);

    public ImageHelper() {
        panel.setLayout(new FlowLayout());
        frame.setSize(640, 450);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.add(scrollPane);
    }

    /**
     * добавление входного изображение и отображение окна
     *
     * @param inputImage входное изображение
     */
    public void addImage(Mat inputImage) {

        int type = BufferedImage.TYPE_BYTE_GRAY;

        if (inputImage.channels() > 1) {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        int bufferSize = inputImage.channels() * inputImage.cols() * inputImage.rows();
        byte[] b = new byte[bufferSize];

        inputImage.get(0, 0, b);
        BufferedImage image = new BufferedImage(inputImage.cols(), inputImage.rows(), type);
        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        System.arraycopy(b, 0, targetPixels, 0, b.length);

        ImageIcon imageIcon = new ImageIcon(image);

        JLabel label = new JLabel();
        label.setIcon(imageIcon);

        panel.add(label);
        frame.setVisible(true);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}
