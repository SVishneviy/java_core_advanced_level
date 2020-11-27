package homework_4.homework_4_2;

import homework_4_2.interfaces.Operation;

public class Calculator implements Operation {
    private String value1 = "";
    private String value2 = "";
    private String operation = "";
    private String result = "";
    private boolean isOperation;

    public void addNumber(String number) {
        if (!isOperation) {
            value1 += number;
        } else {
            value2 += number;
        }
    }

    public void addOperation(String operation) {
        this.operation = operation;
        isOperation = true;
    }

    public void check() throws RuntimeException {
        try {
            Double.parseDouble(value1);
            Double.parseDouble(value2);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Неверный формат числа.");
        } finally {
            isOperation = false;
        }
    }

    public void clean() {
        value1 = "";
        value2 = "";
    }

    public String getOperation() {
        return operation;
    }

    public String getResult() {
        isOperation = false;
        return result;
    }

    @Override
    public void addition() {
        result = String.valueOf(Double.parseDouble(value1) + Double.parseDouble(value2));
    }

    @Override
    public void subtraction() {
        result = String.valueOf(Double.parseDouble(value1) - Double.parseDouble(value2));
    }

    @Override
    public void multiplication() {
        result = String.valueOf(Double.parseDouble(value1) * Double.parseDouble(value2));
    }

    @Override
    public void division() throws RuntimeException {
        try {
            result = String.valueOf(Double.parseDouble(value1) / Double.parseDouble(value2));
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Деление на 0.");
        }
    }

}
