package com.scbastos.repository.helper.imovel;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.scbastos.model.Imovel;
import com.scbastos.repository.filter.ImovelFilter;

public class ImoveisImpl implements ImoveisQueries{
	
	@PersistenceContext
	private EntityManager manager;
	

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Imovel> filtrar(ImovelFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Imovel.class);
		
		if (filtro != null) {
			
			
			if (!StringUtils.isEmpty(filtro.getCodigosc())) {
				criteria.add(Restrictions.eq("codigosc", filtro.getCodigosc()));
			}
			
			if (filtro.getTipoImovel() != null) {
				criteria.add(Restrictions.eq("tipoImovel", filtro.getTipoImovel()));
			}
			
			
			if (filtro.getStatus() != null) {
				criteria.add(Restrictions.eq("status", filtro.getStatus()));
			}
			
			if (filtro.getSituacao()!= null) {
				criteria.add(Restrictions.eq("situacao", filtro.getSituacao()));
			}
		}
		
		return criteria.list();
		
		
	}//END filtrar


/*	@Override
	public List<Imovel> cpfs(Imovel imovel) {
		return manager.createQuery("SELECT p.cpf FROM imovel i INNER JOIN i.proprietario p WHERE i = :imovel", Imovel.class)
				.setParameter("imovel", imovel)
				.getResultList();
	}*/

}//END CLASS



