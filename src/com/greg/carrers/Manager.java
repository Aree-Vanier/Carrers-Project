package com.greg.carrers;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Manager {
    
    
    boolean gameStat = true;
    boolean menuStat = false;
    Game game = new Game();
    
    public Manager(){        
    }
    
    public void draw(Graphics g){
    	if(gameStat) game.render(g);
    	if(menuStat) ;
    }
    
    public void update(){
        
    }
    
    public void keyDown(KeyEvent e){
        
    }
    
    public void keyUp(KeyEvent e){
    }
    
    public void mouseUpdate(MouseEvent e){
        if(gameStat) game.mouseUpdate(e);
    	if(menuStat) ;
    }
}
