package com.game.RunningWilbert;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.game.RunningWilbert.Game.STATE;

public class Menu extends MouseAdapter{
	
	private Game game;
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	public Menu(Game game, Handler handler, HUD hud) {
	this.game = game;	
	this.handler = handler; 
	this.hud = hud;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
//--------------------------------------------------------Main Menu
		if(game.gameState == STATE.Menu) {
			
			//Play
			if(mouseOver(mx, my, 200, 150, 200, 64 )) {
				
			game.gameState = STATE.Select;
			
			AudioPlayer.getSound("ClickSound").play();
			return;
			}
			
			//Help
			if(mouseOver(mx, my, 200, 250, 200, 64)) {
			game.gameState = STATE.Help;
			AudioPlayer.getSound("ClickSound").play();
		
			}
		
		
			//Quit
			if(mouseOver(mx, my, 200, 350, 200, 64)) {
			
			System.exit(1);
			}
		}
		
		//Back Button for Help
		if(game.gameState == STATE.Help) {
			if(mouseOver(mx, my,200, 350, 200, 64)) {
			game.gameState = STATE.Menu;
			AudioPlayer.getSound("ClickSound").play();
			return;
			}
		}
//----------------------------------------------------------Select Menu
	if(game.gameState == STATE.Select) {
			
			//Normal
			if(mouseOver(mx, my, 200, 150, 200, 64 )) {
			
				game.gameState = STATE.Game;
				hud.setLevel(1);
				hud.setScore(0);
				
				
				handler.clearAllEnemys();
				handler.addObject(new Player(game.WIDTH/2-32,game.HEIGHT/2-32, ID.Player, handler));
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50 ), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
				
				game.diff = 0;
	
				AudioPlayer.getSound("ClickSound").play();
				
			}
			
			//Hard
			if(mouseOver(mx, my, 200, 250, 200, 64)) {

				game.gameState = STATE.Game;
				hud.setLevel(1);
				hud.setScore(0);
				
				
				handler.clearAllEnemys();
				handler.addObject(new Player(game.WIDTH/2-32,game.HEIGHT/2-32, ID.Player, handler));
				handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH -50 ), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
				
				game.diff = 1;

				AudioPlayer.getSound("ClickSound").play();
				
			}
		}
//-------------------------------------------------------------Back/ Try again Buttons
	
		
		//Back Button for Help && Select
		if(game.gameState == STATE.Help || game.gameState == STATE.Select) {
			if(mouseOver(mx, my,200, 350, 200, 64)) {
			game.gameState = STATE.Menu;
			AudioPlayer.getSound("ClickSound").play();
			return;
			}
		}
	

		//Try again
		if(game.gameState == STATE.End) {
			if(mouseOver(mx, my,200, 350, 200, 64)) {
			game.gameState = STATE.Menu;
			AudioPlayer.getSound("ClickSound").play();
			return;
			}
		}
	}
		
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		
	
		if(game.gameState == STATE.Menu) {
			//--------------------------------------------Menu
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
		
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Menu", 230, 85);
			
			g.setFont(fnt2);
	
			g.drawRect(200, 150, 200, 64);
			g.drawString("Play", 265, 195);
		
	
			g.drawRect(200, 250, 200, 64);
			g.drawString("Help", 265, 295);
		
			g.drawRect(200, 350, 200, 64);
			g.drawString("Quit", 265, 395);
			
		}else if(game.gameState == STATE.End) {
			//-------------------------------------------End
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			Font fnt3 = new Font("arial", 1, 20);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Game Over", 175, 100);
			
			g.setFont(fnt3);
			g.drawString("Score: " + hud.getScore(), 250, 200);
			g.drawString("See you around!", 225, 250);
			 
			
			g.setFont(fnt2);
			g.drawRect(200, 350, 200, 64);
			g.drawString("Try again!", 230, 395);
			
		}else if(game.gameState == STATE.Help) {
			//-------------------------------------Help
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			Font fnt3 = new Font("arial", 1, 20);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Help", 100, 100);
			
			g.setFont(fnt3);
			g.drawString("Hit the Keyboard 'till something happens!", 50, 200);
			g.drawString("I got no time to explain >:|", 50, 250);
			 
			
			g.setFont(fnt2);
			g.drawRect(200, 350, 200, 64);
			g.drawString("Back", 265, 395);
			
		}else if(game.gameState == STATE.Select) {
			//-------------------------------------Select
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
		
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Select difficulty", 125, 85);
			
			g.setFont(fnt2);
	
			g.drawRect(200, 150, 200, 64);
			g.drawString("Normal", 265, 195);
		
	
			g.drawRect(200, 250, 200, 64);
			g.drawString("Hard", 265, 295);
		
			g.drawRect(200, 350, 200, 64);
			g.drawString("Back", 265, 395);
		}
	}
	
}
