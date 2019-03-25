package de.lukas_reining.redball.objects.events;

import java.util.ArrayList;
import java.util.Iterator;

public class EventQueue {

	private ArrayList<Event> events;

	public EventQueue() {
		events = new ArrayList<>();
	}

	public void update(double elapsed) {
		Iterator<Event> iterator = events.iterator();
		// Iterate over every Event
		while (iterator.hasNext()) {
			Event currentEvent = iterator.next();
			if (currentEvent.hasStarted() && !currentEvent.hasEnded()) {
				currentEvent.update(); // If event has started -> Update
			} else if (!currentEvent.hasStarted()) {
				currentEvent.startEvent(); // If event has not started -> start
				currentEvent.update();
			} else if (currentEvent.hasEnded()) {
				iterator.remove(); // If event has ended -> delete
			}
		}
	}

	public void addEvent(Event event) {
		if (event.isExclusive()) {
			for(Event e: events) {
				if(e.isExclusive() && e.getClass() == event.getClass()) {
					return; // Dont add a second exclusive
				}
			}
		}
		events.add(event);
	}

}
