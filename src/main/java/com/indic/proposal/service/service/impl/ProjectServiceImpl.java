package com.indic.proposal.service.service.impl;

import com.indic.proposal.service.model.Project;
import com.indic.proposal.service.repository.ProjectRepository;
import com.indic.proposal.service.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    @Override
    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project fetchProjectById(long projectId) {
        return projectRepository.findById(projectId).get();
    }

    @Override
    public List<Project> fetchAllProject() {
        return projectRepository.findAll();
    }

    @Override
    public void deleteProjectById(long projectId) {
        projectRepository.deleteById(projectId);
    }

    @Override
    public Project updateProject(long projectId, Project project) {
        project.setProjectId(projectId);
        project.setComponent(this.fetchProjectById(projectId).getComponent());
        return projectRepository.save(project);
    }
}
