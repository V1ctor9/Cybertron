# Modelos y repositorios oficiales de IA

Este inventario separa **código oficial**, **modelos/pesos** y **servicios cerrados**. La presencia en esta lista no garantiza que cada modelo sea open source en sentido estricto; comprobar la licencia exacta de cada versión antes de uso comercial.

## Proveedores y repositorios oficiales prioritarios

| Proveedor | Repositorio | Qué aporta | Clasificación inicial |
|---|---|---|---|
| OpenAI | https://github.com/openai/gpt-oss | Modelos gpt-oss y recursos oficiales asociados | Pesos/modelos abiertos; comprobar licencia y ficha de cada versión |
| OpenAI | https://github.com/openai/whisper | Reconocimiento automático de voz | Código y modelos publicados; revisar licencia de pesos y uso |
| OpenAI | https://github.com/openai/openai-cookbook | Ejemplos oficiales para APIs, herramientas, RAG y evaluación | Código de ejemplos; no abre los modelos/API |
| Google DeepMind | https://github.com/google-deepmind/gemma | Recursos oficiales de la familia Gemma | Modelos con condiciones propias por versión |
| Google | https://github.com/google-gemini/gemini-cli | Agente de terminal para trabajar con Gemini | Código abierto; el modelo/servicio Gemini sigue sujeto a sus condiciones |
| Google | https://github.com/google-research/t5x | Código de investigación/entrenamiento T5X | Código; comprobar disponibilidad/licencia de cada checkpoint |
| Microsoft | https://github.com/microsoft/AutoGen | Framework de agentes multiagente | Código abierto |
| Microsoft | https://github.com/microsoft/semantic-kernel | SDK para integrar modelos y agentes en aplicaciones | Código abierto |
| Microsoft | https://github.com/microsoft/Phi-3CookBook | Material y ejemplos de la familia Phi-3 | Documentación y ejemplos; licencia del modelo por versión |
| Meta | https://github.com/meta-llama/llama-models | Recursos oficiales de modelos Llama | Pesos con licencia/comunidad y condiciones específicas |
| Meta | https://github.com/facebookresearch/llama | Código de investigación Llama | Código y acceso a modelos según condiciones aplicables |
| Alibaba / Qwen | https://github.com/QwenLM/Qwen3 | Modelos y recursos Qwen3 | Pesos y código publicados; revisar licencia por modelo |
| Alibaba / Qwen | https://github.com/QwenLM/Qwen2.5-Coder | Modelos especializados en programación | Revisar licencia de cada checkpoint |
| DeepSeek | https://github.com/deepseek-ai/DeepSeek-R1 | Modelo de razonamiento y recursos oficiales | Pesos/código publicados; confirmar licencia del artefacto |
| DeepSeek | https://github.com/deepseek-ai/DeepSeek-V3 | Modelo de lenguaje y recursos | Revisar licencia, tamaño y requisitos |
| Mistral AI | https://github.com/mistralai/mistral-inference | Inferencia de modelos Mistral | Código; licencia del modelo por separado |
| NVIDIA | https://github.com/NVIDIA/NeMo | Entrenamiento, personalización e inferencia | Código abierto; revisar componentes y modelos |
| NVIDIA | https://github.com/NVIDIA/TensorRT-LLM | Optimización e inferencia en GPU NVIDIA | Código; hardware NVIDIA requerido para su principal ventaja |
| Allen Institute for AI | https://github.com/allenai/OLMo | Modelos, código y recursos de investigación abiertos | Candidato de alta prioridad para apertura integral |
| Hugging Face | https://github.com/huggingface/transformers | Biblioteca para cargar y entrenar numerosos modelos | Código Apache-2.0; licencia del modelo independiente |

## Repositorios oficiales de Anthropic y xAI: lectura cuidadosa
- https://github.com/anthropics/skills — colección de ejemplos de habilidades/agentes; revisar licencia y alcance.
- https://github.com/anthropics/claude-code — herramienta de programación con código publicado; esto no convierte los modelos Claude en abiertos.
- https://github.com/xai-org/grok-1 — publicación de un modelo/pesos; comprobar tamaño, licencia y requisitos antes de considerarlo viable.

## Modelos a investigar por familias
- OpenAI: gpt-oss.
- Google: Gemma y T5.
- Microsoft: Phi.
- Meta: Llama.
- Alibaba: Qwen y Qwen-Coder.
- DeepSeek: R1, V3 y variantes coder.
- Mistral: modelos abiertos y variantes de código.
- NVIDIA: Nemotron y recursos NeMo.
- Allen AI: OLMo.
- BigScience / EleutherAI: BLOOM, Pythia y familias de investigación.
- Moonshot AI / Kimi: comprobar qué versiones tienen pesos publicados y qué términos aplican; no asumir que la app/API Kimi es abierta.

## Para Cybertron AI Manager
Crear una matriz por tarea: conversación general, programación, razonamiento, visión, voz, embeddings, clasificación, agente y extracción documental. Seleccionar modelo por calidad, licencia, latencia, RAM/VRAM, privacidad y coste. Añadir fallback entre proveedores solo si las condiciones de datos y API lo permiten.

## Advertencia de recursos
Los modelos grandes pueden requerir GPU y mucha memoria. Para el equipo local de Cybertron, priorizar pruebas cuantizadas pequeñas y medir rendimiento antes de descargar modelos de decenas o cientos de GB.
