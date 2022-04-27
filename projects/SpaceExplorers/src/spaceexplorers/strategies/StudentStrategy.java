package spaceexplorers.strategies;

import spaceexplorers.publicapi.*;

import java.util.*;

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
		List<IVisiblePlanet> priority = new ArrayList<>(); //dangerous planets to be prioritized

		for (IPlanet planet : planets) { //for all planets
			if (planet instanceof IVisiblePlanet) { //if visible
				if (((IVisiblePlanet) planet).getOwner() == Owner.SELF) {
					conquered.add((IVisiblePlanet) planet); //if owned by self, add to conquered
				} else {
					unconquered.add((IVisiblePlanet) planet); //if owned by someone else, add to unconquered
				}
			}
		}

		for (IVisiblePlanet planet : conquered) {
			neighbor = false;
			double tempPopulation = planet.getTotalPopulation();
			IVisiblePlanet sourcePlanet = planet;
			Queue<IVisiblePlanet> sortedDist = getDistances(planet, planets);

			if (neighbor) {
				//planets need to seek help if close to an enemy
				helpNeed.put(sourcePlanet, true);
			}

			for (IVisiblePlanet neighbor : sortedDist) {
				//looks for neutral planets
				if (tempPopulation > 1 && neighbor.getOwner() == Owner.NEUTRAL) {
					tempPopulation = tempPopulation / 2;
					eventsToExecute.offer(planetOperations.transferPeople(sourcePlanet, neighbor, (long) tempPopulation / 2));
					//sends half of current planet's population
				}
			}
			while (!sortedDist.isEmpty()) {
				//attack the opponent when our population is 15% greater
				double size = sourcePlanet.getSize();
				double enemyPop = sortedDist.peek().getP2Population();

				if (sortedDist.peek().getOwner() == Owner.OPPONENT) {
					int max = (int) Math.max(3, enemyPop * 1.15);
					double maxPop = Math.max(max, sourcePlanet.getP1Population() / 1.15);

					if ((tempPopulation > enemyPop * 1.15) && (tempPopulation - maxPop > 1)) { //attack the opponent based on size
						tempPopulation -= maxPop;
						priority.add(sortedDist.peek());
						eventsToExecute.offer(planetOperations.transferPeople(sourcePlanet, sortedDist.peek(), (long) maxPop));
					}
				}
				sortedDist.remove();
			}
		}

		for (IVisiblePlanet seekingPlanet: helpNeed.keySet()) {
			//planets that need help for loop -> our neighbors are our own team = send to that need-help planet
			if (helpNeed.get(seekingPlanet) == true) {
				for (IVisiblePlanet conquer : conquered) {
					if (conquer.getTotalPopulation() < 6 || getEnemies(conquer, planets).size() > 1) {}
					//if false this block does not run because of else if
					else if (conquer.getTotalPopulation() > conquer.getSize() * 0.5) {
						for (IEdge edge : conquer.getEdges()) {
							if (seekingPlanet.getId() == edge.getDestinationPlanetId() && seekingPlanet.getSize() > seekingPlanet.getTotalPopulation()) {
								//if this is the planet we want to help, and it has room for us
								eventsToExecute.offer(planetOperations.transferPeople(conquer, seekingPlanet, conquer.getTotalPopulation()/2));
								break;
							}
						}
					}
				}
				helpNeed.remove(seekingPlanet);
			}
		}
		for (IVisiblePlanet helped : priority) { //for every planet helped
			List<IVisiblePlanet> enemies = getEnemies(helped, planets);
			for (IVisiblePlanet enemy : enemies) {
				eventsToExecute.offer(planetOperations.transferPeople(helped, enemy, helped.getP1Population()/2));
			}
		}
	}

	public Queue<IVisiblePlanet> getDistances(IPlanet planet, List<IPlanet> planets) {
		HashMap<IVisiblePlanet, Integer> neighbors = new HashMap<>(); //dictionary of K:planet and V:distance
		Set<IEdge> edges = planet.getEdges();
		Queue<IVisiblePlanet> distQueue = new LinkedList<>();
		int[] sortArr = new int[edges.size()]; //sets array size to amount of edges that planet has
		int count = 0;
		for (IEdge edge : edges) {
			for (IPlanet i : planets) {
				if (i.getId() == edge.getDestinationPlanetId()) {
					sortArr[count] = edge.getLength(); //length at index i
					count++;
					neighbors.put((IVisiblePlanet) planet, edge.getLength());
					if (((IVisiblePlanet) planet).getOwner() == Owner.OPPONENT) { //if planet belongs to opponent
						neighbor = true;
					}
				}
			}
		}
		count = 0;
		Arrays.sort(sortArr);
		while (count < edges.size()) { //add to queue in increasing distance
			for (IVisiblePlanet neighbor : neighbors.keySet()) {
				if (neighbors.get(neighbor) == sortArr[count]) {
					count++;
					distQueue.add(neighbor);
				}
			}
		}
		return distQueue;
	}

	public List<IVisiblePlanet> getEnemies(IPlanet planet, List<IPlanet> planets) {
		List<IVisiblePlanet> enemies = new ArrayList<>();
		Set<IEdge> edges = planet.getEdges();
		for (IEdge edge : edges) {
			for (IPlanet i : planets) {
				if (i.getId() == edge.getDestinationPlanetId()) {
					if (((IVisiblePlanet) i).getOwner() == Owner.OPPONENT) {
						enemies.add((IVisiblePlanet) i);	
					}
				}
			}
		}
		return enemies;
	}


	@Override
	public String getName() {
		return "Nathan M.";
	}

	@Override
	public boolean compete() {
		return false;
	}
}
