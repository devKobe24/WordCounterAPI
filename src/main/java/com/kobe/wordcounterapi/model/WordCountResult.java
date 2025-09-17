package com.kobe.wordcounterapi.model;

import java.util.Map;

/**
 * packageName    : com.kobe.wordcounterapi.result
 * fileName       : WordCountResult
 * author         : kobe
 * date           : 2025. 9. 18.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 9. 18.        kobe       최초 생성
 */
public class WordCountResult {
	private int totalCharacters;
	private int charactersWithoutSpaces;
	private int wordCount;
	private int lineCount;
	private Map<String, Integer> wordFrequency;
	private String mostFrequentWord;
	private double averageWordLength;

	// Constructor
	public WordCountResult() {}

	// Getters and Setters
	public int getTotalCharacters() {
		return totalCharacters;
	}

	public void setTotalCharacters(int totalCharacters) {
		this.totalCharacters = totalCharacters;
	}

	public int getCharactersWithoutSpaces() {
		return charactersWithoutSpaces;
	}

	public void setCharactersWithoutSpaces(int charactersWithoutSpaces) {
		this.charactersWithoutSpaces = charactersWithoutSpaces;
	}

	public int getWordCount() {
		return wordCount;
	}

	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}

	public int getLineCount() {
		return lineCount;
	}

	public void setLineCount(int lineCount) {
		this.lineCount = lineCount;
	}

	public Map<String, Integer> getWordFrequency() {
		return wordFrequency;
	}

	public void setWordFrequency(Map<String, Integer> wordFrequency) {
		this.wordFrequency = wordFrequency;
	}

	public String getMostFrequentWord() {
		return mostFrequentWord;
	}

	public void setMostFrequentWord(String mostFrequentWord) {
		this.mostFrequentWord = mostFrequentWord;
	}

	public double getAverageWordLength() {
		return averageWordLength;
	}

	public void setAverageWordLength(double averageWordLength) {
		this.averageWordLength = averageWordLength;
	}
}
