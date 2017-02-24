package com.greg.carrers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Money {
	
	int x;
	float y;
	double speed;
	Image image;
	Rectangle rect;
	
	public Money(int x, double speed){
		y = -50;
		this.speed = speed;
		this.x = x;
		try {
			image = ImageIO.read(Money.class.getResourceAsStream("money.png")).getScaledInstance(64, 32, 0);
		} catch (IOException e) { e.printStackTrace(); }
		rect = new Rectangle();
		rect.setBounds(x, (int) y, image.getWidth(null), image.getHeight(null));
	}
	
	public void render(Graphics g){
		g.drawImage(image, x, (int)y, null);
	}
	
	public void update(){
		y += speed;
		rect.setLocation(x,(int) y);
	}
	
}
