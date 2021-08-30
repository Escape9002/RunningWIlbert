package com.game.RunningWilbert;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Boss1 extends GameObject{

	private Handler handler;
	Random r = new Random(); 
	
	private int timer = 50;
	private int timer2 = 50;
	
	private int lastLevel = 0;
	
	public Boss1(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 0;
		velY= 2;
	}
	
	
	public void tick() {
		x += velX;
		y += velY;
		
		if(timer <= 0) {
			velY=0;
		}else {
			timer --;
		}
		
		if(timer <= 0) timer2--;
		if(timer2 <=0) 
		{
			if(velX == 0) velX = 2;
			
			int spawn = r.nextInt(10);
			
			if (spawn == 0) handler.addObject(new Boss1Bullet((int) x + 48, (int)y + 48, ID.BasicEnemy, handler)); 
		}
		
		if(x <= 0 || x >= Game.WIDTH - 64) velX *= -1;
		
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 64, 64);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 64, 64);
	}

}
