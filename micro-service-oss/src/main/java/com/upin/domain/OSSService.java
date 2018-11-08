package com.upin.domain;

import com.upin.dtos.CommonResponseDTO;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Created by Leslie on 2018/7/24.
 */
public interface OSSService {

    CommonResponseDTO upload(MultipartFile multipartFile, boolean isPublic) throws Exception;

    CommonResponseDTO timeStampUrl(String url) throws Exception;

}
