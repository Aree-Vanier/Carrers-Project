package com.greg.carrers;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Menu {
	
	
	BufferedImage image;
	Graphics2D g;
	int width = 640/100*55;
	int height = 480/100*99;
	FontMetrics fm;
	Button[] buttons = new Button[5];
	
	public Menu(){
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		g = (Graphics2D) image.getGraphics();
		g.setFont(new Font("Arial", Font.PLAIN, 25));
		fm = g.getFontMetrics(g.getFont());
		buttons[0] = new Button(0, 50, width, "Billets Ralentis",Math.pow((Stats.SPEED_LEVEL*10),2)+"$");
		buttons[1] = new Button(0, 100, width, "Montant de Billets",Math.pow((Stats.SPAWN_RATE_LEVEL*10),2)+"$");
		buttons[2] = new Button(0, 150, width, "Valeur de Billets",Math.pow((Stats.MONEY_VALUE_LEVEL*10),2)+"$");
		buttons[3] = new Button(0, height-50, width, "RÉINITIALISER","");
		buttons[4] = new Button(0, height-100, width, "ARGENT POUR TESTER", "");
	}
	
	public void render(Graphics G){
		g.setColor(Color.WHITE);
		g.setStroke(new BasicStroke(7));
		g.fillRoundRect(0, 0, width, height, 25, 25);
		g.setColor(Color.BLACK);
		g.drawRoundRect(0, 0, width, height, 25, 25);
		g.drawString("Menu", width/2-fm.stringWidth("Menu")/2, 25);
		buttons[0].update("Billets Ralentis",Math.pow((Stats.SPEED_LEVEL*10),2)+"$");
		buttons[1].update("Montant de Billets",Math.pow((Stats.SPAWN_RATE_LEVEL*10),2)+"$");
		buttons[2].update("Valeur de Billets",Math.pow((Stats.MONEY_VALUE_LEVEL*10),2)+"$");
		for(Button button: buttons) button.render(g);
		G.drawImage(image, 320-width/2, 240-height/2, null);
	}
	
	public void mouseUpdate(MouseEvent e){
		if(buttons[0].clicked(e, 320-width/2, 240-height/2)){
			if(Stats.SCORE >= Math.pow((Stats.SPEED_LEVEL*10),2) && Stats.SPEED > 0.75) {
				Stats.SCORE -= Math.pow((Stats.SPEED_LEVEL*10),2);
				Stats.SPEED_LEVEL++;
				Stats.SPEED -= 0.25;
			}
		}
		if(buttons[1].clicked(e, 320-width/2, 240-height/2)){
			if(Stats.SCORE >= Math.pow((Stats.SPAWN_RATE_LEVEL*10),2)){
				Stats.SCORE -= Math.pow((Stats.SPAWN_RATE_LEVEL*10),2);
				Stats.SPAWN_RATE_LEVEL++;
				Stats.SPAWN_RATE += 10;
			}
		}
		if(buttons[2].clicked(e, 320-width/2, 240-height/2)){
			if(Stats.SCORE >= Math.pow((Stats.MONEY_VALUE_LEVEL*10),2)){
				Stats.SCORE -= Math.pow((Stats.MONEY_VALUE_LEVEL*10),2);
				Stats.MONEY_VALUE_LEVEL ++;
				Stats.MONEY_VALUE += Stats.MONEY_VALUE_LEVEL*2.5;
			}
		}
		if(buttons[3].clicked(e, 320-width/2, 240-height/2)){
			Stats.reset();
		}
		if(buttons[4].clicked(e, 320-width/2, 240-height/2)){
			Stats.SCORE = 2000000000;
		}
	}
	
}
