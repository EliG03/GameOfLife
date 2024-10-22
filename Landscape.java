
/**
 * Eli Giglietti
 * 
 * The purpose of this class is to make the landscape object
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Landscape {

    // initiating rows and columns to use later
    private int rows;
    private int cols;

    Random rand = new Random();
    /**
     * The underlying grid of Cells for Conway's Game
     */
    private Cell[][] landscape;

    /**
     * The original probability each individual Cell is alive
     */
    private double initialChance;

    /**
     * Constructs a Landscape of the specified number of rows and columns.
     * All Cells are initially dead.
     * 
     * @param rows    the number of rows in the Landscape
     * @param columns the number of columns in the Landscape
     */

    public Landscape(int rows, int columns) {
        landscape = new Cell[rows][columns]; // makes an array of specified size

        this.rows = rows;
        this.cols = columns;

        for (int i = 0; i < this.rows; i++) {

            for (int j = 0; j < this.cols; j++) {
                landscape[i][j] = new Cell();
            }
        }

        reset();
    }

    /**
     * Constructs a Landscape of the specified number of rows and columns.
     * Each Cell is initially alive with probability specified by chance.
     * 
     * @param rows    the number of rows in the Landscape
     * @param columns the number of columns in the Landscape
     * @param chance  the probability each individual Cell is initially alive
     */
    public Landscape(int rows, int columns, double chance) {
        landscape = new Cell[rows][columns]; // makes an array of specified size

        this.rows = rows;
        this.cols = columns;

        for (int i = 0; i < this.rows; i++) {

            for (int j = 0; j < this.cols; j++) { // nested for loop to iterate through the 2d array

                if (rand.nextFloat(1) < chance) { // generate a random number and check if less than chance
                    landscape[i][j] = new Cell(true);// make the cell alive
                } else {
                    landscape[i][j] = new Cell(false); // otherwise the cell is dead ie false
                }
            }
        }

    }

    /**
     * Recreates the Landscape according to the specifications given
     * in its initial construction.
     */
    public void reset() {
        for (int i = 0; i < this.rows; i++) {

            for (int j = 0; j < this.cols; j++) { // iterates through 2d array
                landscape[i][j] = new Cell(); // makes the cell objects
            }
        }
    }

    /**
     * Returns the number of rows in the Landscape.
     * 
     * @return the number of rows in the Landscape
     */
    public int getRows() {
        return landscape.length;
    }

    /**
     * Returns the number of columns in the Landscape.
     * 
     * @return the number of columns in the Landscape
     */
    public int getCols() {
        return landscape[0].length;
    }

    /**
     * Returns the Cell specified the given row and column.
     * 
     * @param row the row of the desired Cell
     * @param col the column of the desired Cell
     * @return the Cell specified the given row and column
     */
    public Cell getCell(int row, int col) {
        return landscape[row][col];
    }

    /**
     * Returns a String representation of the Landscape.
     */
    public String toString() {
        String landscape_Rep = ""; // initiate a string
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getCols(); j++) { // iterate through landscape
                landscape_Rep += landscape[i][j].toString(); // add a 1 or 0
            }
            landscape_Rep += "\n"; // new line
        }
        return landscape_Rep; // return the string
    }

    /**
     * Returns an ArrayList of the neighboring Cells to the specified location.
     * 
     * @param row the row of the specified Cell
     * @param col the column of the specified Cell
     * @return an ArrayList of the neighboring Cells to the specified location
     */
    public ArrayList<Cell> getNeighbors(int row, int col) {
        ArrayList<Cell> neighbors = new ArrayList<Cell>(); // initiates an array of neighbors

        for (int i = row - 1; i < row + 2; i++) {
            for (int j = col - 1; j < col + 2; j++) { // iterate through landscape
                if (i >= 0 && j >= 0 && i < this.getRows() && j < this.getCols()) { // check for boundaries
                    if (i != row || j != col) { // make sure its not the actual cell
                        neighbors.add(landscape[i][j]); // adds the cell to the new arraylist
                    }
                }
            }
        }
        return neighbors;
    }

    /**
     * Advances the current Landscape by one step.
     */

    /**
     * Draws the Cell to the given Graphics object at the specified scale.
     * An alive Cell is drawn with a black color; a dead Cell is drawn gray.
     * 
     * @param g     the Graphics object on which to draw
     * @param scale the scale of the representation of this Cell
     */
    public void draw(Graphics g, int scale) {
        for (int x = 0; x < getRows(); x++) {
            for (int y = 0; y < getCols(); y++) {
                g.setColor(getCell(x, y).getAlive() ? Color.BLACK : Color.gray);
                g.fillOval(x * scale, y * scale, scale, scale);
            }
        }
    }

    public void advance(){
        Cell[][] newLandscape = new Cell[this.rows][this.cols]; //creates a copy of the landscape

        for (int i = 0; i<landscape.length; i++){
            for (int j = 0; j<landscape[i].length; j++){ //iterates through entire landscape
                newLandscape[i][j] = new Cell(landscape[i][j].getAlive()); //assigns each cell to newLandscape
            }
        }

        for (int i = 0; i<landscape.length; i++){
            for (int j = 0; j<landscape[i].length; j++){ //iterates through entire landscape
                newLandscape[i][j].updateState(getNeighbors(i, j)); //gets all the neighbors
            }      
        }
        
        landscape = newLandscape; //makes the orignial landscape the temporary one
    }

    public class LifeSimulationExtention{

        // public boolean repeat(){
        //     Cell[][] newLandscape = new Cell[this.rows][this.cols];
        //     Cell[][] extraLandscape = new Cell[this.rows][this.col];
            
        //     newLandscape.advance();
        //     newLandscape.advance();
    
        //     if (extraLandscape == newLandscape){
        //         return false;
        //     }
        //     else{
        //         return true;
        //     }
        // }


    public static void main(String[] args) {
        // testing all my methods
        Landscape landscape1 = new Landscape(10, 10, 0.5);
        System.out.println(landscape1.getRows());
        System.out.println(landscape1.getCols());
        System.out.println(landscape1.getCell(5, 5));
        System.out.println(landscape1.toString());
        System.out.println(landscape1.getNeighbors(0, 0));
        landscape1.reset();// using the reset method and testing it after
        System.out.println(landscape1.getNeighbors(0, 0));
        System.out.println(landscape1.toString());

        }
    }
}