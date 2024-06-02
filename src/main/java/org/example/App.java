package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.function.Function;

class App {
    public static void main(String[] args) throws IOException {
        BufferedReader nameOfFileReader = new BufferedReader(new InputStreamReader(System.in));
        //введите имя файла
        String fileName = nameOfFileReader.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String[] data = reader.readLine().split(" ");
        Functions f = new Functions();
        System.out.println("Минимальное: " + f.min(data));
        System.out.println("Максимальное:" + f.max(data));
        System.out.println("Сумма: " + f.sum(data));
        System.out.println("Произведение: " + f.mult(data));
    }
}

