import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// time complexity: O(N*N)
public class Anagram01 {

    private static ArrayList<ArrayList<String>> handleAnagrams(String[] arr){

        ArrayList<ArrayList<String>> res = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            char[] array = arr[i].toCharArray();
            Arrays.sort(array);

            String s = String.valueOf(array);
            if(!map.containsKey(s)){
                ArrayList<String> list = new ArrayList<>();
                list.add(arr[i]);
                map.put(s, list);
            }else{
                ArrayList<String> list = map.get(s);
                list.add(arr[i]);
                map.put(s, list);
            }
        }

        for (ArrayList<String> list: map.values()) {
            res.add(list);
        }
        return res;
    }
    public static void main(String[] args) {
        String[] arr = {"eat","tea","tan","ate","nat","bat"};
        ArrayList<ArrayList<String>> list = handleAnagrams(arr);
        System.out.println(list);
    }
}