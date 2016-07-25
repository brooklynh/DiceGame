/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicegame;

/**
 *
 * @author Brooklyn
 */
public class DiceGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Game newGame = new Game("Joe");
	Player joe = new Player("Joe", "Jane");
	Player jane = new Player("Jane", "Joe");
	joe.start();
	jane.start();
	try{
            jane.join();
        }
        catch(InterruptedException ie){
            ie.printStackTrace();
        }
        newGame.displayWinner(joe, jane);
    }
    
}
