package server.controller.lgdb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import server.base.Response;
import server.util.JwtToken;

import java.io.File;

@JwtToken
@RestController
@CrossOrigin
@RequestMapping("/advert")
public class AdvertController {

    //Value注解里面是虚拟路径
    @Value("F:\\myJavaWorkspace\\Iwms\\Lgdb\\src\\main\\resources\\myStatic\\images")
    private String uploadAbsolutePath;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Response upload(@RequestParam("upload") MultipartFile multipartFile) {
        Response response = null;
        if (!multipartFile.isEmpty()) {
            try {
//                byte[] bytes = multipartFile.getOriginalFilename().getBytes("utf-8");
//                multipartFile.transferTo(new File(uploadAbsolutePath + "\\" + bytes));
//                String s_utf8 = new String(bytes,"utf-8");
//                String url = "http://localhost:3000/myStatic/images/" + s_utf8;
                multipartFile.transferTo(new File(uploadAbsolutePath + "\\" + multipartFile.getOriginalFilename()));
                String url = "http://localhost:3000/myStatic/images/" + multipartFile.getOriginalFilename();
                response = new Response(0, "上传成功", url);
            } catch (Exception e) {
                e.printStackTrace();
                response = new Response(-1, "网络异常", "");
            }
        } else {
            response = new Response(-1, "上传失败", "");
        }
        return response;
    }
}
