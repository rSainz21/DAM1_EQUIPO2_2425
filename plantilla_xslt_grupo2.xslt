<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:gpx="http://www.topografix.com/GPX/1/1"
    exclude-result-prefixes="gpx">

    <xsl:output method="text" encoding="UTF-8"/>

    <xsl:template match="/">
        <xsl:value-of select="gpx:gpx/gpx:metadata/gpx:name"/><xsl:text>,</xsl:text>    
        <xsl:value-of select="gpx:gpx/gpx:metadata/gpx:author/gpx:name"/>
        <xsl:text>,</xsl:text>  
        <xsl:value-of select="gpx:gpx/gpx:metadata/gpx:link[1]/@href"/>
        <xsl:text>,</xsl:text>
        <xsl:value-of select="gpx:gpx/gpx:metadata/gpx:time"/>
        <xsl:text>&#10;</xsl:text>
        <xsl:apply-templates select="//gpx:wpt"/>
        <xsl:apply-templates select="//gpx:trk"/>
    </xsl:template>

    <xsl:template match="gpx:wpt">
        <xsl:text>WPT,</xsl:text>
        <xsl:value-of select="gpx:name"/><xsl:text>,</xsl:text>
        <xsl:value-of select="@lat"/><xsl:text>,</xsl:text>
        <xsl:value-of select="@lon"/><xsl:text>,</xsl:text>
        <xsl:value-of select="gpx:ele"/><xsl:text>,</xsl:text>
        <xsl:value-of select="gpx:time"/><xsl:text>,</xsl:text>
        <xsl:value-of select="gpx:cmt"/><xsl:text>,</xsl:text>
        <xsl:value-of select="gpx:desc"/><xsl:text>&#10;</xsl:text>
    </xsl:template>

    <xsl:template match="gpx:trk">
    <xsl:variable name="trackName" select="gpx:name"/>
    <xsl:for-each select="gpx:trkseg/gpx:trkpt">
        <xsl:text>TRK,</xsl:text>
        <xsl:value-of select="$trackName"/><xsl:text>,</xsl:text>
        <xsl:value-of select="@lat"/><xsl:text>,</xsl:text>
        <xsl:value-of select="@lon"/><xsl:text>,</xsl:text>
        <xsl:value-of select="gpx:ele"/><xsl:text>,</xsl:text>
        <xsl:value-of select="gpx:time"/><xsl:text>,,,</xsl:text>
        <xsl:text>&#10;</xsl:text>
    </xsl:for-each>
</xsl:template>
</xsl:stylesheet>