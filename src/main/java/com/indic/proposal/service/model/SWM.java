package com.indic.proposal.service.model;

import lombok.*;
import net.bytebuddy.asm.Advice;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SWM extends ComponentMetaInfo{
    private List<ProjectMetaInfo> projectsList;
}
