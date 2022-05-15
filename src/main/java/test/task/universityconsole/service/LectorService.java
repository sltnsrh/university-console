package test.task.universityconsole.service;

import java.util.List;
import test.task.universityconsole.model.Lector;

public interface LectorService {
    Lector add(Lector lector);

    Lector get(Long id);

    List<String> findByTemplate(String template);
}
