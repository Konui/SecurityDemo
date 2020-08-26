package cn.kion.kionhub.service;

import javax.mail.MessagingException;

/**
 * 邮件
 *
 * @Author Kion
 * @Date 2020-08-22 22:45
 */
public interface MailService {
    /**
     * 发送邮件
     *
     * @Param   to          接收人
     * @Param   subject     主题
     * @Param   content     内容
     * @Return  boolean
     *
     * @Date    2020-08-22 22:46
     */
    boolean sendEmailCode(String to, String subject, String content);
}
