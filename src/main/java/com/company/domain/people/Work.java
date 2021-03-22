package com.company.domain.people;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@Getter
public class Work {
//    @Id
    private long id;
    private final Date term;
    private final String name;


}
