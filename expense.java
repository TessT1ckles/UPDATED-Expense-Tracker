package com.mycompany.projectoop;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import static java.lang.Integer.parseInt;

class expense{
    private String date;
    private int food, transport, electricity, housing;
    private int essential;
    private int nonEssential;
    
    // constructor for all variables in add user
    public expense(String date,int food, int transport, int electricity, int housing, 
            int essential, int nonEssential){
        this.food = food;
        this.transport = transport;
        this.electricity = electricity;
        this.housing = housing;
        this.date = date;
        this.essential = essential;
        this.nonEssential = nonEssential;
    }
    
    //return value's
    public String getDate(){
        return date;
    }
    public int getFood(){
        return food;
    }
    public int getTransport(){
        return transport;
    }
    public int getElectricity(){
        return electricity;
    }
    public int getHousing(){
        return housing;
    }
    public int getEssential(){
        return essential;
    }
    public int getNonEssential(){
        return nonEssential;
    }
    
    public void addRecord(String fileName){
        File file = new File(fileName);
        int count = 2;
        if(file.exists()){
            while(file.exists()){
                fileName = "Record" + count + ".txt";
                file = new File(fileName);
                count++;
            }
        }
        //make file writter
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            //if filename not existing then next :-D
            writer.write(date + "\n");
            writer.write(food + "\n");
            writer.write(transport + "\n");
            writer.write(electricity + "\n");
            writer.write(housing + "\n");
            writer.write(essential + "\n");
            writer.write(nonEssential + "\n");
            writer.close();
            System.out.println("Record Saved!");
        }
        catch(IOException e) {
            System.err.println("Error writting to file: " + e.getMessage());
        }
    }
}