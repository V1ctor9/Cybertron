# Política de enrutamiento, fallback y seguridad

## Clases de tareas
- **T0 — pública/creativa:** guiones, ideas, borradores públicos. Puede usar proveedor cloud aprobado.
- **T1 — interna no sensible:** documentación técnica general y código sintético. Local preferido; cloud solo si el proveedor está aprobado.
- **T2 — confidencial:** credenciales, datos personales, contratos, datos de clientes, información institucional no pública. Solo entorno local/privado aprobado; nunca API pública gratuita por defecto.
- **T3 — crítica/seguridad:** incidentes, vulnerabilidades explotables, datos de Ojo de Dios, telemetría sensible. Entorno segregado, controles reforzados y autorización humana.

## Orden de selección inicial
1. Modelo local disponible y suficiente para la tarea.
2. Proveedor cloud gratuito aprobado, solo para T0/T1 y mientras tenga cuota.
3. Otro proveedor gratuito aprobado para T0/T1.
4. Degradar la tarea a un modelo local más pequeño o ponerla en cola.
5. Si no existe ruta segura y permitida, detenerse y comunicarlo.

No debe haber salto automático a una API facturable. Los fallbacks cloud se habilitan explícitamente y se limitan por clave, proyecto y presupuesto.

## Manejo de errores
- HTTP 429: leer Retry-After/cabeceras de cuota, aplicar espera/cooldown y luego probar el siguiente proveedor permitido.
- HTTP 5xx/timeout: reintento acotado con backoff; después fallback.
- Error de autenticación, modelo inexistente o política de seguridad: no repetir indefinidamente; marcar proveedor no disponible y alertar.
- Contexto excedido: elegir modelo/contexto compatible o resumir localmente; no reenviar datos sensibles a otro servicio.
- Rechazo de seguridad: no intentar evadirlo mediante otro modelo.

## Datos y secretos
- Claves en variables de entorno o gestor de secretos, nunca en Git.
- Archivo .env excluido mediante .gitignore; subir solo .env.example con nombres de variables vacíos.
- Redactar tokens, correos, datos personales y rutas privadas en logs.
- No almacenar prompts/respuestas completos por defecto; habilitar trazas detalladas solo con datos sintéticos o consentimiento.
- Revisar retención, entrenamiento, ubicación y subprocesadores del proveedor antes de aprobarlo.

## Agentes de programación
- Ejecutar en rama separada y sandbox.
- Permisos mínimos: lectura por defecto; escritura solo en rutas autorizadas.
- Prohibido borrar, sobrescribir, publicar secretos o fusionar a main sin autorización.
- Revisión humana obligatoria antes de PR/merge y antes de ejecutar scripts con efectos externos.

## Métricas
- solicitudes por proveedor/modelo
- tokens de entrada/salida cuando el proveedor los reporte
- latencia p50/p95
- ratio de 429, 5xx y timeouts
- fallbacks y motivo
- coste real y presupuesto restante
- tasa de éxito/calidad con un conjunto de pruebas reproducible

## Criterios de aceptación del prototipo
- Una llamada local funciona sin Internet.
- Una llamada T0 puede usar proveedor cloud aprobado.
- Un 429 simulado provoca fallback solo a otro destino autorizado.
- Una cuenta sin presupuesto no puede usar proveedor de pago.
- Las claves no aparecen en logs ni repositorio.
- T2/T3 nunca salen a proveedores públicos.
- El sistema explica qué modelo respondió y por qué se eligió, sin revelar secretos.
