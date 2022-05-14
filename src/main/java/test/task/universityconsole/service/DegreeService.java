package test.task.universityconsole.service;

import java.util.List;
import test.task.universityconsole.model.Degree;

public interface DegreeService {
    Degree add(Degree degree);

    Degree getByName(String name);

    List<Degree> getAll();
}
