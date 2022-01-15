/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 *
 * @author Rawan
 */
public class Record {

//    AllFiles a = new AllFiles();
    boolean flag = true;
    String[][] gameMoves = new String[9][2];
    ListView list;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH-mm-ss");
    Date date = new Date();
    File fileName = new File(dateFormat.format(date) + " game.txt");
    FilenameFilter filter;
    File f = new File(".");

    public void SaveMoves(String label, String value) {
        FileWriter writer;

        try {

            writer = new FileWriter(fileName, true);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write(label + " " + value + "\n");
            buffer.close();
        } catch (IOException ex) {
            Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String[][] read(String path) throws IOException {
        FileReader file = null;
        try {
            file = new FileReader(path);
            BufferedReader Reader = new BufferedReader(file);
            String myString;
            for (int i = 0; i < 9; i++) {
                myString = Reader.readLine();

                if (myString != null) {
                    String[] str = myString.split(" ");
                    String label = str[0];
                    String value = str[1];
                    gameMoves[i][0] = label;
                    gameMoves[i][1] = value;

                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
        }
            try {
                file.close();
            } catch (IOException ex) {
                Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
            }
        return gameMoves;
    }

    public ObservableList<String> retriveAllFiles() {
        // file filter 
        filter = new FilenameFilter() {

            public boolean accept(File f, String name) {
                return name.endsWith("game.txt");
            }
        };
        File[] files = f.listFiles(filter);
        list = new ListView<String>();
        ObservableList<String> items = FXCollections.observableArrayList();
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i].getName());

            items.add(files[i].getName());

        }
        return items;

    }
}
