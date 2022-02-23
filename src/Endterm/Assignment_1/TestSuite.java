package Endterm.Assignment_1;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TestSuite {

        @Test
        void testCountSubstringOccurrences() {
            // Example 1: string s "mississippi", integer k is 4
            // substrings and occurrences in returned map: (miss, 1), (issi, 2), (ssis, 1), (siss, 1),
            // (ssip, 1), (sipp, 1), (ippi, 1)
            Map<String, Integer> missMap = Solution.countSubstringOccurrences("mississippi", 4);
            Map<String, Integer> missExpected = new HashMap<>();
            missExpected.put("miss", 1);
            missExpected.put("issi", 2);
            missExpected.put("ssis", 1);
            missExpected.put("siss", 1);
            missExpected.put("ssip", 1);
            missExpected.put("sipp", 1);
            missExpected.put("ippi", 1);
            assertEquals(missExpected, missMap);
        }

        @Test
        void testCountSubstringOccurrencesEmpty() {
            // Example: string s "ads", integer k is 4
            // substrings and occurrences in returned map: --
            Map<String, Integer> adsMap = Solution.countSubstringOccurrences("ads", 4);
            Map<String, Integer> adsExpected = new HashMap<>();
            assertEquals(adsExpected, adsMap);
        }

        @Test
        void testCountAllSubstringOccurrences() {
            // Example: string s "ads"
            // substrings and occurrences in returned map: (a, 1), (d, 1), (s, 1), (ad, 1), (ds, 1),
            // (ads, 1)
            Map<String, Integer> adsMap = Solution.countSubstringOccurrences("ads");
            Map<String, Integer> adsExpected = new HashMap<>();
            adsExpected.put("a", 1);
            adsExpected.put("d", 1);
            adsExpected.put("s", 1);
            adsExpected.put("ad", 1);
            adsExpected.put("ds", 1);
            adsExpected.put("ads", 1);
            assertEquals(adsExpected, adsMap);
            assertOrderSubstrings(adsMap);
            // Example: string s "ppppp"
            // substrings and occurrences in returned map: (p, 5), (pp, 4), (ppp, 3), (pppp, 2), (ppppp,
            // 1)
            Map<String, Integer> pMap = Solution.countSubstringOccurrences("ppppp");
            Map<String, Integer> pExpected = new HashMap<>();
            pExpected.put("p", 5);
            pExpected.put("pp", 4);
            pExpected.put("ppp", 3);
            pExpected.put("pppp", 2);
            pExpected.put("ppppp", 1);
            assertEquals(pExpected, pMap);
            assertOrderSubstrings(pMap);
        }

        @Test
        void testRepeatedSubstrings() {
            // Example 3: simplify map: (p, 5), (pp, 4), (ppp, 3), (pppp, 2), (ppppp, 1)
            // simplified map, after returning: (p, 5), (pp, 4), (ppp, 3), (pppp, 2)
            Map<String, Integer> pInput = new HashMap<>();
            pInput.put("p", 5);
            pInput.put("pp", 4);
            pInput.put("ppp", 3);
            pInput.put("pppp", 2);
            pInput.put("ppppp", 1);
            Solution.repeatedSubstrings(pInput);
            Map<String, Integer> pExpected = new HashMap<>();
            pExpected.put("p", 5);
            pExpected.put("pp", 4);
            pExpected.put("ppp", 3);
            pExpected.put("pppp", 2);
            assertEquals(pExpected, pInput);
        }

    @Test
    void testRepeatedSubstringsEmpty() {
        // Example 2: simplify map: (a, 1), (d, 1), (s, 1), (ad, 1), (ds, 1), (ads, 1)
        // simplified map, after returning: --- (empty)
        Map<String, Integer> adsInput = new HashMap<>();
        adsInput.put("a", 1);
        adsInput.put("d", 1);
        adsInput.put("s", 1);
        adsInput.put("ad", 1);
        adsInput.put("ds", 1);
        adsInput.put("ads", 1);
        Solution.repeatedSubstrings(adsInput);
        Map<String, Integer> adsExpected = new HashMap<>();
        assertEquals(adsExpected, adsInput);
    }

    void assertOrderSubstrings(Map<String, Integer> actual) {
        Iterator<String> actualIt = actual.keySet().iterator();
        int cur = 0;
        while (actualIt.hasNext()) {
            String sub = actualIt.next();
            assertTrue(cur <= sub.length(), "Map entries are not in the correct order");
            cur = sub.length();
        }
    }

}