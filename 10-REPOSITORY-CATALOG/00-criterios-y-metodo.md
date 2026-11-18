# Criterios de evaluación del catálogo

## Ficha mínima por proyecto
- Nombre y URL canónica del repositorio.
- Organización/autores oficiales y relación con el proveedor.
- Función y proyectos Cybertron a los que puede aportar.
- Licencia del código y, por separado, licencia de modelos, pesos, datasets y voces.
- Última actividad, versiones, incidencias y política de seguridad.
- Requisitos de hardware, memoria, almacenamiento, GPU y sistema operativo.
- Dependencias, telemetría, conexiones externas y tratamiento de datos.
- Costes: gratuito local, cuota gratuita limitada, API de pago o infraestructura propia.
- Riesgos, madurez, facilidad de instalación y prueba aislada propuesta.

## Niveles de decisión
- **Candidato:** localizado, pendiente de verificación.
- **En evaluación:** licencia, mantenimiento y funcionamiento revisados parcialmente.
- **Prueba de laboratorio:** probado en entorno aislado, sin datos reales.
- **Aprobado para piloto:** evaluación técnica y de seguridad documentada.
- **Adoptado:** integrado con responsable, versión fijada y plan de mantenimiento.
- **Descartado:** motivo documentado.

## No confundir
- Un repositorio oficial de una empresa no significa que el modelo comercial de esa empresa sea abierto.
- Un modelo con pesos descargables no implica que sus datos de entrenamiento o código completo sean públicos.
- Una licencia MIT/Apache del programa anfitrión no cambia la licencia del modelo que se descarga.
- Una API con nivel gratuito puede cambiar límites o condiciones.
- Las listas comunitarias sirven para descubrir candidatos, no para certificar licencias ni seguridad.

## Proceso
1. Descubrir repositorios desde organizaciones oficiales y fuentes técnicas.
2. Confirmar URL, autoría, licencia y estado en GitHub y documentación primaria.
3. Revisar dependencias, releases, avisos de seguridad y requisitos.
4. Probar en máquina virtual/contenedor sin privilegios ni credenciales.
5. Registrar resultados y decisión antes de usar en proyectos reales.
