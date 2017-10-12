package com.scbastos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scbastos.model.Bairro;

@Repository
public interface Bairros extends JpaRepository<Bairro, Long>{
	

}
