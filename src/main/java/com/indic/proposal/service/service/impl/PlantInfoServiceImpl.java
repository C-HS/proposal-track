package com.indic.proposal.service.service.impl;

import com.indic.proposal.service.model.PlantInfo;
import com.indic.proposal.service.repository.PlantInfoRepository;
import com.indic.proposal.service.service.PlantInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlantInfoServiceImpl implements PlantInfoService {
    private final PlantInfoRepository plantInfoRepository;
    @Override
    public PlantInfo addPlantInfo(PlantInfo plantInfo) {
        return plantInfoRepository.save(plantInfo);
    }

    @Override
    public PlantInfo fetchPlantInfoById(long plantInfoId) {
        return plantInfoRepository.findById(plantInfoId).get();
    }

    @Override
    public List<PlantInfo> fetchAllPlantInfo() {
        return plantInfoRepository.findAll();
    }

    @Override
    public void deletePlantInfoById(long plantInfoId) {
        plantInfoRepository.deleteById(plantInfoId);
    }

    @Override
    public PlantInfo updatePlantInfo(long plantInfoId, PlantInfo plantInfo) {
//        plantInfo.setPlantInfoId(plantInfoId);

        return null;
    }
}
