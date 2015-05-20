package edu.chl.roborally.model.maps;

import java.util.ArrayList;

/**
 * Created by axel on 2015-04-23.
 */
public class MapFactory {

    private static MapFactory mapFactory;
    private ArrayList<GameBoard> maps;

    public static MapFactory getInstance(){
        if (mapFactory == null) {
            mapFactory = new MapFactory();

            mapFactory.createMaps();
        }
        return mapFactory;
    }

    private void createMaps() {
        maps = new ArrayList<>();
        maps.add(new BlankMap());
        maps.add(new IslandKingMap());
        maps.add(new RiskyExchangeMap());
    }

    public ArrayList<GameBoard> getMaps(){
        return maps;
    }

    public GameBoard getMap(int i) {
        return maps.get(i);
    }
}
