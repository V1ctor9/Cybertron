# Matriz inicial de proveedores y modelos

**Corte de consulta:** 18-11-2026. Las cuotas y catálogos cambian; volver a comprobar antes de integrar.

| Proveedor/herramienta | Papel | Nivel gratuito verificado/documentado | Integración | Riesgos y decisión |
|---|---|---|---|---|
| Google Gemini API | Modelo cloud general, análisis y generación | Existe free tier para modelos seleccionados; límites varían por modelo/proyecto. | API oficial; revisar SDK y límites por modelo. | En free tier el contenido puede usarse para mejorar productos según la página de precios. No enviar datos sensibles. **Candidato piloto Semillitas.** |
| GroqCloud | Inferencia cloud rápida de modelos disponibles | Tiene tier gratuito con límites por RPM/RPD/TPM/TPD; consultar el panel de la organización. | API de chat; revisar modelos disponibles y formato soportado. | No asumir cuota fija universal: depende del modelo/cuenta y puede cambiar. **Candidato secundario.** |
| OpenRouter | Gateway a varios proveedores/modelos | Variantes :free tienen $0 por token, pero límites publicados: 20 RPM y 50 RPD; otras condiciones pueden aplicar. | API unificada compatible con OpenAI para chat. | Capacidad compartida, modelos cambian y pueden fallar/limitarse. No enviar datos sensibles sin revisar proveedor final. **Candidato de experimentación.** |
| Hugging Face Inference Providers | Acceso a modelos y proveedores | La documentación consultada presenta condiciones de créditos distintas según fecha/plan; una versión indicaba $0.10 para Free y otra actualizada indicaba que Free no incluye créditos. Confirmar en cuenta antes de usar. | SDK/API unificada y claves de proveedor. | No presupuestar uso gratuito; pay-as-you-go disponible. **Catálogo y experimentación, no dependencia crítica.** |
| Cerebras Inference | Inferencia rápida de modelos abiertos | Oferta Developer anuncia $5 promocionales con método de pago válido, expiran a 30 días; no es gratis permanente. | API; revisar modelos/SDK actuales. | Evitar activar si el objetivo es cero gasto. **Opcional, no base gratuita.** |
| Ollama | Ejecución local de modelos | Sin cobro por token al ejecutar localmente; coste de hardware/energía propio. | API local y compatibilidad parcial OpenAI; endpoints propios. | Rendimiento depende de RAM/VRAM; mantener servicio ligado a localhost/red privada. **Base local prioritaria.** |
| llama.cpp | Inferencia local cuantizada | Software abierto; sin tarifa por inferencia local. | Servidor HTTP y formatos/modelos compatibles. | Requiere pruebas y configuración técnica; revisar licencia de cada modelo. **Alternativa local.** |
| LiteLLM | Proxy/router, no modelo | Software open source; infraestructura y operación corren por cuenta propia. | APIs unificadas, routing, retries, fallbacks, budgets. | Proteger panel y proxy; revisar cambios de licencia/edición y mantener actualizado. **Candidato de orquestación.** |
| GitHub Models | Inferencia de modelos desde GitHub | Servicio retirado el 30-07-2026. | Ya no disponible. | **Excluir de la arquitectura.** |

## Fuentes oficiales consultadas
- Gemini pricing: https://ai.google.dev/gemini-api/docs/pricing
- Groq rate limits: https://console.groq.com/docs/rate-limits
- Groq billing FAQ: https://console.groq.com/docs/billing-faqs
- OpenRouter free models: https://openrouter.ai/collections/free-models
- Hugging Face pricing: https://huggingface.co/docs/inference-providers/pricing
- Hugging Face inference providers: https://huggingface.co/docs/hub/models-inference
- Cerebras pricing: https://www.cerebras.ai/pricing
- Ollama API: https://docs.ollama.com/api
- LiteLLM fallbacks: https://docs.litellm.ai/docs/router/learn/reliability
- LiteLLM budgets: https://docs.litellm.ai/docs/proxy/users
- GitHub Models retirement: https://github.blog/changelog/2026-07-01-github-models-is-being-fully-retired-on-july-30-2026/

## Reglas para declarar una opción gratuita
1. Diferenciar gratis permanente, crédito promocional, prueba temporal, cuota limitada y código abierto autoalojado.
2. Registrar fecha, región, método de pago requerido, expiración, límites y política de datos.
3. Comprobar límites reales de la cuenta; la tabla pública puede ser orientativa.
4. No habilitar fallback hacia un proveedor de pago si no existe presupuesto y autorización explícitos.
5. No tratar un modelo con pesos abiertos como servicio de inferencia gratuito.
