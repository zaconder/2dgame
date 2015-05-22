package ctec.controller.game.level.tiles;

import ctec.controller.game.gfx.Colours;
import ctec.controller.game.gfx.Screen;
import ctec.controller.game.level.Level;

public abstract class Tile
{

	
	
	public static final Tile[] tiles = new Tile[256];
	public static final Tile VOID = new BasicSolidTile(0, 0, 0, Colours.get(000, -1, -1, -1), 0xFF000000);
	public static final Tile STONE = new BasicSolidTile(1,1,0,Colours.get(-1, 333, -1, -1), 0xFF555555);
	public static final Tile GRASS = new BasicTile(2, 2, 0, Colours.get(-1, 131, 141, -1), 0xFF00FF00);
	public static final Tile WATER = new AnimatedTile(3, new int[][] {{ 0 , 5 }, { 1 , 5 }, { 2 , 5 }, { 1 , 5 }}, Colours.get(-1, 004, 115, -1), 0xFF0000FF, 500);
	public static final Tile DIRT = new BasicTile(4, 3, 0, Colours.get(-1, 421, 532, -1), 0xFF996633);
	public static final Tile WOOD = new BasicSolidTile(5, 4, 0, Colours.get(-1, 321, 432, -1), 0xFFdb9854);
	
	
	protected byte id;
	protected boolean solid;
	protected boolean emitter;
	private int levelColour;
	
	public Tile(int id, boolean isSolid, boolean isEmitter, int levelColour)
	{
		this.id = (byte) id;
		if(tiles[id] != null) throw new RuntimeException("Duplicate tile id on " + id);
		this.solid = isSolid;
		this.emitter = isEmitter;
		this.levelColour = levelColour;
		tiles[id] = this;
		
	}
	
	public byte getid()
	{
		return id;
	}
	
	public boolean isSolid()
	{
		return solid;
	}
	
	public boolean isEmitter()
	{
		return emitter;
	}
	
	public int getLevelColour()
	{
		return levelColour;
	}
	
	public abstract void tick();
	
	public abstract void render(Screen screen, Level level, int x, int y);

}
