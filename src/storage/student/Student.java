package storage.student;

import java.io.IOException;
import java.util.ArrayList;

public interface Student<T> {
    public ArrayList<T> readFile() throws IOException, ClassNotFoundException;
    public void writeFile(ArrayList<T> t) throws IOException;
}
