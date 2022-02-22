public class HeatGrid {
    int[][] testarray;
    int height;
    int width;
    double decay;
    int range;

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
                range = 0;
                decay = 0;
            } else if (src.equals("c")) { // campfire, assign 4 heat units
                src = "4";
                range = 2;
                decay = 0.5;
            } else if (src.equals("f")) { // furnace
                src = "10";
                range = 4;
                decay = 0.35;
            } else if (src.equals("i")) { // ice cube, assign -2 heat units
                src = "-2";
                range = 1;
                decay = 0.5;
            } else if (src.equals("r")) { // refrigerator
                src = "-8";
                range = 3;
                decay = 0.2;
            } else if (src.equals("g")) { // glacier
                src = "-20";
                range = 5;
                decay =- 0.15;
            }

            int temp = Integer.valueOf(src); // can't add string to a list of ints because java is stupid
            for (int i = 0; i < testarray.length; i++) { // sets array to grid of strings
                for (int j = 0; j < testarray[i].length; j++) {
                    int distance = Math.max(Math.abs(x-i),Math.abs(y-j));
                    testarray[i][j] = decayHeat(decay, temp, distance);
                }
            }
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
    public int[][] getHeats() {
        return testarray;
    }
    public int getHeat(int x, int y) {
        if (this.height < x) {
            return Integer.MAX_VALUE; }
        if (this.width < y) {
            return Integer.MAX_VALUE; }

        return testarray[x][y];
    }
    public int getNetHeat() {
        int sum = 0;
        for (int i = 0; i < testarray.length; i++) {
            for (int j = 0; j < testarray[i].length; j++) {
                sum += testarray[i][j];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        HeatGrid test = new HeatGrid(8,8); // sets grid of 0's
        test.placeSource("c",4,5); // sets heat origin location to (4,5);
        // placeSource source = new placeSource("g",4,5); is incorrect
        // cannot treat a method (action) as a class (noun)
        // test.placeSource("i", 2,2);
        // overwrites old source? ask for help
        System.out.println(test.toString());
        System.out.println(test.getNetHeat());
    }
}
