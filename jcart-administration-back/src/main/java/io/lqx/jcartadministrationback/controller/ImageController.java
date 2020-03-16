package io.lqx.jcartadministrationback.controller;

import io.lqx.jcartadministrationback.constant.ClientExceptionConstant;
import io.lqx.jcartadministrationback.exception.ClientException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/24 17:06
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@RestController
@RequestMapping("/image")
@CrossOrigin
public class ImageController {

    @Value("${www.image.baseurl}")
    private String imageBaseurl;

    private List<String> imageExts= Arrays.asList("jpg","jpeg","png");

    /* *
     * 上传图片接口
     * @param image
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile image) throws Exception{
        // 获取图片文件名称
        String originalFilename = image.getOriginalFilename();
        // 进行切割名称，拿到文件名的后缀名
        String[] splits = originalFilename.split("\\.");
        String ext = splits[splits.length - 1];
        ext = ext.toLowerCase();
        //todo judge with content type
        // 判断图片格式是否为上述所定义的
        boolean contains = imageExts.contains(ext);
        if (!contains){
            throw new ClientException(ClientExceptionConstant.IMAGE_INVALID_ERRCODE, ClientExceptionConstant.IMAGE_INVALID_ERRMSG);
        }
        // 存入自定义本地路径
        String uuid = UUID.randomUUID().toString();
        String filename = String.format("%s.%s", uuid, ext);
        String filepath = String.format("www/image/%s", filename);
        try(FileOutputStream out = new FileOutputStream(filepath)){
            byte[] data = image.getBytes();
            out.write(data);
        }
        return imageBaseurl + "/" + filename;
    }
}
