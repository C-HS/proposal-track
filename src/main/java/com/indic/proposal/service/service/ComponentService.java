package com.indic.proposal.service.service;

import com.indic.proposal.service.model.Component;
import com.indic.proposal.service.model.Proposal;
import com.indic.proposal.service.request.ComponentList;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface ComponentService {
    public Component addComponent(Component component);
    public List<Component> addComponentList(Iterable<Component> componentList);
    public Component fetchComponentById(long componentId);
    public List<Component> fetchAllComponent();
    public String deleteComponentById(long componentId);
    public Component updateComponent(long componentId, Component component);
    public Set<Proposal> filterByComponentType(String componentType);
    public Set<Proposal> filterByBetweenDates(Date fromDate, Date toDate, Set<Proposal> proposals);
    public Set<Proposal> filterByStatus(String proposalStatus, Set<Proposal> proposals);
}
