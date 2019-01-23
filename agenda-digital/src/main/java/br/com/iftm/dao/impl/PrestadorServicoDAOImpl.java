package br.com.iftm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.iftm.dao.PrestadorServicoDAO;
import br.com.iftm.entity.PrestadorServico;

@Repository
public class PrestadorServicoDAOImpl implements PrestadorServicoDAO {
	private int indice = 1;
	private List<PrestadorServico> lista = new ArrayList<>();

	@Override
	public PrestadorServico create(PrestadorServico preSer) {
		preSer.setCodigo(indice++);
		lista.add(preSer);

		return preSer;
	}

	@Override
	public List<PrestadorServico> read() {
		return lista;
	}

	@Override
	public PrestadorServico update(PrestadorServico preSer) {
		for (PrestadorServico preSer2 : lista) {
			if (preSer2.getCodigo().equals(preSer.getCodigo())) {
				preSer2.setBairro(preSer.getBairro());
				preSer2.setCep(preSer.getCep());
				preSer2.setCidade(preSer.getCidade());
				preSer2.setComplemento(preSer.getComplemento());
				preSer2.setEmail(preSer.getEmail());
				preSer2.setLogradouro(preSer.getLogradouro());
				preSer2.setNome(preSer.getNome());
				preSer2.setNumero(preSer.getNumero());
				preSer2.setTelefones(preSer.getTelefones());
				preSer2.setTipoLogradouro(preSer.getTipoLogradouro());
				preSer2.setTipoServicos(preSer.getTipoServicos());
			}
		}

		return preSer;
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
