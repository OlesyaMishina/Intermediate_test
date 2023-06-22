package model;

import java.util.Comparator;

public class ComparatorById implements Comparator<Toy> {
    @Override
    public int compare(Toy t1, Toy t2) {
        if (t1.getId() > t2.getId())
            return 1;
        else if (t1.getId() > t2.getId())
            return -1;
        return 0;
    }
}
