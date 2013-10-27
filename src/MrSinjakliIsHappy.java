
public class MrSinjakliIsHappy extends Fiber<Integer> {

    /**
     *
     * Ruby example from docs:

fiber = Fiber.new do
  Fiber.yield 1
  2
end

puts fiber.resume
puts fiber.resume
puts fiber.resume

produces

1
2
FiberError: dead fiber called

     */
    public static void main(String[] args) {
        Fiber<Integer> fiber = new MrSinjakliIsHappy();
        System.out.println(fiber.resume());
        System.out.println(fiber.resume());
        System.out.println(fiber.resume());
    }

    @Override
    public void run() {
        // Ok, so this uses a runnable as a continuation.
        // Your ruby code doesn't need to do this,
        // It just needs to do a CPS transform into this form
        // all this exists to do is to prove that you don't
        // need a JVM Level change.
        yield(1, new Runnable() {
            @Override
            public void run() {
                yield(2, null);
            }
        });
    }

}
