package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.etablissement.EtablissementJoinUpdates;

@Mapper
public interface EtablissementJoinUpdatesMapper {
    List<EtablissementJoinUpdates> findAll();

    EtablissementJoinUpdates findOne(Long id);

    void save(EtablissementJoinUpdates player);

    void update(EtablissementJoinUpdates player);

    void delete(Long id);
}
