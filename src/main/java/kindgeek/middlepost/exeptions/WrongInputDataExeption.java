package kindgeek.middlepost.exeptions;

public class WrongInputDataExeption extends RuntimeException {
    public WrongInputDataExeption(String message) {
        super(message);
    }
}
