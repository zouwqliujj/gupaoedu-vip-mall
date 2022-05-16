package com.gupaoedu.vip.mall.file.fastdfs;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;


public class FileHandler {

    private FastFileStorageClient storageClient;

    public FileHandler(FastFileStorageClient storageClient) {
        this.storageClient = storageClient;
    }


    /**
     * 上传文件
     *
     * @param file 文件对象
     * @return 文件访问地址
     * @throws IOException
     */
    public String uploadFile(MultipartFile file) throws IOException {
        StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(),
                FilenameUtils.getExtension(file.getOriginalFilename()), null);
        return storePath.getFullPath();
    }

    public String uploadFile2(MultipartFile file) throws IOException {
        StorePath storePath = storageClient.uploadImageAndCrtThumbImage(file.getInputStream(), file.getSize(),
                FilenameUtils.getExtension(file.getOriginalFilename()), null);

        return storePath.getFullPath();
    }

    /**
     * 将一段字符串生成一个文件上传
     *
     * @param content       文件内容
     * @param fileExtension
     * @return
     */
    public String uploadFile(String content, String fileExtension) {
        byte[] buff = content.getBytes(Charset.forName("UTF-8"));
        ByteArrayInputStream stream = new ByteArrayInputStream(buff);
        StorePath storePath = storageClient.uploadFile(stream, buff.length, fileExtension, null);
        return storePath.getFullPath();
    }




    /**
     * 下载文件
     *
     * @param fileUrl
     * @return
     */
    public byte[]  downloadFile(String fileUrl) {
        StorePath storePath = StorePath.praseFromUrl(fileUrl);
        DownloadByteArray downloadByteArray = new DownloadByteArray();
        return storageClient.downloadFile(storePath.getGroup(),storePath.getPath(),downloadByteArray);
    }


    // 封装图片完整URL地址
   /* private String getResAccessUrl(HttpRequest request,StorePath storePath) {
        String fileUrl = request.getURI()  + "/" + storePath.getFullPath();
        return fileUrl;
     }*/

    /**
     * 删除文件
     *
     * @param fileUrl 文件访问地址
     * @return
     */
    public void deleteFile(String fileUrl) {
        StorePath storePath = StorePath.praseFromUrl(fileUrl);
        storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
    }
}
