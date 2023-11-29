package com.mycompany.projectoop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Double.parseDouble;

class viewFile{
    protected int fileCount;
    protected String date;
    protected double food, transport, utilityBill;
    protected double essential;
    protected double nonEssential;
    
    public viewFile(int fileCount){
        this.fileCount = fileCount;
    }
    
    public void viewRecord(){
        String fileName = "Record" + fileCount + ".txt";
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            date = reader.readLine();
            food = parseDouble(reader.readLine());
            transport = parseDouble(reader.readLine());
            utilityBill = parseDouble(reader.readLine());
            essential = parseDouble(reader.readLine());
            nonEssential = parseDouble(reader.readLine());
            System.out.println("\n\n============================");
            System.out.println(" " + date);
            System.out.println("============================");
            System.out.printf("   Food          |  %.2f \n", food);
            System.out.printf("   Transport     |  %.2f \n", transport);
            System.out.printf("   Utility Bills |  %.2f \n", utilityBill);
            System.out.println("----------------------------");
            System.out.printf("   Essential     |  %.2f \n", essential);
            System.out.printf("   Non-Essential |  %.2f \n", nonEssential);
            System.out.println("----------------------------\n");
            reader.close();
        }catch(IOException e){
            System.out.println("Error Reaading File: " + e.getMessage());
        }
    }
}

