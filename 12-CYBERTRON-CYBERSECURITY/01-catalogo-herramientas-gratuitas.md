# Catálogo inicial de herramientas gratuitas y abiertas

**Regla:** “gratuito”, “open source”, “open weights” y “free tier” no son sinónimos. Antes de adoptar una herramienta se debe revisar el archivo LICENSE, licencias de modelos y datasets, dependencias, actividad de mantenimiento, vulnerabilidades conocidas, telemetría, requisitos de hardware y límites de uso comercial.

## SOC, SIEM y detección de red

| Herramienta | Uso principal | Fuente |
|---|---|---|
| Wazuh | SIEM/XDR, agentes, eventos y detección | https://github.com/wazuh/wazuh |
| Suricata | IDS/IPS de red | https://github.com/OISF/suricata |
| Zeek | Análisis de tráfico y protocolos | https://github.com/zeek/zeek |
| Falco | Detección de comportamiento en hosts/contenedores | https://github.com/falcosecurity/falco |
| Security Onion | Distribución/plataforma de monitoreo; revisar componentes y recursos | https://github.com/Security-Onion-Solutions/securityonion |
| Sigma | Formato de reglas de detección | https://github.com/SigmaHQ/sigma |
| MISP | Inteligencia de amenazas | https://github.com/MISP/MISP |

## Vulnerabilidades, código y cadena de suministro

| Herramienta | Uso principal | Fuente |
|---|---|---|
| Greenbone Community Edition | Escaneo de vulnerabilidades | https://github.com/greenbone |
| Nuclei | Escaneo basado en plantillas; usar solo con alcance autorizado | https://github.com/projectdiscovery/nuclei |
| Semgrep | Análisis estático de código | https://github.com/semgrep/semgrep |
| Trivy | Vulnerabilidades, contenedores y configuraciones | https://github.com/aquasecurity/trivy |
| Grype | Vulnerabilidades en imágenes y artefactos | https://github.com/anchore/grype |
| Syft | Inventario SBOM | https://github.com/anchore/syft |
| OSV-Scanner | Dependencias vulnerables | https://github.com/google/osv-scanner |
| Gitleaks | Secretos en repositorios | https://github.com/gitleaks/gitleaks |
| Dependency-Track | Gestión de riesgo de componentes/SBOM | https://github.com/DependencyTrack/dependency-track |
| Checkov | Análisis de infraestructura como código | https://github.com/bridgecrewio/checkov |
| OpenSSF Scorecard | Señales de seguridad de proyectos open source | https://github.com/ossf/scorecard |

## Respuesta a incidentes y análisis forense

| Herramienta | Uso principal | Fuente |
|---|---|---|
| Velociraptor | DFIR y recolección en endpoints | https://github.com/Velocidex/velociraptor |
| TheHive | Gestión de casos; verificar edición y licencia | https://github.com/TheHive-Project |
| Cortex | Analizadores y respondedores; verificar edición/licencia | https://github.com/TheHive-Project/Cortex |
| YARA | Reglas de identificación de archivos | https://github.com/VirusTotal/yara |
| osquery | Consultas de estado de endpoints | https://github.com/osquery/osquery |
| Autopsy | Análisis forense digital | https://github.com/sleuthkit/autopsy |
| Plaso | Línea de tiempo forense | https://github.com/log2timeline/plaso |

## Protección específica de aplicaciones de IA

| Herramienta | Función | Consideraciones |
|---|---|---|
| Meta LlamaFirewall / PurpleLlama | PromptGuard, controles de alineación de agentes y análisis de código inseguro | Código y modelos/componentes pueden tener licencias distintas; revisar por separado |
| NVIDIA NeMo Guardrails | Reglas programables para conversaciones y aplicaciones LLM | Apache 2.0 en el proyecto principal; revisar dependencias |
| LLM Guard | Escáneres de entrada/salida, PII y prompt injection | Verificar estado de mantenimiento y licencia en adopción |
| Guardrails AI | Validación de entradas y salidas | Revisar validadores y licencias individuales |
| Promptfoo | Pruebas de seguridad, evaluación y red teaming LLM | Las pruebas deben ejecutarse en sistemas propios o autorizados |
| Microsoft PyRIT | Automatización de evaluación adversarial de IA | Framework de pruebas, no firewall de producción |
| DeepTeam | Red teaming de sistemas LLM | Verificar licencia, mantenimiento y compatibilidad |
| Snyk Agent Scan / MCP-Scan | Análisis de agentes, servidores MCP y skills | Revisar licencia y versión exactas |
| Invariant Guardrails | Políticas y control de llamadas/herramientas de agentes | Revisar licencia y compatibilidad |
| IBM Granite Guardian | Clasificación de riesgos y seguridad de contenido | Licencia de cada modelo y requisitos de despliegue |

Repositorios y documentación:
- LlamaFirewall: https://github.com/meta-llama/PurpleLlama/tree/main/LlamaFirewall
- PurpleLlama: https://github.com/meta-llama/PurpleLlama
- NeMo Guardrails: https://github.com/NVIDIA/NeMo-Guardrails
- LLM Guard: https://github.com/protectai/llm-guard
- Guardrails AI: https://github.com/guardrails-ai/guardrails
- Promptfoo: https://github.com/promptfoo/promptfoo
- PyRIT: https://github.com/Azure/PyRIT
- DeepTeam: https://github.com/confident-ai/deepteam
- Invariant: https://github.com/invariantlabs-ai/invariant
- Granite Guardian: https://github.com/ibm-granite/granite-guardian

## Marcos, taxonomías y conjuntos de pruebas

- OWASP Top 10 for LLM Applications: https://owasp.org/projects/top-10-for-large-language-model-applications/
- MITRE ATLAS: https://atlas.mitre.org/
- NIST AI Risk Management Framework: https://www.nist.gov/itl/ai-risk-management-framework
- NIST AI 600-1 Generative AI Profile: https://doi.org/10.6028/NIST.AI.600-1
- NIST Cybersecurity Framework 2.0: https://www.nist.gov/cyberframework

## Precauciones de selección

1. Revisar licencia del código, modelos, pesos, datos de entrenamiento y dependencias por separado.
2. Revisar fecha de última versión, issues, CVE, mantenedores y proceso de divulgación responsable.
3. Probar primero sin acceso a producción.
4. No dar acceso de administrador a agentes IA.
5. No asumir que un escáner detecta todas las vulnerabilidades.
6. No confiar en una única defensa contra prompt injection: combinar filtros con aislamiento y control de permisos.
7. No instalar software de fuentes no oficiales ni descargar binarios sin verificar procedencia e integridad.
