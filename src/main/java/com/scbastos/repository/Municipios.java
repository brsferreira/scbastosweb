package com.scbastos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scbastos.model.Municipio;

@Repository
public interface Municipios extends JpaRepository<Municipio, Long>{

}
