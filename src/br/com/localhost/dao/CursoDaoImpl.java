package br.com.localhost.dao;

import br.com.localhost.domain.Curso;
import br.com.localhost.exception.NaoExisteDaoException;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CursoDaoImpl implements CursoDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Curso curso) {
		entityManager.persist(curso);
	}

	@Override
	public void update(Curso curso) {
		entityManager.merge(curso);
	}

	@Override
	public void delete(Long id) {
		try {
			entityManager.remove(entityManager.getReference(Curso.class, id));
		} catch (EntityNotFoundException ex) {
			throw new NaoExisteDaoException("Curso não encontrado para o id = " + id);
		}
	}

	@Override
	public Curso findById(Long id) {
		Curso curso = entityManager.find(Curso.class, id);
		if (curso == null) {
			throw new NaoExisteDaoException("Curso não encontrado para o id = " + id);
		}
		return curso;
	}

	@Override
	public List<Curso> findAll() {
		return entityManager.createNamedQuery("Curso.findAll", Curso.class).getResultList();
	}
}
