package com.game.RunningWilbert;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import com.game.RunningWilbert.Game.STATE;

public class KeyInput extends KeyAdapter {

	private Game game;
	private Handler handler;
	private boolean[] keyDown1 = new boolean[4];
	private boolean[] keyDown2 = new boolean[4];
	
	Random r = new Random();
	
	public KeyInput(Handler handler, Game game) {
		this.handler = handler;
		this.game = game;
		
		keyDown1[0] = false;
		keyDown1[1] = false;
		keyDown1[2] = false;
		keyDown1[3] = false;
		
		keyDown2[0] = false;
		keyDown2[1] = false;
		keyDown2[2] = false;
		keyDown2[3] = false;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i< handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player1){
				//Shit for player 1
				
				if(key == KeyEvent.VK_W) { tempObject.setVelY(-5); keyDown1[0] = true; }
				if(key == KeyEvent.VK_S) { tempObject.setVelY(5); keyDown1[1] = true; }
				
				if(key == KeyEvent.VK_D) { tempObject.setVelX(5); keyDown1[2] = true; }
				if(key == KeyEvent.VK_A) { tempObject.setVelX(-5); keyDown1[3] = true; }
				
				}
			
			if(tempObject.getId() == ID.Player2){
				//Shit for player 2
				
				if(key == KeyEvent.VK_UP) { tempObject.setVelY(-5); keyDown2[0] = true; }
				if(key == KeyEvent.VK_DOWN) { tempObject.setVelY(5); keyDown2[1] = true; }
				
				if(key == KeyEvent.VK_RIGHT) { tempObject.setVelX(5); keyDown2[2] = true; }
				if(key == KeyEvent.VK_LEFT) { tempObject.setVelX(-5); keyDown2[3] = true; }
				
				}
			}
		
		if(key == KeyEvent.VK_P && game.gameState == STATE.Game) {
			if(Game.paused) Game.paused = false;
			else Game.paused = true;
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
			}else if(game.gameState == STATE.Help || game.gameState == STATE.Settings) {
				
				game.gameState = STATE.Menu;
			}
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i< handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player1){
				//Shit for player 1
				
				if(key == KeyEvent.VK_W) keyDown1[0] = false; 
				if(key == KeyEvent.VK_S) keyDown1[1] = false; 
				
				if(key == KeyEvent.VK_D) keyDown1[2] = false; 
				if(key == KeyEvent.VK_A) keyDown1[3] = false; 
				
				
				//vertical movement
				if (!keyDown1[0] && !keyDown1[1]) tempObject.setVelY(0);
				//horizontal
				if (!keyDown1[2] && !keyDown1[3]) tempObject.setVelX(0);
				}	
			
			if(tempObject.getId() == ID.Player2){
				//Shit for player 2
				
				if(key == KeyEvent.VK_UP) keyDown2[0] = false; 
				if(key == KeyEvent.VK_DOWN) keyDown2[1] = false; 
				
				if(key == KeyEvent.VK_RIGHT) keyDown2[2] = false; 
				if(key == KeyEvent.VK_LEFT) keyDown2[3] = false; 
				
				
				//vertical movement
				if (!keyDown2[0] && !keyDown2[1]) tempObject.setVelY(0);
				//horizontal2
				if (!keyDown2[2] && !keyDown2[3]) tempObject.setVelX(0);
				}	
			
		}
	}
}
