package com.solution.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Prob17LetterCombinationPhoneNumber {
    private static final Map<Character, Character[]> digitLetterMap = new HashMap();

    private static void setupStaticMap() {
        digitLetterMap.put('2', new Character[] {'a', 'b', 'c'});
        digitLetterMap.put('3', new Character[] {'d', 'e', 'f'});
        digitLetterMap.put('4', new Character[] {'g', 'h', 'i'});
        digitLetterMap.put('5', new Character[] {'j', 'k', 'l'});
        digitLetterMap.put('6', new Character[] {'m', 'n', 'o'});
        digitLetterMap.put('7', new Character[] {'p', 'q', 'r', 's'});
        digitLetterMap.put('8', new Character[] {'t', 'u', 'v'});
        digitLetterMap.put('9', new Character[] {'w', 'x', 'y', 'z'});
    }

    public List<String> letterCombinations(String digits) {
        setupStaticMap();
        List<String> resultStrings = new ArrayList<>();
        for (char c : digits.toCharArray()) {
            Character[] charSet = digitLetterMap.get(c);
            if (charSet == null) {
                return new ArrayList<>();
            }
            // init case: single digit - make resultStrings be the answer
            if (resultStrings.size() == 0) {
                resultStrings = Arrays.stream(charSet).map(String::valueOf).collect(Collectors.toList());
                continue;
            }
            // starting
            resultStrings = resultStrings.stream()
                    .flatMap(str -> Arrays.stream(charSet).map(character -> str + character.toString()))
                    .collect(Collectors.toList());
       }
       return resultStrings;
    }
}
