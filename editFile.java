 package com.mycompany.projectoop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Double.parseDouble;

class editFile extends viewFile{
    private double newFood, newTransport, newUtilityBill, newEssential, newNonEssential;
    private int editChoose;
    
    //contructor
    public editFile(int fileCount, int editChoose){
        super(fileCount);
        this.editChoose = editChoose;
    }
    
    totalEssential n = new totalEssential();
    
    public void editRecord(double newFood, double newTransport, double newUtilityBill, double newNonEssential){
        String fileName = "Record" + fileCount + ".txt";
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
        String line;
        date = reader.readLine();
        food = parseDouble(reader.readLine());
        transport = parseDouble(reader.readLine());
        utilityBill = parseDouble(reader.readLine());
        essential = parseDouble(reader.readLine());
        nonEssential = parseDouble(reader.readLine());
        reader.close();
        }catch(IOException e) {
            System.err.println("Error writting to file: " + e.getMessage());
        }
        if(editChoose == 1){
            newFood = n.add(food, newFood);
            newTransport = n.add(transport, newTransport);
            newUtilityBill = n.add(utilityBill, newUtilityBill);
            newEssential = newFood + newTransport + newUtilityBill;
            newNonEssential = n.add(nonEssential, newNonEssential);
            
            File file = new File(fileName);
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            //if filename not existing then next :-D
            writer.write(date + "\n");
            writer.write(newFood + "\n");
            writer.write(newTransport + "\n");
            writer.write(newUtilityBill+ "\n");
            writer.write(newEssential + "\n");
            writer.write(newNonEssential + "\n");
            writer.close();
            System.out.println("Edit Saved!");
            }catch(IOException e) {
                System.err.println("Error writting to file: " + e.getMessage());
            }
        }
        else if(editChoose == 2){
            newFood = n.subtract(food, newFood);
            newTransport = n.subtract(transport, newTransport);
            newUtilityBill = n.subtract(utilityBill, newUtilityBill);
            newEssential = newFood + newTransport + newUtilityBill;
            newNonEssential = n.subtract(nonEssential, newNonEssential);
            
            File file = new File(fileName);
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            //if filename not existing then next :-D
            writer.write(date + "\n");
            writer.write(newFood + "\n");
            writer.write(newTransport + "\n");
            writer.write(newUtilityBill + "\n");
            writer.write(newEssential + "\n");
            writer.write(newNonEssential + "\n");
            writer.close();
            System.out.println("Edit Saved!");
            }catch(IOException e) {
                System.err.println("Error writting to file: " + e.getMessage());
            }
        }
    }
    public void deleteRecord(){
        String fileName = "Record" + fileCount + ".txt";
        File file = new File(fileName);
        file.delete();
        fileCount++;
        fileName = "Record" + fileCount + ".txt";
        file = new File(fileName);
        while(file.exists()){
            try(BufferedReader reader = new BufferedReader(new FileReader(file))){
                date = reader.readLine();
                food = parseDouble(reader.readLine());
                transport = parseDouble(reader.readLine());
                utilityBill = parseDouble(reader.readLine());
                essential = parseDouble(reader.readLine());
                nonEssential = parseDouble(reader.readLine());
                reader.close();
            }catch(IOException e){
                System.err.println("Failed to Retrieve file: " + e.getMessage());
            }
            file.delete();
            fileCount--;
            fileName = "Record" + fileCount + ".txt";
            file = new File(fileName);
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
                //if filename not existing then next :-D
                writer.write(date + "\n");
                writer.write(food + "\n");
                writer.write(transport + "\n");
                writer.write(utilityBill + "\n");
                writer.write(essential + "\n");
                writer.write(nonEssential + "\n");
                writer.close();
            }catch(IOException e) {
                System.err.println("Error writting to file: " + e.getMessage());
            }
            fileCount++;
            fileCount++;
            fileName = "Record" + fileCount + ".txt";
            file = new File(fileName);
        }
    }
}
