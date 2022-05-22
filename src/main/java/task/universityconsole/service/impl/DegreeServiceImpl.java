package task.universityconsole.service.impl;

import org.springframework.stereotype.Service;
import task.universityconsole.model.Degree;
import task.universityconsole.repository.DegreeRepository;
import task.universityconsole.service.DegreeService;

@Service
public class DegreeServiceImpl implements DegreeService {
    private final DegreeRepository degreeRepository;

    public DegreeServiceImpl(DegreeRepository degreeRepository) {
        this.degreeRepository = degreeRepository;
    }

    @Override
    public Degree add(Degree degree) {
        return degreeRepository.save(degree);
    }
}
