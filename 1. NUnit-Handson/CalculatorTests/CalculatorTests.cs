using CalcLibrary;
using NUnit.Framework;

namespace CalculatorTests
{
    /// <summary>
    /// Test class for SimpleCalculator. [TestFixture] declares this as a
    /// container of NUnit tests.
    /// </summary>
    [TestFixture]
    public class CalculatorTests
    {
        private SimpleCalculator _calculator;

        /// <summary>
        /// [SetUp] runs BEFORE EACH test. Use it to initialize the object
        /// under test so every test starts from a known, clean state.
        /// </summary>
        [SetUp]
        public void Initialize()
        {
            _calculator = new SimpleCalculator();
        }

        /// <summary>
        /// [TearDown] runs AFTER EACH test. Use it for cleanup activities
        /// (release resources, reset state, etc.).
        /// </summary>
        [TearDown]
        public void Cleanup()
        {
            _calculator = null;
        }

        /// <summary>
        /// Parameterised test of the Addition functionality.
        /// Each [TestCase] supplies two inputs and the expected result.
        /// Assert.That compares the actual and expected results.
        /// </summary>
        [TestCase(10, 20, 30)]
        [TestCase(-5, 5, 0)]
        [TestCase(2.5, 2.5, 5.0)]
        [TestCase(0, 0, 0)]
        public void Addition_TwoNumbers_ReturnsExpectedSum(
            double a, double b, double expected)
        {
            // Act
            double actual = _calculator.Addition(a, b);

            // Assert: actual must match expected
            Assert.That(actual, Is.EqualTo(expected));
        }

        /// <summary>
        /// Demonstrates the [Ignore] attribute: this test is skipped by the
        /// runner (with a documented reason) but kept in the codebase.
        /// </summary>
        [Test]
        [Ignore("Demonstrates the [Ignore] attribute - feature not ready yet.")]
        public void PendingFeature_Test()
        {
            Assert.Fail("This test is intentionally ignored.");
        }
    }
}
