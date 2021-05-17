package com.game.RunningWilbert;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Boss1Bullet extends GameObject{

	private Handler handler;
	Random r = new Random();
	
	
	
	public Boss1Bullet(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = (r.nextInt(5 - -5) + -5);
		velY= 5;
	}
	
	public void tick() {
		x+= velX;
		y += velY;
		
		if(y >= Game.HEIGHT) handler.removeObject(this);
		
		
		
		handler.addObject(new Trail ((int)x, (int)y, ID.Trail, Color.red , 16, 16, 0.01f, handler));
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}

}
