package components;

import mediator.Image;
import mediator.Mediator;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * Конкретные компоненты никак не связаны между собой. У них есть только один
 * канал общения – через отправку уведомлений посреднику.
 */
public class AddButton extends JButton implements Component {
    private Mediator mediator;

    public AddButton() {
        super("Add");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView());
        int ret1 = fileChooser.showDialog(null, "Открыть файл");
        if (ret1 == JFileChooser.APPROVE_OPTION) {
            File file1 = fileChooser.getSelectedFile();
            Image img = new Image();
            img.setName(file1.getName());
            img.setPath(file1.getPath());
            img.setFile(file1);
            mediator.addNewImage(img);
        }
    }

    @Override
    public String getName() {
        return "AddButton";
    }
}
