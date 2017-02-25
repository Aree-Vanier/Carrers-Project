package com.greg.carrers;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Window extends JComponent implements ActionListener, KeyListener, MouseListener, MouseMotionListener{


	private static final long serialVersionUID = 999999999;
	private String title;
	public int height;
	public int width;
	private Timer timer;
	private Manager manager;
	
	private JFrame window;
	public Window(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
		init();
	    manager = new Manager();
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.dispose();
		window.setVisible(true);
		timer.start();

	    window.addKeyListener(this); 
	    window.addMouseListener(this);
	    window.addMouseMotionListener(this);
	}

	private void init() {
		window = new JFrame(title); 
		window.add(this);
		window.pack();
		window.setSize(new Dimension(width, height));
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);

		
		window.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    		Manager.save();
		            System.exit(0);
		        }
		});
//		window.addKeyListener(new KeyAdapter(){
//			@Override
//			public void keyPressed(KeyEvent e){
//				key_handler.keyPressed(e);
//				
//			}
//			
//			@Override
//			public void keyReleased(KeyEvent e){
//				key_handler.keyReleased(e);
//			}
//		});
//		
		timer = new Timer(40, this);
	}

	
	@Override
	protected void paintComponent(Graphics g){
		manager.draw(g);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		manager.mouseUpdate(e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		manager.keyDown(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		manager.keyUp(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}
}