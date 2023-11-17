package ui;

import model.SongDatabase;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class LoadAction extends AbstractAction {

    private SongDatabase sd;
    private JsonReader jsonReader;

    private String location;

    private JFrame frame;

    public LoadAction(SongDatabase sd, JsonReader jsonReader, String location, JFrame frame) {
        super("Load Data");
        this.sd = sd;
        this.jsonReader = jsonReader;
        this.location = location;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            sd = jsonReader.read();
            JOptionPane.showMessageDialog(null,
                    "Loaded data form " + location, "Load Data", JOptionPane.PLAIN_MESSAGE);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
            System.out.println(sd.getSongs().get(0).getSongName());
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null,
                    "Unable to load data from " + location, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}