package Controllers.Undo;

import Controllers.GameState;

public class Originator {

    private GameState state;

    public void set(GameState state){
        this.state = state;
    }

    public MementoStates storeInMementoState() {
        return new MementoStates(state);
    }

    public GameState restoreFromMementoStates(MementoStates m) {
        return m.getSavedMementoState();
    }
}
