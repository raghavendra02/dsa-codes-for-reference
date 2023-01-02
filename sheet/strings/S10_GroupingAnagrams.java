import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * S10_GroupingAnagrams
 */
public class S10_GroupingAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>> bmap = new HashMap<>();
        for(String s:strs)
        {
            HashMap<Character, Integer> newMap = new HashMap<>();
            for(int i=0;i<s.length();i++)
            {
                newMap.put(s.charAt(i), newMap.getOrDefault(s.charAt(i), 0) + 1);
            }
            if(bmap.containsKey(newMap))
            {
                ArrayList<String> temp = bmap.get(newMap);
                temp.add(s);
            }
            else
            {
                ArrayList<String> newList = new ArrayList<>();
                newList.add(s);
                bmap.put(newMap, newList);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(ArrayList<String> val: bmap.values())
        {
            res.add(val);
        }
        return res;
    }
    public static void main(String[] args) {
        
    }
}