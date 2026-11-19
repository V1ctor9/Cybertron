# ARTEX: expediente de inteligencia y decisión de integración defensiva

**Estado de investigación: 18 de noviembre de 2026**

## Identificación

La herramienta que mejor coincide con la descripción del proyecto es **ARTEX**, un framework de pruebas de penetración multiagente impulsado por LLM. No es un modelo de IA autónomo: coordina agentes, modelos externos y herramientas de seguridad existentes para planificar y ejecutar tareas de evaluación.

### Estado del proyecto original

- Publicado en GitHub en julio de 2026 por el desarrollador que usaba el alias Autumn-27.
- El 8 de octubre de 2026 el desarrollador anunció que dejaría de actualizarlo, no publicaría más versiones y lo convertiría en código cerrado tras informes de uso malicioso.
- Reuters confirmó que el repositorio original de GitHub fue retirado.
- Existen forks y derivados no oficiales. No equivalen a una versión confiable ni mantenida por el autor original.

Fuentes:
- Reuters, 9-oct-2026: https://www.reuters.com/world/china/chinese-developer-makes-artex-ai-agent-closed-source-after-korean-bank-hack-2026-10-09/
- Google Threat Intelligence Group, 30-oct-2026: https://cloud.google.com/blog/topics/threat-intelligence/artex-and-friends-enter-agentic-offensive-frameworks
- CERT-EU, 5-nov-2026: https://www.cert.europa.eu/blog/from-penetration-testing-to-cyber-threat-beware-of-artex
- Microsoft Security, 6-nov-2026: https://www.microsoft.com/en-us/security/blog/2026/11/06/artex-abuse-expands-as-cybercriminals-target-financial-sector/
- WIRED, 18-nov-2026: https://www.wired.com/story/artex-ai-hacking-tools/

## Capacidades a comprender (sin reproducir operaciones ofensivas)

Las fuentes describen una arquitectura multiagente que descompone objetivos en tareas, coordina agentes especializados y conecta modelos de IA con herramientas convencionales. Los informes de amenazas observan su abuso para reconocimiento, pruebas/explotación de servicios, movimiento dentro de entornos y preparación de extracción de datos.

Para Cybertron interesa estudiar esa arquitectura para entender la amenaza y construir pruebas defensivas autorizadas. No se debe importar un fork aleatorio ni desplegar un controlador ARTEX encontrado en Internet.

## Riesgo de cadena de suministro

- El repositorio original ya no proporciona una fuente upstream mantenida.
- Los forks pueden incluir modificaciones no revisadas.
- Se ha documentado una imagen Docker trojanizada asociada a un fork, capaz de proporcionar acceso root no autenticado dentro del contenedor y potencialmente al host según el despliegue.
- Un controlador de este tipo puede almacenar claves de API, objetivos, hallazgos y credenciales; su compromiso sería grave.

Fuente de investigación: Cloud Security Alliance / CSAI Foundation, nota del 16-nov-2026 (el propio documento declara que fue generado con asistencia de IA y no pasó el proceso oficial de aprobación de CSA; tratarlo como alerta secundaria, no como única evidencia):
https://labs.cloudsecurityalliance.org/wp-content/uploads/2026/11/CSA_research_note_trojanized_offensive_ai_tooling_20261106-csa-styled.pdf

## Decisión de Cybertron

**No incorporar ni ejecutar el código de ARTEX ni sus imágenes/forks no verificados en producción.** No descargar binarios de mirrors, no usar imágenes Docker de terceros y no conectar credenciales reales.

Sí integrar tres capacidades defensivas derivadas del análisis:

1. **Evaluador multiagente acotado:** orquestación de tareas de auditoría de activos propios o formalmente autorizados, con lista cerrada de objetivos y acciones permitidas.
2. **Motor de validación y remediación:** hallazgos vinculados a evidencia, CVE/CVSS cuando aplique, responsable, corrección, prueba y reescaneo.
3. **Detección de actividad agentic ofensiva:** correlación de ráfagas de solicitudes, escaneos, reintentos, enumeración, uso anómalo de herramientas, cambios de privilegios y actividad de identidad.

### Controles obligatorios del evaluador Cybertron

- Alcance firmado y allowlist de activos; denegar por defecto todo lo demás.
- Sandbox efímero y red aislada; sin rutas hacia activos de terceros.
- Sin explotación destructiva, persistencia, movimiento lateral ni extracción de datos.
- Sin secretos reales ni credenciales privilegiadas en el contexto del agente.
- Herramientas y comandos permitidos por política, parámetros validados y límites de tasa.
- Aprobación humana para cualquier prueba activa de impacto y para cambios de configuración.
- Registro de prompts, decisiones, comandos permitidos, resultados y aprobaciones, con redacción de datos sensibles.
- Parada de emergencia, límites de tiempo/recursos y reversión.
- Pruebas con aplicaciones deliberadamente vulnerables y datos sintéticos.

## Frameworks relacionados a evaluar como alternativas

Google Threat Intelligence Group confirmó actividad de amenazas que involucra ARTEX, Hexstrike, CAIRN, PentAGI y otros frameworks agentic. Esto no significa que todos estén retirados ni que todos sean confiables.

- **PentAGI:** https://github.com/vxcontrol/pentagi — proyecto público con arquitectura multiagente y ejecución de herramientas en sandboxes Kali Linux según la descripción de GTIG. Revisar licencia, releases, hardening, límites y dependencias antes de cualquier laboratorio.
- **Hexstrike AI:** https://github.com/0x4m4/hexstrike-ai — evaluar estado, mantenedores, licencia y seguridad de cada release; no confiar en mirrors.
- **CAIRN:** identificar repositorio oficial y procedencia antes de considerar su adopción. No usar forks sin verificación.
- **ARTEX:** upstream original retirado; solo tratarlo como inteligencia de amenazas y referencia arquitectónica.

Fuente primaria para la actividad observada y las descripciones de frameworks:
https://cloud.google.com/blog/topics/threat-intelligence/artex-and-friends-enter-agentic-offensive-frameworks

## Detecciones defensivas a construir

- Alertas por ráfagas de reconocimiento y múltiples solicitudes a servicios distintos.
- Detección de enumeración y patrones de reintento automatizado.
- Correlación de identidad, MFA, cambios de permisos y uso de credenciales de aplicaciones.
- Alertas por exposición de consolas de administración.
- Detección de uso anómalo de Nmap, curl, wget, clientes HTTP, Playwright/headless browsers y herramientas equivalentes, sin bloquearlos ciegamente por nombre de proceso.
- Integrar eventos con Wazuh, Suricata, Zeek y reglas Sigma.
- Crear honeypots y señuelos defensivos en redes propias, aislados de datos reales.
- Priorizar parches, MFA, reducción de superficie expuesta, rotación de secretos y mínimo privilegio.

Microsoft señala que los frameworks agentic pueden generar ráfagas de solicitudes y reintentar variaciones a gran velocidad; las señales de herramientas son útiles para alertar, pero pueden cambiarse y no deben ser la única defensa:
https://www.microsoft.com/en-us/security/blog/2026/11/06/artex-abuse-expands-as-cybercriminals-target-financial-sector/

CERT-EU recomienda reducir exposición de activos, proteger paneles de administración, priorizar parches, MFA, EDR, WAF y monitorización de actividad anómala:
https://www.cert.europa.eu/blog/from-penetration-testing-to-cyber-threat-beware-of-artex

## Siguiente fase de verificación

1. Verificar repositorios y licencias oficiales de PentAGI y Hexstrike.
2. Descargar únicamente desde repositorios upstream confirmados.
3. Revisar commits, releases, dependencias, imágenes, SBOM y avisos de seguridad.
4. Ejecutar análisis estático y de contenedores antes de compilar.
5. Desplegar en laboratorio aislado, sin credenciales ni conectividad a redes de producción.
6. Probar exclusivamente contra objetivos de laboratorio deliberadamente vulnerables.
7. Documentar resultados y decidir si se reutiliza una arquitectura, no necesariamente el software original.

**Conclusión:** ARTEX es la coincidencia más probable con la herramienta recordada. Cybertron debe estudiar su arquitectura y las técnicas de detección, pero no ejecutar copias no verificadas. La meta es construir una capacidad defensiva equivalente, limitada, auditable y segura.
