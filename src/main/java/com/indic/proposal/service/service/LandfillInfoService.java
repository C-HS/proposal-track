package com.indic.proposal.service.service;

import com.indic.proposal.service.dto.LandfillInfoDTO;
import com.indic.proposal.service.dto.MediaDTO;
import com.indic.proposal.service.model.LandfillInfo;
import com.indic.proposal.service.model.Media;

import java.util.List;

public interface LandfillInfoService {
    public LandfillInfoDTO addLandfillInfo(LandfillInfo landfillInfo);
    public LandfillInfoDTO fetchLandfillInfoById(long landfillInfoId);
    public List<LandfillInfoDTO> fetchAllLandfillInfo();
    public void deleteLandfillInfoById(long landfillInfoId);
    public LandfillInfoDTO updateLandfillInfo(long landfillInfoId, LandfillInfo landfillInfo);
}
