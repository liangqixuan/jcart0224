package io.lqx.jcartadministrationback.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/* *
 * @Author: LiangQiXuan
 * @Date: 2020/2/24 17:06
 * 为API生，为框架死，为debug奋斗一辈子，
 * 吃符号亏，上大小写的当，最后死在需求上。
 */
@RestController
@RequestMapping("/image")
public class ImageController {

    /* *
     * 上传图片接口
     * @param image
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile image){
        return null;
    }
}
