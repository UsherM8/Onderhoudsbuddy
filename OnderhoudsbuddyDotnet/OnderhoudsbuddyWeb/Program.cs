using Microsoft.EntityFrameworkCore;
using Dal; // Voor OnderhoudsbuddyDbContext

var builder = WebApplication.CreateBuilder(args);

// 1. Configureer de connectionstring
var connectionString = builder.Configuration.GetConnectionString("DefaultConnection");

// 2. Registreer de DbContext voor gebruik met MySQL
builder.Services.AddDbContext<OnderhoudsbuddyDbContext>(options =>
    options.UseMySql(
        connectionString,
        new MySqlServerVersion(new Version(8, 0, 33)) // Verander de versie als nodig
    )
);

// 3. Voeg services toe aan de container
// Voeg controllers toe
builder.Services.AddControllers();

// Voeg Swagger API-documentatie toe (optioneel, maar handig)
builder.Services.AddEndpointsApiExplorer(); // Nodig voor minimal endpoints en Swagger ondersteuning
builder.Services.AddSwaggerGen(); // Genereert API-documentatie

// Hier kun je eventueel je eigen services of repositories registreren
// builder.Services.AddScoped<ICarRepository, CarRepository>();

var app = builder.Build();

// 4. Configureer middleware voor de HTTP-pipeline
if (app.Environment.IsDevelopment())
{
    app.UseDeveloperExceptionPage(); // Geeft uitgebreide foutpagina's in development
    app.UseSwagger(); // Activeer Swagger-documentatie
    app.UseSwaggerUI(); // Voeg Swagger UI toe
}

app.UseHttpsRedirection(); // Forceer HTTPS

app.UseAuthorization(); // Voeg autorisatie middleware toe

app.MapControllers(); // Gebruik de controllers als endpoints

// Applicatie starten
app.Run();