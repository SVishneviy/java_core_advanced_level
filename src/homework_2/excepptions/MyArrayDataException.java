package homework_2.excepptions;

public class MyArrayDataException extends RuntimeException {
    protected int col;
    protected int row;

    public MyArrayDataException(String message, int col, int row) {
        super(message);
        this.col = col;
        this.row = row;
    }

    public MyArrayDataException(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

}
