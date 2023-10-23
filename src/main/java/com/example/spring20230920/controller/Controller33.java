package com.example.spring20230920.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("main33")
public class Controller33 {
    @GetMapping("sub1")
    public void method1(){

    }
    @PostMapping("sub2")
    public void method2(String name, Integer age, MultipartFile myFile) throws IOException {
        System.out.println("name = " + name);
        System.out.println("age = " + age);

        if(myFile != null){
            String fileName = myFile.getOriginalFilename();
            System.out.println("fileName = " + fileName);

            String path = "c:\\temp\\upload_"+fileName;
            InputStream inputStream = myFile.getInputStream();
            FileOutputStream outputStream = new FileOutputStream(path);

            BufferedInputStream bis = new BufferedInputStream(inputStream);
            BufferedOutputStream bos = new BufferedOutputStream(outputStream);

            try(bis; bos; inputStream; outputStream) {
                byte[] data = new byte[1024];
                int len = 0;

                while ((len = bis.read(data)) != -1) {
                    bos.write(data, 0, len);
                }
                bos.flush();
            }
        }
    }


    @GetMapping("sub3")
    public void method3(){
    }

    @PostMapping("sub4")
     public void method4(MultipartFile upload) throws IOException {
        // 업로드한 파일을 C://temp 폴더에 저장하기
        if(upload != null){
            String fileName = upload.getOriginalFilename();

            String path = "C:/temp/upload_"+fileName;
            InputStream inputStream = upload.getInputStream();
            OutputStream outputStream = new FileOutputStream(path);

            BufferedInputStream bis = new BufferedInputStream(inputStream);
            BufferedOutputStream bos = new BufferedOutputStream(outputStream);

            try(bis; bos; inputStream; outputStream){
                byte[] data = new byte[1024];
                int len = 0;

                while ((len = bis.read(data)) != -1){
                    bos.write(data, 0, len);
                }
                bos.flush();
            }
        }
    }

    @GetMapping("sub5")
    public void method5(){

    }
    // 여러파일 올리기
    @PostMapping("sub6")
    public void mehtod(MultipartFile[] files) throws IOException {
        // 파일을 선택하지 않아도 1
        System.out.println("files.length = " + files.length);
        System.out.println("업로드 파일 크기들.");
        for(MultipartFile file : files){
            // 파일 선택하지 않으면 배열의 크기는 1, 파일의 크기는 0
            System.out.println("file.getSize() = " + file.getSize());

            if(file.getSize()>0){
                String path = "C:/temp/";
                BufferedInputStream bis = new BufferedInputStream(file.getInputStream());
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + file.getOriginalFilename()));

                try(bis; bos) {
                    int len = 0;
                    byte[] data = new byte[2048];

                    while ((len = bis.read(data)) != -1) {
                        bos.write(data, 0, len);

                        bos.flush();
                    }
                }
            }
        }
    }

    @GetMapping("sub7")
    public void method7(){

    }

    @PostMapping("sub8")
    public void method8(MultipartFile[] files) throws IOException {
        //여러 업로드 된 파일을 temp의 upload 폴더에 저장
        for(MultipartFile file:files){
            if(file.getSize()>0){
                String path = "C:/temp/upload";
                File fileDir = new File(path);

                BufferedInputStream bis = new BufferedInputStream(file.getInputStream());
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path+"/new_"+file.getOriginalFilename()));

                if(!fileDir.exists()){
                    fileDir.mkdirs();
                }
                try(bis; bos){
                    int len=0;
                    byte[] bytes = new byte[1024];

                    while((len= bis.read(bytes))!=-1){
                        bos.write(bytes, 0, len);

                        bos.flush();
                    }
                }
            }
        }
    }
}
