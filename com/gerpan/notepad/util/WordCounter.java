package com.gerpan.notepad.util;

public class WordCounter {

    private String textData;

    public WordCounter(String s) {
        this.textData = s;
    }

    private boolean isWhiteSpace(char c) {
        return c == ' ' || c == '\t' || c == '\n';
    }

    private boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isEndSentence(char c) {
        return c == '.' || c == '?' || c == '!';
    }

    public int getCharCount() {
        return (int) textData.length();
    }

    public int getWordCount() {
        int count = 0;
        for (int i = 0; i < textData.length() - 1; i++) {
            if (isWhiteSpace(textData.charAt(i)) && (isAlpha(textData.charAt(i + 1)) || isDigit(textData.charAt(i + 1)))) {
                count++;
            }
        }
        if (count == 0) {
            return 0;
        }
        return count + 1;
    }

    public int getSenCount() {
        int count = 0;
        for (int i = 0; i < textData.length() - 1; i++) {
            if (isEndSentence(textData.charAt(i)) && !isEndSentence(textData.charAt(i + 1))) {
                count++;
            }
        }
        if (count == 0) {
            return 0;
        }
        return count + 1;
    }
}
