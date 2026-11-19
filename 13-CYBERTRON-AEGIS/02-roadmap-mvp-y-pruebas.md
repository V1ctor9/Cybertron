# Roadmap del MVP y plan de validación

## Fase 0 — Gobierno y seguridad
Entregables:
- Política de uso aceptable y autorización.
- Plantilla de alcance, activos, exclusiones y ventana.
- Modelo de amenazas.
- Inventario de datos y política de retención.
- Matriz de licencias y cadena de suministro.
- Procedimiento de incidentes y kill switch.

Salida: ninguna prueba activa hasta aprobar esta fase.

## Fase 1 — MVP de solo lectura
Objetivo: demostrar flujo de trabajo sin escaneo de red ni explotación.
- API para registrar activos y autorizaciones.
- Importación de resultados existentes en formatos estándar.
- Análisis de repositorios Cybertron autorizados con Semgrep, Gitleaks y OSV-Scanner.
- Normalización de hallazgos, deduplicación y evidencias.
- Panel/CLI básico de revisión.
- Reporte de hallazgos y recomendaciones.

Pruebas:
- Usuario sin permiso no ve el tenant ajeno.
- Un trabajo sin autorización es rechazado.
- Secretos de prueba se redactan.
- Hallazgos conservan herramienta, versión y evidencia de origen.
- La IA no puede modificar la severidad sin registrar motivo y evidencia.

## Fase 2 — Escáneres en laboratorio
Solo sobre máquinas virtuales o aplicaciones deliberadamente vulnerables bajo control de Cybertron.
- Greenbone CE para evaluación de vulnerabilidades.
- Nuclei únicamente con plantillas seleccionadas y targets de laboratorio.
- Trivy/Syft/Grype para imágenes y SBOM.
- Integración de Wazuh para telemetría cuando exista infraestructura de prueba.

Controles:
- Red aislada.
- Targets allowlist.
- Rate limits conservadores.
- Sin explotación automática.
- Registro completo de ejecuciones.
- Prueba de parada y expiración de autorización.

## Fase 3 — Correlación multiagente
- Agentes con tareas estrechas y salidas tipadas.
- Un orquestador controla estados y permisos.
- Evidencia obligatoria para cada afirmación.
- Modelo local por defecto para datos sensibles.
- Comparación de resultados del modelo con reglas y herramientas deterministas.

Métricas:
- Precisión de hallazgos confirmados.
- Falsos positivos y falsos negativos conocidos.
- Hallazgos sin evidencia (objetivo: cero).
- Acciones rechazadas correctamente.
- Tiempo de análisis y coste por evaluación.
- Reproducibilidad del retest.

## Fase 4 — Remediación asistida
- Crear rama de corrección o parche propuesto.
- Ejecutar tests unitarios, análisis estático y escaneo de dependencias.
- Revisión humana obligatoria.
- No desplegar a producción automáticamente.
- Retest después de aplicar el cambio aprobado.

## Fase 5 — Piloto controlado
Comenzar con un activo interno no crítico y autorización explícita. Luego, si los controles se demuestran, piloto con cliente mediante contrato y reglas de enfrentamiento. No prometer seguridad absoluta ni certificaciones no obtenidas.

## Definition of Done del MVP
- [ ] Scope Registry obligatorio.
- [ ] Autorización verificable y con vencimiento.
- [ ] RBAC y aislamiento entre organizaciones.
- [ ] Tool Gateway tipado con allowlist.
- [ ] Workers aislados y no privilegiados.
- [ ] Kill switch probado.
- [ ] Logs y evidencias saneadas.
- [ ] Importación de resultados y análisis de repositorios.
- [ ] Reporte reproducible.
- [ ] Pruebas automatizadas de abuso y fallos.
- [ ] Documentación de licencias y versiones.
- [ ] Revisión de seguridad independiente antes de piloto externo.

## Riesgos que deben gestionarse
- Alucinaciones del LLM: exigir evidencia y validación determinista.
- Prompt injection: tratar contenido externo como datos no confiables.
- Abuso de herramientas: allowlist, aislamiento, rate limit y aprobación.
- Fuga de datos: minimización, redacción y modelos locales según clasificación.
- Supply chain: fijar versiones/digests, SBOM y escaneo.
- Falsos positivos: revisión y retest.
- Cambios destructivos: solo diffs revisables y aprobación.
- Deriva de alcance: validar cada destino en tiempo de ejecución.

## Regla de lanzamiento
No se considera listo para clientes ni para entidades gubernamentales hasta completar pruebas de seguridad, revisión jurídica, privacidad, documentación contractual, continuidad operativa y validación independiente.
