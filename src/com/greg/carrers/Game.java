package com.greg.carrers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class Game {
	
	ArrayList<Money> money = new ArrayList<Money>();
	Random random = new Random();
	int score = 0;
	ArrayList<Money> toRemove = new ArrayList<Money>();
	
	public void render(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0, 0, 640, 480);
		if(!(random.nextInt(score+100) < 50)){
			System.out.println("New Money");
			money.add(new Money(random.nextInt(640-32)));
		}
		for(Money money: money){
			money.render(g);
			money.update();
			if(money.y > 480){
				toRemove.add(money);
			}
		}
		for(Money money: toRemove){
			this.money.remove(money);
		}
		toRemove.clear();
	}
	
	public void mouseUpdate(MouseEvent e){
		
	}
}
