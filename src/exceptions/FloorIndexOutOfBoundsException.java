package exceptions;

public class FloorIndexOutOfBoundsException extends IndexOutOfBoundsException {
    public FloorIndexOutOfBoundsException(int sizeArray,int number) {
        String message = "FloorIndexOutOfBoundsException: incorrect index " + number + " enter number between 0 to " +
                (sizeArray - 1);
        throw new IndexOutOfBoundsException(message);
    }
}
