package test.task.universityconsole.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import test.task.universityconsole.model.Lector;
import test.task.universityconsole.repository.LectorRepository;
import test.task.universityconsole.service.LectorService;

@Service
public class LectorServiceImpl implements LectorService {
    private final LectorRepository lectorRepository;

    public LectorServiceImpl(LectorRepository lectorRepository) {
        this.lectorRepository = lectorRepository;
    }

    @Override
    public Lector add(Lector lector) {
        return lectorRepository.save(lector);
    }

    @Override
    public Lector get(Long id) {
        return lectorRepository.getById(id);
    }

    @Override
    public List<String> findByTemplate(String template) {
        return lectorRepository.findByTemplate(template);
    }
}
