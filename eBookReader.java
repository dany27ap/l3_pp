package com.dlegacy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class eBookReader {
    private String fileName;

    eBookReader(){
//        System.out.print("Numele ebook-ului din care doresti citirea: ");
//        Scanner sc = new Scanner(System.in);
//        fileName = sc.nextLine();

        fileName = "Shadows-of-Childhood.txt";
    }

    public void readOnBook(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String st;
            while((st = br.readLine()) != null){
                System.out.println(st);
            }
        } catch (Exception e){
            e.getMessage();
        }
    }

    public void writeOnBook(){
        String []number = {"1", "2", "3"};
        char []ro = {'?', '?', '?', '?', '?', '?'};
        char []en = {'A', 'a', 'S', 's', 'T', 't'};


        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            PrintWriter writer = new PrintWriter("file.txt");
            String st;
            List<String> lines = new ArrayList<>();
            List<String> newBook = new ArrayList<>();

            //Delete >1 space
            while((st = br.readLine()) != null){
                lines.add(st.replaceAll("\\s+", " "));
            }

            //Change ro ch to en ch
            for(String eng : lines) {


            }
            //Delete new line
            for(String l : lines){
                if( (!l.equals("")) && (!l.equals(" ")) && (!isNumeric(l))){
                    newBook.add(l);
                }
            }

            for(String put:newBook){
                writer.println(put);
            }
            writer.close();

        } catch (Exception e){
            e.getMessage();
        }
    }

    public static boolean isNumeric(String str){
        try{
            Integer.parseInt(str);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public char []replaceCh(char []a, char []b){
        for(int i = 0; i < a.length; ++i){
            a[i] = b[i];
        }
        return a;
    }

}
