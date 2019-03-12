package com.dlegacy;

public class Main {

    public static void main(String[] args) {
        eBookReader ebook = new eBookReader();
        ebook.readOnBook();
        ebook.writeOnBook();

        char []ro = {'d', 'd'};
        System.out.println(ro);
    }
}
