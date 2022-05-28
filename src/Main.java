import buildings.dwelling.DwellingFloor;
import buildings.interfaces.Floor;
import threads.*;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Semaphore semaphore = new Semaphore(true);
        Floor floor = new DwellingFloor(7);
        SequentalRepairer repairer = new SequentalRepairer(floor, semaphore);
        SequentalCleaner cleaner = new SequentalCleaner(floor, semaphore);
        Thread repairerstart = new Thread(repairer);
        Thread cleanerstart = new Thread(cleaner);
        repairerstart.start();
        cleanerstart.start();
    }
}
