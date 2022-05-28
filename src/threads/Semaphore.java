package threads;

public class Semaphore {
    private boolean flag;

    public Semaphore(boolean flag) {
        this.flag = flag;
    }

    public void switching() {
        flag = !flag;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
