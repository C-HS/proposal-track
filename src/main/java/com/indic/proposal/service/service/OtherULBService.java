package com.indic.proposal.service.service;

import com.indic.proposal.service.dto.OtherULBDTO;
import com.indic.proposal.service.model.OtherULB;

import java.util.List;

public interface OtherULBService {
    public OtherULBDTO addOtherULB(OtherULB otherULB);
    public OtherULBDTO fetchOtherULBYId(long otherULBId);
    public List<OtherULBDTO> fetchAllOtherULB();
    public void deleteOtherULBById(long otherULBId);
    public OtherULBDTO updateOtherULB(long otherULBId, OtherULB otherULB);
}
