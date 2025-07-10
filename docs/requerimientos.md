
# 📋 Requerimientos del Proyecto Geo Bio Service

Microservicio en Java con Spring Boot que traduce coordenadas geográficas (latitud y longitud) en direcciones aproximadas usando una API externa.

## ✅ Requerimientos Funcionales

- **Endpoint REST:** `POST /geolocate`
- **Entrada:** JSON con los campos `latitude` y `longitude`
- **Validación:** valores dentro de rangos válidos (-90 a 90, -180 a 180)
- **API Externa:** consumo de Nominatim (OpenStreetMap)
- **Caché:** en memoria para optimizar llamadas repetidas
- **Errores manejados:**
  - Coordenadas fuera de rango o mal formateadas
  - Falta de datos en la respuesta externa
  - Fallos de red o tiempo de espera
- **Documentación:** Swagger/OpenAPI 3.0
- **Testing:** JUnit 5 con cobertura en servicio, controlador y cliente externo

## 📦 Requerimientos No Funcionales

- **Arquitectura modular y extensible**, siguiendo principios SOLID
- **Separación de responsabilidades** por capas
- **Buena práctica REST**, usando controladores bien definidos
- **Configuración centralizada** en `application.yml`
- **Código limpio y comentado**
- **Licencia libre:** MIT
- **Repositorio presentable:** README detallado, `.gitignore`, `.gitattributes`

## 📚 Aplicaciones futuras

- Integración en plataformas logísticas para validación de ubicación
- Sistemas de turnos multisucursal (verificación por zona)
- Herramientas inclusivas con geolocalización accesible (asistente de voz, mapas simplificados)

---

> Este archivo puede incluirse en `/docs/requerimientos.md` dentro del repositorio.
