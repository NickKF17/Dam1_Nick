<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:output method="html" version="5.0" encoding="UTF-8" indent="yes"/>

  <!-- ============================================================
       PLANTILLA RAÍZ — genera el esqueleto HTML5
       ============================================================ -->
  <xsl:template match="/">
    <html lang="es">
      <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>
          <xsl:value-of select="biblioteca/@nombre"/>
        </title>
        <style>
          /* ── Variables y reset ── */
          *, *::before, *::after { box-sizing: border-box; margin: 0; padding: 0; }

          :root {
            --bg:        #f4f1eb;
            --surface:   #ffffff;
            --primary:   #2c3e50;
            --accent:    #e67e22;
            --accent2:   #27ae60;
            --danger:    #c0392b;
            --muted:     #95a5a6;
            --radius:    10px;
            --shadow:    0 2px 12px rgba(0,0,0,.08);
            --font:      'Segoe UI', system-ui, sans-serif;
          }

          body {
            font-family: var(--font);
            background: var(--bg);
            color: var(--primary);
            min-height: 100vh;
          }

          /* ── Cabecera ── */
          header {
            background: var(--primary);
            color: #fff;
            padding: 2rem 2.5rem 1.5rem;
            display: flex;
            flex-direction: column;
            gap: .4rem;
          }
          header h1 { font-size: 1.9rem; letter-spacing: -.5px; }
          header .sede {
            font-size: .95rem;
            opacity: .75;
            display: flex;
            align-items: center;
            gap: .4rem;
          }

          /* ── Navegación de secciones ── */
          nav {
            background: var(--accent);
            display: flex;
            gap: 0;
          }
          nav a {
            color: #fff;
            text-decoration: none;
            padding: .7rem 1.4rem;
            font-weight: 600;
            font-size: .9rem;
            transition: background .2s;
          }
          nav a:hover { background: rgba(0,0,0,.15); }

          /* ── Contenedor principal ── */
          main {
            max-width: 1050px;
            margin: 2rem auto;
            padding: 0 1.5rem;
            display: flex;
            flex-direction: column;
            gap: 2.5rem;
          }

          /* ── Sección genérica ── */
          section {
            background: var(--surface);
            border-radius: var(--radius);
            box-shadow: var(--shadow);
            overflow: hidden;
          }
          .section-header {
            background: var(--primary);
            color: #fff;
            padding: 1rem 1.5rem;
            font-size: 1.15rem;
            font-weight: 700;
            display: flex;
            align-items: center;
            gap: .6rem;
          }
          .section-body { padding: 1.5rem; }

          /* ── Tabla de libros ── */
          table {
            width: 100%;
            border-collapse: collapse;
            font-size: .92rem;
          }
          thead tr { background: #ecf0f1; }
          th, td {
            padding: .75rem 1rem;
            text-align: left;
            border-bottom: 1px solid #e8e8e8;
          }
          th { font-weight: 700; color: var(--primary); font-size: .82rem; text-transform: uppercase; letter-spacing: .5px; }
          tbody tr:last-child td { border-bottom: none; }
          tbody tr:hover { background: #fdf8f3; }

          /* ── Badges de categoría ── */
          .badge {
            display: inline-block;
            padding: .2rem .65rem;
            border-radius: 50px;
            font-size: .78rem;
            font-weight: 700;
            text-transform: uppercase;
            letter-spacing: .3px;
          }
          .badge-ficcion    { background: #d5e8d4; color: #2d6a2d; }
          .badge-no-ficcion { background: #dae8fc; color: #1a4d8f; }
          .badge-infantil   { background: #fff2cc; color: #7d6608; }
          .badge-tecnico    { background: #f8cecc; color: #8b1a1a; }

          /* ── Multi-autor ── */
          .autores { color: var(--muted); font-size: .88rem; }

          /* ── Tarjetas de inventario ── */
          .cards {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
            gap: 1rem;
          }
          .card {
            border: 1px solid #e0e0e0;
            border-radius: var(--radius);
            padding: 1rem;
            display: flex;
            flex-direction: column;
            gap: .4rem;
            transition: box-shadow .2s;
          }
          .card:hover { box-shadow: 0 4px 14px rgba(0,0,0,.12); }
          .card .code  { font-weight: 700; font-size: .95rem; }
          .card .shelf { color: var(--muted); font-size: .83rem; }
          .card .ref   { font-size: .8rem; background: #f0f0f0; border-radius: 4px; padding: .15rem .4rem; width: fit-content; }

          /* ── Colores de estado de ejemplar ── */
          .estado-nuevo    { color: var(--accent2); font-weight: 700; }
          .estado-bueno    { color: var(--accent);  font-weight: 700; }
          .estado-gastado  { color: var(--danger);  font-weight: 700; }

          /* ── Aviso ejemplar gastado ── */
          .aviso-gastado {
            margin-top: .5rem;
            background: #fdecea;
            border-left: 3px solid var(--danger);
            border-radius: 4px;
            padding: .3rem .6rem;
            font-size: .78rem;
            color: var(--danger);
          }

          /* ── Lista de socios ── */
          .socios-lista {
            display: flex;
            flex-direction: column;
            gap: .75rem;
          }
          .socio-row {
            display: flex;
            align-items: center;
            gap: 1rem;
            padding: .8rem 1rem;
            border-radius: var(--radius);
            border: 1px solid #eee;
          }
          .socio-avatar {
            width: 42px; height: 42px;
            border-radius: 50%;
            display: flex; align-items: center; justify-content: center;
            font-size: 1.2rem;
            font-weight: 700;
            color: #fff;
            flex-shrink: 0;
          }
          .avatar-premium  { background: var(--accent); }
          .avatar-basico   { background: var(--primary); }
          .avatar-infantil { background: var(--accent2); }

          .socio-info .nombre { font-weight: 600; }
          .socio-info .dni    { color: var(--muted); font-size: .83rem; }

          .nivel-badge {
            margin-left: auto;
            font-size: .78rem;
            font-weight: 700;
            padding: .25rem .8rem;
            border-radius: 50px;
            text-transform: uppercase;
          }
          .nivel-premium  { background: #fff3e0; color: #c55a11; border: 1px solid #f0a64d; }
          .nivel-basico   { background: #e8eaf6; color: #283593; border: 1px solid #9fa8da; }
          .nivel-infantil { background: #e8f5e9; color: #1b5e20; border: 1px solid #81c784; }

          /* ── Nota destacada para premium ── */
          .premium-nota {
            margin-top: .3rem;
            font-size: .78rem;
            color: var(--accent);
            font-weight: 600;
          }

          footer {
            text-align: center;
            padding: 2rem;
            color: var(--muted);
            font-size: .85rem;
          }
        </style>
      </head>
      <body>

        <!-- CABECERA -->
        <header>
          <h1>📚 <xsl:value-of select="biblioteca/@nombre"/></h1>
          <span class="sede">📍 Sede: <xsl:value-of select="biblioteca/@sede"/></span>
        </header>

        <!-- NAVEGACIÓN -->
        <nav>
          <a href="#catalogo">📖 Catálogo</a>
          <a href="#inventario">🗂️ Inventario</a>
          <a href="#socios">👥 Socios</a>
        </nav>

        <main>

          <!-- ====================================================
               SECCIÓN 1: CATÁLOGO DE LIBROS
               Requisito BUCLE: xsl:for-each
               Requisito ORDENACIÓN: xsl:sort por título (A→Z)
               Requisito CONDICIONAL: xsl:choose para badge de categoría
               ==================================================== -->
          <section id="catalogo">
            <div class="section-header">📖 Catálogo de Libros</div>
            <div class="section-body">
              <table>
                <thead>
                  <tr>
                    <th>ISBN</th>
                    <th>Título</th>
                    <th>Autor/es</th>
                    <th>Categoría</th>
                  </tr>
                </thead>
                <tbody>
                  <!-- BUCLE sobre cada libro, ORDENADO alfabéticamente por título -->
                  <xsl:for-each select="biblioteca/catalogo/libro">
                    <xsl:sort select="titulo" order="ascending" data-type="text"/>
                    <tr>
                      <td><code><xsl:value-of select="@isbn"/></code></td>
                      <td><strong><xsl:value-of select="titulo"/></strong></td>
                      <td>
                        <!-- Si hay más de un autor los mostramos separados por coma -->
                        <xsl:for-each select="autor">
                          <xsl:if test="position() > 1">
                            <span class="autores">, </span>
                          </xsl:if>
                          <xsl:value-of select="."/>
                        </xsl:for-each>
                      </td>
                      <td>
                        <!-- CONDICIONAL: badge de color según categoría -->
                        <xsl:choose>
                          <xsl:when test="@categoria = 'ficcion'">
                            <span class="badge badge-ficcion">Ficción</span>
                          </xsl:when>
                          <xsl:when test="@categoria = 'no-ficcion'">
                            <span class="badge badge-no-ficcion">No Ficción</span>
                          </xsl:when>
                          <xsl:when test="@categoria = 'infantil'">
                            <span class="badge badge-infantil">Infantil</span>
                          </xsl:when>
                          <xsl:when test="@categoria = 'tecnico'">
                            <span class="badge badge-tecnico">Técnico</span>
                          </xsl:when>
                          <xsl:otherwise>
                            <span class="badge"><xsl:value-of select="@categoria"/></span>
                          </xsl:otherwise>
                        </xsl:choose>
                      </td>
                    </tr>
                  </xsl:for-each>
                </tbody>
              </table>
            </div>
          </section>

          <!-- ====================================================
               SECCIÓN 2: INVENTARIO DE EJEMPLARES
               Requisito BUCLE: xsl:for-each
               Requisito CONDICIONAL: xsl:if para aviso de ejemplar gastado
               ==================================================== -->
          <section id="inventario">
            <div class="section-header">🗂️ Inventario de Ejemplares</div>
            <div class="section-body">
              <div class="cards">
                <xsl:for-each select="biblioteca/inventario/ejemplar">
                  <!-- ORDENAR por estado: nuevo > bueno > gastado -->
                  <xsl:sort select="@estado" order="ascending" data-type="text"/>
                  <div class="card">
                    <span class="code">🔖 <xsl:value-of select="@codigo"/></span>
                    <span class="ref">Libro: <xsl:value-of select="@ref_libro"/></span>
                    <span class="shelf">📦 Estantería: <xsl:value-of select="estanteria"/></span>
                    <!-- CONDICIONAL: clase de color según estado -->
                    <span>
                      <xsl:choose>
                        <xsl:when test="@estado = 'nuevo'">
                          <span class="estado-nuevo">✅ Nuevo</span>
                        </xsl:when>
                        <xsl:when test="@estado = 'bueno'">
                          <span class="estado-bueno">🟡 Bueno</span>
                        </xsl:when>
                        <xsl:when test="@estado = 'gastado'">
                          <span class="estado-gastado">🔴 Gastado</span>
                        </xsl:when>
                      </xsl:choose>
                    </span>
                    <!-- CONDICIONAL: aviso especial si el estado es "gastado" -->
                    <xsl:if test="@estado = 'gastado'">
                      <div class="aviso-gastado">⚠️ Requiere revisión o reposición</div>
                    </xsl:if>
                  </div>
                </xsl:for-each>
              </div>
            </div>
          </section>

          <!-- ====================================================
               SECCIÓN 3: SOCIOS
               Requisito BUCLE: xsl:for-each
               Requisito ORDENACIÓN: xsl:sort por nombre (A→Z)
               Requisito CONDICIONAL: xsl:choose para avatar/nivel; xsl:if para nota premium
               ==================================================== -->
          <section id="socios">
            <div class="section-header">👥 Socios de la Biblioteca</div>
            <div class="section-body">
              <div class="socios-lista">
                <xsl:for-each select="biblioteca/usuarios/socio">
                  <xsl:sort select="nombre_completo" order="ascending" data-type="text"/>
                  <div class="socio-row">
                    <!-- Avatar con inicial del nombre -->
                    <div>
                      <xsl:attribute name="class">
                        socio-avatar
                        <xsl:choose>
                          <xsl:when test="@nivel = 'premium'"> avatar-premium</xsl:when>
                          <xsl:when test="@nivel = 'infantil'"> avatar-infantil</xsl:when>
                          <xsl:otherwise> avatar-basico</xsl:otherwise>
                        </xsl:choose>
                      </xsl:attribute>
                      <xsl:value-of select="substring(nombre_completo, 1, 1)"/>
                    </div>

                    <div class="socio-info">
                      <div class="nombre"><xsl:value-of select="nombre_completo"/></div>
                      <div class="dni">DNI: <xsl:value-of select="@dni"/></div>
                      <!-- CONDICIONAL: nota extra para socios premium -->
                      <xsl:if test="@nivel = 'premium'">
                        <div class="premium-nota">⭐ Acceso ilimitado a reservas</div>
                      </xsl:if>
                    </div>

                    <!-- Badge de nivel -->
                    <span>
                      <xsl:choose>
                        <xsl:when test="@nivel = 'premium'">
                          <span class="nivel-badge nivel-premium">Premium</span>
                        </xsl:when>
                        <xsl:when test="@nivel = 'infantil'">
                          <span class="nivel-badge nivel-infantil">Infantil</span>
                        </xsl:when>
                        <xsl:otherwise>
                          <span class="nivel-badge nivel-basico">Básico</span>
                        </xsl:otherwise>
                      </xsl:choose>
                    </span>
                  </div>
                </xsl:for-each>
              </div>
            </div>
          </section>

        </main>

        <footer>
          Generado automáticamente desde datos.xml · XSLT 1.0
        </footer>

      </body>
    </html>
  </xsl:template>

</xsl:stylesheet>
