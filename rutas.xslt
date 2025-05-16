<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns:gpx="http://www.topografix.com/GPX/1/1"
  exclude-result-prefixes="gpx">

  <xsl:output method="html" indent="yes" encoding="UTF-8"/>

  <xsl:template match="/">
    <html>
      <head>
        <title>Ruta GPX</title>
        <style>
          table { border-collapse: collapse; width: 100%; }
          th, td { border: 1px solid #ccc; padding: 8px; }
          th { background-color: #f0f0f0; }
        </style>
      </head>
      <body>
        <h1><xsl:value-of select="//gpx:trk/gpx:name"/></h1>
        <p><xsl:value-of select="//gpx:metadata/gpx:desc"/></p>

        <h2>Puntos de la ruta</h2>
        <table>
          <tr>
            <th>#</th>
            <th>Latitud</th>
            <th>Longitud</th>
            <th>Altitud</th>
            <th>Hora</th>
          </tr>
          <xsl:for-each select="//gpx:trkpt">
            <tr>
              <td><xsl:value-of select="position()"/></td>
              <td><xsl:value-of select="@lat"/></td>
              <td><xsl:value-of select="@lon"/></td>
              <td><xsl:value-of select="gpx:ele"/></td>
              <td><xsl:value-of select="gpx:time"/></td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>

</xsl:stylesheet>


