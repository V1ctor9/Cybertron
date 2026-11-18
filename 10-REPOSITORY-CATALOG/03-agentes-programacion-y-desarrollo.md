# Agentes, programación y desarrollo

| Proyecto | Repositorio | Uso | Nota |
|---|---|---|---|
| OpenHands | https://github.com/All-Hands-AI/OpenHands | Agente de desarrollo que trabaja en entornos controlados | Prioridad para evaluar con sandbox |
| OpenCode | https://github.com/anomalyco/opencode | Agente de programación en terminal | Candidato destacado; fijar versión |
| Cline | https://github.com/cline/cline | Agente de programación en IDE | Revisar permisos de terminal/archivos |
| Aider | https://github.com/Aider-AI/aider | Programación asistida desde terminal | Útil con modelos locales o APIs compatibles |
| Continue | https://github.com/continuedev/continue | Asistente/agente para IDE | Verificar mantenimiento y estado del proyecto antes de adoptar |
| Gemini CLI | https://github.com/google-gemini/gemini-cli | Agente de terminal oficial de Google | Requiere considerar condiciones del servicio Gemini |
| Claude Code | https://github.com/anthropics/claude-code | Herramienta de programación de Anthropic | Código público; modelo Claude no es abierto |
| Microsoft Agent Framework | https://github.com/microsoft/agent-framework | Construcción/orquestación de agentes | Evaluar madurez y compatibilidad |
| AutoGen | https://github.com/microsoft/autogen | Sistemas multiagente | Proyecto de Microsoft |
| Semantic Kernel | https://github.com/microsoft/semantic-kernel | SDK de orquestación e integración | Alternativa para aplicaciones .NET/Python/Java |
| smolagents | https://github.com/huggingface/smolagents | Agentes ligeros | Adecuado para prototipos |
| Browser Use | https://github.com/browser-use/browser-use | Automatización de navegador por agentes | Solo cuentas y sitios autorizados |

## Seguridad de agentes
- Ejecutar en contenedor/VM con usuario sin privilegios.
- Restringir carpetas y comandos permitidos.
- No entregar tokens personales ni credenciales de producción.
- Exigir confirmación humana para borrar, publicar, comprar, enviar mensajes o desplegar.
- Registrar cambios y mantener copias de seguridad.
- Para Cybertron, restringir el agente GitHub al repositorio autorizado y a ramas de trabajo.

## Primeras pruebas sugeridas
1. OpenCode o Aider en un proyecto de prueba.
2. OpenHands en sandbox aislado.
3. Comparar modelos locales pequeños y APIs gratuitas con datos ficticios.
4. Medir correcciones correctas, errores, consumo y coste.
