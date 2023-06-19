package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * FileHandler
 */
public class FileHandler {

    public void SaveToFile(List<Toy> listToys, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(listToys);
            oos.flush();
            oos.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Toy> LoadFromFile(String filename) {
        List<Toy> listToys = null;
        try (
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            listToys = ((List<Toy>) ois.readObject());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return listToys;
    }
}