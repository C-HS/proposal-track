package com.indic.proposal.service.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProposalFilter {
	private String componentType;
	private String fromDate;
	private String toDate;
	private String status;
}
