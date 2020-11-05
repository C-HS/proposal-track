package com.indic.proposal.service.service;

import com.indic.proposal.service.dto.DumpsiteDTO;
import com.indic.proposal.service.dto.MediaDTO;
import com.indic.proposal.service.model.Dumpsite;
import com.indic.proposal.service.model.Media;

import java.util.List;

public interface DumpsiteService {
    public DumpsiteDTO addDumpsite(Dumpsite dumpsite);
    public DumpsiteDTO fetchDumpsiteById(long dumpsiteId);
    public List<DumpsiteDTO> fetchAllDumpsite();
    public void deleteDumpsiteById(long dumpsiteId);
    public DumpsiteDTO updateDumpsite(long dumpsiteId, Dumpsite dumpsite);
}
