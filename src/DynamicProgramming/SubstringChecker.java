package DynamicProgramming;

    import java.util.*;

    public class SubstringChecker {

        public String checkSubString(String mainString, String searchString) {
            if (mainString == null || mainString.isEmpty() ||
                    searchString == null || searchString.isEmpty()) {
                return "";
            }

            // Frequency map for characters in searchString
            Map<Character, Integer> freqMap = new HashMap<>();
            for (char c : searchString.toCharArray()) {
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            }

            int left = 0;
            int minLen = Integer.MAX_VALUE;
            int minStart = 0;
            int required = searchString.length();

            for (int right = 0; right < mainString.length(); right++) {
                char rightChar = mainString.charAt(right);

                if (freqMap.containsKey(rightChar)) {
                    freqMap.put(rightChar, freqMap.get(rightChar) - 1);
                    if (freqMap.get(rightChar) >= 0) {
                        required--; // matched a needed character
                    }
                }

                // Try to shrink window when all characters are matched
                while (required == 0) {
                    if (right - left + 1 < minLen) {
                        minLen = right - left + 1;
                        minStart = left;
                    }

                    char leftChar = mainString.charAt(left);
                    if (freqMap.containsKey(leftChar)) {
                        freqMap.put(leftChar, freqMap.get(leftChar) + 1);
                        if (freqMap.get(leftChar) > 0) {
                            required++; // need this char again
                        }
                    }
                    left++;
                }
            }

            String result = (minLen == Integer.MAX_VALUE)
                    ? ""
                    : mainString.substring(minStart, minStart + minLen);

            if (!result.isEmpty()) {
                System.out.println("Smallest substring containing search string: " + result);
                System.out.println("Length: " + result.length());
            } else {
                System.out.println("No valid substring found");
            }

            return result;
        }

        public static void main(String[] args) {
            SubstringChecker obj = new SubstringChecker();

            System.out.println("Result: " + obj.checkSubString("ADOBECODEBANC", "ABC")); // "BANC"
            System.out.println("Result: " + obj.checkSubString("a", "a"));               // "a"
            System.out.println("Result: " + obj.checkSubString("appleacting", "aa"));              // ""
        }
    }
