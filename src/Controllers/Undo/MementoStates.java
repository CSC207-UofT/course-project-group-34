package Controllers.Undo;

import Controllers.GameState;

public class MementoStates {

    private final GameState state;

    public MementoStates(GameState state){
        this.state = state;
    }

    public GameState getSavedMementoState(){
        return state;
    }
}
