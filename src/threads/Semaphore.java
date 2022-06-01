package threads;

public class Semaphore {
    private boolean flag;

    public Semaphore() {
        this.flag = true;
    }

    public void switching() {
        flag = !flag;
    }

    public boolean isFlag() {
        return flag;
    }
}
