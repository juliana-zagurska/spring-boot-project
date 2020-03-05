package locale.test.locale.repository;

import locale.test.locale.entity.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<LanguageEntity, Long> {
    LanguageEntity findByIsActiveIsTrue();
    LanguageEntity findByName(String name);
}
