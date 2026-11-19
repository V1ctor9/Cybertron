# Servicios para el sector público colombiano y hoja de ruta

## Encaje con lineamientos colombianos

La propuesta debe alinearse, como mínimo, con los documentos y lineamientos oficiales vigentes que correspondan al tipo de entidad, contrato, datos y sistema:

- MinTIC publicó el 22 de abril de 2026 lineamientos de seguridad y privacidad de la información para sistemas de IA, con directrices para diseño, desarrollo, implementación, operación y mantenimiento de IA en entidades públicas: https://www.mintic.gov.co/portal/inicio/Sala-de-prensa/Noticias/437197%3AMinisterio-TIC-publica-lineamientos-de-seguridad-y-privacidad-de-la-informacion-para-sistemas-de-inteligencia-artificial
- MSPI de MinTIC: https://gobiernodigital.mintic.gov.co/seguridadyprivacidad/portal/Estrategias/MSPI/
- Resolución MinTIC 02277 de 2025, actualización del MSPI: https://www.mintic.gov.co/portal/715/w3-article-403045.html
- CONPES 3995 de 2020, Política Nacional de Confianza y Seguridad Digital, y otros documentos CONPES: https://www.dnp.gov.co/LaEntidad_/subdireccion-general-prospectiva-desarrollo-nacional/direccion-desarrollo-digital/Paginas/documentos-conpes-confianza-y-seguridad-digital.aspx
- Estrategia Nacional de Seguridad Digital 2025-2027: https://dapre.presidencia.gov.co/AtencionCiudadana/DocumentosConsulta/16052025-Estrategia-nacional-seguridad-digital_VF.pdf
- CONPES 4144 de 2025, Política Nacional de Inteligencia Artificial (referencia recogida en los lineamientos MinTIC).

La aplicabilidad jurídica concreta debe revisarse con asesoría jurídica colombiana. No se debe presentar este catálogo como certificación de cumplimiento legal, ISO 27001 ni habilitación oficial.

## Servicios potenciales de Cybertron

1. Diagnóstico de seguridad y madurez: inventario, clasificación de activos, brechas y plan de tratamiento.
2. Gestión continua de vulnerabilidades: escaneo autorizado, validación, priorización, remediación y reescaneo.
3. SOC gestionado: monitoreo, correlación de eventos, alertas y escalamiento.
4. Protección de endpoints y redes: hardening, EDR/XDR, IDS/IPS y segmentación.
5. Respuesta a incidentes y análisis forense: preservación de evidencia, cronología, contención aprobada y recuperación.
6. Seguridad de aplicaciones y DevSecOps: SAST, SCA, SBOM, secretos, contenedores y revisión de CI/CD.
7. Seguridad de IA: inventario de modelos/agentes, evaluación de riesgos, pruebas adversariales autorizadas, gateway de IA, prevención de filtración y control de herramientas.
8. Formación y simulacros: ejercicios defensivos y capacitación de personal.
9. Continuidad y recuperación: copias, restauración probada, planes de contingencia y ejercicios.

## AI Security Gateway: barreras que se pueden desarrollar

La capa de protección debe funcionar como punto de control entre usuarios, modelos, agentes, datos y herramientas:

- Inspección de entradas y salidas.
- Detección de prompt injection y jailbreak.
- Clasificación y minimización de datos sensibles.
- Control de herramientas MCP y APIs mediante listas permitidas.
- Validación de identidad, propósito, parámetros y permisos.
- Límites de tasa, cuotas y detección de abuso.
- Bloqueo de exfiltración y secretos.
- Políticas de salida y revisión antes de ejecutar código o acciones.
- Auditoría con datos minimizados.
- Modo observación, modo bloqueo y mecanismo de reversión.

**No prometer bloqueo perfecto.** Las defensas de IA pueden ser evadidas. Se debe medir eficacia, falsos positivos y falsos negativos con pruebas continuas, y mantener controles de seguridad convencionales.

## Hoja de ruta técnica

### Fase 0 — Gobierno y alcance
- Definir activos propios y ambientes de laboratorio.
- Política de pruebas autorizadas y reglas de compromiso.
- Clasificación de datos y matriz de permisos.
- Evaluar licencias, mantenimiento y coste total de propiedad.

### Fase 1 — Laboratorio mínimo
- Virtualización y segmentación.
- Wazuh, Suricata, Greenbone, Gitleaks y Trivy.
- Un repositorio de casos y evidencias.
- Backups y snapshots.
- Pruebas con máquinas deliberadamente vulnerables aisladas.

### Fase 2 — Remediación y operaciones
- Integrar hallazgos y deduplicar.
- Priorizar por criticidad y exposición.
- Crear tickets de remediación.
- Validar correcciones en staging.
- Reescanear y producir informe reproducible.

### Fase 3 — Laboratorio de seguridad de IA
- Desplegar un modelo local de prueba sin datos reales.
- Interponer un gateway con autenticación y autorización.
- Integrar LlamaFirewall y/o NeMo Guardrails.
- Evaluar con Promptfoo y PyRIT en escenarios controlados.
- Simular filtración de secretos, inyección indirecta, abuso de herramientas, salida insegura y denegación de servicio.
- Medir detección, falsos positivos y coste computacional.

### Fase 4 — Piloto institucional
- Empezar por un sistema no crítico y datos sintéticos o anonimizados.
- Obtener autorización escrita y acuerdo de tratamiento de datos.
- Definir ventanas, límites, reversión y responsables.
- No ejecutar bloqueos disruptivos sin autorización del responsable institucional.
- Auditoría independiente antes de ampliar.

### Fase 5 — Servicio gestionado
- SLA, turnos, escalamiento y respuesta.
- Informes ejecutivos y técnicos.
- Gestión de cambios y vulnerabilidades.
- Revisión periódica de proveedores y licencias.
- Pruebas de continuidad y auditorías.

## Entregables por cliente

- Inventario y mapa de superficie de ataque autorizada.
- Informe de riesgos priorizados con evidencia.
- Plan de remediación y responsables.
- Evidencia de validación y reescaneo.
- Reglas y controles desplegados con historial de cambios.
- Informe de incidentes y lecciones aprendidas.
- Registro de modelos, agentes, datasets, conectores y permisos.
- Evaluación de seguridad de IA y plan de mejora.

## Condiciones indispensables para contratar con el Estado

- Alcance y autorización escrita del propietario de los sistemas.
- Acuerdo de confidencialidad y tratamiento de datos.
- Reglas de compromiso, horarios y contactos de emergencia.
- Gestión de credenciales mediante bóveda, nunca en repositorios.
- Trazabilidad, cadena de custodia y retención definida.
- Separación de ambientes y mínimo privilegio.
- Plan de reversión y continuidad.
- Revisión jurídica, contractual y de protección de datos.
- Cumplimiento de requisitos de contratación pública y habilitaciones que resulten aplicables.

## Indicadores del piloto

- Porcentaje de activos inventariados.
- Vulnerabilidades críticas validadas y corregidas.
- Tiempo medio de detección y respuesta.
- Porcentaje de correcciones verificadas mediante reescaneo.
- Falsos positivos por herramienta.
- Cobertura de SBOM y secretos.
- Tasa de detección de ataques simulados a IA.
- Falsos positivos y falsos negativos del gateway.
- Incidentes y acciones con aprobación humana documentada.

**Objetivo del primer prototipo:** demostrar, en infraestructura de laboratorio, que Cybertron puede encontrar una falla, documentarla, corregirla, probar que quedó corregida y prevenir su repetición; y demostrar que una aplicación de IA puede quedar detrás de controles medibles sin conceder autonomía peligrosa a los agentes.
