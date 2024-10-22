
/**
 * Eli Giglietti
 * 
 * the purpose of this class is to simulate the game 
 */ 


public class LifeSimulation{

    public static void main(String[] args) throws InterruptedException {

        Landscape landscape = new Landscape(50,50,0.25); //makes the landscape
        LandscapeDisplay display = new LandscapeDisplay(landscape, 10); //makes the display with the landcape
        Thread.sleep(10000); //pauses so I can record

        for (int i = 0; i<100; i++){ //goes through 500 iterations of the landscape

            landscape.advance(); //advances the cell states
            display.repaint(); //repatins the new landscape with the new cell states\
            //display.saveImage( "data/life_frame_" + String.format( "%03d", i ) + ".png" ); //saves the images
            Thread.sleep(250); //pauses for 250 milliseconds

        }
    }
}