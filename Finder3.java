public class Finder3 {
	private static final int CELL_UNKNOWN = -2;
	private static final int CELL_EMPTY = 0;
	private final int[][] mountain;
	private final int[][] field;
	private final int size;
	private boolean madeChange;
	static int pathFinder(String map) {
		return new Finder3(map).findPathLength();
	}
	private Finder3(String maze) {
		mountain = parseMaze(maze);
		size = mountain.length;
		field = new int[size][size];
		for (int i = 0; i < size; i++) {
			field[i] = new int[size];
		}
	}
	private int findPathLength() {
		field[0][0] = 1;
		do {
			madeChange = false;
			for (int ii = 0; ii < size; ii++) {
				for (int jj = 0; jj < size; jj++) {
					int value = getValue(ii, jj);
					if (value > 0) {
						updateValue(ii, jj, 1, 0);
						updateValue(ii, jj, 0, 1);
						updateValue(ii, jj, -1, 0);
						updateValue(ii, jj, 0, -1);
					}
				}
			}
		} while (madeChange);
		if (field[size - 1][size - 1] > 0) {
			return field[size - 1][size - 1] - 1;   // this is our shortest path
		}
		return -1;
	}
	private int[][] parseMaze(String maze) {
		String[] rows = maze.split("\n");
		int size = rows.length;
		int[][] result = new int[size][size];
		for (int i = 0; i < rows.length; i++) {
			result[i] = rows[i].chars()
					.map(ch -> ch - 48)
					.toArray();
		}
		return result;
	}
	private void updateValue(int i, int j, int deltaI, int deltaJ) {
		int oldValue = getValue(i + deltaI, j + deltaJ);
		if (oldValue < 0) {
			return;
		}
		int prevAltitude = mountain[i][j];
		int currAltitude = mountain[i + deltaI][j + deltaJ];
		int newValue = getValue(i, j) + Math.abs(prevAltitude - currAltitude);
		if (oldValue == CELL_EMPTY || newValue < oldValue) {
			field[i + deltaI][j + deltaJ] = newValue;
			madeChange = true;
		}
		System.out.println("  ");
		for(int t=0;t<field.length;t++){
			for(int y=0;y<field.length;y++){
				System.out.print(field[t][y]+" ");
			}
			System.out.println();
		}
		System.out.println("  ");
		for(int t=0;t<mountain.length;t++){
			for(int y=0;y<mountain.length;y++){
				System.out.print(mountain[t][y]+" ");
			}
			System.out.println();
		}
	}
	private int getValue(int i, int j) {
		if (i >= 0 && j >= 0 && i < field.length && j < field.length) {
			return field[i][j];
		}
		return CELL_UNKNOWN;
	}
	
	public static void main(String[] args){

		String a = "747062171\n"+
				"904866986\n"+
				"340268947\n"+
				"974542098\n"+
				"574036106\n"+
				"567149757\n"+
				"726658263\n"+
				"848862682\n"+
				"755104617\n";
		System.out.println(pathFinder(a));

	}
}