package com.library.feature.digitalresources.domain;

import java.util.List;

public interface DigitalResourceRepository {

    void createDigitalResource(DigitalResources digitalResources);

    void deleteDigitalResource(String id);

    void updateDigitalResource(DigitalResources digitalResources);

    List<DigitalResources> getDigitalResources();

    DigitalResources getDigitalResource(String id);
}
