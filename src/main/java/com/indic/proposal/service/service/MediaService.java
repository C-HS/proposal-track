package com.indic.proposal.service.service;

import com.indic.proposal.service.dto.MediaDTO;
import com.indic.proposal.service.model.Media;

import java.util.List;

public interface MediaService {
    public MediaDTO addMedia(Media media);
    public MediaDTO fetchMediaById(long mediaId);
    public List<MediaDTO> fetchAllMedia();
    public void deleteMediaById(long mediaId);
    public MediaDTO updateMedia(long mediaId, Media media);
}
