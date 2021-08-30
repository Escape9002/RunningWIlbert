package com.game.RunningWilbert;

import java.util.Random;

public class Spawn {
	
	private Handler handler;
	private HUD hud;
	private Game game;
	private Random r = new Random();
	
	private int scoreKeep = 0;
	
	public Spawn(Handler handler, HUD hud, Game game) {
		this.handler = handler;
		this.hud = hud;
		this.game = game;
		
	}
	
	public void tick() {
		scoreKeep++;
		
		if(scoreKeep >=500 ) {
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			
			//handler.addObject(new Boss1(r.nextInt(Game.WIDTH/ 2), 0 , ID.Boss1, handler));
			
			if(game.diff == 0) {
				switch (hud.getLevel()) {
				case 2: handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.FastEnemy, handler));
					break;
					
				case 3: handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.SmartEnemy, handler));
					break;
					
				case 4: 
					handler.clearEnemys();
					handler.addObject(new Boss1(r.nextInt(Game.WIDTH /2) - 48, 0, ID.Boss1, handler));
					break;
				
				case 10:
					handler.clearEnemys();
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.FastEnemy, handler));
					handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.SmartEnemy, handler));
				
				}
				
			}else if(game.diff == 1) {
				switch (hud.getLevel()) {
				case 2: 
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.FastEnemy, handler));
				 	handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.FastEnemy, handler));
					break;
					
				case 3: 
					handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.SmartEnemy, handler));
					break;
					
				case 4: 
					handler.clearEnemys();
					handler.addObject(new Boss1(r.nextInt(Game.WIDTH /2) - 48, 70, ID.Boss1, handler));
					break;
				
				case 10:
					handler.clearEnemys();
					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.FastEnemy, handler));
					handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH -50), r.nextInt(Game.HEIGHT -50), ID.SmartEnemy, handler));
				
				}	
			}
				
		}
	}
}
