package com.kobe.wordcounterapi.controller;

import com.kobe.wordcounterapi.model.WordCountResult;
import com.kobe.wordcounterapi.service.WordCounterService;
import com.kobe.wordcounterapi.model.TextInput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * packageName    : com.kobe.wordcounterapi.controller
 * fileName       : WordCounterController
 * author         : kobe
 * date           : 2025. 9. 18.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025. 9. 18.        kobe       최초 생성
 */
@RestController
@RequestMapping("/api/word-counter")
@CrossOrigin(origins = "*")
public class WordCounterController {

	private final WordCounterService wordCounterService;

	public WordCounterController(WordCounterService wordCounterService) {
		this.wordCounterService = wordCounterService;
	}

	@PostMapping("/analyze")
	public ResponseEntity<WordCountResult> analyzeText(@RequestBody TextInput textInput) {
		try {
			if (textInput.getText() == null || textInput.getText().trim().isEmpty()) {
				return ResponseEntity.badRequest().build();
			}

			WordCountResult result = wordCounterService.analyzeText(textInput.getText());
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/health")
	public ResponseEntity<String> healthCheck() {
		return ResponseEntity.ok("Word Counter API is running");
	}
}
