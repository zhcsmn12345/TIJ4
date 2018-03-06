import java.lang.ref.Cleaner;

public class CleaningExample implements AutoCloseable {
	// A cleaner, preferably one shared within a library
	private static final Cleaner cleaner = Cleaner.create();

	static class State implements Runnable {

		State() {
			System.out.println("init");// initialize State needed for cleaning action
		}

		public void run() {
			System.out.println("clean");// cleanup action accessing State, executed at most once
		}
	}

	private final State state;
	private final Cleaner.Cleanable cleanable;

	public CleaningExample() {
		this.state = new State();
		this.cleanable = cleaner.register(this, state);
	}

	public void close() {
		cleanable.clean();
	}
	
	public static void main(String[] args) {
		while(true) {
			new CleaningExample();
		}
	}
}
