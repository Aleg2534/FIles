package threads;

import buildings.interfaces.Floor;

public class SequentalCleaner implements Runnable{
    private Floor floor;
    private Semaphore semaphore;

    public SequentalCleaner(Floor floor) {
        this.floor = floor;
    }

    public SequentalCleaner(Floor floor, Semaphore semaphore) {
        this.floor = floor;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        for(int i=0;i<floor.getNumberOfSpaces();i++){
            synchronized (this){
                while (semaphore.isFlag()) {
                    try {
                        this.wait(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("cleaning space " + i + " with total area " + floor.getSpace(i).getSquare());
                semaphore.switching();
            }
        }
        System.out.println("end of Cleaner");
    }
}
