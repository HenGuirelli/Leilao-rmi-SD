package br.com.fatec.email;

import br.com.fatec.model.Item;
import br.com.fatec.model.Participante;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
    public static void enviar(Participante vencedor, Item item){
        System.out.println("enviando email");
        Properties props = new Properties();
        
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
            new javax.mail.Authenticator() {
                 protected PasswordAuthentication getPasswordAuthentication() 
                 {
                       return new PasswordAuthentication(Config.EMAIL, Config.SENHA);
                 }
            });

        session.setDebug(true);

        try {

              Message message = new MimeMessage(session);
              message.setFrom(new InternetAddress(Config.EMAIL)); //Remetente

              Address[] toUser = InternetAddress //Destinatário(s)
                         .parse(vencedor.getConta().getLogin());  

              message.setRecipients(Message.RecipientType.TO, toUser);
              message.setSubject("Você ganhou o leilão!");//Assunto
              message.setText("Parabéns " + vencedor.getNome() + " você venceu o leilão de: " 
                      + item.getDescricao() + " pelo valor de " + item.getValorAtual());
              /**Método para enviar a mensagem criada*/
              Transport.send(message);
              System.out.println("email enviado");
              
         } catch (MessagingException e) {
              throw new RuntimeException(e);
        }
    }
}
