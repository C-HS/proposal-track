package com.indic.proposal.service.request;

import com.indic.proposal.service.model.Component;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComponentList {
    private List<Component> componentList = new ArrayList<>();
}
