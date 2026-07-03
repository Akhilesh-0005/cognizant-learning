using Microsoft.OpenApi.Models;
using WebApiDemo.Filters;

var builder = WebApplication.CreateBuilder(args);

// ---- Services ----
builder.Services.AddControllers(options =>
{
    options.Filters.Add<CustomExceptionFilter>();   // register globally so it catches exceptions in any controller
});

builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen(c =>
{
    c.SwaggerDoc("v1", new OpenApiInfo { Title = "Swagger Demo", Version = "v1" });
});

var app = builder.Build();

// ---- Pipeline ----
app.UseSwagger();
app.UseSwaggerUI(c => c.SwaggerEndpoint("/swagger/v1/swagger.json", "Swagger Demo"));

app.UseHttpsRedirection();
app.UseAuthorization();
app.MapControllers();

app.Run();
