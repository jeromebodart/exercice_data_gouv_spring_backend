package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.etablissement.AdresseNormalisee;
import com.example.mapper.AdresseNormaliseeMapper;

@Service
public class AdresseNormaliseeService {
	@Autowired
    private AdresseNormaliseeMapper adresseNormaliseeMapper;

    @Transactional
    public List<AdresseNormalisee> findAll() {
        return adresseNormaliseeMapper.findAll();
    }

    @Transactional
    public AdresseNormalisee findOne(Long id) {
        return adresseNormaliseeMapper.findOne(id);
    }

    @Transactional
    public void save(AdresseNormalisee player) {
    	adresseNormaliseeMapper.save(player);
    }

    @Transactional
    public void update(AdresseNormalisee player) {
    	adresseNormaliseeMapper.update(player);
    }

    @Transactional
    public void delete(Long id) {
    	adresseNormaliseeMapper.delete(id);
    }
}
