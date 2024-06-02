import org.example.Functions;
import org.junit.Before;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class FunctionsTest {
    Functions fun;
    @BeforeEach
    void setUp(){
        fun = new Functions();
    }
    @Test
    void min() {
        //проверка работы при стандартном случае
        String act1 = fun.min(new String[]{"2", "10", "16", "32"});
        String expect1 = "2";
        assertEquals(act1, expect1);
        //проверка корректности работы с отрицательными числами
        String act2 = fun.min(new String[]{"-10000", "-100", "-25", "7", "1278403"});
        String expect2 = "-10000";
        assertEquals(act2, expect2);
        //проверка работы с большими числами
        String act3 = fun.min(new String[]{"7930284036839274846473", "12345678900000", "15327494758595673"});
        String expect3 = "12345678900000";
        assertEquals(act3, expect3);
        //проверка исключения (элемент в файле не является строкой, в которой записано число)
        assertThrows(NumberFormatException.class, () -> fun.min(new String[]{"123", "45", "6789", "error"}));
    }

    @Test
    void max() {
        //проверка работы при стандартном случае
        String act1 = fun.max(new String[]{"5", "15", "78", "93", "45"});
        String expect1 = "93";
        assertEquals(act1, expect1);
        //проверка работы с отрицательными числами
        String act2 = fun.max(new String[]{"-1000", "-8694", "-984", "-4"});
        String expect2 = "-4";
        assertEquals(act2, expect2);
        //проверка работы с отрицательными и неотрицательными числами
        String act3 = fun.max(new String[]{"-1934042", "-18494", "0", "-1848493", "7584", "226"});
        String expect3 = "7584";
        assertEquals(act3, expect3);
        //проверка работы с большими числами
        String act4 = fun.max(new String[]{"8457924839", "9852925395795327529529", "78592539"});
        String expect4 = "9852925395795327529529";
        assertEquals(act4, expect4);
        //проверка исключения (элемент в файле не является строкой, в которой записано число)
        assertThrows(NumberFormatException.class, () -> fun.max(new String[]{"123", "45", "6789", "error"}));
    }

    @Test
    void sum() {
        //проверка работы при стандартном случае
        String act1 = fun.sum(new String[]{"10", "15", "12", "37"});
        String expect1 = "74";
        assertEquals(act1, expect1);
        //проверка работы с неположительными числами
        String act2 = fun.sum(new String[]{"10", "0", "-6", "29", "-8"});
        String expect2 = "25";
        assertEquals(act2, expect2);
        //проверка работы с большими числами
        String act3 = fun.sum(new String[]{"1762829495039374949303", "7238490127648287953924", "63938475839395"});
        String expect3 = "9001319686626138742622";
        assertEquals(act3, expect3);
        //проверка исключения (элемент в файле не является строкой, в которой записано число)
        assertThrows(NumberFormatException.class, () -> fun.sum(new String[]{"123", "45", "6789", "error"}));
    }

    @Test
    void mult() {
        //проверка работы в стандартном случае
        String act1 = fun.mult(new String[]{"2", "5", "8", "17"});
        String expect1 = "1360";
        assertEquals(act1, expect1);
        //проверка работы с отрицательным числами
        String act2 = fun.mult(new String[]{"-8", "5", "-13", "17", "-9"});
        String expect2 = "-79560";
        assertEquals(act2, expect2);
        //проверка умножения на 0
        String act3 = fun.mult(new String[]{"4", "9", "0", "20"});
        String expect3 = "0";
        assertEquals(act3, expect3);
        //проверка умножения больших чисел
        String act4 = fun.mult(new String[]{"2798348987983527853988", "38742783256859235953287"});
        String expect4 = "108415828318497210205615637488402696524658556";
        assertEquals(act4, expect4);
        //проверка исключения (элемент в файле не является строкой, в которой записано число)
        assertThrows(NumberFormatException.class, () -> fun.mult(new String[]{"123", "45", "6789", "error"}));
    }

    static String[] arr;
    @BeforeAll
    static void createTestMassive(){
        arr = new String[10000000];
        for (int i = 0; i < 10000000; i++){
            arr[i] = Integer.toString(i);
        }
    }

    @Test @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)@Disabled
    void minTimeoutTest(){
        String min = fun.min(arr);
    }


    @Test
    void minTimeDurationTest(){
        long timeBegin = System.currentTimeMillis();
        String min = fun.min(arr);
        long timeEnd = System.currentTimeMillis();
        System.out.println("Время работы функции min: " + (timeEnd - timeBegin) + " ms");
    }

    @Test
    void maxTimeDurationTest(){
        long timeBegin = System.currentTimeMillis();
        String max = fun.max(arr);
        long timeEnd = System.currentTimeMillis();
        System.out.println("Время работы функции max: " + (timeEnd - timeBegin) + " ms");
    }

    @Test
    void sumTimeDurationTest(){
        long timeBegin = System.currentTimeMillis();
        String sum = fun.sum(arr);
        long timeEnd = System.currentTimeMillis();
        System.out.println("Время работы функции sum: " + (timeEnd - timeBegin) + " ms");
    }

    @Test
    void multTimeDurationTest(){
        long timeBegin = System.currentTimeMillis();
        String mult = fun.mult(arr);
        long timeEnd = System.currentTimeMillis();
        System.out.println("Время работы функции mult: " + (timeEnd - timeBegin) + " ms");
    }
}