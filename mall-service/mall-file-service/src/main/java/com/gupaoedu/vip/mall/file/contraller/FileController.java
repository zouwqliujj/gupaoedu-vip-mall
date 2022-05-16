package com.gupaoedu.vip.mall.file.contraller;

import com.gupaoedu.mall.util.RespResult;
import com.gupaoedu.vip.mall.file.fastdfs.FileHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/file")
public class FileController {

    @Autowired
    private FileHandler fileHandler;

    @Value("${fileUrl}")
    private String fileUrl;

    /****
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping(value = "/upload")
    public RespResult upload(MultipartFile file) throws IOException {
        //调用
        String storePath=fileHandler.uploadFile(file);
        System.out.println("文件存储路经:"+storePath);
        return RespResult.ok();
    }

    /****
     * 文件下载
     * @return
     */
    @GetMapping(value = "/download/{fileName}")
    public void download(@PathVariable String fileName, HttpServletResponse response) throws IOException {
        //调用
        byte[] file= fileHandler.downloadFile(fileUrl);
        ServletOutputStream os = response.getOutputStream();
        os.write(file);
        os.flush();
        os.close();
    }

    /****
     * 文件下载
     * @return
     */
    @GetMapping(value = "/download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {
        byte[] file= fileHandler.downloadFile(fileUrl);
        // byte[] buffer = fileHandler.download(filename);
        ServletOutputStream os = response.getOutputStream();
        os.write(file);
        os.flush();
        os.close();
    }
}
