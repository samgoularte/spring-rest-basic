package br.com.localhost.service;

import br.com.localhost.domain.Curso;
import java.util.Date;
import java.util.List;

public interface CursoService {

    void save(Curso curso);

    void update(Long id, Curso curso);

    void delete(Long id);

    Curso findById(Long id);

    List<Curso> findAll();

    Curso updateDataInicial(Long id, Date dataInicio);
}
