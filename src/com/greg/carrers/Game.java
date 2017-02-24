package com.greg.carrers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class Game {
	
	ArrayList<Money> money = new ArrayList<Money>();
	Random random = new Random();
	int score = 0;
	ArrayList<Money> toRemove = new ArrayList<Money>();
	Font font;
	
	public Game(){
		font = new Font("Arial", Font.BOLD, 25);
	}
	
	public void render(Graphics g){
		g.setFont(font);
		g.setColor(Color.white);
		g.fillRect(0, 0, 640, 480);
		if(random.nextInt(Stats.SPAWN_RATE) > 75){
			money.add(new Money(random.nextInt(640-32), Stats.SPEED));
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
		
		g.setColor(Color.black);
		g.drawString(score+"$", 5, 26);
	}
	
	public void mouseUpdate(MouseEvent e){
		Rectangle clickRect = new Rectangle();
		clickRect.x = e.getX()-Stats.CLICK_RADIUS/2;
		clickRect.y = e.getY()-Stats.CLICK_RADIUS/2;
		clickRect.width = e.getX()+Stats.CLICK_RADIUS/2;
		clickRect.height = e.getY()+Stats.CLICK_RADIUS/2;
		for(Money money: money){
			if(money.rect.intersects(clickRect)){
				toRemove.add(money);
				score += Stats.MONEY_VALUE;
			}
		}
	}
}
