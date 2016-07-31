package com.jesperancinha.service.pojos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by joaofilipesabinoesperancinha on 01-08-16.
 */
@Getter
@Setter
@NoArgsConstructor
public class Country {

    private String id;

    private String code;

    private String name;

    private String continent;

    private String wikipediaLink;

    private String keywords;

}
