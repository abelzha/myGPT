package cn.abel.meta.vo;


import com.unfbx.chatgpt.entity.chat.Message;
import lombok.Data;

import java.util.List;

@Data
public class ChatParam {
    //主题
    private String theme;

    // 对话记录
    private List<Message> messages;


}
