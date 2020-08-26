package cn.kion.kionhub.controller.api;

import cn.kion.kionhub.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

/**
 * @Author Kion
 * @Date 2020-08-22 22:53
 */
@Slf4j
@RestController
@RequestMapping("/mail")
public class MailApi {
    @Autowired
    MailService mailService;
    @RequestMapping("/{email}")
    public String sendMail(@PathVariable("email") String email){

        boolean sended=mailService.sendEmailCode(email,"test","邮件发送测试");
        if(!sended){
            return "发送失败";
        }
        return "已发送";
    }
}
