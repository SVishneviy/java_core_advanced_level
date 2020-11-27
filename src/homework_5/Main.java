package homework_5;

import java.util.Arrays;

public class Main {
    private static final int ARRAY_SIZE = 10000000;
    private static final int HALF_ARRAY_SIZE = ARRAY_SIZE / 2;

    public static void main(String[] args) throws InterruptedException {
        firstMethod();
        secondMethod();
    }

    private static void firstMethod() throws InterruptedException {
        float[] array = new float[ARRAY_SIZE];
        Thread thread = new Thread(() -> {
            for (int i = 0; i < ARRAY_SIZE; i++) {
                array[i] = 1;
            }
            long start = System.currentTimeMillis();
            for (int i = 0; i < ARRAY_SIZE; i++) {
                array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("[Первый метод] Время расчета по формуле в array: " + (System.currentTimeMillis() -
                    start) + " ms");
        });
        thread.start();
        thread.join();
    }

    private static void secondMethod() throws InterruptedException {
        float[] array = new float[ARRAY_SIZE];
        float[] array1 = new float[HALF_ARRAY_SIZE];
        float[] array2 = new float[HALF_ARRAY_SIZE];
        Thread thread1 = new Thread(()-> {
            long start = System.currentTimeMillis();
            System.arraycopy(array, 0, array1, 0, HALF_ARRAY_SIZE);
            System.arraycopy(array, HALF_ARRAY_SIZE, array2, 0, HALF_ARRAY_SIZE);
            System.out.println("[Второй метод] Время разбивки массива array на 2: " + (System.currentTimeMillis() -
                    start) + " ms");
            for (int i = 0; i < HALF_ARRAY_SIZE; i++) {
                array1[i] = 1;
            }
            start = System.currentTimeMillis();
            for (int i = 0; i < HALF_ARRAY_SIZE; i++) {
                array1[i] = (float)(array1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f +
                        i / 2));
            }
            System.out.println("[Второй метод] Время расчета по формуле в array1: " + (System.currentTimeMillis() -
                    start) + " ms");
        });
        Thread thread2 = new Thread(()-> {
            for (int i = 0; i < HALF_ARRAY_SIZE; i++) {
                array2[i] = 1;
            }
            long start = System.currentTimeMillis();
            for (int i = 0; i < HALF_ARRAY_SIZE; i++) {
                array2[i] = (float)(array2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f +
                        i / 2));
            }
            System.out.println("[Второй метод] Время расчета по формуле в array2: " + (System.currentTimeMillis() -
                    start) + " ms");
            start = System.currentTimeMillis();
            System.arraycopy(array1, 0, array, 0, HALF_ARRAY_SIZE);
            System.arraycopy(array2, 0, array, HALF_ARRAY_SIZE, HALF_ARRAY_SIZE);
            System.out.println("[Второй метод] Время склейки двух массивов array1, array2 в array: " +
                    (System.currentTimeMillis() - start) + " ms");
        });
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
    }

}
