# Satélites, SIG y análisis geoespacial

Base tecnológica candidata para Ojo de Dios y el Atlas Marino. Priorizar fuentes públicas oficiales y usos civiles legítimos.

## Código y bibliotecas
| Proyecto | Repositorio | Función |
|---|---|---|
| QGIS | https://github.com/qgis/QGIS | Sistema de información geográfica |
| GDAL | https://github.com/OSGeo/gdal | Lectura/procesamiento de datos raster y vector |
| GeoPandas | https://github.com/geopandas/geopandas | Análisis vectorial en Python |
| Rasterio | https://github.com/rasterio/rasterio | Trabajo con datos raster |
| eo-learn | https://github.com/sentinel-hub/eo-learn | Flujos de trabajo de observación de la Tierra |
| pystac | https://github.com/stac-utils/pystac | Catálogos STAC |
| stackstac | https://github.com/gjoseph92/stackstac | Procesamiento de colecciones STAC |
| xarray | https://github.com/pydata/xarray | Datos multidimensionales |
| Leaflet | https://github.com/Leaflet/Leaflet | Mapas web interactivos |
| MapLibre GL JS | https://github.com/maplibre/maplibre-gl-js | Visualización cartográfica web |

## Fuentes públicas oficiales para investigar
- Copernicus Data Space: https://dataspace.copernicus.eu/
- Sentinel Hub / documentación: https://www.sentinel-hub.com/
- NASA Earthdata: https://www.earthdata.nasa.gov/
- NASA FIRMS: https://firms.modaps.eosdis.nasa.gov/
- USGS EarthExplorer: https://earthexplorer.usgs.gov/
- NOAA NCEI: https://www.ncei.noaa.gov/
- GEBCO bathymetry: https://www.gebco.net/

## Aplicación a Ojo de Dios
- Sentinel-1 para observación radar y cambios de superficie.
- Sentinel-2 y Landsat para observación óptica, con limitaciones por nubes.
- FIRMS para focos de calor/incendios como señal que requiere validación.
- Datos públicos de elevación, hidrografía, vías, límites y coberturas.
- Cámaras/drones solo propios o con autorización.
- Alertas con fuentes, fecha, incertidumbre, trazabilidad y revisión humana.

## Aplicación al Atlas Marino
- Batimetría y relieve submarino.
- Viento, oleaje, corrientes, mareas y temperatura superficial/profundidad cuando haya datos.
- Metadatos, resolución, cobertura temporal y limitaciones de cada fuente.
- No inferir potencial energético únicamente a partir de una capa satelital: validar con mediciones y estudios oceanográficos.

## Salvaguardas
No diseñar vigilancia individual ni identificación biométrica. El alcance es análisis territorial y ambiental civil, con minimización de datos y supervisión humana.
