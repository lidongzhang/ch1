package app.api.service.download.impl;

import app.api.service.download.DownloadFileInterface;
import app.home.controller.AppProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Service
@Slf4j
public class DownloadFileImpl implements DownloadFileInterface {

    @Autowired
    private AppProperties appProperties;

    @Override
    public void  down(String fileName , HttpServletRequest request, HttpServletResponse response) {
        fileName = appProperties.getData_path() + "/" + fileName;

        // 如果文件名不为空，则进行下载
        if (fileName != null) {
            File file = new File(fileName);

            // 如果文件名存在，则进行下载
            if (file.exists()) {

                // 配置文件下载
                response.setHeader("content-type", "application/octet-stream");
                response.setContentType("application/octet-stream");
                try {
                    // 下载文件能正常显示中文
                    response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
                }catch(Exception e){
                    e.printStackTrace();
                    log.error(e.toString());
                }
                // 实现文件下载
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }

                }
                catch (Exception e) {
                    e.printStackTrace();
                    log.error(e.toString());
                }
                finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                            log.error(e.toString());
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                            log.error(e.toString());
                        }
                    }
                }
            }
        }
    }
}
