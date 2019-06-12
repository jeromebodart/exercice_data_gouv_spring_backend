package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.entreprise.Entreprise;

@Mapper
public interface EntrepriseMapper{
    List<Entreprise> findAll();

    Entreprise findOne(Long id);
    
    Long getMaxSiren();
    
    void save(@Param("siren")  String siren,
    		  @Param("id_siege") Long id_siege,
    		  @Param("id_identification_entreprise") Long id_identification_entreprise,
    		  @Param("id_caracteristiques") Long id_caracteristiques);

    void update(@Param("id")  Long id,
    			@Param("siren")  String siren,
    			@Param("id_siege") Long id_siege,
    			@Param("id_identification_entreprise") Long id_identification_entreprise,
    			@Param("id_caracteristiques") Long id_caracteristiques);

    void delete(Long id);

}