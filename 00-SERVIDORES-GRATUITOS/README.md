# Directorio raíz — servidores y alojamiento gratuitos

Inventario para prototipos, páginas, APIs y bases de datos de Cybertron. Los planes gratuitos cambian y tienen límites. No tratar ningún plan gratuito como infraestructura de producción crítica ni almacenar datos sensibles sin revisar contrato, privacidad, copias y seguridad.

Fecha de consulta: 21-11-2026.

## Alojamiento web estático
| Proveedor | Enlace | Plan gratuito / límites relevantes | Uso recomendado |
|---|---|---|---|
| Cloudflare Pages | https://developers.cloudflare.com/pages/ | Free: 500 builds/mes, un build concurrente; límites de archivos y tamaño por sitio | Web corporativa, documentación, landing pages |
| GitHub Pages | https://docs.github.com/pages | Repositorios públicos con GitHub Free; sitio recomendado hasta 1 GB, límite flexible 100 GB/mes; no para comercio/SaaS | Documentación y páginas estáticas de proyectos |
| Netlify | https://www.netlify.com/pricing/ | Plan Free con créditos/uso limitado; revisar consumo y términos | Prototipos y frontends |
| Vercel Hobby | https://vercel.com/docs/plans/hobby | Gratis, pero limitado a uso personal/no comercial | Pruebas personales; no asumir apto para Cybertron comercial |

## Aplicaciones y bases de datos
| Proveedor | Enlace | Plan gratuito / limitación | Uso recomendado |
|---|---|---|---|
| Render | https://render.com/docs/free | Instancias gratuitas limitadas; Postgres gratuito expira a los 30 días; no recomendado para producción | Demos y pruebas temporales |
| Supabase | https://supabase.com/pricing | Free incluye Postgres de 500 MB por proyecto y 5 GB egress; proyectos pueden pausarse tras una semana de inactividad | Prototipos y backend pequeño |
| Neon | https://neon.com/pricing | Consultar cuota Free vigente, compute y almacenamiento | Postgres de desarrollo |
| Cloudflare Workers | https://developers.cloudflare.com/workers/platform/pricing/ | Cuota gratuita con límites diarios y de CPU | APIs ligeras y funciones edge |
| Google Cloud Run | https://cloud.google.com/run/pricing | Cuota mensual gratuita condicionada a región, uso y facturación | Contenedores de prueba; vigilar facturación |
| Oracle Cloud Free Tier | https://www.oracle.com/cloud/free/ | Recursos Always Free sujetos a disponibilidad, región y capacidad; verificar condiciones de cuenta | Laboratorio personal si hay capacidad |

## Recomendación práctica para Cybertron
1. Documentación y web estática: GitHub Pages o Cloudflare Pages.
2. Frontend de prototipo: Cloudflare Pages o Netlify Free.
3. Base de datos pequeña de pruebas: Supabase o Neon Free, con exportaciones periódicas.
4. APIs y contenedores: probar Cloudflare Workers o Render; no alojar servicios críticos en tiers gratuitos.
5. Laboratorio de IA, GIS, LiDAR, SIEM y cómputo pesado: equipo local propio; el alojamiento gratuito no sustituye GPU, RAM, almacenamiento ni procesamiento sostenido.

## Reglas de seguridad y costes
- Configurar alertas de uso y facturación cuando el proveedor las ofrezca.
- No introducir tarjeta ni activar recursos de pago sin autorización del responsable.
- Revisar condiciones comerciales: Vercel Hobby es personal/no comercial; GitHub Pages no está destinado a operar un negocio o SaaS.
- Los tiers gratuitos pueden dormir, pausarse, caducar, limitar transferencia o eliminar bases de datos.
- Confirmar términos oficiales antes de desplegar cada servicio. Última revisión: 21-11-2026.
