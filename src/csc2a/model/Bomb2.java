package csc2a.model;

//This class will contain bombs that will kill the player

import csc2a.designpatterns.iRenderVisitor;

public class Bomb2 extends GameObject {
	
	public Bomb2(int x, int y,String imgPath)
	{
		super(x, y);
	}

	@Override
	public void accept(iRenderVisitor visitor) {
		// TODO Auto-generated method stub
		
			visitor.render(this);	
		
	}

}
