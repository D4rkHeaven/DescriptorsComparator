package components;

import mediator.Mediator;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.io.File;

public class SaveButton extends JButton implements Component {
    private Mediator mediator;

    public SaveButton() {
        super("Save");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void fireActionPerformed(ActionEvent actionEvent) {
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView());
        int ret1 = fileChooser.showDialog(null, "Сохранить файл");
        if (ret1 == JFileChooser.APPROVE_OPTION) {
            File file1 = fileChooser.getSelectedFile();
        }
    }

    @Override
    public String getName() {
        return "SaveButton";
    }
}