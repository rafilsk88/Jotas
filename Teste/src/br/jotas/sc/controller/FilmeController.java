package br.jotas.sc.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import br.jotas.sc.dao.FilmeDAO;
import br.jotas.sc.model.Filme;

public class FilmeController {

	public void salvarFilme(Filme filme) throws NullPointerException, Exception {
		validaDados(filme);
		FilmeDAO dao = new FilmeDAO();
		if(filme.getId()!=0){
			dao.editarFilme(filme);
		}else{
			dao.salvarFilme(filme);			
		}
	}

	public Filme obterFilme(int id){
		FilmeDAO dao = new FilmeDAO();		
		return dao.obterFilme(id);		
	}
	
	public ArrayList<Filme> listarFilme() {
		FilmeDAO dao = new FilmeDAO();		
		return dao.listarFilmes();
	}	

	public void excluirFilme(int id) throws SQLException {
		FilmeDAO dao = new FilmeDAO();
		dao.excluirFilme(id);
	}

	public void validaDados(Filme filme) throws NullPointerException, Exception {
		if (filme.getTitulo().isEmpty() || filme.getTitulo().equals("")) {
			throw new NullPointerException("Campo Titulo � obrigat�rio!");
		}
		if (filme.getGenero().isEmpty() || filme.getGenero().equals("")) {
			throw new NullPointerException("Campo Nome obrigat�rio!");
		}
	}
}
