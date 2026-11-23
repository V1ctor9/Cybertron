# Inventario de proyectos externos — corte 2026-11-23

Este documento complementa `REPOSITORY-REGISTER.md`. Registra candidatos localizados en radares anteriores y en la revisión del 23 de noviembre. Es un inventario documental, no una certificación de seguridad.

## Prioridad inmediata: Cybertron AI Manager y AEGIS

### 1. Pipelock — pipelab-org
- URL canónica: https://github.com/pipelab-org/pipelock
- Licencia: Apache-2.0 para el núcleo; `enterprise/` bajo Elastic License 2.0 (ELv2).
- Función: proxy/firewall de tráfico HTTP, WebSocket, MCP y A2A para agentes; detección de exfiltración de secretos, SSRF, prompt injection y tool poisoning; recibos firmados de acciones.
- Valor: capa defensiva potencial para agentes de Cybertron y AEGIS.
- Límites: protege el tráfico que realmente pasa por el proxy; no es seguridad integral del host. Algunas funciones multiagente son Enterprise y de pago. No tratarlo como única barrera.
- Estado: candidato prioritario; revisión documental parcial. No instalado ni ejecutado.

### 2. Microsoft Agent Governance Toolkit
- URL canónica: https://github.com/microsoft/agent-governance-toolkit
- Licencia: MIT.
- Función: políticas, identidad, auditoría, gateway MCP y controles de runtime para agentes.
- Valor: posible plano de gobernanza del AI Manager.
- Riesgos y configuración: el ejemplo de configuración consultado usa `default_action: allow`; Cybertron debe adoptar denegación por defecto y permitir explícitamente. Middleware de gobernanza no equivale a aislamiento a nivel de sistema operativo; usar contenedores/VMs por agente cuando proceda.
- Estado: candidato prioritario; revisión documental parcial. Las cifras de pruebas declaradas por el proyecto no han sido ejecutadas por Cybertron.

### 3. Octomind — Muvon
- URL: https://github.com/Muvon/octomind
- Licencia: Apache-2.0.
- Función: agente/runtime de programación en Rust, MCP, varios modelos y guardrails TOML.
- Valor: evaluar como agente de desarrollo supervisado.
- Estado: candidato priorizado; no instalado ni ejecutado.

### 4. Sandbase Harness
- URL: https://github.com/sandbaseai/sandbase-harness
- Licencia: Apache-2.0.
- Función: runtime local-first para agentes, sesiones aisladas, MCP, credenciales, auditoría y replay.
- Valor: estudiar arquitectura de aislamiento y trazabilidad.
- Estado: candidato priorizado; no instalado ni ejecutado.

### 5. Google AX
- URL: https://github.com/google/ax
- Licencia: Apache-2.0.
- Función: runtime distribuido para ejecución y orquestación de agentes.
- Riesgo: proyecto en desarrollo intenso, con posibles cambios incompatibles y requisitos de infraestructura mayores.
- Estado: seguimiento, no priorizar despliegue.

### 6. Containarium
- URL: https://github.com/FootprintAI/Containarium
- Licencia: no confirmada en la revisión.
- Función: aislamiento de agentes con SSH, eBPF y contenedores/LXC/Kubernetes.
- Riesgo: se observó que el aislamiento entre tenants no se activa por defecto.
- Estado: en espera; no aprobar hasta confirmar licencia y modelo de aislamiento.

## Ciberseguridad, DevSecOps y cadena de suministro

### 7. Trivy — Aqua Security
- URL: https://github.com/aquasecurity/trivy
- Licencia: Apache-2.0.
- Función: escaneo de vulnerabilidades, configuración, secretos y artefactos.
- Estado: candidato priorizado; revisión documental parcial.

### 8. Syft — Anchore
- URL: https://github.com/anchore/syft
- Licencia: Apache-2.0.
- Función: generación de SBOM.
- Estado: candidato priorizado; revisión documental parcial.

### 9. Grype — Anchore
- URL: https://github.com/anchore/grype
- Licencia: Apache-2.0.
- Función: correlación de SBOM/artefactos con vulnerabilidades.
- Estado: candidato priorizado; revisión documental parcial.

### 10. OSV-Scanner — Google
- URL: https://github.com/google/osv-scanner
- Licencia: Apache-2.0.
- Función: análisis de dependencias frente a la base OSV.
- Estado: candidato priorizado; revisión documental parcial.

### 11. Wazuh
- URL: https://github.com/wazuh/wazuh
- Licencias: revisar componentes, integraciones y paquetes; no asumir que toda la distribución comparte una sola licencia.
- Función: plataforma SIEM/XDR.
- Estado: por revisar antes de proponer arquitectura.

### 12. Betterleaks
- URL: https://github.com/betterleaks/betterleaks
- Licencia reportada MIT; confirmar en la versión exacta.
- Función: detección de secretos.
- Nota: revisar estado de mantenimiento y relación con Gitleaks antes de elegir.
- Estado: por revisar.

### 13. Canonical RepoScan
- URL: https://github.com/canonical/reposcan
- Licencia: GPL-3.0; las herramientas integradas mantienen sus licencias individuales.
- Función: orquestación de secretos, SBOM, SCA, SAST, IaC y controles CI.
- Nota: adopción pública baja en la revisión; inspeccionar herramientas y licencias transitivas.
- Estado: por revisar.

### 14. bomlens — SK Telecom
- URL: https://github.com/sktelecom/bomlens
- Licencia: Apache-2.0.
- Función: evaluación local de SBOM y riesgo de software abierto.
- Nota: herramientas integradas conservan licencias propias.
- Estado: candidato priorizado; revisión documental parcial.

### 15. GLPI
- URL: https://github.com/glpi-project/glpi
- Licencia: GPL-3.0.
- Función: ITSM, inventario y gestión de activos.
- Estado: candidato para estudiar; revisar plugins y módulos por separado.

## Ojo de Dios: geoespacial, satélites y observación terrestre

### 16. QGIS
- URL: https://github.com/qgis/QGIS
- Licencia: GPL-2.0.
- Función: plataforma GIS.
- Nota: los plugins pueden tener licencias diferentes.
- Estado: candidato priorizado; revisar complementos individualmente.

### 17. eo-learn
- URL: https://github.com/sentinel-hub/eo-learn
- Licencia: MIT.
- Función: procesamiento de datos de observación terrestre.
- Nota: verificar servicios externos, cuotas y costes asociados.
- Estado: candidato priorizado; revisión documental parcial.

### 18. OpenDroneMap
- URL: https://github.com/OpenDroneMap/ODM
- Licencia: AGPL-3.0.
- Función: fotogrametría y procesamiento de imágenes de drones.
- Nota: estudiar obligaciones AGPL antes de ofrecer servicios de red.
- Estado: candidato priorizado; revisión documental parcial.

### 19. OpenDrift
- URL: https://github.com/OpenDrift/opendrift
- Licencia: GPL-2.0.
- Función: modelado de trayectorias oceánicas y transporte ambiental.
- Estado: candidato priorizado; revisión documental parcial.

### 20. SatStream
- URL: https://github.com/thirtyHP/SatStream
- Licencia: no localizada.
- Función: plugin QGIS para consumir/recortar Sentinel y Landsat mediante STAC/COG.
- Riesgo: configuración descrita con almacenamiento de credenciales sin cifrar si no se cambia la opción correspondiente; actividad observada muy baja.
- Estado: en espera; no aprobar.

### 21. EOBrowser
- URL: https://github.com/sentinel-hub/EOBrowser
- Estado: archivado el 2026-05-26.
- Decisión: no recomendar para desarrollo nuevo; conservar como referencia histórica.

### 22. QStac
- URL: https://github.com/nkarasiak/QStac
- Estado: el plugin asociado fue marcado para eliminación del repositorio oficial de plugins QGIS el 2026-11-20.
- Decisión: no aprobar hasta aclarar la retirada y confirmar mantenimiento/licencia.

## Atlas Nacional de Potencial Energético Marino

### 23. VITAL — Sandia National Laboratories
- URL: https://github.com/sandialabs/VITAL
- Licencia: Apache-2.0.
- Función: evaluación preliminar de sistemas de energía de corrientes/mareas, recursos, rotor, restricciones, AEP, LCOE y optimización.
- Límite: herramienta de screening; no sustituye ingeniería, estudios oceanográficos, permisos ni diseño final.
- Estado: candidato priorizado; revisión documental parcial.

### 24. pyTMD
- URL: https://github.com/pyTMD/pyTMD
- Licencia: MIT.
- Función: predicción de mareas y modelos relacionados.
- Límite: el proyecto advierte que no debe usarse para navegación ni decisiones críticas de seguridad.
- Estado: candidato priorizado; revisión documental parcial.

### 25. PyWake — DTU
- Fuente canónica: https://gitlab.windenergy.dtu.dk/TOPFARM/PyWake
- Licencia: MIT.
- Función: modelado de estelas y parques eólicos.
- Nota: la fuente oficial es GitLab; un espejo de GitHub no sustituye la fuente original.
- Estado: candidato priorizado; revisión documental parcial.

### 26. OpenFAST
- URL: https://github.com/OpenFAST/openfast
- Licencia: Apache-2.0.
- Función: simulación de turbinas eólicas, incluidas aplicaciones offshore.
- Estado: candidato priorizado; revisar requisitos de compilación y modelos.

### 27. WEC-Sim
- URL: https://github.com/WEC-Sim/WEC-Sim
- Licencia: Apache-2.0.
- Función: simulación temporal de convertidores de energía undimotriz.
- Coste: el código es abierto, pero el entorno completo depende de MATLAB/Simulink/Simscape, que puede requerir licencias comerciales.
- Estado: candidato priorizado con coste potencial.

### 28. SEA-Stack
- URL: https://github.com/Project-SEA-Stack/SEA-Stack
- Licencia: MIT.
- Función: plataforma modular C++ para simulación de energía marina.
- Madurez: versión beta y baja adopción observada; NLR la identifica como framework de modelado.
- Estado: experimental; estudiar, no asumir madurez productiva.

### 29. DTOceanPlus
- Documentación: https://dtoceanplus.gitlab.io/documentation/
- Función: herramientas de diseño y evaluación de tecnologías de energía marina.
- Nota: revisar licencia por módulo y madurez de las funciones; algunas se describen como en desarrollo/no plenamente probadas.
- Estado: por revisar.

### 30. HydroChrono
- URL: https://github.com/Project-SEA-Stack/HydroChrono
- Licencia: MIT.
- Estado: archivado el 2026-05-19.
- Decisión: no recomendar para desarrollo nuevo; conservar como referencia histórica.

## Infraestructura, automatización y formación: referencias por completar

Se conservaron nombres del radar anterior que requieren resolver la URL canónica exacta antes de atribuirles licencia o evaluarlos:
- Projectmem.
- MCP Scanner.
- OpenTRAP.
- LocalEmu.
- SpectrAccess.
- Synctoon.

LocalAI se registra como referencia en https://github.com/mudler/LocalAI, pero la ficha legal, versión y componentes deben verificarse antes de asignar estado de aprobación.

## Fuentes oficiales y estándares de auditoría para el trabajo futuro

- NIST Cybersecurity Framework 2.0: https://tsapps.nist.gov/publication/get_pdf.cfm?pub_id=957258
- NIST AI RMF Generative AI Profile: https://tsapps.nist.gov/publication/get_pdf.cfm?pub_id=958388
- NSA, MCP Security Design Considerations: https://www.nsa.gov/Portals/75/documents/Cybersecurity/CSI_MCP_SECURITY.pdf
- OWASP DevSecOps Guideline — AI Agent and MCP Security: https://owasp.org/www-project-devsecops-guideline/latest/02c-AI-Agent-and-MCP-Security/
- SLSA: https://slsa.dev/
- OSV: https://osv.dev/

## Declaración de auditoría

Las notas anteriores reflejan la revisión documental y de metadatos disponible al 2026-11-23. No se han instalado ni ejecutado estos repositorios, no se ha completado una revisión exhaustiva de cada archivo ni se ha ejecutado un escáner de malware. “Candidato priorizado” no equivale a “seguro”, “libre de malware”, “validado en laboratorio” o “aprobado para producción”.
