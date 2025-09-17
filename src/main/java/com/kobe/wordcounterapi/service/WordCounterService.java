package com.kobe.wordcounterapi.service;

import com.kobe.wordcounterapi.model.WordCountResult;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * packageName    : com.kobe.wordcounterapi.service
 * fileName       : WordCounterService
 * author         : kobe
 * date           : 2025. 9. 18.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 9. 18.        kobe       최초 생성
 */
@Service
public class WordCounterService {

	public WordCountResult analyzeText(String text) {
		WordCountResult result = new WordCountResult();

		// 기본 통계 계산
		result.setTotalCharacters(text.length());
		result.setCharactersWithoutSpaces(text.replaceAll("\\s", "").length());
		result.setLineCount(text.split("\n").length);

		// 단어 분석
		String[] words = text.trim().split("\\s+");
		result.setWordCount(text.trim().isEmpty() ? 0 : words.length);

		// 단어 빈도 계산
		Map<String, Integer> wordFrequency = calculateWordFrequency(text);
		result.setWordFrequency(wordFrequency);

		// 가장 자주 사용된 단어
		result.setMostFrequentWord(findMostFrequentWord(wordFrequency));

		// 평균 단어 길이
		result.setAverageWordLength(calculateAverageWordLength(words));

		return result;
	}

	private Map<String, Integer> calculateWordFrequency(String text) {
		Map<String, Integer> frequency = new HashMap<>();

		String cleanText = text.toLowerCase()
			.replaceAll("[^a-zA-Z가-힣\\s]", "")
			.trim();

		if (cleanText.isEmpty()) {
			return frequency;
		}

		String[] words = cleanText.split("\\s+");

		for (String word : words) {
			if (!word.isEmpty()) {
				frequency.put(word, frequency.getOrDefault(word, 0) + 1);
			}
		}

		return frequency;
	}

	private String findMostFrequentWord(Map<String, Integer> wordFrequency) {
		return wordFrequency.entrySet().stream()
			.max(Map.Entry.comparingByValue())
			.map(Map.Entry::getKey)
			.orElse("");
	}

	private double calculateAverageWordLength(String[] words) {
		if (words.length == 0) {
			return 0.0;
		}

		int totalLength = 0;
		int validWords = 0;

		for (String word : words) {
			String cleanWord = word.replaceAll("[^a-zA-Z가-힣]", "");
			if (!cleanWord.isEmpty()) {
				totalLength += cleanWord.length();
				validWords++;
			}
		}

		return validWords > 0 ? (double) totalLength / validWords : 0.0;
	}
}
