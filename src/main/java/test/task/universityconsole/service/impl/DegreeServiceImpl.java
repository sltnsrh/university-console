package test.task.universityconsole.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import test.task.universityconsole.model.Degree;
import test.task.universityconsole.repository.DegreeRepository;
import test.task.universityconsole.service.DegreeService;

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

    @Override
    public Degree getByName(String name) {
        return degreeRepository
                .getDegreeByDegreeName(Degree.DegreeName.valueOf(name.toUpperCase()));
    }

    @Override
    public List<Degree> getAll() {
        return degreeRepository.getAll();
    }
}
