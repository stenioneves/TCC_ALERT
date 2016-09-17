package org.alert.controllers;

import javax.transaction.Transactional;

import org.alert.daos.MoradorDAO;
import org.alert.models.Morador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
/***
 * Classe para o controler das Views relacionado a morador e suas solicitações.
 * @author stenio
 *
 */

@Controller
@Transactional
public class MoradorController {
	
	@Autowired
	 private MoradorDAO moradorDAO;
	/**
	 * Método para exibir a tela de cadastro.
	 * @return Cadastro
	 */
	 @RequestMapping("cadastro")
	 public String formCadastro(){
		 return "cadastro";
	 }
	
	/**
	 * Método para persistência do morador.
	 * @param morador
	 * @return redireciona para tela seleção de grupo.
	 */
	@RequestMapping("adicionarMorador")
	 public String adicionarMorador(Morador morador){
		  moradorDAO.cadastrar(morador);
		 return "redirect:/grupo/selecionarGrupo";
	 }
}
