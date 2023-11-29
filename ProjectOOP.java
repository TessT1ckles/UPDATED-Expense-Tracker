package com.mycompany.projectoop;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ProjectOOP {
    
    public static void Menu(){
        System.out.println("\n========== MENU ===========");
        System.out.println("What do you want to do?");
        System.out.println("[1] Add Record");
        System.out.println("[2] View Record");
        System.out.println("[3] Exit");
        System.out.println("---------------------------");
        System.out.print("Enter Choice: ");

    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
	    // MENU
        System.out.println("___________________________");
        System.out.println("| Welcome to ExpendiTrack |");
        do {
            try {
                Menu();
                int menuChoose = userInput.nextInt();
                System.out.println("===========================\n\n");

                //if statement decider of previous input "menuChoose" 👍
                if(menuChoose == 1){
                    userInput.nextLine();
                    //date input
                    System.out.println("Input the date of the record: ");
                    String date = userInput.nextLine();
                    System.out.println("---------------------------");

                    //expense input
                    System.out.println("Input your Expense(s): ");
                    //essentials
                    System.out.print("  Food: ");
                    double food = userInput.nextInt();

                    System.out.print("  Transportation: ");
                    double transport = userInput.nextInt();

                    System.out.print("  Utility Bills: ");
                    double utilityBill = userInput.nextInt();

                    //for total essential
                    totalEssential t = new totalEssential();
                    double essential = t.add(food, transport, utilityBill);


                    System.out.print("  Others: ");
                    int nonEssential = userInput.nextInt();

                    expense e = new expense(date, food, transport, utilityBill, essential, nonEssential);
                    e.newRecord("Record1.txt");
                }
                //view record 👍
                else if(menuChoose == 2){
                    previewFiles pf = new previewFiles("Record1.txt");
                    System.out.println("Available Records:");
                    pf.previewRecord();
                    System.out.println("---------------------------");
                    System.out.print("Which record do you want to view? ");
                    int view = userInput.nextInt();
                    //view the file based on the input above
                    viewFile vf = new viewFile(view);
                    vf.viewRecord();
                    do {
                        System.out.println("\n----------------------------");
                        System.out.println("What do you want to do?");
                        System.out.println("   1) Edit Record");
                        System.out.println("   2) Delete Record");
                        System.out.println("   3) Back to main menu");
                        System.out.println("----------------------------");
                        int viewChoose = userInput.nextInt();
                        switch(viewChoose){
                            case 1:
                                //edit record
                                System.out.println("----------------------------");
                                System.out.println("Edit Record:");
                                System.out.println("   1) Add Expense");
                                System.out.println("   2) Reduce Expense");
                                System.out.println("----------------------------");
                                int editChoose = userInput.nextInt();
                                editFile ef = new editFile(view, editChoose);

                                System.out.println("----------------------------");
                                System.out.println("Enter values: ");
                                System.out.print("   Food: ");
                                int addFood = userInput.nextInt();
                                System.out.print("   Transportation: ");
                                int addTransport = userInput.nextInt();
                                System.out.print("   Utility Bills: ");
                                int addUtilityBill = userInput.nextInt();
                                System.out.print("   Others: ");
                                int addNonEssential = userInput.nextInt();

                                ef.editRecord(addFood, addTransport, addUtilityBill, addNonEssential);
                                break;
                            case 2:
                                //delete record
                                do{
                                    System.out.print("Confirm Deletion? (Y / N): ");
                                    char confirmDelete = userInput.next().charAt(0);

                                    if(confirmDelete == 'Y' || confirmDelete == 'y'){
                                        editFile df = new editFile(view, 0);
                                        df.deleteRecord();
                                        System.out.println("Record has been deleted.\n");
                                        break;
                                    }
                                    else if(confirmDelete == 'N' || confirmDelete == 'n'){
                                        System.out.println("Deletion Cancelled");
                                        break;
                                    }
                                    else { 
                                        System.out.println("Invalid Input! Try Again.");
                                    }
                                } while(true);
                                break;
                            case 3:
                                //back to main menu
                                    break;
                            default:
                                    System.out.println("Invalid Input!");
                        }
                        break;
                    } while(true);
                }
                else if(menuChoose == 3){
                    do {
                            System.out.print("Confirm Exit? (Y / N): ");
                            char confirmExit = userInput.next().charAt(0);

                            if(confirmExit == 'Y' || confirmExit == 'y'){
                                System.out.print("Thank you for using the program!");
                                System.exit(0);
                            }
                           else if(confirmExit == 'N' || confirmExit == 'n'){
                               System.out.println("Exit Cancelled!");
                               break;
                           }
                           else { 
                               System.out.println("Invalid Input! Try Again.");
                           }
                    } while(true);
                }
                else {
                    System.out.println("Invalid Input! Try Again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Try Again.");
                userInput.nextLine();
            }
        } while(true);
    }
}
