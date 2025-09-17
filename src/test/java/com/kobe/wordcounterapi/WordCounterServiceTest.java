package com.kobe.wordcounterapi;

import com.kobe.wordcounterapi.model.WordCountResult;
import com.kobe.wordcounterapi.service.WordCounterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * packageName    : com.kobe.wordcounterapi
 * fileName       : WordCounterServiceTest
 * author         : kobe
 * date           : 2025. 9. 18.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 9. 18.        kobe       최초 생성
 */
public class WordCounterServiceTest {

	private WordCounterService service;

	@BeforeEach
	void setUp() {
		service = new WordCounterService();
	}

	@Test
	@DisplayName("기본 텍스트 분석 테스트")
	void testBasicTextAnalysis() {
		// Given
		String text = "Hello World! This is a test.";

		// When
		WordCountResult result = service.analyzeText(text);

		// Then
		assertEquals(28, result.getTotalCharacters());
		assertEquals(23, result.getCharactersWithoutSpaces());
		assertEquals(6, result.getWordCount());
		assertEquals(1, result.getLineCount());
	}

	@Test
	@DisplayName("빈 텍스트 처리 테스트")
	void testEmptyText() {
		// Given
		String text = "";

		// When
		WordCountResult result = service.analyzeText(text);

		// Then
		assertEquals(0, result.getTotalCharacters());
		assertEquals(0, result.getCharactersWithoutSpaces());
		assertEquals(0, result.getWordCount());
		assertEquals(1, result.getLineCount());
	}

	@Test
	@DisplayName("공백만 있는 텍스트 처리 테스트")
	void testWhitespaceOnlyText() {
		// Given
		String text = "   \n\t  ";

		// When
		WordCountResult result = service.analyzeText(text);

		// Then
		assertEquals(7, result.getTotalCharacters());
		assertEquals(0, result.getCharactersWithoutSpaces());
		assertEquals(0, result.getWordCount());
	}

	@Test
	@DisplayName("다중 라인 텍스트 처리 테스트")
	void testMultilineText() {
		// Given
		String text = "Line 1\nLine 2\nLine 3";

		// When
		WordCountResult result = service.analyzeText(text);

		// then
		assertEquals(6, result.getWordCount());
		assertEquals(3, result.getLineCount());
	}

	@Test
	@DisplayName("한글 텍스트 처리 테스트")
	void testKoreanText() {
		// Given
		String text = "안녕하세요 월드! 이것은 테스트입니다.";

		// When
		WordCountResult result = service.analyzeText(text);

		// Then
		assertEquals(4, result.getWordCount());
		assertTrue(result.getWordFrequency().containsKey("안녕하세요"));
		assertTrue(result.getWordFrequency().containsKey("월드"));
	}

	@Test
	@DisplayName("단어 빈도 계산 테스트")
	void testWordFrequency() {
		// Given
		String text = "apple banana apple orange apple";

		// When
		WordCountResult result = service.analyzeText(text);

		// Then
		assertEquals(3, result.getWordFrequency().get("apple"));
		assertEquals(1, result.getWordFrequency().get("banana"));
		assertEquals(1, result.getWordFrequency().get("orange"));
		assertEquals("apple", result.getMostFrequentWord());
	}
}
