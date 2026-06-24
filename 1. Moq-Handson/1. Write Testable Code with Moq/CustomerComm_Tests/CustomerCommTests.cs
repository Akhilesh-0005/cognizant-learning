using CustomerCommLib;
using Moq;
using NUnit.Framework;

namespace CustomerComm.Tests
{
    /// <summary>
    /// Unit tests for CustomerComm using NUnit + Moq.
    /// The IMailSender dependency is mocked so that SendMailToCustomer() can be
    /// tested WITHOUT contacting a real SMTP server / sending real email.
    /// </summary>
    [TestFixture]
    public class CustomerCommTests
    {
        private Mock<IMailSender> _mockMailSender;
        private CustomerCommLib.CustomerComm _customerComm;

        /// <summary>
        /// [OneTimeSetUp] runs ONCE before all tests in this fixture.
        /// Here we create the mock, configure it, and inject it into the
        /// class under test.
        /// </summary>
        [OneTimeSetUp]
        public void Init()
        {
            _mockMailSender = new Mock<IMailSender>();

            // Configure the mock: for ANY two string arguments, SendMail
            // should always return true.
            _mockMailSender
                .Setup(m => m.SendMail(It.IsAny<string>(), It.IsAny<string>()))
                .Returns(true);

            // Inject the mock object (Constructor Injection).
            _customerComm = new CustomerCommLib.CustomerComm(_mockMailSender.Object);
        }

        /// <summary>
        /// Asserts that SendMailToCustomer returns true, proving the unit runs
        /// successfully against the mocked dependency.
        /// </summary>
        [TestCase]
        public void SendMailToCustomer_WithMockedMailSender_ReturnsTrue()
        {
            // Act
            bool result = _customerComm.SendMailToCustomer();

            // Assert
            Assert.That(result, Is.True);

            // (Optional) verify the dependency was actually invoked once.
            _mockMailSender.Verify(
                m => m.SendMail(It.IsAny<string>(), It.IsAny<string>()),
                Times.Once);
        }
    }
}
