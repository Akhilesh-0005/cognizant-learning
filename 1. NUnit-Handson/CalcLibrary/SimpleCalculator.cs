namespace CalcLibrary
{
    /// <summary>
    /// A simple calculator that is the "unit under test".
    /// It has no external dependencies, so it is trivially testable.
    /// </summary>
    public class SimpleCalculator
    {
        /// <summary>Adds two numbers and returns the result.</summary>
        public double Addition(double firstNumber, double secondNumber)
        {
            return firstNumber + secondNumber;
        }

        /// <summary>Subtracts the second number from the first.</summary>
        public double Subtraction(double firstNumber, double secondNumber)
        {
            return firstNumber - secondNumber;
        }

        /// <summary>Multiplies two numbers.</summary>
        public double Multiplication(double firstNumber, double secondNumber)
        {
            return firstNumber * secondNumber;
        }

        /// <summary>Divides the first number by the second.</summary>
        public double Division(double firstNumber, double secondNumber)
        {
            if (secondNumber == 0)
            {
                throw new System.DivideByZeroException("Cannot divide by zero.");
            }

            return firstNumber / secondNumber;
        }
    }
}
