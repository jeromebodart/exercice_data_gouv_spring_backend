package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.etablissement.Etablissement;

@Mapper
public interface EtablissementMapper {
    List<Etablissement> findAll();

    Etablissement findOne(Long id);

//    void save(Etablissement player);
//
//    void update(Etablissement player);

    void delete(Long id);

	Long getMaxNic();
	
	Long getMaxId();

	void save(@Param("nic") String nic, 
			  @Param("id_entreprise") Long id_entreprise,
			  @Param("id_adresse_declaree") Long id_adresse_declaree,
			  @Param("id_adresse_normalisee") Long id_adresse_normalisee,
			  @Param("id_info") Long id_info,
			  @Param("id_adresse_geographique") Long id_adresse_geographique,
			  @Param("id_localisation_geographique") Long id_localisation_geographique,
			  @Param("id_caracteristiques_economiques") Long id_caracteristiques_economiques);
	
	void update(@Param("id") Long id, 
			  @Param("nic") String nic, 
			  @Param("id_entreprise") Long id_entreprise,
			  @Param("id_adresse_declaree") Long id_adresse_declaree,
			  @Param("id_adresse_normalisee") Long id_adresse_normalisee,
			  @Param("id_info") Long id_info,
			  @Param("id_adresse_geographique") Long id_adresse_geographique,
			  @Param("id_localisation_geographique") Long id_localisation_geographique,
			  @Param("id_caracteristiques_economiques") Long id_caracteristiques_economiques);
}