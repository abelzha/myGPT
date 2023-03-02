package cn.abel.meta.controller;


import cn.abel.meta.vo.ResponseMsg;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("test")
    public ResponseMsg test() {
        return ResponseMsg.ok();
    }
}
