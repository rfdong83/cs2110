/** TIME SPENT: 5 hours and # minutes. */ 

package student;
import java.util.ArrayList;
import java.util.List;

import danaus.*;

public class Butterfly extends AbstractButterfly {
	
public TileState[][] places; 
public ArrayList<Direction> direct = new ArrayList<Direction>();
public ArrayList<Aroma> wanted = new ArrayList<Aroma>();

	public @Override TileState[][] learn() {
		
		places = new TileState[getMapHeight()][getMapWidth()];
		dfs();
		System.out.println("H");
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
		System.out.println("I");
		Aroma want = setup(flowerIds);
		while (wanted.size() > 0) {
			capture(want);
		}
	}
	
	public Aroma setup(List<Long> L) {
	    for (Aroma aroma: state.getAromas()) {
        	if (L.contains(aroma.getFlowerId())) {
        		wanted.add(aroma);
        	}
        }
	    System.out.println(wanted);
        Aroma closest = wanted.get(0);
        for (Aroma aroma: state.getAromas()) {
        	if (wanted.contains(aroma) && aroma.intensity > closest.intensity) {
        		closest = aroma;
        	}
        }
        return closest;
	}
	
	public void capture(Aroma scent) {
		Direction progress = null;
		for (Direction dir: Common.DIRECTIONS) {
			int pos = next(state,dir).getAromas().indexOf(scent);
			double nextScent = next(state,dir).getAromas().get(pos).intensity;
			if (nextScent > scent.intensity) {
				progress = dir;
			}
		}
		if (progress == null) {
			for (Flower flower: state.getFlowers()) {
				if (flower.getFlowerId() == scent.getFlowerId()) {
					collect(flower);
					wanted.remove(scent);
				}
			}	
		}
		else {
			fly(progress, Speed.NORMAL);
			refreshState();
			capture(scent);
		}
	}
}