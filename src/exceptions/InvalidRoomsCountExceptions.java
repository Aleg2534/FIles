package exceptions;

public class InvalidRoomsCountExceptions extends IllegalArgumentException{
    public InvalidRoomsCountExceptions(int number)
    {
        String massage = "InvalidRoomsCountExceptions: " + "your number: " + number + " correct count: 1 to 7";
        throw new IllegalArgumentException(massage);
    }
}
