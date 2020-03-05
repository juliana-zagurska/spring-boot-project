package locale.test.locale.service.impl;

import locale.test.locale.dto.LanguageDto;
import locale.test.locale.entity.LanguageEntity;
import locale.test.locale.repository.LanguageRepository;
import locale.test.locale.service.LanguageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;

    @Override
    public LanguageDto getCurrentLanguage() {
        return convertToDto(languageRepository.findByIsActiveIsTrue());
    }

    @Override
    @Transactional
    public void changeLanguage(String changeTo) {
        if (changeTo.equals("Russian")) {
            LanguageEntity languageEntity = languageRepository.findByName(changeTo);
            changeStatusToAnotherLanguage(processEntity(languageEntity), "English");
        }else {
            LanguageEntity languageEntity = languageRepository.findByName("English");
            changeStatusToAnotherLanguage(processEntity(languageEntity), "Russian");
        }
    }

    private LanguageDto convertToDto(LanguageEntity languageEntity) {
        return new LanguageDto(languageEntity.getCode(), languageEntity.getName());
    }

    private boolean processEntity(LanguageEntity languageEntity) {
        if (!languageEntity.isActive()) {
            languageEntity.setActive(true);
            languageRepository.save(languageEntity);
            return true;
        }
        return false;
    }

    private void changeStatusToAnotherLanguage(boolean needToChange, String language) {
        if (needToChange) {
            LanguageEntity byName = languageRepository.findByName(language);
            byName.setActive(false);
        }
    }
}
