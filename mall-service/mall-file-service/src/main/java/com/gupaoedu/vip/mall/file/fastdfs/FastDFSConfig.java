package com.gupaoedu.vip.mall.file.fastdfs;

import com.github.tobato.fastdfs.FdfsClientConfig;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;

@Configuration
@Import(FdfsClientConfig.class)
@EnableMBeanExport(registration= RegistrationPolicy.IGNORE_EXISTING)
public class FastDFSConfig {

    @Bean
    public FileHandler fileHandler(FastFileStorageClient storageClient){
        return new FileHandler(storageClient);
    }
}
