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
        addMap("Vault Map");
    }

    private void addMap(String map){
        maps.add(map);
    }

    public GameBoard createMap(int i){
        switch(i){
            case 1:
                return new BlankMap();
            case 2:
                return new VaultMap();
            default:
                return new BlankMap();
        }
    }

    public ArrayList<String> getMaps(){
        return maps;
    }
}
