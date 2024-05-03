package com.vazhnov.pattern.coreJava.palindrom;

class Solution {
    public boolean isPalindrome(int x) {
        String parseXtoString = Integer.toString(x);
        char[] parseXtoChar = parseXtoString.toCharArray();
        for (int i = 0; i < parseXtoChar.length ; i++) {
            if (parseXtoChar[i] != parseXtoChar[parseXtoChar.length-i-1] )
                return false;
        }
        return true;
    }
}