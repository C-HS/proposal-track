package com.indic.proposal.service.service;

import com.indic.proposal.service.dto.MediaDTO;
import com.indic.proposal.service.dto.PlantInfoDTO;
import com.indic.proposal.service.model.Media;
import com.indic.proposal.service.model.PlantInfo;

import java.util.List;

public interface PlantInfoService {
    public PlantInfoDTO addPlantInfo(PlantInfo plantInfo);
    public PlantInfoDTO fetchPlantInfoById(long plantInfoId);
    public List<PlantInfoDTO> fetchAllPlantInfo();
    public void deletePlantInfoById(long plantInfoId);
    public PlantInfoDTO updatePlantInfo(long plantInfoId, PlantInfo plantInfo);
}
