package cn.imust.blog.controller;

import cn.imust.blog.entity.Album;
import cn.imust.blog.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping (value = "/album")
public class AlbumController {
    @Autowired private AlbumService albumService;

    @RequestMapping(value = "upload")
    @ResponseBody
    public String upload(@RequestParam("album") MultipartFile file) {
        if (file.isEmpty()) {
            return "文件为空";
        }
        Album album = new Album();
        // 获取文件名
        String fileName = file.getOriginalFilename();
        album.setFileName(fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 解决中文问题，liunx 下中文路径，图片显示问题
        fileName = UUID.randomUUID() + suffixName;

        albumService.save(album);
        return "redirect:/album/gallery";
    }

    @RequestMapping (value = "gallery")
    public String findAll(Model model){
        List<Album> albums = albumService.findAll();
        model.addAttribute("albums",albums);
        return "/admin/album/gallery";
    }
}
