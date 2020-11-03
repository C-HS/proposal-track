package com.indic.proposal.service.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DumpSiteRemediation extends ProjectSubType{
    private List<DumpSite> dumpSiteList = new ArrayList<>();
}
