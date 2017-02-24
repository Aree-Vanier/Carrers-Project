package com.greg.carrers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Money {
	
	int x;
	int y;
	int speed = 5;
	Image image;
	Rectangle rect;
	
	public Money(int x){
		y = -50;
		this.x = x;
		try {
			image = ImageIO.read(Money.class.getResourceAsStream("money.png")).getScaledInstance(64, 32, 0);
		} catch (IOException e) { e.printStackTrace(); }
		rect = new Rectangle();
		rect.setBounds(y, y, image.getWidth(null), image.getHeight(null));
	}
	
	public void render(Graphics g){
		g.drawImage(image, x, y, null);
		g.setColor(Color.red);
		g.drawRect(rect.x, rect.y, rect.width, rect.height);
	}
	
	public void update(){
		y += speed;
		rect.setLocation(x, y);
	}
	
}
