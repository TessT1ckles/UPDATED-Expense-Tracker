package com.mycompany.projectoop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Integer.parseInt;

class editFile extends viewFile{
    private int newFood, newTransport, newElectricity, newHousing, newEssential, newNonEssential;
    private int editChoose;
    
    //contructor
    public editFile(int fileCount, int editChoose){
        super(fileCount);
        this.editChoose = editChoose;
    }
    
    private int addTotal(int value1, int value2){
        return value1 + value2;
    }
    private int reduceTotal(int value1, int value2){
        return value1 - value2;
    }
    
    public void editRecord(int newFood, int newTransport, int newElectricity,
            int newHousing, int newNonEssential){
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
        reader.close();
        }catch(IOException e) {
            System.err.println("Error writting to file: " + e.getMessage());
        }
        if(editChoose == 1){
            newFood = addTotal(food, newFood);
            newTransport = addTotal(transport, newTransport);
            newElectricity = addTotal(electricity, newElectricity);
            newHousing = addTotal(housing, newHousing);
            newEssential = newFood + newTransport + newElectricity + newHousing;
            newNonEssential = addTotal(nonEssential, newNonEssential);
            
            File file = new File(fileName);
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            //if filename not existing then next :-D
            writer.write(date + "\n");
            writer.write(newFood + "\n");
            writer.write(newTransport + "\n");
            writer.write(newElectricity + "\n");
            writer.write(newHousing + "\n");
            writer.write(newEssential + "\n");
            writer.write(newNonEssential + "\n");
            writer.close();
            System.out.println("Edit Saved!");
            }catch(IOException e) {
                System.err.println("Error writting to file: " + e.getMessage());
            }
        }
        else if(editChoose == 2){
            newFood = reduceTotal(food, newFood);
            newTransport = reduceTotal(transport, newTransport);
            newElectricity = reduceTotal(electricity, newElectricity);
            newHousing = reduceTotal(housing, newHousing);
            newEssential = newFood + newTransport + newElectricity + newHousing;
            newNonEssential = reduceTotal(nonEssential, newNonEssential);
            
            File file = new File(fileName);
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            //if filename not existing then next :-D
            writer.write(date + "\n");
            writer.write(newFood + "\n");
            writer.write(newTransport + "\n");
            writer.write(newElectricity + "\n");
            writer.write(newHousing + "\n");
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
        System.out.println("The file has been deleted!");
        fileCount++;
        fileName = "Record" + fileCount + ".txt";
        file = new File(fileName);
        while(file.exists()){
            try(BufferedReader reader = new BufferedReader(new FileReader(file))){
                date = reader.readLine();
                food = parseInt(reader.readLine());
                transport = parseInt(reader.readLine());
                electricity = parseInt(reader.readLine());
                housing = parseInt(reader.readLine());
                essential = parseInt(reader.readLine());
                nonEssential = parseInt(reader.readLine());
                reader.close();
            }catch(IOException e){
                System.err.println("Failed to Retreive file: " + e.getMessage());
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
                writer.write(electricity + "\n");
                writer.write(housing + "\n");
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