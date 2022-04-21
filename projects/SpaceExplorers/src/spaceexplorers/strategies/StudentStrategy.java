package spaceexplorers.strategies;

import spaceexplorers.publicapi.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class StudentStrategy implements IStrategy {
	private HashMap<IVisiblePlanet, Boolean> helpNeed = new HashMap<>(); //self planets that need help
	private boolean neighbor = false;

	/**
	 * Method where students can observe the state of the system and schedule events to be executed.
	 *
	 * @param planets          The current state of the system.
	 * @param planetOperations Helper methods students can use to interact with the system.
	 * @param eventsToExecute  Queue students will add to in order to schedule events.
	 */
	@Override
	public void takeTurn(List<IPlanet> planets, IPlanetOperations planetOperations, Queue<IEvent> eventsToExecute) {
		List<IVisiblePlanet> conquered = new ArrayList<>();
		List<IVisiblePlanet> unconquered = new ArrayList<>();

		for (IPlanet planet : planets) { //for all planets
			if (planet instanceof IVisiblePlanet) { //if visible
				if (((IVisiblePlanet) planet).getOwner() == Owner.SELF) {
					conquered.add((IVisiblePlanet) planet); //if owned by self, add to conquered
				} else {
					unconquered.add((IVisiblePlanet) planet); //if owned by someone els, add to unconquered
				}
			}
		}

		for (IVisiblePlanet planet : conquered) {
			neighbor = false;
			long tempPopulation = ((IVisiblePlanet) planet).getTotalPopulation();
			IVisiblePlanet sourcePlanet = (IVisiblePlanet) planet;
			//Queue<IVisiblePlanet> sortedNeighborDistances = //TODO:GET DISTANCE OF NEIGHBORS

			if (neighbor) {
				//planets need to seek help if close to an enemy
				helpNeed.put(sourcePlanet, true);
			}
		}
	}
}
