package me.lukasweb.quiz.components;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/quiz")
public class QuizController {
    private final QuizService quizService;
    @GetMapping
    public List<Question> getAllQuestions() {
        return quizService.getAllQuestions();
    }
    @PostMapping
    public Question addQuestion(@RequestBody Question question){
        return quizService.addNewQuestion(question);
    }
    @GetMapping("/{category}")
    public List<Question> getAllQuestionsByCategory(@PathVariable String category) {
        return quizService.getAllQuestionsByCategory(Category.valueOf(category.toUpperCase()));
    }
    @PutMapping()
    public Question changeQuestion(@RequestBody Question question) {
        return quizService.changeQuestion(question);
    }
    @DeleteMapping("/{id}")
    public void deleteQuestionById(@PathVariable String id) {
        quizService.deleteQuestionById(id);
    }
}
