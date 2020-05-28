package components;

import mediator.Mediator;
import mediator.Image;

import javax.swing.*;

@SuppressWarnings("unchecked")
public class List extends JList<Object> implements Component {
    private Mediator mediator;
    private final DefaultListModel<Object> LIST_MODEL;

    public List(DefaultListModel listModel) {
        super(listModel);
        this.LIST_MODEL = listModel;
        setModel(listModel);
        this.setLayoutOrientation(JList.VERTICAL);
        Thread thread = new Thread(new Hide(this));
        thread.start();
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void addElement(Image image) {
        LIST_MODEL.addElement(image);
        int index = LIST_MODEL.size() - 1;
        setSelectedIndex(index);
        ensureIndexIsVisible(index);
    }

    public void deleteElement() {
        int index = this.getSelectedIndex();
        try {
            LIST_MODEL.remove(index);
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
    }

    public Image getCurrentElement() {
        return (Image) getSelectedValue();
    }

    @Override
    public String getName() {
        return "List";
    }

    private class Hide implements Runnable {
        private List list;

        Hide(List list) {
            this.list = list;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                mediator.hideElements(list.isSelectionEmpty());
            }
        }
    }
}
