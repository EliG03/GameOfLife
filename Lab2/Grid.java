/**
 * Eli Giglieti
 * 
 * The purpose of this class is to disiplay the landscape object
 */

import java.util.Random;

public class Grid{


    public static void main(String[] args){
        Random rand = new Random(); //making a random object

        String str1 = "";

        int[][] grid; //making grid object
        grid = new int[3][4]; //initializing a size


        /**for(int i = 0; i < 3; i++){ //for loop to assign the other dimension size
            grid[i] = new String[i+3];
        }*/ 

        //nested for loop to assginm random chars to the grid
        for (int i=0; i<grid.length; i++ ){
            for (int j=0; j<grid[i].length; j++){ //iterates through the entire 2d array
                char Letter = (char)(rand.nextInt(0, 9) + 48);
                grid[i][j]  = Letter;
                //grid[i][j] = Character.toString(Letter);
                //System.out.println(grid[i][j]);
            }
        }

        //nested for loop to print out the contents of the array
        System.out.println(grid.length);
        for (int i=0; i<grid.length; i++){
            System.out.print((i + 1) + ": ");
            for (int j=0; j<grid[i].length; j++){

                System.out.print(grid[i][j] + " ");


            }
            System.out.print("\n");

        }

        int[][] newArr = rotate(grid);
        System.out.println("rotated array");
        printArray(newArr);

        if (args.length < 1){ //see if atleast one arg is written
            System.out.println("Usage: java Grid.java [args...]");//usage statement 
            
        }
        //iterating throught the command line parameters
        
        /**for (int i=0; i<args.length; i++){
            System.out.println(args[i]); //printing it out
        } */

        
        int[][] arr1 = new int[2][2];
        int[][] arr2 = new int[2][2];
        int[][] arr3;
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                arr1[i][j] = i+j;
                arr2[i][j] = i+j;
            }
        } 
        arr3 = arr1;
        System.out.println(arr1 == arr2);
        System.out.println(arr1 == arr3);


        System.out.println(gridEquals(arr1, arr2));

        rotate (grid);

    }

    public static boolean gridEquals(int[][] arr1, int[][] arr2){
        for (int i = 0; i<arr1.length; i++){
            for (int j = 0; j<arr1[i].length; j++){
                int x = arr1[j][i];
                int y = arr2[j][i];
                if (x != y){
                    return false;
                }
            }
        }
        return true;
    }    

    public static int[][] rotate(int[][] arr){
        int row = arr.length;
        int col = arr[0].length;
        int[][] newArr = new int[col][row];

        for (int i = 0; i<row; i++){
            
            for (int j = 0; j<col; j++){
                newArr[j][row - i - 1] = arr[i][j]; 

            }
        }
        return newArr;
    }

    public static void printArray(int[][] grid){
        System.out.println(grid.length);
        for (int i=0; i<grid.length; i++){
            System.out.print((i + 1) + ": ");
            for (int j=0; j<grid[i].length; j++){

                System.out.print(grid[i][j] + " ");


            }
            System.out.print("\n");

        }
    }

}