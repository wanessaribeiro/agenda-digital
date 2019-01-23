package br.com.iftm.dao;

import java.util.List;

import br.com.iftm.entity.Cidade;
import br.com.iftm.enums.Estado;

public interface CidadeDAO {

	/**
	 * Metodo responsavel por persistir o objeto {@link Cidade} na base de dados.
	 * 
	 * @param cidade Objeto a ser persistido.
	 * @return Objeto persistido.
	 */
	Cidade create(Cidade cidade);

	/**
	 * Metodo responsavel por recuperar da base de dados todos os objetos.
	 * 
	 * @return Lista de {@link Cidade}
	 */
	List<Cidade> read();

	/**
	 * Metodo responsavel por recuperar da base de dados todos os objetos
	 * {@link Cidade} cujo nome possua parte do parametro Estado.
	 * 
	 * @param estado Estado a ser buscado
	 * @return Lista de {link Cidade}
	 * 
	 */
	List<Cidade> readByState(Estado estado);

	/**
	 * Metodo responsavel por persistir (atualizar) na base de dados o objeto
	 * {@link Cidade}
	 * 
	 * @param cidade Objeto a ser persistido
	 * @return Objeto persistido
	 */
	Cidade update(Cidade cidade);

	/**
	 * Metodo responsavel por excluir da base de dados o objeto {@link Cidade}
	 * referente ao id informado
	 * 
	 * @param id Identificador do objeto
	 */
	void delete(Integer id);
}
