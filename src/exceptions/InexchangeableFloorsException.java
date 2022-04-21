package exceptions;

public class InexchangeableFloorsException extends RuntimeException{
    public InexchangeableFloorsException() {
        String message = "Floors are inexchahgeable";
        throw new Error(message);
    }
}
