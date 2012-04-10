import java.io.*;
import java.util.ArrayList;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/7/12
 * Time: 10:13 PM
 */
class Gridizer {
    //Grid is a zero based matrix of values
    //In the case of a Gid of:
    // 08 02 22
    // 25 49 99
    // 81 49 31
    //Grid[0][0] is 8
    //Grid[0][1] is 2
    //Grid[1][0] is 25
    //Grid[1][1] is 49
    //Grid[2][2] is 31
    private ArrayList<ArrayList<Integer>> Grid = new ArrayList<ArrayList<Integer>>();

    public void InitializeGrid(String s) {
        if (s.compareTo("") == 0) return;

        Grid = new ArrayList<ArrayList<Integer>>(); // reset if Initialized more than once

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DataInputStream in = new DataInputStream(fileInputStream);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                String[] lineValues = line.split(" ");
                ArrayList<Integer> gridLine = new ArrayList<Integer>();
                for (String lineValue : lineValues) {
                    gridLine.add(Integer.parseInt(lineValue));
                }
                Grid.add(gridLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ArrayList<Integer>> GetGrid() {
        return Grid;
    }

    public int GetValueAt(int x, int y) throws IndexOutOfBoundsException {
        return Grid.get(x).get(y);
    }

    public int GetProductRight(int x, int y, int sequenceSize) {
        int toReturn = 1;
        try {
            for (int i = sequenceSize - 1; i >= 0; i--) {
                toReturn *= GetValueAt(x, y + i);
            }
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
        return toReturn;
    }

    public int GetProductDown(int x, int y, int sequenceSize) {
        int toReturn = 1;
        try {
            for (int i = sequenceSize - 1; i >= 0; i--) {
                toReturn *= GetValueAt(x + i, y);
            }

        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
        return toReturn;
    }

    public int GetProductDownAndRight(int x, int y, int sequenceSize) {
        int toReturn = 1;

        try {
            for (int i = sequenceSize - 1; i >= 0; i--) {
                toReturn *= GetValueAt(x + i, y + i);
            }
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
        return toReturn;
    }

    public int GetProductDownAndLeft(int x, int y, int sequenceSize) {
        int toReturn = 1;

        try {
            for (int i = sequenceSize - 1; i >= 0; i--) {
                toReturn *= GetValueAt(x + i, y - i);
            }
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
        return toReturn;
    }


}
