package com.indic.proposal.service.service;

import com.indic.proposal.service.dto.MediaDTO;
import com.indic.proposal.service.dto.SubtypeDTO;
import com.indic.proposal.service.model.Media;
import com.indic.proposal.service.model.Subtype;

import java.util.List;

public interface SubTypeService {
    public SubtypeDTO addSubtype(Subtype subtype);
    public SubtypeDTO fetchSubtypeById(long subtypeId);
    public List<SubtypeDTO> fetchAllSubtype();
    public void deleteSubtypeById(long subtypeId);
    public SubtypeDTO updateSubtype(long subtypeId, Subtype subtype);
}
