/**
 * Eli Giglietti
 * 
 * The purpose of this class is to make a cell ojbect that will be used to make the landscape
 */

import java.util.ArrayList;

public class Cell {

    /**
     * The status of the Cell.
     */
    private boolean alive;

    /**
     * Constructs a dead cell.
     */
    public Cell() {
        this.alive = false;
    }

    /**
     * Constructs a cell with the specified status.
     * 
     * @param status a boolean to specify if the Cell is initially alive
     */
    public Cell(boolean status) {
        if (status){
            this.alive = true;
        }
        else{
            this.alive = false;
        }
    
    }

    /**
     * Returns whether the cell is currently alive.
     * 
     * @return whether the cell is currently alive
     */
    public boolean getAlive() {
        return this.alive;
    }

    /**
     * Sets the current status of the cell to the specified status.
     * 
     * @param status a boolean to specify if the Cell is alive or dead
     */
    public void setAlive(boolean status) {
        this.alive = status;
    }

    /**
     * Updates the state of the Cell.
     * 
     * If this Cell is alive and if there are 2 or 3 alive neighbors,
     * this Cell stays alive. Otherwise, it dies.
     * 
     * If this Cell is dead and there are 3 alive neighbors,
     * this Cell comes back to life. Otherwise, it stays dead.
     * 
     * @param neighbors An ArrayList of Cells
     */
    public void updateState(ArrayList<Cell> neighbors) {
        int numNeighbors = 0; //initiate variable

        for (int i=0; i<neighbors.size(); i++){
            if (neighbors.get(i).getAlive()){ 
                numNeighbors++; //adds one if the neighbor is alive
            }
        }

        if (this.getAlive()){// checking alive status
            if (numNeighbors == 2 || numNeighbors == 3){
                this.setAlive(true); //keeps cell alive if it has 2 or 3 alive neighbors
            }
            else{
                this.setAlive(false); //sets cell to dead if anything else
            }
        
        }
        else{ //if the cell is dead...
            if (numNeighbors == 3){
                this.setAlive(true); //makes the cell alive 
            }
            else {
                this.setAlive(false); //makes the cell dead
            }
        }
    }

    /**
     * Returns a String representation of this Cell.
     * 
     * @return 1 if this Cell is alive, otherwise 0.
     */
    public String toString() {
        if (this.alive){
            return "1";
        }
        else{
            return "0";
        }
    }

    public static void main(String[] args){
        //testing all the methods
        Cell cell1 = new Cell(true); //making a cell object
        cell1.getAlive(); //testing getAlive method
        cell1.setAlive(false); //changning alive status
        System.out.println(cell1.toString()); //testing the toString and setAlive
        cell1.setAlive(true);
        System.out.println(cell1.toString());
    }
}