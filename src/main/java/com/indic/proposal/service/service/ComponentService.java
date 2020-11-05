package com.indic.proposal.service.service;

import com.indic.proposal.service.model.Component;

import java.util.List;

public interface ComponentService {
    public Component addComponent(Component component);
    public Component fetchComponentById(long componentId);
    public List<Component> fetchAllComponent();
    public void deleteComponentById(long componentId);
    public Component updateComponent(long componentId, Component component);
}
