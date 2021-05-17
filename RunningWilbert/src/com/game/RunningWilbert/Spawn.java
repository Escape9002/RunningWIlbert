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
			
			//handler.addObject(new Boss1(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.Boss1, handler));
			
			
				
				switch (hud.getLevel()) {
				case 2: handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.FastEnemy, handler));
					break;
					
				case 3: handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.SmartEnemy, handler));
					break;
					
				case 4: 
					handler.clearEnemys();
					handler.addObject(new Boss1(r.nextInt(Game.WIDTH /2) - 48, r.nextInt(Game.HEIGHT /2) - 70, ID.Boss1, handler));
					break;
					
				
				}	
		}
	}
}
