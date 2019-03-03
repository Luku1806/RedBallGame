package de.lukas_reining.redball.objects.events;

import de.lukas_reining.redball.objects.Object;;

public abstract class Event {

	protected Object object;
	protected long startTime, endTime;
	protected long duration;
	protected boolean hasStarted;
	protected boolean hasEnded;

	public Event(long duration, Object object) {
		this.object = object;
		this.duration = duration;
	}

	public void startEvent() {
		this.startTime = System.currentTimeMillis();
		this.endTime = startTime + duration;
		hasStarted = true;
		onStart();
	}

	public void update() {
		onUpdate();
		if (System.currentTimeMillis() >= endTime) {
			onEnd();
			hasEnded = true;
		}
	}

	protected abstract void onStart();

	protected abstract void onUpdate();

	protected abstract void onEnd();

	public boolean hasStarted() {
		return hasStarted;
	}

	public boolean hasEnded() {
		return hasEnded;
	}

}
