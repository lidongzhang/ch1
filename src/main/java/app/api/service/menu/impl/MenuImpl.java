package app.api.service.menu.impl;

import app.api.service.menu.MenuInterface;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Slf4j
@Service
public class MenuImpl implements MenuInterface {

    @Override
    public List<MenuEntity> getMenus(String right){
        try {
            File file = ResourceUtils.getFile("classpath:app/menu/config.json");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String str;
            while( (str = bufferedReader.readLine()) != null){
                stringBuffer.append(str);
            }
            str = stringBuffer.toString();
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(str, new TypeReference<List<MenuEntity>>(){});
        }catch (FileNotFoundException e){
            e.printStackTrace();
            log.error(e.toString());
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.toString());
        }
        return  null;
    }
}
