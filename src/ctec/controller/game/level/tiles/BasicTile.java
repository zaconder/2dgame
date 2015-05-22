package ctec.controller.game.level.tiles;

import ctec.controller.game.gfx.Screen;
import ctec.controller.game.level.Level;

public class BasicTile extends Tile
{

	protected int tileid;
	protected int tileColour;
	
	public BasicTile(int id, int x, int y, int tileColour, int levelColour)
	{
		super(id, false, false, levelColour);
		this.tileid = x + y * 32;
		this.tileColour = tileColour;

	}
	
	public void tick()
	{
		
	}
	
	public void render(Screen screen, Level level, int x, int y)
	{
		screen.render(x, y, tileid, tileColour, 0x00, 1);
		
	}

}
