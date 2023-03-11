package cn.abel.meta.vo;


import com.unfbx.chatgpt.entity.chat.Message;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 对话参数
 *
 * @author junzhang27
 */
@Data
public class ChatParam {
    //主题
    private String theme;

    // 对话记录
    @NotNull
    private List<Message> messages;

    // 意图 eg：帮我总结一下这个文本
    private String intention;
}
