# Plataformas de IA en la nube

Inventario de servicios alojados que permiten probar modelos, consumir APIs, ejecutar notebooks o desplegar aplicaciones sin administrar toda la infraestructura. Los planes, cuotas y disponibilidad cambian: confirmar siempre la página oficial antes de integrar.

## A. Catálogos de modelos y APIs alojadas

| Plataforma | Sitio / documentación | Qué ofrece | Tipo de coste / cautela |
|---|---|---|---|
| Hugging Face Inference Providers | https://huggingface.co/docs/inference-providers | API unificada para modelos de distintos proveedores; catálogo de texto, visión, audio y otras tareas | Pago por uso y créditos según plan; no asumir API ilimitada gratis |
| GroqCloud | https://console.groq.com/docs/overview | Inferencia rápida de modelos disponibles mediante API | Puede tener nivel gratuito con límites por modelo/cuenta; verificar rate limits actuales |
| Google Gemini API | https://ai.google.dev/gemini-api/docs | Modelos Gemini por API y herramientas de desarrollo | Algunos modelos/uso tienen nivel gratuito sujeto a disponibilidad, límites y condiciones |
| Cloudflare Workers AI | https://developers.cloudflare.com/workers-ai/ | Inferencia serverless de modelos del catálogo desde Workers/API | Cuota gratuita limitada y facturación/Neuronas según plan |
| OpenRouter | https://openrouter.ai/docs | API unificada a numerosos modelos y proveedores, incluidos modelos con rutas gratuitas cuando estén disponibles | Rutas free sujetas a límites, disponibilidad y cambios |
| Cerebras Inference | https://inference-docs.cerebras.ai/ | Inferencia alojada de modelos compatibles | Revisar cuota gratuita, límites y disponibilidad regional |
| Together AI | https://docs.together.ai/ | APIs para inferencia y herramientas de modelos | Normalmente uso medido; comprobar créditos vigentes |
| Fireworks AI | https://docs.fireworks.ai/ | Inferencia alojada y despliegue de modelos | Uso medido y condiciones por modelo |
| DeepInfra | https://deepinfra.com/docs | APIs alojadas para modelos abiertos | Uso medido; comprobar precios y privacidad |
| Replicate | https://replicate.com/docs | Ejecutar modelos mediante API y despliegues | Pago por uso; no considerarlo alojamiento gratuito permanente |
| Novita AI | https://novita.ai/docs | APIs de modelos y generación multimedia | Revisar tarifas, créditos y licencia del modelo |
| Fal.ai | https://fal.ai/docs | APIs de generación de imagen, vídeo y audio | Normalmente facturación por uso |
| NVIDIA NIM | https://build.nvidia.com/ | Catálogo de microservicios/modelos y despliegue acelerado | Distinguir pruebas/servicios alojados de despliegue empresarial; revisar términos |
| AWS Bedrock | https://docs.aws.amazon.com/bedrock/ | Modelos de varios proveedores como servicio gestionado | Servicio comercial; verificar créditos y tarifas regionales |
| Azure AI Foundry | https://learn.microsoft.com/azure/ai-foundry/ | Catálogo, evaluación y despliegue de modelos | Servicios y cuotas sujetos a facturación |
| Vertex AI | https://cloud.google.com/vertex-ai/docs | Modelos y herramientas de IA gestionadas por Google Cloud | Servicio comercial; revisar créditos y costes |
| Mistral La Plateforme | https://docs.mistral.ai/ | API de modelos Mistral | Planes y límites según cuenta |
| Cohere Platform | https://docs.cohere.com/ | APIs de generación, embeddings y reranking | Planes y cuotas según cuenta |

## B. Nube para experimentar, entrenar y alojar demos

| Plataforma | Sitio | Uso principal | Límite estructural |
|---|---|---|---|
| Google Colab | https://colab.research.google.com/ | Notebooks y experimentos con CPU/GPU/TPU según disponibilidad | Sesiones temporales; GPU no garantizada |
| Kaggle Notebooks | https://www.kaggle.com/code | Notebooks, datasets y competiciones con cuota de acelerador | Cuotas y sesiones temporales |
| Hugging Face Spaces | https://huggingface.co/spaces | Demos y aplicaciones Gradio/Streamlit/Docker | CPU gratuito limitado; GPU/ZeroGPU con condiciones y cuota |
| Lightning AI | https://lightning.ai/ | Entornos de desarrollo y cómputo acelerado | Créditos y límites del plan |
| Modal | https://modal.com/ | Funciones serverless, tareas y endpoints GPU | Créditos iniciales/plan; revisar medio de pago y sobrecostes |
| Streamlit Community Cloud | https://streamlit.io/cloud | Publicar aplicaciones y dashboards | Recursos comunitarios limitados; no es un servidor GPU permanente |
| GitHub Codespaces | https://github.com/features/codespaces | Entorno de desarrollo en navegador | Cuota incluida según plan; no es plataforma de inferencia GPU |
| AWS SageMaker Studio Lab | https://studiolab.sagemaker.aws/ | Notebooks de aprendizaje y experimentación | Disponibilidad y recursos limitados |
| Intel Tiber AI Cloud | https://www.intel.com/content/www/us/en/developer/tools/oneapi/overview.html | Explorar hardware/software Intel para IA | Acceso y recursos según programa |
| Saturn Cloud | https://saturncloud.io/ | Notebooks y recursos de ciencia de datos | Planes y cuotas variables |

## C. Datos y almacenamiento en la nube
- Hugging Face Hub: https://huggingface.co/ — modelos, datasets, Spaces y almacenamiento.
- Kaggle Datasets: https://www.kaggle.com/datasets — datasets comunitarios; revisar licencias y condiciones.
- Google Dataset Search: https://datasetsearch.research.google.com/ — buscador de datasets, no repositorio con licencia uniforme.
- AWS Open Data Registry: https://registry.opendata.aws/ — conjuntos de datos alojados en AWS; revisar licencia de cada conjunto.
- Microsoft Planetary Computer: https://planetarycomputer.microsoft.com/ — datos geoespaciales y APIs para análisis ambiental.
- Copernicus Data Space: https://dataspace.copernicus.eu/ — acceso a datos Sentinel y servicios Copernicus.
- NASA Earthdata: https://www.earthdata.nasa.gov/ — datos de observación de la Tierra.
- Google Earth Engine: https://earthengine.google.com/ — plataforma geoespacial gestionada; revisar acceso, cuotas y condiciones.

## D. Estrategia de uso para Cybertron
1. Probar primero opciones locales cuando protejan datos y no requieran GPU costosa.
2. Usar cuotas gratuitas de nube para pruebas, benchmarks y prototipos no críticos.
3. Diseñar un adaptador común (por ejemplo, OpenAI-compatible cuando esté soportado) para cambiar de proveedor sin rehacer cada aplicación.
4. Registrar límites, latencia, región, política de retención, entrenamiento con datos, precio y condiciones.
5. No poner claves API en GitHub: usar secretos del entorno/gestor de secretos.
6. No enviar documentos privados, datos personales ni información de seguridad a APIs externas sin evaluación y autorización.
7. Para producción, calcular coste mensual y definir límites de gasto/alertas antes de habilitar tráfico.

## E. Estado de verificación
Este archivo es un mapa inicial de proveedores y documentación oficial. No declara que todas las cuentas tengan nivel gratuito activo en Colombia ni que todos los modelos estén disponibles en todas las regiones. Confirmar la página de precios, términos y consola de cada servicio antes de adoptarlo.
