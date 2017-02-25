package com.greg.carrers;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.prefs.Preferences;

public class Manager {
    
    
    boolean gameStat = true;
    boolean menuStat = false;
    Game game = new Game();
    Menu menu = new Menu();
    
    public Manager(){
    	load();
    }
    
    public void draw(Graphics g){
    	if(gameStat) game.render(g);
    	if(menuStat) menu.render(g);
    }
    
    public void update(){
        
    }
    
    public void keyDown(KeyEvent e){
        
    }
    
    public void keyUp(KeyEvent e){
    	if(e.getKeyCode()==KeyEvent.VK_ESCAPE) menuStat = !menuStat;
    }
    
    public void mouseUpdate(MouseEvent e){
    	if(menuStat) menu.mouseUpdate(e);
    	else if(gameStat) game.mouseUpdate(e);
    }
    
    public static void save(){
    	Preferences prefs = Preferences.userNodeForPackage(com.greg.carrers.Manager.class);
    	
    	prefs.putInt("score", Stats.SCORE);
    	prefs.putDouble("speed", Stats.SPEED);
    	prefs.putInt("spawn rate", Stats.SPAWN_RATE);
    	prefs.putInt("money value", Stats.MONEY_VALUE);
    	prefs.putInt("speed level", Stats.SPEED_LEVEL);
    	prefs.putInt("spawn rate level", Stats.SPAWN_RATE_LEVEL);
    	prefs.putInt("money value level", Stats.MONEY_VALUE_LEVEL);
    	
    }
    
    public void load(){
    	Preferences prefs = Preferences.userNodeForPackage(com.greg.carrers.Manager.class);
    	
    	Stats.SCORE = prefs.getInt("score", Stats.SCORE);
    	Stats.SPEED = prefs.getDouble("speed", Stats.SPEED);
    	Stats.SPAWN_RATE = prefs.getInt("spawn rate", Stats.SPAWN_RATE);
    	Stats.MONEY_VALUE = prefs.getInt("money value", Stats.MONEY_VALUE);
    	Stats.SPEED_LEVEL = prefs.getInt("speed level", Stats.SPEED_LEVEL);
    	Stats.SPAWN_RATE_LEVEL = prefs.getInt("spawn rate level", Stats.SPAWN_RATE_LEVEL);
    	Stats.MONEY_VALUE_LEVEL = prefs.getInt("money value level", Stats.MONEY_VALUE_LEVEL);
    }
    
}
