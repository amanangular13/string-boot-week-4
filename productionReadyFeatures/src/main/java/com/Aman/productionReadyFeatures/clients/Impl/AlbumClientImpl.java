package com.Aman.productionReadyFeatures.clients.Impl;

import com.Aman.productionReadyFeatures.clients.AlbumClient;
import com.Aman.productionReadyFeatures.dto.AlbumDTO;
import com.Aman.productionReadyFeatures.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumClientImpl implements AlbumClient {

    private final RestClient restClient;

    @Override
    public List<AlbumDTO> getAllAlbums() {
        try {
            List<AlbumDTO> albumDTOList = restClient.get()
                    .uri("/albums")
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
            return albumDTOList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public AlbumDTO getAlbumById(Long id) {
        try {
            AlbumDTO albumDTO = restClient.get()
                    .uri("/albums/{id}", id)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, ((request, response) -> {
                        throw new ResourceNotFoundException("Could not find Album with id : " + id);
                    }))
                    .body(new ParameterizedTypeReference<>() {
                    });
            return albumDTO;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public AlbumDTO updateAlbumById(AlbumDTO albumDTO) {
        try {
            AlbumDTO newAlbumDTO = restClient.post()
                    .uri("/albums")
                    .body(albumDTO)
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
            return newAlbumDTO;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
