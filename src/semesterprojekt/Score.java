/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterprojekt;

/**
 *
 * @author rickie
 */
public  class Score {
    private static int currentScore = 0;
    
    public Score(){
        
    }
    
    public void addToPoints(int addToScore){
        currentScore += addToScore;
    }
    
    public int getCurrentScore(){
        return currentScore;
    }
    
}
