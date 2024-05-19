package com.library.feature.digitalresources.domain;

import com.library.feature.digitalresources.domain.digitalbook.domain.DigitalBook;

import java.util.List;

public interface DigitalResourceRepository {

    void createDigitalResource(DigitalResources digitalResources);

    void deleteDigitalResource(String id);

    void updateDigitalResource(DigitalResources digitalResources);

    List<DigitalResources> getDigitalResources();

    DigitalResources getDigitalResource(String id);
}
