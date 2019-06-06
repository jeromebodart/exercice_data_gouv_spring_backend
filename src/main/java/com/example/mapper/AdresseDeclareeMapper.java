package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.etablissement.AdresseDeclaree;

@Mapper
public interface AdresseDeclareeMapper {
	List<AdresseDeclaree> findAll();

	AdresseDeclaree findOne(Long id);

	void save(AdresseDeclaree adr);

	void update(AdresseDeclaree adr);

	void delete(Long id);
}
