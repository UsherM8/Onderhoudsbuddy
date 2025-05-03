using Microsoft.EntityFrameworkCore;
using Domain.Dtos;

namespace Dal
{
    public class OnderhoudsbuddyDbContext : DbContext
    {
        public OnderhoudsbuddyDbContext(DbContextOptions<OnderhoudsbuddyDbContext> options) 
            : base(options)
        {
        }

        // Definieer hier je DbSet met de DTO's
        public DbSet<CarDto> Cars { get; set; } = null!;

        // Gebruik Fluent API om je database mapping correct in te stellen
        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            // Mapping voor CarDto
            modelBuilder.Entity<CarDto>(entity =>
            {
                // De primaire sleutel
                entity.HasKey(e => e.CarId);

                // Verplicht attribuut LicencePlate met een maximale lengte van 50
                entity.Property(e => e.LicencePlate)
                    .IsRequired()    // Zorgt ervoor dat het niet null kan zijn
                    .HasMaxLength(50);

                // Verplicht attribuut BrandName met een maximale lengte van 100
                entity.Property(e => e.BrandName)
                    .IsRequired()    // Zorgt ervoor dat dit veld niet null kan zijn
                    .HasMaxLength(100);

                // Verplicht attribuut CarType met een maximale lengte
                entity.Property(e => e.CarType)
                    .IsRequired()    // Zorgt ervoor dat dit veld niet null kan zijn
                    .HasMaxLength(100);
            });
        }
    }
}