package br.com.iftm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.iftm.dao.TipoServicoDAO;
import br.com.iftm.entity.TipoServico;

@Repository
public class TipoServicoDAOImpl implements TipoServicoDAO {
	private int indice = 1;
	private List<TipoServico> lista = new ArrayList<TipoServico>();

	@Override
	public TipoServico create(TipoServico tipoServico) {
		tipoServico.setCodigo(indice++);
		lista.add(tipoServico);

		return tipoServico;
	}

	@Override
	public List<TipoServico> read() {
		return lista;
	}

	@Override
	public List<TipoServico> readByName(String nome) {
		List<TipoServico> temp = new ArrayList<>();
		for (TipoServico tipoServico : lista) {
			if (tipoServico.getNome().toLowerCase().contains(nome.toLowerCase())) {
				temp.add(tipoServico);
			}
		}

		return temp;
	}

	@Override
	public TipoServico update(TipoServico tipoServico) {
		for (TipoServico tipoServico2 : lista) {
			if (tipoServico2.getCodigo().equals(tipoServico.getCodigo())) {
				tipoServico2.setNome(tipoServico.getNome());
			}
		}

		return tipoServico;
	}

	@Override
	public void delete(Integer id) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getCodigo().equals(id)) {
				lista.remove(i);
				break;
			}
		}
	}

}
