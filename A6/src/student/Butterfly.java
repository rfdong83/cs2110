/** TIME SPENT: 11 hours and # minutes. */ 

package student;
import java.util.ArrayList;
import java.util.List;

import danaus.*;

public class Butterfly extends AbstractButterfly {
	
public TileState[][] places; 
public ArrayList<Direction> direct = new ArrayList<Direction>();

	public @Override TileState[][] learn() {
		
		places = new TileState[getMapHeight()][getMapWidth()];
		dfs();
		return places;
	}
	
	public void dfs() {
		
		refreshState();
		places[state.location.row][state.location.col] = state;
		for (Direction dir: Common.DIRECTIONS) {
			try {
				if (next(state, dir) == null) {
					fly(dir, Speed.NORMAL);
					direct.add(dir);
					refreshState();
					dfs();
				}
			}
			catch (CliffCollisionException | WaterCollisionException w) {
				places[Common.mod(state.location.row + dir.dRow, getMapHeight())]
						[Common.mod(state.location.col + dir.dCol, getMapWidth())]
								= TileState.nil;
			}
		}
		if (direct.size() != 0) {
			fly(Direction.opposite(direct.get(direct.size()-1)), Speed.NORMAL);
			direct.remove(direct.size()-1);
			refreshState();
		}
	}
	
	public TileState next(TileState current, Direction thisway) {
		return places[Common.mod(state.location.row + thisway.dRow, getMapHeight())]
				[Common.mod(state.location.col + thisway.dCol, getMapWidth())];
	}
	
	public @Override void run(List<Long> flowerIds) {
		System.out.println("Start");
		while (flowerIds.size() > 0) {
			System.out.println("List is now" + flowerIds.toString());
			Aroma targetAroma = setup(flowerIds);
			capture(targetAroma,flowerIds);
		}
	}
	
	public Aroma setup(List<Long> L) {
		ArrayList<Aroma> wantedAromas = new ArrayList<Aroma>();
	    for (Aroma aroma: state.getAromas()) {
        	if (L.contains(aroma.getFlowerId())) {
        		wantedAromas.add(aroma);
        	}
        }
	    System.out.println(wantedAromas.toString());
        Aroma closest = wantedAromas.get(0);
        for (Aroma aroma: state.getAromas()) {
        	if (wantedAromas.contains(aroma) && aroma.intensity > closest.intensity) {
        		closest = aroma;
        	}
        }
        System.out.println(closest);
        return closest;
	}
	
	public void capture(Aroma target, List<Long> L) {
		Direction progress = null;
		for (Direction dir: Common.DIRECTIONS) {
			System.out.println(next(state,dir).getAromas().toString());
			for (Aroma point: next(state,dir).getAromas()) {
				if (point.getFlowerId() == target.getFlowerId() && 
						target.compareTo(point) == -1) {
					progress = dir;
					target = point;
				}
			}
		}
		System.out.println(target.toString());
		System.out.println(progress);
		if (progress == null) {
			for (Flower flower: state.getFlowers()) {
				if (flower.getFlowerId() == target.getFlowerId()) {
					collect(flower);
					L.remove(target.getFlowerId());
					System.out.println(L.toString());
				}
			}
			System.out.println("I'm here");
		}
		else {
			fly(progress, Speed.NORMAL);
			refreshState();
			System.out.println("Restarting capture");
			System.out.println("I'm at " + state.location.toString());
			capture(target, L);
		}
		//System.out.println("Got'em");
	}
}