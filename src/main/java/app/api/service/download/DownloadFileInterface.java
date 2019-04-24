package app.api.service.download;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface DownloadFileInterface {

    void down(String fileName, HttpServletRequest request, HttpServletResponse response);
}
