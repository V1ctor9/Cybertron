# Inferencia y modelos locales

Herramientas para ejecutar modelos en equipos propios, laboratorio local o servidores.

| Proyecto | Repositorio | Utilidad | Nota inicial |
|---|---|---|---|
| Ollama | https://github.com/ollama/ollama | Descargar, administrar y servir modelos localmente | Prioridad alta para laboratorio inicial |
| llama.cpp | https://github.com/ggml-org/llama.cpp | Inferencia eficiente y cuantización GGUF | Útil en CPU y equipos modestos |
| Open WebUI | https://github.com/open-webui/open-webui | Interfaz web para modelos locales y APIs | Revisar licencia y configuración de acceso |
| vLLM | https://github.com/vllm-project/vllm | Servir modelos con alto rendimiento | Más apropiado para servidor con GPU |
| LocalAI | https://github.com/mudler/LocalAI | API local compatible con múltiples tareas/modelos | Evaluar compatibilidad y consumo |
| LiteLLM | https://github.com/BerriAI/litellm | Gateway y enrutamiento entre proveedores/modelos | Candidato central para AI Manager; revisar edición/licencia |
| Hugging Face Transformers | https://github.com/huggingface/transformers | Cargar, entrenar y evaluar modelos | Biblioteca base |
| SGLang | https://github.com/sgl-project/sglang | Servir modelos y cargas complejas | Para infraestructura más avanzada |
| MLX | https://github.com/ml-explore/mlx | ML optimizado para Apple Silicon | Solo si se incorpora hardware Apple |
| Jan | https://github.com/menloresearch/jan | Asistente de escritorio local | Evaluar privacidad, licencia y compatibilidad |

## Diseño preliminar del laboratorio
1. Ollama o llama.cpp para primeras pruebas locales.
2. Interfaz local protegida; no exponer puertos a Internet.
3. LiteLLM como candidato de gateway para combinar API y modelos propios.
4. Registro de uso, coste, latencia, errores y límites.
5. Política para no enviar datos sensibles a proveedores externos.
6. Pruebas con modelos pequeños cuantizados antes de escalar.

## Criterio de hardware
No fijar modelos recomendados hasta confirmar CPU, RAM disponible, GPU/VRAM y espacio libre. Las cuantizaciones reducen memoria, pero pueden afectar velocidad y calidad.
