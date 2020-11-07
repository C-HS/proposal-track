package com.indic.proposal.service.service.impl;

import com.indic.proposal.service.model.Subtype;
import com.indic.proposal.service.repository.SubTypeRepository;
import com.indic.proposal.service.service.SubTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SubTypeServiceImpl implements SubTypeService {
    private final SubTypeRepository subTypeRepository;
    @Override
    public Subtype addSubtype(Subtype subtype) {
        return subTypeRepository.save(subtype);
    }
    @Override
    public Subtype fetchSubtypeById(long subtypeId) {
        return subTypeRepository.findById(subtypeId).get();
    }
    @Override
    public List<Subtype> fetchAllSubtype() {
        return subTypeRepository.findAll();
    }
    @Override
    public void deleteSubtypeById(long subtypeId) {
        subTypeRepository.deleteById(subtypeId);
    }
    @Override
    public Subtype updateSubtype(long subtypeId, Subtype subtype) {
        subtype.setProjectSubTypeId(subtypeId);
        subtype.setProject(this.fetchSubtypeById(subtypeId).getProject());
        return subTypeRepository.save(subtype);
    }
}
