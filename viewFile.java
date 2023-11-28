package com.mycompany.projectoop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;

class viewFile{
    protected int fileCount;
    protected String date;
    protected int food, transport, electricity, housing;
    protected int essential;
    protected int nonEssential;
    
    public viewFile(int fileCount){
        this.fileCount = fileCount;
    }
    
    public void viewRecord(){
        String fileName = "Record" + fileCount + ".txt";
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            date = reader.readLine();
            food = parseInt(reader.readLine());
            transport = parseInt(reader.readLine());
            electricity = parseInt(reader.readLine());
            housing = parseInt(reader.readLine());
            essential = parseInt(reader.readLine());
            nonEssential = parseInt(reader.readLine());
            System.out.println(date);
            System.out.println("Food: " + food);
            System.out.println("Transport: " + transport);
            System.out.println("Electricity: " + electricity);
            System.out.println("Housing: " + housing);
            System.out.println("Total Expenses: " + essential);
            System.out.println("Other Expenses: " + nonEssential);
            reader.close();
        }catch(IOException e){
            System.out.println("Error Reaading File: " + e.getMessage());
        }
    }
}
