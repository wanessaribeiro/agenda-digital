package br.com.iftm.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.CidadeBusiness;
import br.com.iftm.dao.CidadeDAO;
import br.com.iftm.entity.Cidade;
import br.com.iftm.enums.Estado;

@Service
public class CidadeBusinessImpl implements CidadeBusiness {
	@Autowired
	private CidadeDAO dao;

	@Override
	public Cidade create(Cidade cidade) throws BusinessException {
		if (StringUtils.isEmpty(cidade.getNome())) {
			throw new BusinessException("Nome requerido.");
		}

		if (cidade.getEstado() == null) {
			throw new BusinessException("Estado requerido.");
		}

		return dao.create(cidade);
	}

	@Override
	public List<Cidade> read() throws BusinessException {
		return dao.read();
	}

	@Override
	public List<Cidade> readByState(Estado estado) throws BusinessException {
		if (estado == null) {
			throw new BusinessException("Busca vazia.");
		}

		return dao.readByState(estado);
	}

	@Override
	public Cidade update(Cidade cidade) throws BusinessException {
		if (cidade.getCodigo() == null) {
			throw new BusinessException("Codigo requerido");
		}

		if (StringUtils.isEmpty(cidade.getNome())) {
			throw new BusinessException("Nome requerido.");
		}

		if (cidade.getEstado() == null) {
			throw new BusinessException("Estado requerido.");
		}

		return dao.update(cidade);

	}

	@Override
	public void delete(Integer id) throws BusinessException {
		if (id == null) {
			throw new BusinessException("Codigo requerido.");
		}

		dao.delete(id);
	}

}
