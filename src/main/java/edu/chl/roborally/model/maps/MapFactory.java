package edu.chl.roborally.model.maps;

import java.util.ArrayList;

/**
 * Created by axel on 2015-04-23.
 *
 * Creates all the maps.
 */
public class MapFactory {

    private static MapFactory instance;
    private ArrayList<GameBoard> maps;

    private MapFactory() {
        createMaps();
    }

    public static MapFactory getInstance(){
        if (instance == null) {
            instance = new MapFactory();
        }
        return instance;
    }

    private void createMaps() {
        maps = new ArrayList<>();
        maps.add(new BlankMap());
        maps.add(new IslandKingMap());
        maps.add(new RiskyExchangeMap());
    }

    /**
     * Returns all the maps in the game.
     * @return A list containing all the maps.
     */
    public ArrayList<GameBoard> getMaps(){
        return maps;
    }

    /**
     * Returns a single map with the specied id.
     * @param id The id of the map to request.
     * @return The requested map.
     */
    public GameBoard getMap(int id) {
        return maps.get(id);
    }
}
