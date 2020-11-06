package com.indic.proposal.service.request;

import com.indic.proposal.service.model.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectList {
    List<Project> projectList = new ArrayList<>();
}
