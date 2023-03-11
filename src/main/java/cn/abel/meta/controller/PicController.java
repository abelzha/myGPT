package cn.abel.meta.controller;


import cn.abel.meta.utils.ClientUtils;
import cn.abel.meta.vo.ResponseMsg;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.StrUtil;
import com.unfbx.chatgpt.entity.images.Image;
import com.unfbx.chatgpt.entity.images.ImageResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("pic")
public class PicController {


    public static final List<String> ZOO = ListUtil.of("鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪");

    /**
     * 头像生成器
     *
     * @param
     * @return
     */
    @GetMapping("get")
    public ResponseMsg get(String prompt, HttpServletResponse response) throws IOException {
        if (StrUtil.isEmpty(prompt)) {
            return ResponseMsg.errResponse("请输入图片描述");
        }
        if (prompt.trim().length() > 1) {
            return ResponseMsg.errResponse("图片描述太多");
        }
        if (!ZOO.contains(prompt)) {
            return ResponseMsg.errResponse("请输入你的生肖");
        }
        Image image = Image.builder().prompt("卡通简笔画-" + prompt.trim()).build();
        ImageResponse imageResponse = ClientUtils.openAiClient.genImages(image);

        // 图片的 URL
        String imageUrl = imageResponse.getData().get(0).getUrl();

        // 从 URL 创建一个输入流
        URL url = new URL(imageUrl);
        InputStream in = new BufferedInputStream(url.openStream());

        // 设置响应的内容类型为图片
        response.setContentType("image/jpeg");

        // 设置响应的头信息，指示浏览器不要缓存该图片
        response.setHeader("Cache-Control", "no-store");

        // 将输入流的内容复制到响应输出流中，将图片输出到浏览器
        OutputStream out = response.getOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
        in.close();
        out.close();
        return ResponseMsg.ok();
    }
}
