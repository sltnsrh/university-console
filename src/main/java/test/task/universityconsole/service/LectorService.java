package test.task.universityconsole.service;

import test.task.universityconsole.model.Lector;

public interface LectorService {
    Lector add(Lector lector);

    Lector get(Long id);
}
