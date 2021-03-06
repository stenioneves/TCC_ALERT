package org.alert.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.alert.models.Grupo;
import org.alert.models.Morador;
import org.springframework.stereotype.Repository;

/**
 * classe para tratamentos de dados do Grupo.
 * @author stenio
 *
 */
@Repository
public class GrupoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void criarGrupo(Grupo grupo){
		manager.persist(grupo);
		
		
	}
	public Grupo consultarGrupoId(Grupo grupo){
		return manager.createQuery("from Grupo p  where p.idGrupo=:id",Grupo.class)
		.setParameter("id",grupo.getIdGrupo()).getSingleResult();
		
	}
	public List<Grupo> listarGrupo(){
		return manager.createQuery("select	distinct(p) from Grupo p",Grupo.class).getResultList();
		
	}

 public List<Grupo>listarGrupoPorBairro(Morador morador){
	 return manager.createQuery("from Grupo g where g.bairro=:bairro",Grupo.class).
			 setParameter("bairro", morador.getBairroEnderecoMorador()).getResultList();
	 
 }
  public void alterarDadosGrupo(Grupo grupo){
	  manager.createNativeQuery("UPDATE grupo SET bairro=:bai,nivelRiscoBairro=:risco,nome=:nom WHERE idGrupo=:id");
	  
  }
}
