package com.indic.proposal.service.service;

import com.indic.proposal.service.model.Subtype;

import java.util.List;

public interface SubTypeService {
    public Subtype addSubtype(Subtype subtype);
    public Subtype fetchSubtypeById(long subtypeId);
    public List<Subtype> fetchAllSubtype();
    public void deleteSubtypeById(long subtypeId);
    public Subtype updateSubtype(long subtypeId, Subtype subtype);
}
