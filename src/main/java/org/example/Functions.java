package org.example;

import java.math.BigInteger;

public class Functions {
    //функция для поиска минимального числа
    public String min(String[] data){
        BigInteger min = new BigInteger(data[0]);
        for (int i = 1; i < data.length; i++){
            BigInteger x = new BigInteger(data[i]);
            if (x.compareTo(min) == -1){
                min = x;
            }
        }
        return min.toString();
    }

    //функция для поиска максимального числа
    public String max(String[] data){
        BigInteger max = new BigInteger(data[0]);
        for (int i = 1; i < data.length; i++){
            BigInteger x = new BigInteger(data[i]);
            if (x.compareTo(max) == 1){
                max = x;
            }
        }
        return max.toString();
    }

    //функция для поиска суммы чисел
    public String sum(String[] data){
        BigInteger sum = new BigInteger("0");
        for (int i = 0; i < data.length; i++){
            sum = sum.add(new BigInteger(data[i]));
        }
        return sum.toString();
    }

    //функция для поиска произведения чисел
    public String mult(String[] data){
        BigInteger mult = new BigInteger("1");
        for (int i = 0; i < data.length; i++){
            mult = mult.multiply(new BigInteger(data[i]));
        }
        return mult.toString();
    }
}
