# Cybertron AI Manager — plan técnico inicial

**Estado:** propuesta de arquitectura e investigación; no es todavía un sistema desplegado.

## Objetivo
Crear una capa central que seleccione modelos locales o remotos según tarea, calidad requerida, disponibilidad, privacidad, latencia, cuota y coste. Debe permitir cambiar de proveedor sin reescribir cada proyecto.

## Principios
- Local-first para información sensible y tareas que el hardware pueda resolver.
- Nube gratuita solo como capacidad limitada de desarrollo; nunca asumir disponibilidad permanente.
- No activar facturación automática. Presupuestos y límites duros antes de cualquier proveedor de pago.
- Ningún secreto, token ni clave dentro del repositorio. Usar variables de entorno o gestor de secretos.
- No enviar datos de Ojo de Dios, ciberseguridad o información institucional a APIs públicas sin autorización, evaluación contractual y clasificación previa.
- Todo agente con permisos mínimos, registro de acciones, confirmación humana para cambios externos y operaciones destructivas.
- No ejecutar automáticamente código descargado de catálogos.

## Arquitectura lógica
1. **Gateway/API:** interfaz única compatible con OpenAI cuando sea posible.
2. **Router:** LiteLLM Proxy como candidato inicial para selección, reintentos, cooldowns y fallbacks.
3. **Registro de modelos:** proveedor, modelo exacto, modalidad, contexto, licencia, región, precio, cuotas, política de datos y fecha de verificación.
4. **Proveedores locales:** Ollama inicialmente; evaluar llama.cpp según el hardware.
5. **Proveedores cloud:** Gemini API, Groq, OpenRouter y otros solo tras validar cuota, términos y disponibilidad.
6. **Agentes:** OpenHands/OpenCode para desarrollo bajo sandbox y permisos limitados; no son el router.
7. **Observabilidad:** logs sin prompts sensibles, métricas de latencia, errores, tokens, coste y motivo del fallback.
8. **Proyectos consumidores:** Semillitas, Cybertron Cybersecurity, Ojo de Dios, Atlas y Data Center.

## Flujo de una solicitud
1. El proyecto identifica tarea y clasificación de datos.
2. El gateway valida identidad, permisos y presupuesto.
3. El router elige modelo autorizado por política.
4. Si hay 429/5xx/timeout, respeta Retry-After y aplica fallback permitido.
5. Registra proveedor/modelo, consumo y resultado sin almacenar secretos.
6. Para acciones sensibles, exige aprobación humana.

## Perfil de hardware conocido
En conversaciones anteriores se indicó aproximadamente 11 GB de RAM en el PC. Es un dato orientativo, no una especificación técnica completa. Antes de elegir modelos locales hay que conocer CPU, GPU/VRAM, sistema operativo y espacio libre. No se presupone que un modelo 7B/8B vaya a funcionar con fluidez.

## Fases
- Fase 0: inventario de hardware, requisitos, cuentas y clasificación de datos.
- Fase 1: prototipo local con Ollama y un modelo pequeño cuantizado; pruebas de calidad/latencia.
- Fase 2: gateway LiteLLM en entorno local, sin claves cloud inicialmente.
- Fase 3: conectar un proveedor cloud de prueba con límites y facturación desactivada o controlada.
- Fase 4: probar fallbacks y recuperación ante 429/5xx.
- Fase 5: integrar un proyecto piloto no sensible (Semillitas).
- Fase 6: endurecimiento, auditoría y evaluación por separado para Cybersecurity/Ojo de Dios.

## No incluido todavía
No se han creado servicios, claves, contenedores, despliegues ni automatizaciones. Este documento define el diseño a validar.
