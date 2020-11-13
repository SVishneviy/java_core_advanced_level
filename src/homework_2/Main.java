package homework_2;

import homework_2.excepptions.MyArrayDataException;
import homework_2.excepptions.MyArraySizeException;

public class Main {
    private static final int ARRAY_SIZE = 4;

    public static void main(String[] args) {
        String[][] array = new String[ARRAY_SIZE][ARRAY_SIZE];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int number = (int) (Math.random() * 100);
                if (i == array.length - 1 && j == array.length - 1) {
                    array[i][j] = "Hello";
                } else {
                    array[i][j] = String.valueOf(number);
                }
            }
        }
        System.out.println("Двумерный массив:");
        for (String[] strings : array) {
            for (String string : strings) {
                System.out.printf("%-3s", string);
            }
            System.out.println();
        }
        try {
            System.out.println("Сумма элементов массива: " + stringToIntegerInArrayAndSum(array));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
            System.out.println("Неверный формат в ячейке: " + e.getRow() + " " + e.getCol());
            System.out.println("Значение в ячейке: " + array[e.getRow()][e.getCol()]);
            System.out.println("Невозможно просуммировать элементы массива.");
        }
    }

    public static int stringToIntegerInArrayAndSum(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != ARRAY_SIZE) {
            throw new MyArraySizeException();
        }
        for (String[] strings : array) {
            if (strings.length != ARRAY_SIZE) {
                throw new MyArraySizeException();
            }
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверный формат в ячейке: " + i + " " + j, i, j);
                }
            }
        }
        return sum;
    }

    /*private static class MyArraySizeException extends RuntimeException {

    }

    private static class MyArrayDataException extends RuntimeException {

    }*/

}
