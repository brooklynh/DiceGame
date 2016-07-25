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
public class Player extends Thread{
    String name;
    String opponent;
    Boolean gameInProgress = true;
    int score = 0;
    int turns = 1;
    public Player(String name, String opponent){
        super();
        this.name = name;
	this.opponent = opponent;
    }
    public void run(){
        while(gameInProgress){
            takeTurn();
	}
    }
    public void takeTurn(){
        synchronized(Game.lock){
            if(!(Game.name.equals(this.name))){
                try{
                    System.out.println("\""+name+"\": Whoops! It's not my turn.");
                    Game.lock.wait();
                }
                catch(InterruptedException ie){
                    ie.printStackTrace();
                }
            }
        score += Game.throwDice(name, opponent);
        System.out.println(name+" finished turn number: "+turns+".");
        turns++;
        if(turns == 7){
            gameInProgress = false;
        }
        Game.lock.notifyAll();
        }
    }    
}
