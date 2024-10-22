
/**
 * Eli Giglietti
 * 
 * the purpose of this class is to simulate the games for my extensiosn
 */ 

import java.util.Scanner;


public class LifeSimulationExtension{
    public static void main(String[] args) throws InterruptedException{

        int numCells = 0; //variable for counting the alive cells at the end

        if (args.length != 3) { //making sure there are 3 arguments           
            System.out.println("USAGE: Pass in an int for the number of rows, an int for columns, and a double for the chance the cell is alive to being with");
            System.out.println("For example: 50, 50, 0.25");
            return;
        }

        Integer row = Integer.parseInt(args[0]);

        Integer col = Integer.parseInt(args[1]);

        Double chance = Double.parseDouble(args[2]); 


        //making sure the command line arguments are the right type
        if (!(row instanceof Integer && col instanceof Integer && chance instanceof Double && chance < 1)){
            System.out.println("USAGE: Pass in an int for the number of rows, an int for columns, and a double for the chance the cell is alive to being with");
            System.out.println("For example: 50, 50, 0.25");
            return;

            }

        for (int x = 0; x<5; x++){  
             //does this five times 
            numCells = 0;

            Landscape landscape = new Landscape(row, col, chance); //intitiates landscape object    
            LandscapeDisplay display = new LandscapeDisplay(landscape, 10); //initiates display
        

            for (int i = 0; i<1000; i++){

                landscape.advance(); //advances the cell states
                display.repaint(); //repaints the display
                
                }

    
 
            for (int i = 0; i<row; i++){ //iterates through each cell
                for (int j = 0; j<col; j++){
                    if (landscape.getCell(i, j).getAlive()){ //gets the state
                        numCells ++; //adds to my variable
                    }
                }
            }

            System.out.println(numCells);
        }
    }

}
