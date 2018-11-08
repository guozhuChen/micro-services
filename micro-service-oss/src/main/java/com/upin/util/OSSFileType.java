package com.upin.util;

/**
 * @Created by Leslie on 2018/7/24.
 */
public class OSSFileType {
    public static String getContentType(String fileName){
        String fileType = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
        String contentType = "";
        switch (fileType) {
            case "bmp":	contentType = "image/bmp";
                break;
            case "gif":	contentType = "image/gif";
                break;
            case "png":
            case "jpeg":
            case "jpg":	contentType = "image/jpeg";
                break;
            case "html":contentType = "text/html";
                break;
            case "txt":	contentType = "text/plain";
                break;
            case "vsd":	contentType = "application/vnd.visio";
                break;
            case "ppt":
            case "pptx":contentType = "application/vnd.ms-powerpoint";
                break;
            case "doc":
            case "docx":contentType = "application/msword";
                break;
            case "xml":contentType = "text/xml";
                break;
            case "mp4":contentType = "video/mp4";
                break;
            case "pdf":contentType = "application/pdf";
            default: contentType = "application/octet-stream";
                break;
        }
        return contentType;
    }
}
