package mediator;

import java.io.File;

public class Image {
    private String name;
    private String path;
    private File file;

    public Image() {
        name = "New image";
        path = "src/main/resources/home.png";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public File getFile() {
        return file;
    }

    @Override
    public String toString() {
        return name;
    }
}
