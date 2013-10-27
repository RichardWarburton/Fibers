
public class FiberException extends RuntimeException {

    private static final long serialVersionUID = -2012471320838730774L;

    public FiberException() {
        super("Dead fiber called");
    }

}
