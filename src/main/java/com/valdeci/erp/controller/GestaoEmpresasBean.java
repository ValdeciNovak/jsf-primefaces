package com.valdeci.erp.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.valdeci.erp.model.Empresa;
import com.valdeci.erp.model.RamoAtividade;
import com.valdeci.erp.model.TipoEmpresa;
import com.valdeci.erp.repository.Empresas;
import com.valdeci.erp.repository.RamoAtividades;
import com.valdeci.erp.service.CadastroEmpresaService;
import com.valdeci.erp.util.FacesMessages;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Empresa> listaEmpresas;

	private String termoPesquisa;

	private Converter ramoAtividadesConverter;

	@Inject
	private CadastroEmpresaService cadastroEmpresaService;

	@Inject
	private FacesMessages messages;

	@Inject
	private RamoAtividades ramoAtividades;

	private Empresa empresa;

	private boolean jaHouvePesquisa() {
		return termoPesquisa != null && !"".equals(termoPesquisa);
	}

	public void prepararNovaEmpresa() {
		empresa = new Empresa();
	}

	public void salvar() {
		cadastroEmpresaService.salvar(empresa);

		if (jaHouvePesquisa()) {
			pesquisar();
		} else {
			todasEmpresas();
		}

		messages.info("Empresa salva com sucesso!");

		RequestContext.getCurrentInstance().update(Arrays.asList("frm:empresasDataTable", "frm:messages"));
	}

	public void pesquisar() {

		listaEmpresas = empresas.pesquisar(termoPesquisa);

		if (listaEmpresas.isEmpty()) {
			messages.info("Sua consulta não retornou registros.");
		}
	}

	@Inject
	private Empresas empresas;

	public void todasEmpresas() {
		listaEmpresas = empresas.todas();
	}

	public List<RamoAtividade> completarRamoAtividade(String termo) {
		List<RamoAtividade> listaRamoAtividades = ramoAtividades.pesquisar(termo);

		ramoAtividadesConverter = new RamoAtividadeConverter(listaRamoAtividades);

		return listaRamoAtividades;
	}

	public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}

	public String getTermoPesquisa() {
		return termoPesquisa;
	}

	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}

	public TipoEmpresa[] getTiposEmpresa() {
		return TipoEmpresa.values();
	}

	public Converter getRamoAtividadesConverter() {
		return ramoAtividadesConverter;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public boolean isEmpresaSelecionada() {
		return empresa != null && empresa.getId() != null;
	}

}
