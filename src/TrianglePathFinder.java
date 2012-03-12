import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/12/12
 * Time: 11:03 AM
 */
class TrianglePathFinder {
    private List<List<Integer>> Triangle;

    public void Load(String filePath) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DataInputStream in = new DataInputStream(fileInputStream);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        Triangle = new ArrayList<List<Integer>>();
        try {
            while ((line = reader.readLine()) != null) {
                List<Integer> width = new ArrayList<Integer>();
                String[] values = line.split("\\s+");
                for (String value : values) {
                    width.add(Integer.parseInt(value));
                }
                Triangle.add(width);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<List<Integer>> GetTriangle() {
        return Triangle;
    }

    public int GetGreatestSumTopToBottom() {
        //Start with second to last row
        //Take greater value between (row,column + row + 1, column) and (row, column + row + 1, column + 1)
        //Move up and do again

        for (int rowIndex = Triangle.size() - 2; rowIndex >= 0; rowIndex--) {
            for (int colIndex = 0; colIndex < Triangle.get(rowIndex).size(); colIndex++) {
                int leftSum = Triangle.get(rowIndex).get(colIndex) + Triangle.get(rowIndex + 1).get(colIndex);
                int rightSum = Triangle.get(rowIndex).get(colIndex) + Triangle.get(rowIndex + 1).get(colIndex + 1);
                if (leftSum < rightSum)
                    Triangle.get(rowIndex).set(colIndex, rightSum);
                else
                    Triangle.get(rowIndex).set(colIndex, leftSum);
            }
        }
        return Triangle.get(0).get(0);
    }
}
