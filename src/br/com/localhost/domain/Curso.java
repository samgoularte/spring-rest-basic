package br.com.localhost.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "cursos", indexes = {
		@Index(columnList = "titulo, data_inicio", unique = true, name = "unique_titulo_dataInicio") })
@NamedQueries({ @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c") })
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String titulo;

	@Column(name = "carga_horaria", nullable = false)
	@Enumerated(EnumType.STRING)
	private CargaHoraria cargaHoraria;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_inicio")
	private Date dataInicio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public CargaHoraria getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(CargaHoraria cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Curso curso = (Curso) o;

		return id != null ? id.equals(curso.id) : curso.id == null;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Curso{" + "id=" + id + ", titulo='" + titulo + '\'' + '}';
	}
}
