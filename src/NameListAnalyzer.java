import java.io.*;
import java.util.*;

/**
 * Go IntelliJ IDEA!
 * User: Austin
 * Date: 2/18/12
 * Time: 4:12 PM
 */
class NameListAnalyzer {
    private List<String> NameList;

    public void Load(String filePath) {
        NameList = new ArrayList<String>();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DataInputStream in = new DataInputStream(fileInputStream);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        try {
            while((line = reader.readLine()) != null)
            {
                String[] names = line.split(",+");
                for(String name: names)
                {
                    NameList.add(name.replaceAll("\"+", ""));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> GetNamesList() {
        return NameList;
    }

    public void Sort() {
        Collections.sort(NameList);
    }


    public int GetAlphabeticalValue(String name) {
        Dictionary<String, Integer> charValues = GetCharValues();
        int toReturn = 0;
        for(int i = 0; i < name.length(); i++)
        {
            toReturn += charValues.get(name.substring(i, i+1).toLowerCase());
        }
        
        return toReturn;
    }


    public int GetSumOfAlphabeticalValuesTimesAlphabeticalOrdering() {
        Sort();
        int toReturn = 0;
        for(int i = 0; i < NameList.size(); i++)
        {
            toReturn += GetAlphabeticalValue(NameList.get(i)) * (i + 1);
        }
        return toReturn;
    }

    private Dictionary<String, Integer> GetCharValues() {
        Dictionary<String, Integer> toReturn = new Hashtable<String, Integer>();
        toReturn.put("a", 1);
        toReturn.put("b", 2);
        toReturn.put("c", 3);
        toReturn.put("d", 4);
        toReturn.put("e", 5);
        toReturn.put("f", 6);
        toReturn.put("g", 7);
        toReturn.put("h", 8);
        toReturn.put("i", 9);
        toReturn.put("j", 10);
        toReturn.put("k", 11);
        toReturn.put("l", 12);
        toReturn.put("m", 13);
        toReturn.put("n", 14);
        toReturn.put("o", 15);
        toReturn.put("p", 16);
        toReturn.put("q", 17);
        toReturn.put("r", 18);
        toReturn.put("s", 19);
        toReturn.put("t", 20);
        toReturn.put("u", 21);
        toReturn.put("v", 22);
        toReturn.put("w", 23);
        toReturn.put("x", 24);
        toReturn.put("y", 25);
        toReturn.put("z", 26);
        return toReturn;
    }
}
