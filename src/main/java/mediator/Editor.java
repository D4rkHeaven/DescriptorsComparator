package mediator;

import components.*;
import components.Component;
import components.List;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Конкретный посредник. Все связи между конкретными компонентами переехали в
 * код посредника. Он получает извещения от своих компонентов и знает как на них
 * реагировать.
 */
public class Editor implements Mediator {
    private Title title;
    private TextBox textBox;
    private AddButton add;
    private OrbButton orb;
    private SurfButton surf;
    private DeleteButton del;
    private ImagePanel imagePanel;
    private SiftButton sift;
    private List list;

    private final JLabel textLabel = new JLabel("Image:");
    private final JLabel label = new JLabel("Add or select existing image to proceed...");

    /**
     * Здесь происходит регистрация компонентов посредником.
     */
    @Override
    public void registerComponent(Component component) {
        component.setMediator(this);
        switch (component.getName()) {
            case "AddButton":
                add = (AddButton) component;
                break;
            case "OrbButton":
                orb = (OrbButton) component;
                break;
            case "SurfButton":
                surf = (SurfButton) component;
                break;
            case "ImagePanel":
                imagePanel = (ImagePanel) component;
                break;
            case "DeleteButton":
                del = (DeleteButton) component;
                break;
            case "List":
                list = (List) component;
                this.list.addListSelectionListener(listSelectionEvent -> {
                    Note note = (Note) list.getSelectedValue();
                    if (note != null) {
                        getInfoFromList(note);
                    } else {
                        clear();
                    }
                });
                break;
            case "SiftButton":
                sift = (SiftButton) component;
                break;
            case "TextBox":
                textBox = (TextBox) component;
                break;
            case "Title":
                title = (Title) component;
                break;
        }
    }

    /**
     * Разнообразные методы общения с компонентами.
     */
    @Override
    public void addNewImage(Note note) {
        title.setText("");
        textBox.setText("");
        list.addElement(note);
    }

    @Override
    public void deleteNote() {
        list.deleteElement();
    }

    @Override
    public void getInfoFromList(Note note) {
        title.setText(note.getName().replace('*', ' '));
        textBox.setText(note.getText());
    }

    @Override
    public void saveChanges() {
        try {
            Note note = (Note) list.getSelectedValue();
            note.setName(title.getText());
            note.setText(textBox.getText());
            list.repaint();
        } catch (NullPointerException ignored) {
        }
    }

    @Override
    public void markNote() {
        try {
            Note note = list.getCurrentElement();
            String name = note.getName();
            if (!name.endsWith("*")) {
                note.setName(note.getName() + "*");
            }
            list.repaint();
        } catch (NullPointerException ignored) {
        }
    }

    @Override
    public void clear() {
        title.setText("");
        textBox.setText("");
    }

    @Override
    public void setElementsList(ListModel list) {
        this.list.setModel(list);
        this.list.repaint();
    }

    @Override
    public void hideElements(boolean flag) {
        textLabel.setVisible(!flag);
        orb.setVisible(!flag);
        surf.setVisible(!flag);
        imagePanel.setVisible(!flag);
        sift.setVisible(!flag);
        label.setVisible(flag);
    }

    @Override
    public void createGUI() {
        JFrame mainFrame = new JFrame("Comparator");
        mainFrame.setSize(960, 600);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel left = new JPanel();
        left.setBorder(new LineBorder(Color.BLACK));
        left.setSize(320, 600);
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));

        JPanel listPanel = new JPanel();
        list.setFixedCellWidth(260);
        listPanel.setSize(320, 470);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setPreferredSize(new Dimension(275, 410));
        listPanel.add(scrollPane);

        JPanel buttonPanel = new JPanel();
        add.setPreferredSize(new Dimension(85, 25));
        buttonPanel.add(add);
        del.setPreferredSize(new Dimension(85, 25));
        buttonPanel.add(del);
        buttonPanel.setLayout(new FlowLayout());

        left.add(listPanel);
        left.add(buttonPanel);

        JPanel right = new JPanel();
        right.setLayout(null);
        right.setSize(640, 600);
        right.setLocation(320, 0);
        right.setBorder(new LineBorder(Color.BLACK));

        textLabel.setBounds(20, 4, 50, 130);
        imagePanel.setBounds(20, 80, 595, 410);
        orb.setBounds(180, 495, 80, 25);
        surf.setBounds(270, 495, 80, 25);
        sift.setBounds(360, 495, 80, 25);
        label.setFont(new Font("Verdana", Font.PLAIN, 22));
        label.setBounds(100, 240, 500, 100);

        right.add(label);
        right.add(textLabel);
        right.add(imagePanel);
        right.add(orb);
        right.add(surf);
        right.add(sift);
        mainFrame.setLayout(null);
        mainFrame.getContentPane().add(left);
        mainFrame.getContentPane().add(right);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
}
