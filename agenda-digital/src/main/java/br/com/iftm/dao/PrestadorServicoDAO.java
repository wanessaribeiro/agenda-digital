package br.com.iftm.dao;

import java.util.List;

import br.com.iftm.entity.PrestadorServico;

public interface PrestadorServicoDAO {

	PrestadorServico create(PrestadorServico preSer);

	List<PrestadorServico> read();

	PrestadorServico update(PrestadorServico preSer);

	void delete(Integer id);
}
