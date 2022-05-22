package task.universityconsole.service;

import java.util.List;
import task.universityconsole.model.Lector;

public interface LectorService {
    Lector add(Lector lector);

    Lector get(Long id);

    List<String> findByTemplate(String template);
}
