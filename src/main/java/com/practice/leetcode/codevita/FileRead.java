//package com.practice.leetcode.codevita;
//
//import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.practice.leetcode.model.Quote;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.ClassPathResource;
//
//public class FileRead {
//    public static void main(String[] args) {
//        List<Quote> quotes = new ArrayList<>();
//
//        try {
//            Resource resource = new ClassPathResource("quotes_all.txt");
//            File file = resource.getFile();
//            String line = null;
//
//            FileReader fileReader = new FileReader(file);
//
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//            while((line = bufferedReader.readLine()) != null) {
//                String[] arr = line.split(";");
//                Quote q = new Quote(arr[0] , arr[1]);
//                quotes.add(q);
//            }
//            bufferedReader.close();
//            ObjectMapper objectMapper = new ObjectMapper();
//            //Set pretty printing of json
//            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
//            String json = objectMapper.writeValueAsString(quotes);
//            System.out.println(json);
//
//            String path = "D:\\Projects\\json.json";
//
//            Files.write(Paths.get(path), json.getBytes());
//        }
//        catch(FileNotFoundException ex) {
//            System.out.println("Unable to open file");
//        }
//        catch(IOException ex) {
//            System.out.println("Error reading file");
//        }
//
//        System.out.println(quotes.size());
//    }
//}
