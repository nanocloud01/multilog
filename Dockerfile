# -------- Etapa de construcción --------
FROM eclipse-temurin:25-jdk-jammy AS build

WORKDIR /app

# Copia los archivos del proyecto, incluyendo mvnw y el wrapper de Maven
COPY . .

# Asegúrate de que el wrapper tenga permisos de ejecución
RUN chmod +x mvnw

# Compilar el proyecto usando el wrapper de Maven
RUN ./mvnw clean package -DskipTests

# -------- Etapa de producción --------
FROM eclipse-temurin:25-jre-jammy

WORKDIR /app

# Copia el jar generado desde la etapa build
COPY --from=build /app/boot-app/target/boot-app-1.0-SNAPSHOT.jar app.jar

# Expone el puerto para la aplicación
EXPOSE 8080

# Comando de arranque para la aplicación Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
