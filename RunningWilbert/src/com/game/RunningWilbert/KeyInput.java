package com.game.RunningWilbert;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import com.game.RunningWilbert.Game.STATE;

public class KeyInput extends KeyAdapter {

	private Game game;
	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	
	Random r = new Random();
	
	public KeyInput(Handler handler, Game game) {
		this.handler = handler;
		this.game = game;
		
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i< handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player){
				//Shit for player 1
				
				if(key == KeyEvent.VK_W) { tempObject.setVelY(-5); keyDown[0] = true; }
				if(key == KeyEvent.VK_S) { tempObject.setVelY(5); keyDown[1] = true; }
				
				if(key == KeyEvent.VK_D) { tempObject.setVelX(5); keyDown[2] = true; }
				if(key == KeyEvent.VK_A) { tempObject.setVelX(-5); keyDown[3] = true; }
				
				}
			}
		
		if(key == KeyEvent.VK_ESCAPE) {
			if(game.gameState == STATE.Menu) {
				System.exit(1);
			}else if(game.gameState == STATE.Game) {
				handler.clearAllEnemys();
				game.gameState = STATE.Menu;
				for (int i= 0; i<10; i++) {
					handler.addObject(new MenuParticle(r.nextInt(game.WIDTH),r.nextInt(game.HEIGHT), ID.MenuParticle, handler));
				}
			}
		}
		
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i< handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player){
				//Shit for player 1
				
				if(key == KeyEvent.VK_W) keyDown[0] = false; 
				if(key == KeyEvent.VK_S) keyDown[1] = false; 
				
				if(key == KeyEvent.VK_D) keyDown[2] = false; 
				if(key == KeyEvent.VK_A) keyDown[3] = false; 
				
				
				//vertical movement
				if (!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
				//horizontal
				if (!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
				}	
			
		}
	}
}
