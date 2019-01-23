package br.com.iftm.business;

import java.util.List;

import br.com.iftm.entity.PrestadorServico;

public interface PrestadorServicoBusiness {

	PrestadorServico create(PrestadorServico preSer) throws BusinessException;

	List<PrestadorServico> read() throws BusinessException;

	PrestadorServico update(PrestadorServico preSer) throws BusinessException;

	void delete(Integer id) throws BusinessException;
}
