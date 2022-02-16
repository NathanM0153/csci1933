public class HeatGrid {
    int[][] testarray;
    int height;
    int width;

    private int decayHeat(double decay, int heat, int distance) {
        // Hint: The distance is the number of squares between a coordinate and a source
        return (int) (heat * Math.exp(-1 * decay * distance));
    }
    public HeatGrid(int height, int width) {
        testarray = new int[height][width]; // sets dimensions of array
        this.height = height;
        this.width = width;
    }
    public boolean placeSource(String src, int x, int y) {
        if (this.height < x) {
            return false; //x value is not in range of the grid
        } if (this.width < y) {
            return false; //y value is not in range
        } else {
            if (src.equals("l")) { // lightbulb, assign 1 heat unit
                src = "1";
            } else if (src.equals("c")) { // campfire, assign 4 heat units
                src = "4";
            } else if (src.equals("f")) { // furnace
                src = "10";
            } else if (src.equals("i")) { // ice cube, assign -2 heat units
                src = "-2";
            } else if (src.equals("r")) { // refrigerator
                src = "-8";
            } else if (src.equals("g")) { // glacier
                src = "-20";
            }
            int temp = Integer.valueOf(src); // can't add string to a list of ints because java is stupid
            testarray[x][y] = temp;
            return true;
        }
    }
    public String toString() {
        String stringarray = "";
        for (int i = 0; i < testarray.length; i++) { // sets array to grid of strings
            for (int j = 0; j < testarray[i].length; j++) {
                stringarray += testarray[i][j] + " ";
            }
            stringarray += "\n";
        }
        return stringarray;
    }
//    public int[][] getHeats() {
//
//    }
//    public int getHeat(int x, int y) {
//
//    }
//    public int getNetHeat() { // https://baeldung.com/java-array-sum-average
//
//    }
    public static void main(String[] args) {
        HeatGrid test = new HeatGrid(8,8); // sets grid of 0's
        test.placeSource("g",4,5); // sets glacier heat origin location to (4,5);
        // placeSource source = new placeSource("g",4,5); is incorrect
        // cannot treat a method (action) as a class (noun)
        System.out.println(test.toString());
    }
}
