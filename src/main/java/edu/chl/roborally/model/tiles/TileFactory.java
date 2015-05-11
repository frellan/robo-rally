package edu.chl.roborally.model.tiles;

/**
 * Created by Pertta on 15-05-11.
 */
public class TileFactory {

    private static TileFactory tile;

    public static TileFactory getInstance(){
        if(tile == null){
            tile = new TileFactory();
        }
        return tile;
    }

    /**
     * Blank = 0
     * ConVey N,W,S,E : NW,NE,SW,SE = 11,12,13,14 : 15,16,17,18
     * RotTile W,E = 21,22
     * WallTile N,W,S,E = 31,32,33,34
     * PitAttribute = 4
     * StarTile = 5
     */

    public GameTile createTile(int tileNbr) {
        GameTile tile = new GameTile();
        if(tileNbr == 0) {
            return tile.addAttribute();
        }
        return new GameTile();
    }

}
