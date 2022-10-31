/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takehome1.takehome1;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ASUS
 */
@Controller
public class controller {    
    @RequestMapping("/login")
    public String getLogin(@RequestParam (value="Nama") String name,
                           @ RequestParam (value="Waktu") String date,
                           @ RequestParam (value="Foto") MultipartFile  picture,
                           Model model)
        throws IOException{
        byte[] img = picture.getBytes();
        String base64Image = Base64.encodeBase64String(img);
        String image ="data:image/png;base64,".concat(base64Image);
        model.addAttribute("sendname", name);
        model.addAttribute("senddate", date);
        model.addAttribute("sendphoto", image);
        return "result";
    }
}
