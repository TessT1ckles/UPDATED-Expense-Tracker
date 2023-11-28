package com.mycompany.projectoop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class previewFiles{
    protected String fileName;
    
    public previewFiles(String fileName){
        this.fileName = fileName;
    }

    public void previewRecord(){
        
        File file = new File(fileName);
        int count = 2;
        int fileCount = 1;
        while(file.exists()){
            try(BufferedReader reader = new BufferedReader(new FileReader(file))){
                String dateText = reader.readLine();

                System.out.println(fileCount + ") " + dateText);
                fileName = "Record" + count + ".txt";
                file = new File (fileName);
                count++;
                fileCount++;
            }
            catch(IOException e){
                System.err.println("Error Reading File: " + e.getMessage());
            }
        }
    }
}
