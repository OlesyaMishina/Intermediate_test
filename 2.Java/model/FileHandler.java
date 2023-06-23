package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.PriorityQueue;

/**
 * FileHandler
 */
public class FileHandler {

    public void SaveToFile(ListOfToys listToys, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(listToys);
            oos.flush();
            oos.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ListOfToys LoadFromFile(String filename) {
        ListOfToys listToys = null;
        try (
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            listToys = ((ListOfToys) ois.readObject());
        } catch (Exception ex) {
            System.out.println("Файл" + filename + "не существует." );
        }
        return listToys;
    }

    public void SaveToFileGiveOutToys(Toy giveOutToy, String filename) {
try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(giveOutToy.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    }

