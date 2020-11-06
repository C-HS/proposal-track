package com.indic.proposal.service.service;

import com.indic.proposal.service.model.Project;

import java.util.List;

public interface ProjectService {
    public Project addProject(Project project);
    public Project fetchProjectById(long projectId);
    public List<Project> fetchAllProject();
    public void deleteProjectById(long projectId);
    public Project updateProject(long projectId, Project project);
}
