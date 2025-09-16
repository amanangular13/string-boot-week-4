package com.Aman.productionReadyFeatures;

import com.Aman.productionReadyFeatures.clients.AlbumClient;
import com.Aman.productionReadyFeatures.dto.AlbumDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductionReadyFeaturesApplicationTests {

    @Autowired
    private AlbumClient albumClient;

	@Test
	void getAllAlbums() {
        List<AlbumDTO> albumDTOList = albumClient.getAllAlbums();
        System.out.println(albumDTOList);
    }

    @Test
    void getAlbumById() {
        AlbumDTO albumDTO = albumClient.getAlbumById(100L);
        System.out.println(albumDTO);
    }

    @Test
    void updateAlbum() {
        AlbumDTO albumDTO = AlbumDTO.builder().id(101L).title("My Test Title").userId(1L).build();
        AlbumDTO updatedAlbumDTO = albumClient.updateAlbumById(albumDTO);
        System.out.println(updatedAlbumDTO);
    }
}
