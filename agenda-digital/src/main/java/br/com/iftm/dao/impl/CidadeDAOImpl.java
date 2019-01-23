package br.com.iftm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.iftm.dao.CidadeDAO;
import br.com.iftm.entity.Cidade;
import br.com.iftm.enums.Estado;

@Repository
public class CidadeDAOImpl implements CidadeDAO {
	private int indice = 1;
	private List<Cidade> lista = new ArrayList<>();

	@Override
	public Cidade create(Cidade cidade) {
		cidade.setCodigo(indice++);
		lista.add(cidade);

		return cidade;
	}

	@Override
	public List<Cidade> read() {
		return lista;
	}

	@Override
	public List<Cidade> readByState(Estado estado) {
		List<Cidade> temp = new ArrayList<>();
		for (Cidade cidade : lista) {
			if (cidade.getEstado().equals(estado)) {
				temp.add(cidade);
			}
		}

		return temp;
	}

	@Override
	public Cidade update(Cidade cidade) {
		for (Cidade c : lista) {
			if (cidade.getCodigo().equals(c.getCodigo())) {
				c.setEstado(cidade.getEstado());
				c.setNome(cidade.getNome());
			}
		}

		return cidade;
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
