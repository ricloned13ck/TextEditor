package model;

import java.io.*;
import java.util.Scanner;

import static java.io.BufferedWriter.*;

public class TxtFileModel extends AbstractFileModel{


    public TxtFileModel(String filename) {
        super(filename, "txt");
    }

    @Override
    public void save() throws IOException {
        if(!this.isNeedSave) return;
        FileWriter written = new FileWriter(this.filename);
        BufferedWriter bufferedWriter = new BufferedWriter(written);
        bufferedWriter.write(this.content);
        bufferedWriter.close();
        written.close();
        this.isNeedSave = false;

    }

    @Override
    public void open() throws IOException {
        FileReader reader = new FileReader(this.filename);
        Scanner scanner = new Scanner(reader);
        StringBuilder content = new StringBuilder();
        while (scanner.hasNext())
            content.append(scanner.nextLine()).append("\n");
        this.setContent(content.toString());
        this.isNeedSave=false;
        scanner.close();
        reader.close();
    }
}
