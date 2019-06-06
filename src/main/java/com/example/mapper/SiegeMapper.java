package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.entreprise.InformationsSiege;

@Mapper
public interface SiegeMapper{
    List<InformationsSiege> findAll();

    InformationsSiege findOne(Long id);

    void save(InformationsSiege player);

    void update(InformationsSiege player);

    void delete(Long id);
}
