using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Filters;

namespace WebApiDemo.Filters
{
    public class CustomExceptionFilter : IExceptionFilter
    {
        public void OnException(ExceptionContext context)
        {
            string logPath = "exception_log.txt";
            string logEntry = $"{DateTime.Now}: {context.Exception.Message}{Environment.NewLine}";
            File.AppendAllText(logPath, logEntry);

            context.Result = new ObjectResult(new
            {
                Message = "An unexpected error occurred.",
                Detail = context.Exception.Message
            })
            {
                StatusCode = 500
            };

            context.ExceptionHandled = true;
        }
    }
}
