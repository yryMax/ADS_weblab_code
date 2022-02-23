package Endterm.Assignment_1;
import java.util.*;
public class Solution {

    /**
     * Counts the number of occurrences of substring of length k in string s.
     *
     * @param s
     *     The String in which to look for substrings.
     * @param k
     *     The length of the substrings to look for.
     * @return Map with entries in the form of (sub, numOcc), where sub denotes a substring with numOcc occurrences in s.
     * Note: There should be no entries in the map for substrings that do not occur in string s.
     */
    public static Map<String, Integer> countSubstringOccurrences(String s, int k) {
        // TODO
        Map<String, Integer> cnt = new HashMap();
        int n = s.length();
        for(int i=0;i<=n-k;i++){
            String str = s.substring(i,i+k);
            if(cnt.containsKey(str)){
                int val = cnt.get(str);
                cnt.put(str,val+1);
            }
            else cnt.put(str,1);
        }
        return cnt;
    }

    /**
     * Counts the occurrences of substrings (of **all lengths**) in a given string s.
     * Should make use of the method countSubstringOccurrences(String s, int k).
     *
     * @param s
     *     The String in which to look for substrings.
     * @return Map with entries in the form of (sub, numOcc), where sub denotes a substring with numOcc occurrences in s.
     * Note 1: There should be no entries in the map for substrings that do not occur in string s.
     * Note 2: When iterating through the returned map, the substrings should be found in increasing order of their length.
     */
    public static Map<String, Integer> countSubstringOccurrences(String s) {
        // TODO
        Map<String, Integer> cnt = new LinkedHashMap();
        int n = s.length();
        for(int len = 1;len<=n;len++){
            Map<String, Integer>tmp = countSubstringOccurrences(s,len);
            for(String el:tmp.keySet())cnt.put(el,tmp.get(el));
        }
        return cnt;
    }

    /**
     * Simplifies a given map of substrings and their occurrences by removing substrings that do not repeat.
     * Must be implemented in-place.
     *
     * @param substringsMap
     *     The map from which substrings that do not repeat (occur only once) are to be removed.
     */
    public static void repeatedSubstrings(Map<String, Integer> substringsMap) {
        /*
        Iterator<Map.Entry<String, Integer>> ss = substringsMap.entrySet().iterator();
        while (ss.hasNext()){
            //  System.out.println(el);
            //   System.out.println(substringsMap.get(el));
            String el = ss.next().getKey();
            if(substringsMap.get(el) == 1)substringsMap.remove(el);
        }
         */
        substringsMap.keySet().removeIf(key -> substringsMap.get(key) == 1);
    }
}