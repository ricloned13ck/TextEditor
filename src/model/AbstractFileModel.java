package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;

public abstract class AbstractFileModel {

    private static void checkExtension(String filename, String needExtension) {
        String[] splittedFilename = filename.split("\\.");
        String extension = splittedFilename[splittedFilename.length - 1];
        if (!extension.equals(needExtension))
            throw new AssertionError("Bad file extension");
    }

    protected String filename = null;
    protected String content = null;
    protected boolean isNeedSave = false;

    private String needExtension;

    public AbstractFileModel(String filename, String needExtension) {
        this.needExtension = needExtension;
        checkExtension(filename, needExtension);
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        checkExtension(filename, needExtension);
        this.isNeedSave = true;
        this.filename = filename;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.isNeedSave = true;
        this.content = content;
    }

    public boolean getIsNeedSave() {
        return isNeedSave;
    }

    public abstract void save() throws IOException;

    public abstract void open() throws IOException;

}
