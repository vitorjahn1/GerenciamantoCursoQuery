package com.query.query.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.query.query.dto.TurmaDto;
import com.query.query.exception.TurmaException;
import com.query.query.model.Turma;
import com.query.query.repository.TurmaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class TurmaService {

	private final TurmaRepository turmaRepository;

	public TurmaDto retornaTurma(Integer idTurma) {

		Turma turmaRetorno = turmaRepository.findByIdTurma(idTurma);

		if (turmaRetorno == null)
			throw new TurmaException("Turma não encontrada");

		return criarTurmaDto(turmaRetorno);
	}

	public List<TurmaDto> retornaTurma() {

		List<TurmaDto> turmasDto = new ArrayList<>();

		for (Turma turma : turmaRepository.findAll()) {

			if (turma == null) {
				continue;
			}

			turmasDto.add(criarTurmaDto(turma));
		}

		return turmasDto;
	}

	public TurmaDto criarTurmaDto(Turma turma) {

		TurmaDto turmaDto = new TurmaDto();

		turmaDto.setAlunos(turma.getAlunos());
		turmaDto.setAnoLetivo(turma.getAnoLetivo());
		turmaDto.setDescricao(turma.getDescricao());
		turmaDto.setNumeroVagas(turma.getNumeroVagas());
		turmaDto.setPeriodoLetivo(turma.getPeriodoLetivo());

		return turmaDto;

	}
}
