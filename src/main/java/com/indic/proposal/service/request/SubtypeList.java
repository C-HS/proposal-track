package com.indic.proposal.service.request;

import com.indic.proposal.service.model.Subtype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubtypeList {
    List<Subtype> subtypeList = new ArrayList<>();
}
