package com.upin.domain;

import com.upin.dtos.CommonResponseDTO;
import com.upin.exception.BaseException;
import com.upin.util.AliyunOSSUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @Created by Leslie on 2018/7/24.
 */
@Service
public class OSSServiceImpl implements OSSService {
    @Value("${aliyun.oss.end-point}")
    private String endPoint;
    @Value("${aliyun.oss.access-key-id}")
    private String accessKeyId;
    @Value("${aliyun.oss.access-key-secret}")
    private String accessKeySecret;
    @Value("${aliyun.oss.bucket-name-public}")
    private String publicBucketName;
    @Value("${aliyun.oss.bucket-name-private}")
    private String privateBucketName;
    @Value("${aliyun.oss.expiration-hours}")
    private Double expirationHours;

    @Override
    public CommonResponseDTO upload(MultipartFile multipartFile, boolean isPublic) throws Exception {
        AliyunOSSUtils aliyunOSSUtils = new AliyunOSSUtils(endPoint, accessKeyId, accessKeySecret, publicBucketName, privateBucketName, expirationHours);

        String prefix = multipartFile.getOriginalFilename().substring(0, multipartFile.getOriginalFilename().lastIndexOf("."));
        String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
        File file = File.createTempFile(prefix, suffix);
        FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);
        String url = aliyunOSSUtils.upload(file, isPublic);
        return new CommonResponseDTO().code(HttpStatus.OK.value()).message(HttpStatus.OK.getReasonPhrase()).data(url);
    }

    @Override
    public CommonResponseDTO timeStampUrl(String url) throws Exception {
        CommonResponseDTO commonResponseDTO = new CommonResponseDTO();
        AliyunOSSUtils aliyunOSSUtils = new AliyunOSSUtils(endPoint, accessKeyId, accessKeySecret, publicBucketName, privateBucketName, expirationHours);
        Map<String, String> data = getObjectName(url);
        data.forEach((key, value) -> {
            if ("true".equals(key)) {
                commonResponseDTO.data(value);
            } else {
                String urlNew = aliyunOSSUtils.getUrl(value, privateBucketName);
                commonResponseDTO.data(urlNew);
            }
        });
        commonResponseDTO.code(HttpStatus.OK.value()).message(HttpStatus.OK.getReasonPhrase());
        return commonResponseDTO;
    }

    private Map<String, String> getObjectName(String oldUrl) throws BaseException {
        Map<String, String> data = new HashMap<>();
        int index = oldUrl.indexOf('?');
        if (index <= 0 && oldUrl.contains(publicBucketName)) {
            data.put("true", oldUrl);
        } else if (index > 0 && oldUrl.contains(privateBucketName)) {
            String objectName = oldUrl.substring(oldUrl.lastIndexOf("/") + 1, index);
            data.put("false", objectName);
        } else {
            throw new BaseException("url地址不存在。");
        }
        return data;
    }
}
