package edu.chl.roborally.model.maps;

import java.util.ArrayList;

/**
 * Created by axel on 2015-04-23.
 */
public class MapFactory {

    private ArrayList<String> maps;

    public MapFactory(){
        maps = new ArrayList<>();
        addMap("Blank Map");
        addMap("Island King");
    }

    private void addMap(String map){
        maps.add(map);
    }

    public GameBoard createMap(String name){
        if (name.equals(maps.get(0))) {
            System.out.print("New map created: " + maps.get(0));
            return new BlankMap();
        } else if (name.equals(maps.get(1))) {
            System.out.print("New map created: " + maps.get(1));
            return new IslandKingMap();
        } else {
            System.out.print("Created default: " + maps.get(0));
            return new BlankMap();
        }
    }

    public ArrayList<String> getMaps(){
        return maps;
    }
}
