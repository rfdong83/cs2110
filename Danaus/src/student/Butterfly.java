/** TIME SPENT: 3 hours and 30 minutes. */ 

package student;
import java.util.List;

import danaus.*;

public class Butterfly extends AbstractButterfly {
	/**
	 * Return: An array containing all the TileStates of the Tiles traversed 
	 * by a Butterfly after boustrophedonically searching the map. 
	 */
	public @Override TileState[][] learn() {
		TileState[][] grid;
		//Creates array to store TileStates
		grid = new TileState[getMapHeight()][getMapWidth()];
		//Sets starting direction of Butterfly
		Direction thisway = danaus.Direction.E; 
		
		//Loop for ideal map with no obstacles at all
		for (int x=1; x<getMapWidth()*getMapHeight(); x++){ 
			//Refresh state and store location
			refreshState();
			grid[state.location.row][state.location.col] = state;
			
			//Turn butterfly around if it hits Eastern boundary
			if (state.location.col == 0 && x!=1 &&
					state.location.row != getMapHeight()-1){
				fly(danaus.Direction.S, danaus.Speed.NORMAL);
				thisway = danaus.Direction.E;
				refreshState();
				grid[state.location.row][state.location.col] = state;
			}

			//Turn butterfly around if it hits Western boundary
			else if (state.location.col == getMapWidth()-1 &&
					state.location.row != getMapHeight()-1){
				fly(danaus.Direction.S, danaus.Speed.NORMAL);
				thisway = danaus.Direction.W;
				refreshState();
				grid[state.location.row][state.location.col] = state;
			}

			//Catching exception if Butterfly hits a cliff
			try{
				fly(thisway, danaus.Speed.NORMAL);
				refreshState();
				grid[state.location.row][state.location.col] = state;
			}
			catch (danaus.CliffCollisionException e) {
				//Stops loop if Butterfly hits a cliff on the last row
				if (state.location.row == getMapHeight()-1){
					x = getMapHeight()*getMapWidth();
				}
				else if (thisway == danaus.Direction.E) {
					thisway = danaus.Direction.W;
					fly(danaus.Direction.S, danaus.Speed.NORMAL);
					refreshState();
					grid[state.location.row][state.location.col] = state;
				}
				else if (thisway == danaus.Direction.W) {
					thisway = danaus.Direction.E;
					fly(danaus.Direction.S, danaus.Speed.NORMAL);
					refreshState();
					grid[state.location.row][state.location.col] = state;
				}
			}

			//Stop loop if butterfly is on last row going East on last box
			if (state.location.row == getMapHeight()-1 && 
					state.location.col == getMapWidth()-1
					&& thisway == danaus.Direction.E){
				x = getMapHeight()*getMapWidth();
			}

			//Stop loops if butterfly if on last row going West on last box
			if (state.location.row == getMapHeight()-1 && 
					state.location.col == 0 && thisway == danaus.Direction.W){
				x = getMapHeight()*getMapWidth();
			}
		}
		return grid;
	}

	public @Override void run(List<Long> flowerIds) {
		// DO NOT IMPLEMENT FOR A3
	}

	public @Override List<Flower> flowerList() {
		// DO NOT IMPLEMENT FOR A3
		return null;
	}

	public @Override Location flowerLocation(Flower f) {
		// DO NOT IMPLEMENT FOR A3
		return null;
	}

	public @Override Location flowerLocation(long flowerId) {
		// DO NOT IMPLEMENT FOR A3
		return null;
	}
}