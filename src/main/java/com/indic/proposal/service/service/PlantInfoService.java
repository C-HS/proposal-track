package com.indic.proposal.service.service;

import com.indic.proposal.service.model.PlantInfo;

import java.util.List;

public interface PlantInfoService {
    public PlantInfo addPlantInfo(PlantInfo plantInfo);
    public PlantInfo fetchPlantInfoById(long plantInfoId);
    public List<PlantInfo> fetchAllPlantInfo();
    public void deletePlantInfoById(long plantInfoId);
    public PlantInfo updatePlantInfo(long plantInfoId, PlantInfo plantInfo);
}
