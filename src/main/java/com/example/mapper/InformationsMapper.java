package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.example.domain.etablissement.Informations;

@Mapper
public interface InformationsMapper {
    List<Informations> findAll();

    Informations findOne(Long id);

    void save(Informations player);

    void update(Informations player);

    void delete(Long id);
}
