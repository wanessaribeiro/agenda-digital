package br.com.iftm.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.PrestadorServicoBusiness;
import br.com.iftm.dao.PrestadorServicoDAO;
import br.com.iftm.entity.PrestadorServico;
import br.com.iftm.entity.Telefone;

@Service
public class PrestadorServicoBusinessImpl implements PrestadorServicoBusiness {

	@Autowired
	private PrestadorServicoDAO dao;

	@Override
	public PrestadorServico create(PrestadorServico preSer) throws BusinessException {
		// complemento, numero, bairro e email.
		if (StringUtils.isEmpty(preSer.getNome())) {
			throw new BusinessException("Nome requerido.");
		}

		if (preSer.getCidade() == null) {
			throw new BusinessException("Cidade requerida.");
		}

		if (preSer.getCidade().getCodigo() == null) {
			throw new BusinessException("Cidade requerida.");
		}

		if (preSer.getTipoLogradouro() == null) {
			throw new BusinessException("Tipo de logradouro requerido.");
		}

		if (preSer.getLogradouro() == null) {
			throw new BusinessException("Logradouro requerido.");
		}

		if (preSer.getTelefones() == null) {
			throw new BusinessException("Minimo de 1 telefone.");
		}

		if (preSer.getTelefones().isEmpty()) {
			throw new BusinessException("Minimo de 1 telefone.");
		}

		for (Telefone t : preSer.getTelefones()) {
			if (t.getDdd() == null || t.getNumero() == null) {
				throw new BusinessException("Telefone invalido.");
			}
		}

		return dao.create(preSer);
	}

	@Override
	public List<PrestadorServico> read() throws BusinessException {
		return dao.read();
	}

	@Override
	public PrestadorServico update(PrestadorServico preSer) throws BusinessException {
		if (preSer.getCodigo() == null) {
			throw new BusinessException("Codigo requerido.");
		}

		if (StringUtils.isEmpty(preSer.getNome())) {
			throw new BusinessException("Nome requerido.");
		}

		if (preSer.getCidade() == null) {
			throw new BusinessException("Cidade requerida.");
		}

		if (preSer.getTipoLogradouro() == null) {
			throw new BusinessException("Tipo de logradouro requerido.");
		}

		if (preSer.getLogradouro() == null) {
			throw new BusinessException("Logradouro requerido.");
		}

		if (preSer.getTelefones() == null) {
			throw new BusinessException("Minimo de 1 telefone.");
		}

		if (preSer.getTelefones().isEmpty()) {
			throw new BusinessException("Minimo de 1 telefone.");
		}

		for (Telefone t : preSer.getTelefones()) {
			if (t.getDdd() == null || t.getNumero() == null) {
				throw new BusinessException("Telefone invalido.");
			}
		}

		return dao.update(preSer);
	}

	@Override
	public void delete(Integer id) throws BusinessException {
		if (id == null) {
			throw new BusinessException("Codigo requerido.");
		}

		dao.delete(id);
	}

}
