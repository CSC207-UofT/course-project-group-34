package Utils;

import java.util.Stack;

// This is helper class for GameState

public class SizedStack<T> extends Stack {

    private int maxSize;

    public SizedStack(int size) {
        super();
        this.maxSize = size;
    }

    @Override
    public T push(Object object) {
        if (this.size() == this.maxSize) {
            this.remove(0);
        }
        return (T) super.push(object);
    }
}
