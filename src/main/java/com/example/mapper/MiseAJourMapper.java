package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.etablissement.MiseAJour;


@Mapper
public interface MiseAJourMapper {
    List<MiseAJour> findAll();

    MiseAJour findOne(Long id);

    void save(MiseAJour player);

    void update(MiseAJour player);

    void delete(Long id);
}
