package exceptions;

public class SpaceIndexOutOfBoundsException extends IndexOutOfBoundsException{
    public SpaceIndexOutOfBoundsException(int sizeArray,int number)
    {
        String message = "SpaceIndexOutOfBoundsException: incorrect index " + number + " enter number between 0 to " +
                (sizeArray-1);
        throw new IndexOutOfBoundsException(message);
    }
}