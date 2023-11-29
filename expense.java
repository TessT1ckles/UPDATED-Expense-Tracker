package com.mycompany.projectoop;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

class expense{
    private String date;
    private double food, transport, utilityBill;
    private double essential;
    private double nonEssential;
    
    // constructor for all variables in add user
    public expense(String date, double food, double transport, double utilityBill, 
            double essential, double nonEssential){
        this.food = food;
        this.transport = transport;
        this.utilityBill = utilityBill;
        this.date = date;
        this.essential = essential;
        this.nonEssential = nonEssential;
    }
    
    //return value's
    public String getDate(){
        return date;
    }
    public double getFood(){
        return food;
    }
    public double getTransport(){
        return transport;
    }
    public double getUtilityBill(){
        return utilityBill;
    }
    public double getEssential(){
        return essential;
    }
    public double getNonEssential(){
        return nonEssential;
    }
    
    public void newRecord(String fileName){
        File file = new File(fileName);
        int count = 2;
        if(file.exists()){
            while(file.exists()){
                fileName = "Record" + count + ".txt";
                file = new File(fileName);
                count++;
            }
        }
        //make file writer
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            //if filename not existing then next
            writer.write(date + "\n");
            writer.write(food + "\n");
            writer.write(transport + "\n");
            writer.write(utilityBill + "\n");
            writer.write(essential + "\n");
            writer.write(nonEssential + "\n");
            writer.close();
            
            System.out.println("===========================");
            System.out.println("       RECORD SAVED!\n");
        }
        catch(IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

}
