package br.com.iftm.business;

import java.util.List;

import br.com.iftm.entity.TipoServico;

public interface TipoServicoBusiness {
	/**
	 * Metodo responsavel por garantir os parametros obrigatorios, bem como
	 * solicitar a camada de acesso a dados que persista o Objeto
	 * {@link TipoServico}.
	 * 
	 * @param tipoServico Objeto a ser persistido.
	 * @return Objeto persistido.
	 * @throws BusinessException
	 */
	TipoServico create(TipoServico tipoServico) throws BusinessException;

	/**
	 * Método responsável por solicitar a camada de acesso pela lista de todos os
	 * objetos do tipo {@link TipoServico}
	 * 
	 * @return Lista de {@link TipoServico}
	 * @throws BusinessException
	 */
	List<TipoServico> read() throws BusinessException;

	/**
	 * Método responsável por solicitar a camada de acesso a lista filtrada pelo
	 * parametro Nome.
	 * 
	 * @return Lista de {@link TipoServico}
	 * @throws BusinessException
	 */
	List<TipoServico> readByName(String nome) throws BusinessException;

	/**
	 * Mtodo responsavel por validar os dados e solicitar a atualizacao na camada de
	 * acesso aos dados para o objeto do tipo {@link TipoServico}.
	 * 
	 * 
	 * @param tipoServico Objeto a ser persistido.
	 * @return Objeto persistido
	 * @throws BusinessException
	 */
	TipoServico update(TipoServico tipoServico) throws BusinessException;

	/**
	 * Metodo responsavel por validar o parametro e solicitar a exclusão na base de
	 * dados do objeto do tipo {@link TipoServico} referente ao id informado.
	 * 
	 * @param id Identificador do objeto {@link TipoServico} a ser excluido.
	 * @throws BusinessException
	 */
	void delete(Integer id) throws BusinessException;
}
