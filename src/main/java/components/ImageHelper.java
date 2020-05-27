package components;

import org.opencv.core.Mat;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

/**
 * Вспомогательный класс, отвечающий за графический интерфейс
 */
public class ImageHelper extends JFrame {

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JScrollPane scrollPane = new JScrollPane(panel);

    public ImageHelper() {
        panel.setLayout(new FlowLayout());
        frame.setSize(960, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(scrollPane);
    }

    /**
     * добавление входного изображение и отображение окна
     *
     * @param inputImage
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

}
