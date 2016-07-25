/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dicegame;
import java.util.Random;

/**
 *
 * @author Brooklyn
 */
public class Game {
    public static String name;
    static final Object lock = new Object();
    public Game(String firstPlayer){
        name = firstPlayer;
	System.out.println("Let the game begin!");
        System.out.println(name +" goes first.");
    }
    public static int throwDice(String name, String nextPlayer){
        System.out.println(name+" throws the dice!");
	Random die1 = new Random();
        Random die2 = new Random();
	int score = (die1.nextInt(6)+1) + (die2.nextInt(6)+1);
        System.out.println(name+" rolled: "+score+".");
	Game.name = nextPlayer;
        return score;
    }
    public void displayWinner(Player one, Player two){
        System.out.println(one.name+" scored: "+one.score+".");
        System.out.println(two.name+" scored: "+two.score+".");
        if(one.score > two.score){
            System.out.println(one.name+" wins!");
        }
	else{
            System.out.println(two.name+" wins!");
	}
    }
}
