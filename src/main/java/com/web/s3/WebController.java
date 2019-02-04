package com.web.s3;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Controller
public class WebController {
	
	private final S3Uploader s3Uploader;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/upload")
	@ResponseBody
	public String upload(@RequestParam("data") MultipartFile multipartFile) throws IOException {
		String resultImgSrc = s3Uploader.upload(multipartFile, "static");
		log.info("result_img_url : {}", resultImgSrc);
		return resultImgSrc;
	}
	
}
