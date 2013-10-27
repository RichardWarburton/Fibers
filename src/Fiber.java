

public abstract class Fiber<T> implements Runnable {
    
    private T value;
    private Runnable continuation;

    public Fiber() {
        continuation = this;
    }

    public T resume() {
        if (continuation == null)
            throw new FiberException();
        
        continuation.run();
        return value;
    }

    protected void yield(T value, Runnable continuation) {
        this.value = value;
        this.continuation = continuation;
    }

}
