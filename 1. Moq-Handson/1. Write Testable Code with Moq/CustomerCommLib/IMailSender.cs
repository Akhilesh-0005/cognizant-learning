namespace CustomerCommLib
{
    /// <summary>
    /// Abstraction for sending mail. Depending on this interface (rather than
    /// the concrete MailSender) is what makes CustomerComm testable: in tests
    /// we substitute a Moq mock of IMailSender.
    /// </summary>
    public interface IMailSender
    {
        bool SendMail(string toAddress, string message);
    }
}
