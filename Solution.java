package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
        System.out.println(getPassword().toString());
        System.out.println(getPassword().toString());
    }

    public static ByteArrayOutputStream getPassword() {
        String string = "123456789abcdefghijklmnopqrstuvxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        byte[] str = string.getBytes();
        StringBuilder builder = new StringBuilder();


        while(!builder.toString().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8}$")) {
            for (int i = 0; i < 8; i++) {
                int j = (int) (Math.random() * string.length());
                builder.append((char) str[j]);
                if (builder.length() == 9) {builder.delete(0, builder.length());}
            }
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            out.write(builder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out;
    }
}
