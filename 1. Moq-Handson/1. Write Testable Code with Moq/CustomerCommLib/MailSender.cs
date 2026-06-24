using System.Net;
using System.Net.Mail;

namespace CustomerCommLib
{
    /// <summary>
    /// Real implementation that talks to an SMTP server.
    /// NOTE: This class CANNOT be unit tested directly because it reaches out
    /// to an external SMTP mail server. That is exactly why CustomerComm
    /// depends on the IMailSender abstraction instead of this concrete class.
    /// </summary>
    public class MailSender : IMailSender
    {
        public bool SendMail(string toAddress, string message)
        {
            MailMessage mail = new MailMessage();
            SmtpClient SmtpServer = new SmtpClient("smtp.gmail.com");

            mail.From = new MailAddress("your_email_address@gmail.com");
            mail.To.Add(toAddress);
            mail.Subject = "Test Mail";
            mail.Body = message;

            SmtpServer.Port = 587;
            SmtpServer.Credentials = new NetworkCredential("username", "password");
            SmtpServer.EnableSsl = true;

            SmtpServer.Send(mail);

            return true;
        }
    }
}
