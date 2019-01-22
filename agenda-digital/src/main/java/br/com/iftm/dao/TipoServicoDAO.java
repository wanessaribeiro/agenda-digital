package br.com.iftm.dao;

import java.util.List;

import br.com.iftm.entity.TipoServico;

public interface TipoServicoDAO {
	
	/**
	 * Método responsável por persistir o objeto {@link TipoServico} na base de
	 * dados.
	 * 
	 * @param tipoServico Objeto a ser persistido.
	 * @return Objeto persistido.
	 */
	TipoServico create(TipoServico tipoServico);
	
	/**
	 * Método responsável por recuperar da base de dados todos os objetos
	 * {@link TipoServico} 
	 * 
	 * @return Lista de {@link TipoServico}
	 */
	List<TipoServico> read();
	
	/**
	 * Método responsável por recuperar da base de dados todos os objetos
	 * {@link TipoServico}, cujo nome possua parte do parametro Nome. 
	 * @param nome Parte do nome a ser buscado
	 * @return Lista de {@link TipoServico}
	 */
	List<TipoServico> readByName(String nome);
	
	/**
	 * Mtodo responsavel por persistir (atualizar) na base de dados o objeto
	 * {@link TipoServico}.
	 * 
	 * @param tipoServico Objeto a ser persistido.
	 * @return Objeto persistido 
	 */
	TipoServico update(TipoServico tipoServico);
	
	/**
	 * Metodo responsavel por excluir da base de dados o objeto {@link TipoServico}
	 * referente ao id informado.
	 * 
	 * @param id Identificador do objeto {@link TipoServico} a ser excluido.
	 */
	void delete(Integer id);
}
