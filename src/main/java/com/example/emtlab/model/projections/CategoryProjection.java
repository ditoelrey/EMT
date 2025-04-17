package com.example.emtlab.model.projections;

import com.example.emtlab.model.enumerations.Category;

public interface CategoryProjection {
    Category getCategory();
    Long getCount();
}