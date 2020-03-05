package locale.test.locale.controller;

import locale.test.locale.dto.LanguageDto;
import locale.test.locale.service.LanguageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/language")
public class LanguageController {

    private final LanguageService languageService;

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public void setChangeTo (@RequestBody String changeTo) {
        languageService.changeLanguage(changeTo);
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public LanguageDto getCurrentLocale() {
        return languageService.getCurrentLanguage();
    }
}
