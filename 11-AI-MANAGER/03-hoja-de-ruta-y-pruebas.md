# Hoja de ruta y pruebas de Cybertron AI Manager

## Fase 0 — inventario antes de instalar
Solicitar/confirmar: sistema operativo, CPU exacta, RAM real, GPU y VRAM, espacio libre, virtualización disponible y conexión. El dato previo de aproximadamente 11 GB RAM no basta para elegir modelo.

## Fase 1 — banco local
- Instalar Ollama desde su fuente oficial o evaluar llama.cpp.
- Descargar un modelo pequeño cuantizado con licencia compatible.
- Probar 1B–3B primero; probar 7B/8B solo si RAM/VRAM y velocidad lo permiten.
- Medir tiempo al primer token, tokens/s, RAM/VRAM, temperatura y calidad en tareas de español.
- No abrir el puerto del servicio a Internet.

## Fase 2 — gateway
- Desplegar LiteLLM Proxy en local, idealmente mediante contenedor si el equipo lo soporta.
- Conectar únicamente Ollama al principio.
- Definir alias estables (por ejemplo, cybertron-local-general y cybertron-local-code).
- Configurar autenticación local, límites y logs minimizados.

## Fase 3 — primer proveedor cloud
- Elegir Gemini API o Groq para pruebas T0/T1 tras verificar cuenta, límites y términos.
- Crear clave con permisos mínimos y guardarla fuera del repositorio.
- Establecer límites de gasto y alertas; si no se puede garantizar gasto cero, no habilitar facturación.
- Verificar política de uso de datos y región.

## Fase 4 — fallback
- Simular 429, 500, timeout y modelo no disponible.
- Verificar Retry-After, reintentos acotados y cooldown.
- Fallback solo a destinos autorizados y de coste cero cuando ese sea el objetivo.
- Cuando todos fallen, devolver error claro o poner en cola; no activar un proveedor de pago.

## Fase 5 — piloto Semillitas
- Tareas: ideas, estructura de guion, narración, descripción y prompts visuales.
- Mantener revisión humana de exactitud bíblica, lenguaje infantil y derechos de imágenes/audio.
- No usar el piloto para datos confidenciales.
- Medir coste, consistencia del JSON, calidad en español y continuidad de personajes.

## Fase 6 — expansión controlada
- Cybersecurity: laboratorio aislado y datos sintéticos inicialmente.
- Ojo de Dios: datos abiertos/públicos y procesamiento geoespacial; revisar permisos y sensibilidad antes de cualquier nube.
- Atlas: análisis técnico y científico con fuentes citadas; no delegar cálculos críticos sin validación.
- Data Center: evaluación posterior de capacidad, redundancia, seguridad y operación.

## Pruebas mínimas reproducibles
1. Prompt de clasificación de tarea T0/T1/T2/T3.
2. Generación de JSON válido en español.
3. Solicitud repetida con proveedor primario caído.
4. Respuesta 429 con Retry-After.
5. Prueba de presupuesto agotado.
6. Prueba de bloqueo de datos T2/T3 en proveedor público.
7. Escaneo del repositorio para detectar secretos antes de cada commit.
8. Revisión de licencia de cada modelo y componente.

## Entregable de cada fase
Guardar configuración de ejemplo sin secretos, resultados de pruebas, versiones, licencias, limitaciones y decisión de continuar/no continuar. Ninguna fase se considera terminada solo por instalar un programa.
