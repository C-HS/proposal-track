package com.indic.proposal.service.service;

import com.indic.proposal.service.dto.MediaDTO;
import com.indic.proposal.service.dto.ProjectDTO;
import com.indic.proposal.service.model.Media;
import com.indic.proposal.service.model.Project;

import java.util.List;

public interface ProjectService {
    public ProjectDTO addProject(Project project);
    public ProjectDTO fetchProjectById(long projectId);
    public List<ProjectDTO> fetchAllProject();
    public void deleteProjectById(long projectId);
    public ProjectDTO updateProject(long projectId, Project media);
}
