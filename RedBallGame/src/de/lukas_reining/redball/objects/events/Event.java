package de.lukas_reining.redball.objects.events;

public abstract class Event {

	protected long startTime, endTime;
	protected long duration;

	public Event(long duration) {
	}

	public void startEvent() {
		this.startTime = System.currentTimeMillis();
		this.endTime = startTime + duration;
		onStart();
	}

	public void update() {
		onUpdate();
		if (System.currentTimeMillis() >= endTime) {
			onEnd();
		}
	}

	protected abstract void onStart();

	protected abstract void onUpdate();

	protected abstract void onEnd();

}
