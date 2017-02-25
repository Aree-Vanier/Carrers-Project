package com.greg.carrers;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public class Button {
	int x;
	int y;
	int width;
	int height;
	String[] text = new String[2];
	FontMetrics fm;
	Rectangle rect;
	
	public Button(int x, int y, int width, String text0, String text1){
		this.x = x;
		this.y = y;
		this.width = width;
		this.text[0] = text0;
		this.text[1] = text1;
		rect = new Rectangle();
		height = 50;
		rect.setBounds(x, y, width, height);
	}
	

	public void render(Graphics2D g){
		fm = g.getFontMetrics();
		g.setColor(Color.BLACK);
		g.setStroke(new BasicStroke(2));
		g.drawRect(rect.x, rect.y, rect.width, rect.height);
		g.drawString(text[0], x+10, y+30);
		g.drawString(text[1], x+width-fm.stringWidth(text[1])-10, y+30);
	}
	
	public void update(String text0, String text1){
		this.text[0] = text0;
		this.text[1] = text1;
	}
	
	public boolean clicked(MouseEvent e, int offX, int offY){
		if(rect.contains(e.getX()-offX, e.getY()-offY-26)) return true;
		return false;
	}
}
