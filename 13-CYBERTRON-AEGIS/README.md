# CYBERTRON AEGIS
**Autonomous Evaluation, Guardrails, Intelligence & Security**

> Detectar. Comprender. Proteger. Verificar.

Cybertron Aegis es una plataforma defensiva de ciberseguridad asistida por IA, diseñada para evaluar activos propios o expresamente autorizados, priorizar vulnerabilidades, proponer remediaciones y verificar que los controles funcionan.

## Objetivo
Construir una alternativa defensiva, auditable y segura inspirada en la arquitectura multiagente de frameworks como ARTEX, sin copiar código retirado, ejecutar forks no verificados ni convertir el sistema en una herramienta de intrusión autónoma.

## Principios no negociables
1. **Autorización verificable:** cada evaluación requiere propietario, alcance, ventana temporal y autorización registrada.
2. **Defensa primero:** no hay explotación contra terceros, persistencia, movimiento lateral, robo de credenciales ni exfiltración.
3. **Mínimo privilegio:** agentes y herramientas reciben permisos temporales y limitados al activo aprobado.
4. **Sandbox:** pruebas activas se ejecutan en laboratorio aislado o entorno de staging; producción comienza en modo pasivo.
5. **Humano en el circuito:** cambios, bloqueos, pruebas de impacto y remediaciones requieren aprobación según riesgo.
6. **Trazabilidad:** registrar quién autorizó, qué se evaluó, herramientas/versiones, hallazgos, evidencia y resultado de retest.
7. **Privacidad:** minimizar datos, redactar secretos y definir retención antes de cualquier piloto.
8. **Reproducibilidad:** cada hallazgo debe tener evidencia suficiente y pasos seguros de validación.
9. **Fail-safe:** ante pérdida de control, alcance ambiguo o fallo del guardrail, detener la tarea.
10. **Licencias y cadena de suministro:** revisar licencia, procedencia, releases, hashes, dependencias e imágenes antes de integrar.

## Capacidades previstas
- Inventario y descubrimiento pasivo de activos autorizados.
- Análisis de vulnerabilidades con herramientas reconocidas.
- Análisis de código, dependencias, contenedores y configuración cloud.
- Correlación y priorización contextual de hallazgos.
- Orquestación multiagente con tareas pequeñas, permisos explícitos y límites.
- Generación de planes de corrección y cambios revisables.
- Verificación posterior de la corrección mediante pruebas seguras.
- AI Security Gateway para proteger modelos, agentes, herramientas y datos.
- Panel de auditoría, evidencias y reportes para clientes.

## Arquitectura inicial
- **Control plane:** API, identidad, RBAC, autorización, políticas y cola de trabajos.
- **Scope Registry:** activos, propietarios, límites, exclusiones y ventanas aprobadas.
- **Orchestrator:** máquina de estados determinista; el LLM propone, el motor de políticas decide.
- **Agentes especializados:** inventario, código/dependencias, configuración, detección, remediación asistida y verificación.
- **Tool Gateway:** allowlist de herramientas, argumentos validados, cuotas, timeout y aislamiento.
- **Execution workers:** contenedores efímeros sin privilegios, red restringida y filesystem temporal.
- **Evidence Store:** resultados minimizados, hashes, timestamps, versiones y cadena de custodia.
- **AI Security Gateway:** controles de prompt injection, DLP, autorización de herramientas y validación de salida.
- **Human Approval UI:** revisión de hallazgos, cambios y acciones de riesgo.
- **Reporting:** informe técnico y ejecutivo con severidad, evidencia, corrección y retest.

## Stack candidato (sujeto a evaluación)
- Python + FastAPI para servicios iniciales.
- PostgreSQL para inventario, autorizaciones y estados.
- Redis/Celery o alternativa equivalente para trabajos; validar necesidad antes de añadir componentes.
- Docker/Podman rootless para workers; evaluar gVisor/Kata para aislamiento reforzado.
- Ollama para modelos locales y LiteLLM como capa de enrutamiento, bajo políticas de datos.
- Wazuh, Greenbone CE, Semgrep, Trivy, Syft, Grype, OSV-Scanner, Gitleaks, Nuclei en modo controlado, según alcance y licencias.
- OpenTelemetry para telemetría, con redacción de datos sensibles.

No se declara ninguna herramienta instalada, desplegada, certificada ni validada en producción por el hecho de aparecer en este diseño.

## Fases
1. Gobierno, requisitos, modelo de amenazas y registro de autorización.
2. MVP sin escaneo activo: inventario manual, análisis de repositorios propios y dependencias.
3. Integración de escáneres en laboratorio con límites y evidencias.
4. Correlación multiagente y priorización explicable.
5. Remediación mediante propuestas/diffs y aprobación humana.
6. Retest automatizado, reporting y piloto controlado.
7. Gateway de seguridad para IA y despliegue institucional.

## Criterios de aceptación del MVP
- Rechaza cualquier tarea sin autorización y alcance válido.
- No puede invocar herramientas fuera de allowlist.
- Cada ejecución tiene límites de tiempo, recursos, red y número de solicitudes.
- Un fallo del control plane detiene los workers.
- Hallazgos incluyen fuente, evidencia, confianza y limitaciones.
- Las correcciones no se aplican sin aprobación.
- El retest demuestra el estado posterior sin afirmar seguridad absoluta.
- Pruebas automatizadas verifican controles y escenarios de abuso.

## Alcance legal y operativo
Cybertron Aegis solo se utilizará sobre infraestructura propia, laboratorio o activos cubiertos por autorización escrita. Antes de prestar servicios a entidades públicas o privadas se definirán contrato, alcance, reglas de enfrentamiento, tratamiento de datos, conservación de evidencias, notificación de incidentes y revisión jurídica colombiana.

## Estado
**Diseño y documentación inicial.** No es todavía un producto funcional. Los siguientes hitos deben producir código, pruebas y evidencias verificables en ramas separadas.
