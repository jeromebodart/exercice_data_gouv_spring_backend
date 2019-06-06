package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdresseNormaliseeMapper {
    List<AdresseNormaliseeMapper> findAll();

    AdresseNormaliseeMapper findOne(Long id);

    void save(AdresseNormaliseeMapper player);

    void update(AdresseNormaliseeMapper player);

    void delete(Long id);
}
