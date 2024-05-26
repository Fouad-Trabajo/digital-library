package com.library.feature.digitalresources.domain.music.domain;

import com.library.feature.digitalresources.data.musicdata.MusicDataRepository;
import com.library.feature.digitalresources.data.musicdata.local.MusicFileLocalDataSource;
import com.library.feature.digitalresources.data.musicdata.local.MusicLocalDataSource;
import com.library.feature.digitalresources.domain.*;


public class MusicFactory {

    private final MusicLocalDataSource musicLocalDataSource  = new MusicFileLocalDataSource();
    private final DigitalResourceRepository digitalResourceRepository = new MusicDataRepository(musicLocalDataSource);

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
