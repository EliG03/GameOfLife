/*
file name:      LandscapeTests.java
Authors:        Max Bender & Naser Al Madi
last modified:  9/18/2022

How to run:     java -ea LandscapeTests
*/


import java.util.ArrayList;

public class LandscapeTests {

    public static void landscapeTests() {

        // case 1: testing Landscape(int, int)
        {
            // set up
            Landscape l1 = new Landscape(2, 4);
            Landscape l2 = new Landscape(10, 10);

            // verify
            System.out.println(l1);
            System.out.println("\n");
            System.out.println(l2);

            // test
            assert l1 != null : "Error in Landscape::Landscape(int, int)";
            assert l2 != null : "Error in Landscape::Landscape(int, int)";
        }

        // case 2: testing reset()
        {
            // set up
            Landscape l1 = new Landscape(10, 10, 0.5);

            // verify
            System.out.println(l1);
            System.out.println("\n");
            l1.reset(); 
            System.out.println("Should make the landscape all zeroes");
            System.out.println(l1);


            // test
            assert l1 != null : "Error in Landscape::Landscape(int, int)";
           
            
        }

        // case 3: testing getRows()
        {
            // set up
            Landscape l2 = new Landscape(10, 10);


            // verify
            System.out.println("should print 10, for the number of rows");
            System.out.println(l2.getRows());


            // test
            assert l2 != null : "Error in Landscape::Landscape(int, int)";

        }

        // case 4: testing getCols()
        {
            // set up
            Landscape l1 = new Landscape(10, 10, 0.5);


            // verify
            System.out.println("should print 10, for the number of columns");
            System.out.println(l1.getCols());


            // test
            assert l1 != null : "Error in Landscape::Landscape(int, int)";
        }

        // case 5: testing getCell(int, int)
        {
            // set up
            Landscape l1 = new Landscape(10, 10);


            // verify
            System.out.println("should print out the current alive state of the cell: 0 or 1");
            System.out.println(l1.getCell(3,3));


            // test
            assert l1 != null : "Error in Landscape::Landscape(int, int)";

        }

        // case 6: testing getNeighbors()
        {
            // set up
            Landscape l1 = new Landscape(10, 10, 0.5);

            // verify
            System.out.println("Should print out an array of the neighbors of the cell at (3, 3) ");
            System.out.println(l1.getNeighbors(3,3));

            // test
            assert l1 != null : "Error in Landscape::Landscape(int, int)";
        }

        // case 7: testing advance()
        {
            // set up
            Landscape l1 = new Landscape(10, 10,0.5);

            // verify
            System.out.println(l1);
            System.out.println("\n");
            l1.advance();
            System.out.println("Should advance the alive states of the cells in the array");
            System.out.println(l1);


            // test
            assert l1 != null : "Error in Landscape::Landscape(int, int)";

        }

    }


    public static void main(String[] args) {

        landscapeTests();
    }
}