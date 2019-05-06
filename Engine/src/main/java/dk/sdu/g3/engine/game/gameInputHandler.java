package dk.sdu.g3.engine.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import dk.sdu.g3.common.data.Coordinate;


public class gameInputHandler extends InputAdapter {
    STDGame game;

    public gameInputHandler(STDGame game) {
        this.game = game;
    }
    
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button){
        int gameY = (Gdx.graphics.getHeight() - screenY);
        Coordinate clickpoint = new Coordinate(screenX, gameY);
        
        
        return true;
    }

}