# Cybertron Cybersecurity

**Propósito:** construir capacidades defensivas para Cybertron y, mediante contratos, autorizaciones y controles institucionales, prestar servicios de ciberseguridad a entidades públicas y privadas colombianas.

## Misión operativa

1. Descubrir vulnerabilidades en activos incluidos en un alcance autorizado.
2. Priorizar riesgos por criticidad, exposición, explotabilidad e impacto.
3. Corregir o coordinar la corrección, validar el parche y documentar evidencia.
4. Detectar intrusiones y comportamientos anómalos.
5. Responder a incidentes, preservar evidencia y recuperar servicios.
6. Proteger aplicaciones, modelos, datos y agentes de IA frente a abuso y compromiso.

No es un proyecto de intrusión contra terceros. Todo escaneo activo, prueba de penetración, bloqueo o respuesta en redes de clientes requiere autorización documentada, alcance, ventanas, reglas de compromiso y contacto de emergencia.

## Arquitectura propuesta

### 1. Laboratorio local
- Hipervisor y redes virtuales aisladas.
- Sistemas de prueba deliberadamente vulnerables, sin exposición a Internet.
- Repositorio de evidencias, snapshots y restauración.
- Segmentación entre laboratorio, gestión y producción.

### 2. Visibilidad y detección
- Wazuh: SIEM/XDR y telemetría de endpoints.
- Suricata: IDS/IPS de red.
- Zeek: análisis de protocolos y actividad de red.
- Falco: detección de comportamiento en Linux y contenedores.
- MISP: intercambio y gestión de inteligencia de amenazas (validar fuentes y condiciones de uso).

### 3. Gestión de vulnerabilidades y reparación
- Greenbone Community Edition: escaneo de vulnerabilidades.
- Semgrep: análisis estático de código.
- Trivy y Grype: imágenes, dependencias y artefactos.
- OSV-Scanner: dependencias vulnerables.
- Gitleaks: secretos expuestos.
- Syft: SBOM.
- DefectDojo: centralización y seguimiento de hallazgos (validar edición/licencia actual).
- Flujo: detectar → validar → priorizar → asignar → corregir → probar → volver a escanear → cerrar con evidencia.

### 4. Respuesta e investigación
- Velociraptor: recolección y análisis forense en endpoints autorizados.
- TheHive/Cortex: casos y enriquecimiento, sujeto a revisión de edición y licencia.
- Sigma: reglas de detección portables.
- YARA: clasificación y búsqueda de artefactos.
- Playbooks documentados con aprobación humana para acciones disruptivas.

### 5. Seguridad de IA
- LlamaFirewall / PurpleLlama: controles para prompt injection, desalineación de agentes y código inseguro; revisar licencias separadas de modelos y subcomponentes.
- NVIDIA NeMo Guardrails: políticas programables de entrada, diálogo, recuperación y salida.
- LLM Guard: escaneo de entradas/salidas y datos sensibles; comprobar mantenimiento y licencia en la fecha de adopción.
- Guardrails AI: validación de entradas y salidas.
- Promptfoo: pruebas de seguridad y red teaming de aplicaciones LLM.
- Microsoft PyRIT: evaluación adversarial autorizada de sistemas de IA.
- Snyk Agent Scan / MCP-Scan: inventario y evaluación de riesgos en agentes, servidores MCP y skills; comprobar licencia y versión.
- NIST AI RMF, NIST AI 600-1, OWASP Top 10 for LLM Applications y MITRE ATLAS como marcos de referencia.

### 6. Gobierno, auditoría y privacidad
- Inventario de activos y sistemas de IA.
- Clasificación de datos y evaluación de impacto.
- Registro inmutable o protegido de hallazgos, decisiones y cambios.
- Gestión de identidades, MFA, mínimo privilegio y separación de funciones.
- Retención limitada, cifrado y redacción de secretos y datos personales.
- Reportes ejecutivos y técnicos diferenciados.
- Supervisión humana obligatoria para aislar equipos, bloquear cuentas, cambiar reglas de red o afectar servicios esenciales.

## Diseño de barreras para IA (AI Security Gateway)

Ubicar una capa de control entre usuarios/agentes y modelos/herramientas:

1. Autenticación, autorización y cuotas por identidad.
2. Clasificación de datos antes de enviarlos a un modelo.
3. Detección de prompt injection y contenido no confiable.
4. Control de herramientas: lista permitida, parámetros validados, permisos mínimos.
5. Prevención de exfiltración de datos y secretos.
6. Validación de salidas antes de ejecutarlas o mostrarlas.
7. Registro de trazas con minimización de datos.
8. Interruptor de emergencia y degradación segura.
9. Pruebas periódicas contra evasiones y falsos positivos.

**Límite técnico:** ningún filtro garantiza bloquear todos los ataques de prompt injection o jailbreak. Las barreras deben combinarse con aislamiento, permisos mínimos, segmentación, validación determinista y aprobación humana.

## Principios de seguridad

- Local-first para datos confidenciales o restringidos.
- No introducir datos gubernamentales o personales en servicios gratuitos externos sin evaluación, autorización y contrato adecuados.
- No ejecutar acciones destructivas automáticamente.
- No usar credenciales reales en pruebas.
- No desplegar reglas de bloqueo sin modo observación, pruebas de impacto y reversión.
- Mantener inventario de versiones, licencias, hashes y procedencia de modelos y paquetes.
- Separar entornos de desarrollo, pruebas y producción.

## Fases

1. Inventario, política de alcance, laboratorio y análisis de licencias.
2. MVP local: Wazuh + Suricata + Greenbone + Gitleaks + Trivy.
3. Gestión de casos y remediación con aprobación.
4. AI Security Gateway de laboratorio con Promptfoo y LlamaFirewall/NeMo.
5. Piloto institucional no crítico, con datos sintéticos y métricas.
6. Auditoría independiente, hardening, continuidad y escalado.

## Métricas

- Cobertura de activos inventariados.
- Tiempo medio de detección (MTTD) y respuesta (MTTR).
- Vulnerabilidades críticas corregidas dentro del SLA.
- Porcentaje de hallazgos reproducibles y falsos positivos.
- Cobertura de SBOM y secretos.
- Tasa de detección y falsos positivos en pruebas de IA.
- Acciones automáticas bloqueadas por requerir aprobación.
- Disponibilidad y tiempo de recuperación.

## Referencias oficiales y primarias

- MinTIC, lineamientos de seguridad y privacidad para sistemas de IA (22-abr-2026): https://www.mintic.gov.co/portal/inicio/Sala-de-prensa/Noticias/437197%3AMinisterio-TIC-publica-lineamientos-de-seguridad-y-privacidad-de-la-informacion-para-sistemas-de-inteligencia-artificial
- MSPI: https://gobiernodigital.mintic.gov.co/seguridadyprivacidad/portal/Estrategias/MSPI/
- DNP, documentos CONPES de confianza y seguridad digital: https://www.dnp.gov.co/LaEntidad_/subdireccion-general-prospectiva-desarrollo-nacional/direccion-desarrollo-digital/Paginas/documentos-conpes-confianza-y-seguridad-digital.aspx
- OWASP Top 10 for LLM Applications: https://owasp.org/projects/top-10-for-large-language-model-applications/
- MITRE ATLAS: https://atlas.mitre.org/
- NIST AI RMF: https://www.nist.gov/itl/ai-risk-management-framework
- NIST Generative AI Profile: https://doi.org/10.6028/NIST.AI.600-1

Este documento es una arquitectura inicial de investigación, no una certificación ni una afirmación de que los controles ya estén desplegados.
