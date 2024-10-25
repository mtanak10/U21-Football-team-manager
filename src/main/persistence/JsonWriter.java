package persistence;

import model.Team;
import org.json.JSONObject;

import java.io.*;

// Referenced from JsonSerializationDemo Persistence JsonWriter
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

// class that writes the information to the file
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // Effects: constructs writer to write to the destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // Modifies: this
    // Effects opens writer; it will throw FileNotFoundException
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // this
    // Effects: write JSON representation of workroom to file
    public void write(Team tm) {
        JSONObject json = tm.toJson();
        saveToFile(json.toString(TAB));

    }

    // Modifies: this
    // Effects closes the writer
    public void close() {
        writer.close();
    }

    // Modifies: this
    // Effects: writes string to file

    private void saveToFile(String json) {
        writer.print(json);
    }

}