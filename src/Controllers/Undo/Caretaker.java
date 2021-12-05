package Controllers.Undo;

import java.util.ArrayList;

public class Caretaker {
    private ArrayList<MementoStates> mementoStates;

    public void addState(MementoStates state){
        this.mementoStates.add(state);
    }

    public MementoStates getState(int index){
        return this.mementoStates.get(index);
    }
}
