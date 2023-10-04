package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto14;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main17")
public class Controller17 {
    @Autowired
    private ServletContext application;

    //맨 처음 시작할 때 application attribute 초기화(set)
    @PostConstruct
    public void init(){
        application.setAttribute("posts",new ArrayList<MyDto14>());
    }
    //메소드는 쓸 필요 없이 필드만 읽어오면 되니까 형변환 안해도 됨
    @GetMapping("list")
    public void list(Model model){
        model.addAttribute("postList", application.getAttribute("posts"));
    }
    @GetMapping("new")
    public void newPost(){

    }
    //List의 메소드를 써야 하므로 형변환
    @PostMapping("new")
    public String newPost(MyDto14 post, RedirectAttributes rttr){
        Object posts = application.getAttribute("posts");
        List<MyDto14> list = (List<MyDto14>) posts;
        list.add(post);

       rttr.addFlashAttribute("message","새 글이 등록되었습니다.");
       rttr.addAttribute("id",(list.size()-1));

//        return "redirect:/main17/list";
        return "redirect:/main17/view";
    }
    //List의 메소드를 써야 하므로 형변환
    @GetMapping("view")
    public void view(Integer id, Model model){
        List<MyDto14> list = (List<MyDto14>) application.getAttribute("posts");
        model.addAttribute("post",list.get(id));
    }
}
