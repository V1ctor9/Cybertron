# Automatización y agentes

Candidatos para Cybertron AI Manager, procesos internos y automatización audiovisual.

| Proyecto | Repositorio | Función | Nota |
|---|---|---|---|
| Activepieces | https://github.com/activepieces/activepieces | Automatización visual e integraciones | Revisar licencia por edición |
| Kestra | https://github.com/kestra-io/kestra | Orquestación de flujos y tareas | Buen candidato para procesos programados |
| n8n | https://github.com/n8n-io/n8n | Automatización con integraciones y nodos IA | Fair-code; no clasificar como OSI open source sin revisar licencia |
| Dify | https://github.com/langgenius/dify | Aplicaciones LLM, RAG y flujos de agentes | Revisar licencia y edición |
| Flowise | https://github.com/FlowiseAI/Flowise | Constructor visual de flujos LLM | Candidato para prototipos |
| Langflow | https://github.com/langflow-ai/langflow | Constructor visual de agentes y RAG | Candidato para laboratorio |
| CrewAI | https://github.com/crewAIInc/crewAI | Orquestación de agentes por roles | Revisar licencia y controles |
| PydanticAI | https://github.com/pydantic/pydantic-ai | Agentes tipados y validación de resultados | Útil para servicios Python |
| MCP Servers | https://github.com/modelcontextprotocol/servers | Servidores de herramientas para clientes MCP | Revisar cada servidor y sus permisos |
| ComfyUI | https://github.com/Comfy-Org/ComfyUI | Flujos visuales de generación de imagen | Modelos y checkpoints tienen licencias propias |

## Diseño para Cybertron AI Manager
- Registro de proveedores y modelos disponibles.
- Selección por tarea, coste, límites, privacidad y rendimiento.
- Enrutamiento local primero cuando sea viable.
- Fallback a otro modelo solo con consentimiento/política de datos compatible.
- Cuotas y presupuesto por proyecto.
- Reintentos limitados y prevención de bucles.
- Registro de decisiones, latencia, errores y consumo.
- Aprobación humana para acciones externas.

## Make
Make sigue siendo útil para el flujo actual de Semillitas. Estas herramientas son alternativas o complementos; no migrar por moda. Comparar coste real, operaciones, límites gratuitos y facilidad de mantenimiento.
