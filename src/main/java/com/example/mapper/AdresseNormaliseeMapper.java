package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.etablissement.AdresseNormalisee;

@Mapper
public interface AdresseNormaliseeMapper {
    List<AdresseNormalisee> findAll();

    AdresseNormalisee findOne(Long id);

    void save(AdresseNormalisee player);

    void update(AdresseNormalisee player);

    void delete(Long id);
}
