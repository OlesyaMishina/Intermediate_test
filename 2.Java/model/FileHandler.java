package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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


    public void SaveToFilePQ(PriorityQueue<Toy> listPrizeToys, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(listPrizeToys);
            oos.flush();
            oos.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public PriorityQueue<Toy> LoadFromFilePQ(String filename) {
        PriorityQueue<Toy> listPrizeToys = null;
        try (
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            listPrizeToys = ((PriorityQueue<Toy>) ois.readObject());
        } catch (Exception ex) {
            System.out.println("Файл" + filename + "не существует." );
        }
        return listPrizeToys;
    }
}
