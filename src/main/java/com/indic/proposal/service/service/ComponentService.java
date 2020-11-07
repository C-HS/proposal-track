package com.indic.proposal.service.service;

import com.indic.proposal.service.model.Component;
import com.indic.proposal.service.request.ComponentList;

import java.util.List;

public interface ComponentService {
    public Component addComponent(Component component);
    public List<Component> addComponentList(Iterable<Component> componentList);
    public Component fetchComponentById(long componentId);
    public List<Component> fetchAllComponent();
    public void deleteComponentById(long componentId);
    public Component updateComponent(long componentId, Component component);
}
