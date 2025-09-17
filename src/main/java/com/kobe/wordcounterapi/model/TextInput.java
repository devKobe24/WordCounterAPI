package com.kobe.wordcounterapi.model;

/**
 * packageName    : com.kobe.wordcounterapi.textinput
 * fileName       : TextInput
 * author         : kobe
 * date           : 2025. 9. 18.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 9. 18.        kobe       최초 생성
 */
public class TextInput {
	private String text;

	public TextInput() {}

	public TextInput(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
