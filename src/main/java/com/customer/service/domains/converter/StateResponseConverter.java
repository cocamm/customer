package com.customer.service.domains.converter;

import com.customer.service.domains.model.State;
import com.customer.service.domains.resource.model.StateResponse;

import java.util.List;
import java.util.stream.Collectors;

public class StateResponseConverter {

    public static List<StateResponse> convert(List<State> states) {
        return states.stream()
                .map(state -> StateResponse.builder()
                        .id(state.getId())
                        .code(state.getCode())
                        .name(state.getName())
                        .build())
                .collect(Collectors.toList());
    }
}
