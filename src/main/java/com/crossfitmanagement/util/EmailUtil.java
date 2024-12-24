package main.java.com.crossfitmanagement.util;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailUtil {
    /*
     *  이메일 전송 메서드
     * @param from 발신 이메일 주소
     * @param password 발신 이메일 비밀번호
     * @param to 수신 이메일 주소
     * @param subject 이메일제목
     * @param smtpHost SMTP 서버 호스트
     * @param smtpPost SMTP 서버 포트
     * @throws MessagingException  이메일 전송 중 오류 발생 시
     */
    public static void sendEmail(String from, String password, String to, String subject, String body, String smtpHost, String smtpPort) throws MessagingException {
        //SMTP 이메일설정
        Properties properties = new Properties();
        properties.put("mail.smpt.auth", "ture");
        properties.put("mail.smpt.starttls.enable", "true");
        properties.put("mail.smpt.host", smtpHost);
        properties.put("mail.smtp.prot", smtpPort);

        //인증생성
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        //이메일 메세제 작성
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from)); //발실자 이메일 설정
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to)); //수신자설정
        message.setSubject(subject); //제목설정
        message.setText(body); //본문 설정

        //이메일전송
        Transport.send(message);

        System.out.println("이메일이 전송되었습니다.");

    }




}