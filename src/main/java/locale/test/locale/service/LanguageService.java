package locale.test.locale.service;

import locale.test.locale.dto.LanguageDto;

public interface LanguageService {

    LanguageDto getCurrentLanguage();
    void changeLanguage(String changeTo);
}
