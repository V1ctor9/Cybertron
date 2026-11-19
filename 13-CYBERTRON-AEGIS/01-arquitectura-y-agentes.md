# Arquitectura técnica y agentes — Cybertron Aegis

## 1. Modelo de ejecución
La IA no recibe acceso directo e irrestricto al sistema operativo ni a la red. Un orquestador determinista administra estados, políticas, autorizaciones y herramientas. El modelo propone planes estructurados; el motor de políticas valida o rechaza cada paso.

Flujo:
1. Registrar organización, propietario y activo.
2. Validar autorización, alcance, exclusiones y ventana.
3. Crear un trabajo con política inmutable y vencimiento.
4. Seleccionar análisis permitido según el perfil del activo.
5. Ejecutar workers aislados con herramientas aprobadas.
6. Normalizar resultados y eliminar secretos/datos innecesarios.
7. Correlacionar evidencia y calcular prioridad explicable.
8. Presentar remediación propuesta para aprobación.
9. Aplicar cambios solo en repositorio/entorno autorizado y bajo aprobación.
10. Ejecutar retest seguro, comparar resultados y cerrar con evidencia.

## 2. Agentes especializados
| Agente | Entrada | Salida permitida | Límites |
|---|---|---|---|
| Asset Inventory | Activos autorizados | Inventario y exposición observada | Descubrimiento pasivo por defecto |
| Code Auditor | Repositorios autorizados | Hallazgos SAST, secretos, dependencias | Sin publicar ni ejecutar código no confiable |
| Config Auditor | Exportaciones/configuración aprobada | Desviaciones y recomendaciones | Solo lectura |
| Vulnerability Analyst | Resultados de escáneres | Correlación, deduplicación y contexto | No inventar CVE ni evidencia |
| Threat Context | IOC/fuentes aprobadas | Contexto y enlaces de inteligencia | No atribución sin evidencia |
| Remediation Planner | Hallazgos confirmados | Plan, parche o diff propuesto | Nunca aplica por sí mismo |
| Verification Agent | Cambio aprobado y test plan | Resultado del retest | Solo pruebas no destructivas |
| Report Agent | Evidencias saneadas | Informes técnicos/ejecutivos | No alterar evidencias originales |
| AI Guard Agent | Prompts, salidas y llamadas a tools | Decisión de política y alertas | Defensa en profundidad; no garantía |

Cada agente tendrá contrato de entrada/salida versionado, esquema JSON, límites de tokens, timeout, presupuesto, modelo permitido y política de datos.

## 3. Motor de políticas
Reglas mínimas:
- Denegar por defecto si el activo no está en Scope Registry.
- Rechazar IPs/rangos, dominios, repositorios o cuentas fuera de alcance.
- No aceptar que un prompt cambie la autorización o las reglas de sistema.
- Permitir solo herramientas y argumentos definidos por perfiles.
- Bloquear shell arbitrario, ejecución privilegiada y acceso a secretos.
- Limitar concurrencia, frecuencia, tamaño de respuesta y duración.
- Requerir aprobación humana para cualquier cambio o prueba de impacto.
- Detener al expirar la autorización o la ventana de trabajo.
- Cancelar todos los workers al activar kill switch.
- Conservar logs de decisiones sin registrar secretos ni contenido sensible innecesario.

## 4. Tool Gateway
Cada integración debe declarar:
- Identificador y versión exacta de herramienta.
- Procedencia, licencia, hash y fecha de revisión.
- Funciones permitidas y prohibidas.
- Tipos y rangos de argumentos aceptados.
- Destinos de red permitidos.
- Recursos máximos, timeout y rate limit.
- Formato de salida y sanitización.
- Pruebas de integración y responsable.

No se permitirá que el agente invente comandos o construya argumentos de ejecución libre. Se utilizarán adaptadores tipados y perfiles predefinidos.

## 5. Aislamiento
- Workers efímeros, no privilegiados y con filesystem temporal.
- Sin montar el socket Docker del host.
- Sin credenciales de producción dentro del contenedor.
- Egress denegado por defecto; habilitación puntual a destinos de laboratorio.
- Separación entre control plane, workers y almacén de evidencias.
- Límites CPU, RAM, disco, procesos y duración.
- Imágenes fijadas por digest y escaneadas antes de ejecución.
- Destruir entorno efímero tras exportar evidencia saneada.

## 6. Modelo de datos mínimo
- Organization
- User / Role
- Asset
- Authorization
- ScopeRule / Exclusion
- Assessment
- Job / AgentRun
- Tool / ToolVersion
- Finding
- Evidence
- RemediationProposal
- Approval
- Verification
- AuditEvent

Toda entidad sensible tendrá tenant_id y controles de acceso. Los eventos de auditoría serán append-only y tendrán política de retención definida.

## 7. Priorización de hallazgos
No usar solo CVSS. Combinar:
- Severidad técnica y vector de explotación conocido.
- Exposición real del activo.
- Criticidad del negocio/servicio.
- Evidencia reproducible y confianza.
- Controles compensatorios.
- Antigüedad y disponibilidad de parche.

La IA puede explicar y sugerir; reglas deterministas y analistas humanos validan las prioridades críticas. No inventar probabilidad de explotación.

## 8. Diseño del AI Security Gateway
Controles antes y después del modelo:
- Identidad del usuario/agente y autorización de sesión.
- Clasificación y minimización de datos.
- Detección de prompt injection y contenido no confiable.
- Separación entre instrucciones y datos recuperados.
- Tool allowlist, autorización contextual y validación de argumentos.
- DLP y redacción de secretos.
- Validación estructural de salida.
- Revisión de salida antes de acciones.
- Cuotas, rate limits, observabilidad y kill switch.

Los detectores probabilísticos no sustituyen aislamiento, permisos mínimos ni validaciones deterministas. Ningún filtro garantiza bloquear todos los ataques.

## 9. Pruebas de seguridad internas
- Intento de ejecutar una tool no permitida.
- Prompt injection en un documento recuperado.
- Solicitud de ampliar alcance desde el agente.
- Autorización expirada.
- Worker que intenta acceder a secretos.
- Egress a destino no aprobado.
- Salida malformada o con instrucciones ocultas.
- Caída del policy engine.
- Activación del kill switch.
- Cruce de datos entre tenants.

Criterio general: denegar o detener de forma segura, generar evento auditable y no filtrar datos.
