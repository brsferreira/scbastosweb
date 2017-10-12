package com.scbastos.repository.helper.proprietario;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.scbastos.model.Proprietario;
import com.scbastos.repository.filter.ProprietarioFilter;

public class ProprietariosImpl implements ProprietariosQueries{
	
	
	@PersistenceContext
	private EntityManager manager;
	

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Page<Proprietario> filtrarProprietario(ProprietarioFilter filtro, Pageable pageable) {
		
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Proprietario.class);
		
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;
		
		criteria.setFirstResult(primeiroRegistro);
		criteria.setMaxResults(totalRegistrosPorPagina);
		
		
		Sort sort = pageable.getSort();
		System.out.println(">>> sort: " + sort);
		if (sort != null) {
			Sort.Order order = sort.iterator().next();
			String property = order.getProperty();
			criteria.addOrder(order.isAscending() ? Order.asc(property) : Order.desc(property));
		}
		
		adicionarFiltro(filtro, criteria);
		
		return new PageImpl<>(criteria.list(), pageable, total(filtro));
	}
	
	private Long total(ProprietarioFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Proprietario.class);
		adicionarFiltro(filtro, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}
	

	private void adicionarFiltro(ProprietarioFilter filtro, Criteria criteria) {
		if (filtro != null) {
			
			if (!StringUtils.isEmpty(filtro.getNome())) {
				criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
			}
			
			if (!StringUtils.isEmpty(filtro.getCpf())) {
				criteria.add(Restrictions.like("cpf", filtro.getCpf(), MatchMode.ANYWHERE));
			}
			
			if (!StringUtils.isEmpty(filtro.getTelefone())) {
				criteria.add(Restrictions.ilike("telefone", filtro.getTelefone(), MatchMode.ANYWHERE));
			}
			
			if (!StringUtils.isEmpty(filtro.getEmail())) {
				criteria.add(Restrictions.ilike("email", filtro.getEmail(), MatchMode.ANYWHERE));
			}
		}
		
	}// END adicionarFiltro

}//END CLASS
