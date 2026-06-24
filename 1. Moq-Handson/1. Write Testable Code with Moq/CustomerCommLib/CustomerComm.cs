namespace CustomerCommLib
{
    /// <summary>
    /// The class under test. It depends on the IMailSender abstraction, which
    /// is injected via the constructor (Constructor Injection). In production
    /// the real MailSender is injected; in unit tests a Moq mock is injected,
    /// so no real email is ever sent.
    /// </summary>
    public class CustomerComm
    {
        private readonly IMailSender _mailSender;

        public CustomerComm(IMailSender mailSender)
        {
            _mailSender = mailSender;
        }

        public bool SendMailToCustomer()
        {
            // Actual logic goes here: define message and mail address.
            _mailSender.SendMail("cust123@abc.com", "Some Message");

            return true;
        }
    }
}
