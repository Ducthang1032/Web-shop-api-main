package main.java.common.enums;

import lombok.Getter;

@Getter
public enum MailSender {

    MAIL_TRANSPORT_PROTOCOL("mail.transport.protocol", "smtp"),
    MAIL_SMTP_AUTH("mail.smtp.auth", "true"),
    MAIL_SMTP_STARTTLS("mail.smtp.starttls.enable", "true"),
    MAIL_DEBUG("mail.debug", "false");

    private final String property;
    private final String value;

    MailSender(String property, String value) {
        this.property = property;
        this.value = value;
    }

}
