package de.lukas_reining.redball.gamelogic;

public abstract class GameLoop {

	private boolean running = true;
	private float ticks = 60;
	private float fps = 60;

	protected abstract void render();

	protected abstract void update(double timeSinceLast);

	protected abstract void handleInput();

	public void startGameloop() {
		double deltaUpdates = 1000000000 / ticks;
		double deltaFrames = 1000000000 / fps;
		double frames = 0;
		double lag = 0;
		int updateCount = 0;
		int frameCount = 0;
		running = true;

		// Main gameloop
		long lastTime = System.nanoTime();
		long lastFpsPrint = System.currentTimeMillis();

		while (running) {
			long now = System.nanoTime();
			double elapsed = now - lastTime;
			frames += elapsed / deltaFrames;
			lag += elapsed;
			lastTime = now;

			// Fixed Updates
			while (lag >= deltaUpdates) {
				handleInput();
				update(1 / ticks);
				updateCount++;
				lag -= deltaUpdates;
			}
			// Fixed FPS Rendering
			if (frames >= 1) {
				render();
				frameCount++;
				frames--;
			}

			// Prints out the Fps and the updates on the console once a second
			if (System.currentTimeMillis() - lastFpsPrint > 1000) {
				lastFpsPrint = System.currentTimeMillis();
				System.out.println(updateCount + " Updates, " + frameCount + " Fps");
				updateCount = 0;
				frameCount = 0;
			}
		}
	}

	public void startGameloopInThread() {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				startGameloop();
			}
		});
		thread.start();
	}

}
