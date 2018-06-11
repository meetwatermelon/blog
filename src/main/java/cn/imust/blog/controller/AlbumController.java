package cn.imust.blog.controller;

import cn.imust.blog.entity.Album;
import cn.imust.blog.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping (value = "/album")
public class AlbumController {
    @Autowired private AlbumService albumService;

    @PostMapping(value = "upload")
    @ResponseBody
    public ModelAndView upload(@RequestParam("album") MultipartFile file) {
        ModelAndView modelAndView = new ModelAndView();
        if (file.isEmpty()) {
            modelAndView.addObject("errorMsg","文件为空");
            modelAndView.setViewName("/album/addForm");
        }
        Album album = new Album();
        // 获取文件名
        String fileName = file.getOriginalFilename();
        album.setFileName(fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 文件上传路径
        String filePath = "F:\\blog\\album\\";
        // 解决中文问题，liunx 下中文路径，图片显示问题
        fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        album.setName("http://localhost:8080/" + fileName);
        // 检测是否存在目录1
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            albumService.save(album);
            modelAndView.setViewName("redirect:/album/gallery");
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            modelAndView.addObject("errorMsg","上传失败");
            modelAndView.setViewName("/album/addForm");
        }
        return modelAndView;
    }

    @RequestMapping (value = "gallery")
    public String findAll(Model model){
        List<Album> albums = albumService.findAll();
        model.addAttribute("albums",albums);
        return "/admin/album/gallery";
    }

    @RequestMapping("addForm")
    public String addForm(){
        return "/admin/album/galleryadd";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id){
        albumService.delete(id);
        return "redirect:/album/gallery";
    }

}
