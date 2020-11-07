package com.indic.proposal.service.service.impl;

import com.indic.proposal.service.model.Component;
import com.indic.proposal.service.repository.ComponentRepository;
import com.indic.proposal.service.request.ComponentList;
import com.indic.proposal.service.service.ComponentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ComponentServiceImpl implements ComponentService {
    private final ComponentRepository componentRepository;
    @Override
    public Component addComponent(Component component) {
        return componentRepository.save(component);
    }

    @Override
    public List<Component> addComponentList(Iterable<Component> componentList) {
        return componentRepository.saveAll(componentList);
    }

    @Override
    public Component fetchComponentById(long componentId) {
        return componentRepository.findById(componentId).get();
    }

    @Override
    public List<Component> fetchAllComponent() {
        return componentRepository.findAll();
    }

    @Override
    public void deleteComponentById(long componentId) {
        componentRepository.deleteById(componentId);
    }

    @Override
    public Component updateComponent(long componentId, Component component) {
        component.setComponentTypeId(componentId);
        component.setProposal(this.fetchComponentById(componentId).getProposal());
        return componentRepository.save(component);
    }
}
