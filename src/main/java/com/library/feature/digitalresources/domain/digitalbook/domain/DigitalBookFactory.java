package com.library.feature.digitalresources.domain.digitalbook.domain;

import com.library.feature.digitalresources.data.digitalbookdata.DigitalBookDataRepository;
import com.library.feature.digitalresources.data.digitalbookdata.local.DigitalBookFileLocalDataSource;
import com.library.feature.digitalresources.data.digitalbookdata.local.DigitalBookLocalDataSource;
import com.library.feature.digitalresources.domain.*;

public class DigitalBookFactory {
    private final DigitalBookLocalDataSource digitalBookLocalDataSource  = new DigitalBookFileLocalDataSource();
    private final DigitalResourceRepository digitalResourceRepository = new DigitalBookDataRepository(
            digitalBookLocalDataSource);

    public CreateDigitalResourceUseCase buildCreateResource(){
        return new CreateDigitalResourceUseCase(digitalResourceRepository);
    }

    public DeleteDigitalResourceUseCase buildDeleteResource(){
        return new DeleteDigitalResourceUseCase(digitalResourceRepository);
    }

    public GetDigitalResourceUseCase buildGetResource(){
        return new GetDigitalResourceUseCase(digitalResourceRepository);
    }

    public GetDigitalResourcesUseCase buildGetResourcres(){
        return new GetDigitalResourcesUseCase(digitalResourceRepository);
    }

    public UpdateDigitalResourceUseCase buildUpdateResource(){
        return new UpdateDigitalResourceUseCase(digitalResourceRepository);
    }
}
