package com.indic.proposal.service.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DisposalProject extends ProjectMetaInfo{
    private List<ProjectSubType> projectSubTypeList = new ArrayList<>();
}
