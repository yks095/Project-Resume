package com.kiseok.service;

import com.kiseok.domain.Introductions;
import com.kiseok.repository.IntroductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntroductionService {

    @Autowired
    IntroductionRepository introductionRepository;

    public List<Introductions> findIntroductionList()   {
        return introductionRepository.findAll();
    }

    public Introductions findIntroduction(Long idx)   {
        return introductionRepository.getOne(idx);
    }

    public Introductions modifyIntroduction(Long idx, Introductions introductions)  {
        Introductions modifiedIntroduction = introductionRepository.getOne(idx);

        modifiedIntroduction.setTitle((introductions.getTitle()));
        modifiedIntroduction.setGrowth(introductions.getGrowth());
        modifiedIntroduction.setReason(introductions.getReason());
        modifiedIntroduction.setStrength(introductions.getStrength());
        modifiedIntroduction.setWeakness(introductions.getWeakness());
        modifiedIntroduction.setAspiration(introductions.getAspiration());

        modifiedIntroduction.setRegisteredDateNow();

        return modifiedIntroduction;
    }

    public void saveModifiedIntroduction(Introductions modifiedIntroduction)   {
        introductionRepository.save(modifiedIntroduction);
    }

}
