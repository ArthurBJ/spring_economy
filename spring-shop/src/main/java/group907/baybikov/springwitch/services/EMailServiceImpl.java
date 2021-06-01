package group907.baybikov.springwitch.services;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassRelativeResourceLoader;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.SpringTemplateLoader;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class EMailServiceImpl implements EMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String mailFrom;

    @SneakyThrows
    @Override
    public void sendEmail(String email, String code) {
        Template template = getTemplate();

        Map<String, String> attributes = new HashMap<>();
        attributes.put("confirm", code);

        StringWriter writer = new StringWriter();
        template.process(attributes, writer);

        String mailText = writer.toString();

        MimeMessagePreparator messagePreparatory =  mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(mailFrom);
            messageHelper.setTo(email);
            messageHelper.setSubject("Регистрация");
            messageHelper.setText(mailText, true);
        };;

        javaMailSender.send(messagePreparatory);
    }

    @SneakyThrows
    private Template getTemplate() {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_30);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateLoader(new SpringTemplateLoader(new ClassRelativeResourceLoader(this.getClass()),                 "/"));
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        return configuration.getTemplate("templates/mail/mail.ftlh");
    }
}
