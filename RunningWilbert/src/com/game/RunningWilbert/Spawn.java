package com.game.RunningWilbert;

import java.util.Random;

public class Spawn {
	
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	private int scoreKeep = 0;
	
	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
		
	}
	
	public void tick() {
		scoreKeep++;
		
		if(scoreKeep >=500 ) {
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			
			switch(hud.getLevel()) {
			case 1:
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
			break;
			
			case 2:
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
			break;
			
			case 3: 
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
			break;
			
			case 4: 
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
			break;
			}
			//if(hud.getLevel() == 2) {
				
			//}
				
				
		}
	}
}
