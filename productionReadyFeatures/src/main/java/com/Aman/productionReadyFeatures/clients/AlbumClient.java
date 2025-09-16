package com.Aman.productionReadyFeatures.clients;

import com.Aman.productionReadyFeatures.dto.AlbumDTO;

import java.util.List;

public interface AlbumClient {

    List<AlbumDTO> getAllAlbums();

    AlbumDTO getAlbumById(Long id);

    AlbumDTO updateAlbumById(AlbumDTO albumDTO);
}
